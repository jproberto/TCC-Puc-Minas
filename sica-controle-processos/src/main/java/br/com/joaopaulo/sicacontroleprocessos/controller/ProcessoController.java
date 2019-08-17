package br.com.joaopaulo.sicacontroleprocessos.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.joaopaulo.sicacontroleprocessos.enumeration.StatusExecucao;
import br.com.joaopaulo.sicacontroleprocessos.form.ExecucaoProcessoForm;
import br.com.joaopaulo.sicacontroleprocessos.model.Atividade;
import br.com.joaopaulo.sicacontroleprocessos.model.ExecucaoAtividade;
import br.com.joaopaulo.sicacontroleprocessos.model.ExecucaoProcesso;
import br.com.joaopaulo.sicacontroleprocessos.model.Processo;
import br.com.joaopaulo.sicacontroleprocessos.service.ProcessoService;

@Controller
@RequestMapping("/processos")
public class ProcessoController {

	@Autowired
	private ProcessoService service;
	
	@GetMapping
	public String consultarProcesso(@RequestParam(value = "titulo", required = false) String titulo, Model model) {
		List<Processo> processos = service.getProcessos(titulo);
		
		if (processos != null) {
			model.addAttribute("processos", processos);
		}
		
		return "consultarProcesso";
	}
	
	@GetMapping("/{id}")
	public String detalharProcesso(@PathVariable("id") String id, Model model) {
		Processo processo = service.getProcessoById(id);
		
		if (processo != null) {
			model.addAttribute("processo", processo);
			
			List<ExecucaoProcesso> execucoesProcesso = service.getExecucoesByProcesso(processo);
			model.addAttribute("execucoes", execucoesProcesso);
			
			model.addAttribute("localDateTimeFormat", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
			
			return "detalharProcesso";
		} else {
			return consultarProcesso("", model);
		}
	}
	
	@GetMapping("/executar/{idProcesso}")
	public String iniciarExecucao(@PathVariable("idProcesso") String idProcesso, Model model) {
		Processo processo = service.getProcessoById(idProcesso);
		
		if (processo != null) {
			model.addAttribute("processo", processo);
			
			ExecucaoProcesso execucaoProcesso = new ExecucaoProcesso();
			execucaoProcesso.setProcesso(processo);
			execucaoProcesso.setInicioExecucao(LocalDateTime.now());
			
			ExecucaoAtividade execucaoAtividade = new ExecucaoAtividade();
			execucaoAtividade.setNome(execucaoProcesso.getProcesso().getAtividades().get(0).getNome());
			execucaoAtividade.setHorarioExecucao(LocalDateTime.now());
			execucaoProcesso.adicionarExecucaoAtividade(execucaoAtividade);
			
			service.saveExecucaoProcesso(execucaoProcesso);

			adicionaAtributosNoModel(processo, execucaoProcesso, execucaoAtividade, 0, model);
		
			return "executarProcesso";
		} else {
			return consultarProcesso("", model);
		}
	}
	
	@PostMapping(path = "/executar/proximaAtividade")
	public String proximaAtividade(@ModelAttribute("execucaoProcessoForm") ExecucaoProcessoForm execucaoProcessoForm, Model model) {
		return navegarAtividade(execucaoProcessoForm, 1, model);
	}
	
	@PostMapping(path = "/executar/atividadeAnterior")
	public String atividadeAnterior(@ModelAttribute("execucaoProcessoForm") ExecucaoProcessoForm execucaoProcessoForm, Model model) {
		return navegarAtividade(execucaoProcessoForm, -1, model);
	}
	
	private String navegarAtividade(ExecucaoProcessoForm execucaoProcessoForm, int modificadorAtividade, Model model) {
		ExecucaoProcesso execucaoProcesso = service.getExecucaoProcessoById(execucaoProcessoForm.getIdExecucaoProcesso());
		
		if (execucaoProcesso != null) {
			int indiceAtividade = execucaoProcessoForm.getIndiceAtividade();
			
			List<ExecucaoAtividade> execucaoAtividades = execucaoProcesso.getExecucaoAtividades();
			ExecucaoAtividade execucaoAtividadeAtual = execucaoAtividades.get(indiceAtividade);
			execucaoAtividadeAtual.setObservacao(execucaoProcessoForm.getObservacaoExecucaoAtividade());
			
			int indiceAtividadeSeguinte = indiceAtividade + modificadorAtividade;
			ExecucaoAtividade execucaoAtividadeSeguinte;
			if (indiceAtividadeSeguinte < execucaoAtividades.size()) {
				execucaoAtividadeSeguinte = execucaoAtividades.get(indiceAtividadeSeguinte);
			} else {
				execucaoAtividadeSeguinte = new ExecucaoAtividade();
				execucaoAtividadeSeguinte.setNome(execucaoProcesso.getProcesso().getAtividades().get(indiceAtividadeSeguinte).getNome());
				execucaoAtividadeSeguinte.setHorarioExecucao(LocalDateTime.now());
				execucaoProcesso.adicionarExecucaoAtividade(execucaoAtividadeSeguinte);
			}

			service.saveExecucaoProcesso(execucaoProcesso);
			
			adicionaAtributosNoModel(execucaoProcesso.getProcesso(), execucaoProcesso, execucaoAtividadeSeguinte, indiceAtividadeSeguinte, model);
			
			return "executarProcesso";
		} else {
			return consultarProcesso("", model);
		}
	}
	
	private void adicionaAtributosNoModel(Processo processo, ExecucaoProcesso execucaoProcesso, ExecucaoAtividade execucaoAtividade, int indiceAtividade, Model model) {
		model.addAttribute("tituloProcesso", execucaoProcesso.getProcesso().getTitulo());
		model.addAttribute("idExecucaoProcesso", execucaoProcesso.getId());
		model.addAttribute("observacaoExecucaoAtividade",  execucaoAtividade.getObservacao() == null ? "" : execucaoAtividade.getObservacao());
		
		List<Atividade> atividades = processo.getAtividades();
		model.addAttribute("atividade", atividades.get(indiceAtividade));

		model.addAttribute("indiceAtividade", indiceAtividade);
		if (indiceAtividade + 1 < atividades.size()) { 
			model.addAttribute("indiceAtividadeProxima", indiceAtividade + 1);
		} else {
			model.addAttribute("indiceAtividadeProxima", -1);
		}
		
		if (indiceAtividade != 0) {
			model.addAttribute("indiceAtividadeAnterior", indiceAtividade - 1);
		} else {
			model.addAttribute("indiceAtividadeAnterior", -1);
		}
		
		model.addAttribute("execucaoProcessoForm", new ExecucaoProcessoForm());
	}
	
	@PostMapping("/executar/finalizar")
	public String finalizarExecucao(@ModelAttribute("execucaoProcessoForm") ExecucaoProcessoForm execucaoProcessoForm, Model model) {
		ExecucaoProcesso execucaoProcesso = service.getExecucaoProcessoById(execucaoProcessoForm.getIdExecucaoProcesso());
		
		if (execucaoProcesso != null) {
			ExecucaoAtividade execucaoUltimaAtividade = execucaoProcesso.getExecucaoAtividades().get(execucaoProcessoForm.getIndiceAtividade());
			execucaoUltimaAtividade.setObservacao(execucaoProcessoForm.getObservacaoExecucaoAtividade());
			
			execucaoProcesso.setStatus(StatusExecucao.CONCULUIDA_SUCESSO);
			execucaoProcesso.setFimExecucao(LocalDateTime.now());
			service.saveExecucaoProcesso(execucaoProcesso);
			
			return detalharProcesso(execucaoProcesso.getProcesso().getId(), model);
		} else {
			return consultarProcesso("", model);
		}
	}
	
	@PostMapping("/executar/interromper")
	public String interromperExecucao(@ModelAttribute("execucaoProcessoForm") ExecucaoProcessoForm execucaoProcessoForm, Model model) {
		ExecucaoProcesso execucaoProcesso = service.getExecucaoProcessoById(execucaoProcessoForm.getIdExecucaoProcesso());
		
		if (execucaoProcesso != null) {
			ExecucaoAtividade execucaoUltimaAtividade = execucaoProcesso.getExecucaoAtividades().get(execucaoProcessoForm.getIndiceAtividade());
			execucaoUltimaAtividade.setObservacao(execucaoProcessoForm.getObservacaoExecucaoAtividade());
			
			execucaoProcesso.setStatus(StatusExecucao.INTERROMPIDA_SEM_MOTIVO);
			execucaoProcesso.setFimExecucao(LocalDateTime.now());
			service.saveExecucaoProcesso(execucaoProcesso);
			
			return detalharProcesso(execucaoProcesso.getProcesso().getId(), model);
		} else {
			return consultarProcesso("", model);
		}
	}
	
	@GetMapping("/execucao/{idExecucaoProcesso}")
	public String detalharExecucaoProcesso(@PathVariable("idExecucaoProcesso") String idExecucaoProcesso, Model model) {
		ExecucaoProcesso execucaoProcesso = service.getExecucaoProcessoById(idExecucaoProcesso);
		
		if (execucaoProcesso != null) {
			model.addAttribute("execucaoProcesso", execucaoProcesso);
			
			model.addAttribute("localDateTimeFormat", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
			
			return "detalharExecucao";
		} else {
			return consultarProcesso("", model);
		}
	}
}

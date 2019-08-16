package br.com.joaopaulo.sicacontroleprocessos.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			return "detalharProcesso";
		} else {
			return "consultarProcesso";
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
			execucaoAtividade.setHorarioExecucao(LocalDateTime.now());
			execucaoProcesso.adicionarExecucaoAtividade(execucaoAtividade);
			
			service.saveExecucaoProcesso(execucaoProcesso);

			adicionaAtributosNoModel(processo, execucaoProcesso, execucaoAtividade, 0, model);
		
			return "executarProcesso";
		} else {
			return "consultarProcesso";
		}
	}
	
	@PostMapping(path = "/executar/proximaAtividade")
	public String proximaAtividade(@RequestBody String parametros, Model model) {
		return navegaAtividade(parametros, 1, model);
	}
	
	@PostMapping(path = "/executar/atividadeAnterior")
	public String atividadeAnterior(@RequestBody String parametros, Model model) {
		return navegaAtividade(parametros, -1, model);
	}
	
	private String navegaAtividade(String parametros, int modificadorAtividade, Model model) {
		String[] aux = parametros.split("&");
		
		Map<String, String> params = new HashMap<String, String>();
		for (String p : aux) {
			String[] a = p.split("=");
			
			String k = a[0];
			String v = "";
			if (a.length > 1) {
				v = a[1];
			}
			
			params.put(k, v);
		}
		
		ExecucaoProcesso execucaoProcesso = service.getExecucaoProcessoById(params.get("idExecucaoProcesso"));
		
		if (execucaoProcesso != null) {
			int atividade = Integer.parseInt(params.get("atividade"));
			int atividadeAnterior = atividade + modificadorAtividade;
			
			ExecucaoAtividade execucaoAtividadeAnterior;
			
			List<ExecucaoAtividade> execucaoAtividades = execucaoProcesso.getExecucaoAtividades();
			execucaoAtividadeAnterior = execucaoAtividades.get(atividadeAnterior);

			execucaoAtividadeAnterior.setHorarioExecucao(LocalDateTime.now());
			execucaoAtividadeAnterior.setObservacao(params.get("observacaoAtividade"));

			ExecucaoAtividade execucaoAtividadeAtual;
			
			if (atividade > execucaoAtividades.size()) {
				execucaoAtividadeAtual = new ExecucaoAtividade();
				execucaoAtividadeAtual.setHorarioExecucao(LocalDateTime.now());
			} else {
				execucaoAtividadeAtual = execucaoAtividades.get(atividade);
			}
			
			service.saveExecucaoProcesso(execucaoProcesso);
						
			adicionaAtributosNoModel(execucaoProcesso.getProcesso(), execucaoProcesso, execucaoAtividadeAtual, atividade, model);
			
			return "executarProcesso";
		} else {
			return "consultarProcesso";
		}
	}
	
	@PostMapping("/executar/{idExecucaoProcesso}/proximaAtividade")
	public String proximaAtividadeOLD(@PathVariable("idExecucaoProcesso") String idExecucaoProcesso, @RequestParam(value = "atividade", required = true) Integer atividade, @RequestParam(value = "atividadeAnterior", required = true) Integer atividadeAnterior, @RequestParam(value = "observacaoAtividade", required = false) String observacaoAtividade, Model model) {
		ExecucaoProcesso execucaoProcesso = service.getExecucaoProcessoById(idExecucaoProcesso);
		
		if (execucaoProcesso != null) {
			ExecucaoAtividade execucaoAtividadeAnterior;
			
			List<ExecucaoAtividade> execucaoAtividades = execucaoProcesso.getExecucaoAtividades();
			execucaoAtividadeAnterior = execucaoAtividades.get(atividadeAnterior);

			execucaoAtividadeAnterior.setHorarioExecucao(LocalDateTime.now());
			execucaoAtividadeAnterior.setObservacao(observacaoAtividade);

			ExecucaoAtividade execucaoAtividadeAtual;
			
			if (atividade > execucaoAtividades.size()) {
				execucaoAtividadeAtual = new ExecucaoAtividade();
				execucaoAtividadeAtual.setHorarioExecucao(LocalDateTime.now());
			} else {
				execucaoAtividadeAtual = execucaoAtividades.get(atividade);
			}
			
			service.saveExecucaoProcesso(execucaoProcesso);
						
			adicionaAtributosNoModel(execucaoProcesso.getProcesso(), execucaoProcesso, execucaoAtividadeAtual, atividade, model);
			
			return "executarProcesso";
		} else {
			return "consultarProcesso";
		}
	}
	
	private void adicionaAtributosNoModel(Processo processo, ExecucaoProcesso execucaoProcesso, ExecucaoAtividade execucaoAtividade, int atividade, Model model) {
		model.addAttribute("processo", execucaoProcesso.getProcesso());
		model.addAttribute("execucaoProcesso", execucaoProcesso);
		model.addAttribute("execucaoAtividade",  execucaoAtividade);
		
		List<Atividade> atividades = processo.getAtividades();
		model.addAttribute("atividade", atividades.get(atividade));
		
		if (atividade < atividades.size()) { 
			model.addAttribute("atividadeProxima", atividade + 1);
		} else {
			model.addAttribute("atividadeProxima", -1);
		}
		
		if (atividade != 0) {
			model.addAttribute("atividadeAnterior", atividade - 1);
		} else {
			model.addAttribute("atividadeAnterior", -1);
		}
	}
	
	@GetMapping("/finalizarExecucao/{id}")
	public String finalizarExecucao(@PathVariable("id") String id, Model model) {
		Processo processo = service.getProcessoById(id);
		
		if (processo != null) {
			model.addAttribute("processo", processo);
			return "finalizarExecucao";
		} else {
			return "consultarProcesso";
		}
	}
}

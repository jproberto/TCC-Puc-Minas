package br.com.joaopaulo.sicacontroleprocessos.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaopaulo.sicacontroleprocessos.model.ExecucaoAtividade;
import br.com.joaopaulo.sicacontroleprocessos.model.ExecucaoProcesso;
import br.com.joaopaulo.sicacontroleprocessos.model.Processo;
import br.com.joaopaulo.sicacontroleprocessos.repository.ExecucaoProcessoRepository;
import br.com.joaopaulo.sicacontroleprocessos.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository processoRepository;
	
	@Autowired
	private ExecucaoProcessoRepository execucaoProcessoRepository;
	
	public List<Processo> getProcessos(String titulo) {
		if (titulo == null) {
			return processoRepository.findAll();
		} else {		
			return processoRepository.findByTituloLike(titulo);
		}
	}

	public Processo getProcessoById(String id) {
		return processoRepository.findById(id).orElse(null);
	}

	public void saveExecucaoProcesso(ExecucaoProcesso execucaoProcesso) {
		execucaoProcessoRepository.save(execucaoProcesso);
	}

	public ExecucaoProcesso getExecucaoProcessoById(String idExecucaoProcesso) {
		return execucaoProcessoRepository.findById(idExecucaoProcesso).orElse(null);
	}

	public List<ExecucaoProcesso> getExecucoesByProcesso(Processo processo) {
		List<ExecucaoProcesso> execucoes = execucaoProcessoRepository.findByProcesso(processo);
		
		execucoes.sort(new Comparator<ExecucaoProcesso>() {
			@Override
			public int compare(ExecucaoProcesso e1, ExecucaoProcesso e2) {
				return e2.getFimExecucao().compareTo(e1.getFimExecucao());
			}
		});
		
		return execucoes;
	}

	public boolean execucaoTemOcorrencia(ExecucaoProcesso execucaoProcesso) {
		List<ExecucaoAtividade> execucoesComOcorrencia = execucaoProcesso.getExecucaoAtividades()
																			.stream()
																			.filter(execucaoAtividade -> execucaoAtividade.getOcorrencia() != null)
																			.collect(Collectors.toList());
		
		return execucoesComOcorrencia != null && !execucoesComOcorrencia.isEmpty();
	}
}
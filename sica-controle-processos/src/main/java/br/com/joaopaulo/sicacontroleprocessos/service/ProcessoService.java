package br.com.joaopaulo.sicacontroleprocessos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			return processoRepository.findByTitulo(titulo);
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
}
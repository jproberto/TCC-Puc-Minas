package br.com.joaopaulo.sicacontroleprocessos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.joaopaulo.sicacontroleprocessos.model.ExecucaoProcesso;
import br.com.joaopaulo.sicacontroleprocessos.model.Processo;

public interface ExecucaoProcessoRepository extends CrudRepository<ExecucaoProcesso, String> {
	public List<ExecucaoProcesso> findAll();
	public List<ExecucaoProcesso> findByProcesso(Processo processo);
}

package br.com.joaopaulo.sicacontroleprocessos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.joaopaulo.sicacontroleprocessos.model.Processo;

public interface ProcessoRepository extends CrudRepository<Processo, String> {

	public List<Processo> findAll();
	public List<Processo> findByTitulo(String titulo);
}
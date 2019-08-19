package br.com.joaopaulo.sicacontrolebarragens.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.joaopaulo.sicacontrolebarragens.model.Barragem;

public interface BarragemRepository extends CrudRepository<Barragem, String> {

	public List<Barragem> findAll();
	public Barragem findByCodigo(String titulo);
}

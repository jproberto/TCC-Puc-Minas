package br.com.joaopaulo.sicasegurancacomunicacao.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.joaopaulo.sicasegurancacomunicacao.model.Barragem;

public interface BarragemRepository extends CrudRepository<Barragem, String>{

	public Barragem findByCodigo(String codigo);
}

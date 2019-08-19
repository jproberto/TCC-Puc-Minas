package br.com.joaopaulo.sicacontrolebarragens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaopaulo.sicacontrolebarragens.model.Barragem;
import br.com.joaopaulo.sicacontrolebarragens.repository.BarragemRepository;

@Service
public class BarragemService {

	@Autowired
	private BarragemRepository repository;
	
	public List<Barragem> getBarragens() {
		return repository.findAll();
	}
	
	public Barragem getBarragemByCodigo(String codigo) {
		return repository.findByCodigo(codigo);
	}
}

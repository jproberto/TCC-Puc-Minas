package br.com.joaopaulo.sicacontrolebarragens.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaopaulo.sicacontrolebarragens.model.Barragem;
import br.com.joaopaulo.sicacontrolebarragens.service.BarragemService;

@RestController
@RequestMapping("/barragem")
public class BarragemController {

	@Autowired
	private BarragemService service;
	
	@GetMapping
	public ResponseEntity<List<Barragem>> listaBarragens() {
		List<Barragem> barragens = service.getBarragens();
		return ResponseEntity.ok(barragens);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Barragem> detalhaBarragem(@PathVariable("codigo") String codigo) {
		Barragem barragem = service.getBarragemByCodigo(codigo);
		
		if (barragem == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(barragem);
	}
	
	@GetMapping("/checarBarragem/{codigo}")
	public ResponseEntity<Barragem> checaBarragem(@PathVariable("codigo") String codigo) {
		ResponseEntity<Barragem> response = detalhaBarragem(codigo);
		
		if (!response.getStatusCode().is2xxSuccessful()) {
			return response;
		}
		
		
		
		return response;
	}
}

package br.com.joaopaulo.sicasegurancacomunicacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaopaulo.sicasegurancacomunicacao.dto.AlertaDTO;
import br.com.joaopaulo.sicasegurancacomunicacao.service.BarragemService;

@RestController
@RequestMapping("/alerta")
public class AlertaController {

	@Autowired
	private BarragemService service;
	
	@PostMapping
	public ResponseEntity<AlertaDTO> detalhaBarragem(@RequestBody AlertaDTO alertaDTO) {
		AlertaDTO alertaDTOReposta = service.emiteAlerta(alertaDTO);
		
		return ResponseEntity.ok(alertaDTOReposta);
	}
}

package br.com.joaopaulo.sicasegurancacomunicacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alerta")
public class AlertaController {

	@GetMapping
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("hello");
	}
}

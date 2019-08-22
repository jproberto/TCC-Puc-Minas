package br.com.joaopaulo.externalservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.joaopaulo.externalservice.dto.AlertaDTO;

@Controller
@RequestMapping("/recebeAlerta")
public class ExternalService {

	@PostMapping(consumes = "application/json")
	public ResponseEntity<AlertaDTO> recebeAlerta(@RequestBody AlertaDTO alertaDTO) {
		System.out.println(alertaDTO);
		
		return ResponseEntity.ok(alertaDTO);
	}
}

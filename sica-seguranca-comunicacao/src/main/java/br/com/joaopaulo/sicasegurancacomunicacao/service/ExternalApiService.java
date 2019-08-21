package br.com.joaopaulo.sicasegurancacomunicacao.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.joaopaulo.sicasegurancacomunicacao.model.Destinatario;

@Service
public class ExternalApiService extends AlertaService {

	@Override
	protected void enviaMensagem(String titulo, String mensagem, Destinatario destinatario) {
		String uri = destinatario.getEndpoint();
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(uri, mensagem, String.class);
	}
}

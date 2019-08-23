package br.com.joaopaulo.sicacontrolebarragens.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.joaopaulo.sicacontrolebarragens.dto.AlertaDTO;
import br.com.joaopaulo.sicacontrolebarragens.enumeration.TipoAlerta;
import br.com.joaopaulo.sicacontrolebarragens.model.Barragem;

@Service
public class AlertaService {

	private final String endpointEmiteAlerta = "http://localhost:8080/segurancaComunicacao/alerta";
	
	public void enviaAlerta(Barragem barragem, String mensagem, TipoAlerta tipo) {
		AlertaDTO alertaDTO = new AlertaDTO();
		alertaDTO.setCodigoBarragem(barragem.getCodigo());
		alertaDTO.setMensagem(mensagem);
		alertaDTO.setTipo(tipo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<AlertaDTO> request = new HttpEntity<AlertaDTO>(alertaDTO, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity(endpointEmiteAlerta, request, String.class);
	}

}

package br.com.joaopaulo.sicasegurancacomunicacao.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.joaopaulo.sicasegurancacomunicacao.dto.AlertaDTO;
import br.com.joaopaulo.sicasegurancacomunicacao.dto.AlertaExternalApiDTO;
import br.com.joaopaulo.sicasegurancacomunicacao.enumeration.TipoAlerta;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Barragem;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Destinatario;
import br.com.joaopaulo.sicasegurancacomunicacao.model.LocalidadeProxima;

@Service
public class ExternalApiService extends AlertaService {

	@Override
	public void enviaMensagem(Barragem barragem, LocalidadeProxima localidade, String mensagem, AlertaDTO alertaDTO, List<Destinatario> destinatarios) {
		for (Destinatario destinatario : destinatarios) {
			AlertaExternalApiDTO alerta = new AlertaExternalApiDTO();
			alerta.setBarragem("[" + barragem.getCodigo() + "] - " + barragem.getNome());
			alerta.setTipoAlerta(alertaDTO.getTipo().getValor());
			alerta.setMensagem(alertaDTO.getMensagem());
			
			if (alertaDTO.getTipo().equals(TipoAlerta.EVACUACAO)) {
				alerta.setContatoEmergenciaEvacuacao(localidade.getProcedimentoEvacuacao().getContatoEmergencia());
				alerta.setProcedimentoEvacuacao(localidade.getProcedimentoEvacuacao().getDescricaoProcedimento());
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<AlertaExternalApiDTO> request = new HttpEntity<AlertaExternalApiDTO>(alerta, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForEntity(destinatario.getEndpoint(), request, String.class);
		}
	}
}

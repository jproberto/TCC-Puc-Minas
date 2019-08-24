package br.com.joaopaulo.sicasegurancacomunicacao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaopaulo.sicasegurancacomunicacao.dto.AlertaDTO;
import br.com.joaopaulo.sicasegurancacomunicacao.enumeration.TipoAlerta;
import br.com.joaopaulo.sicasegurancacomunicacao.enumeration.TipoMensagem;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Barragem;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Destinatario;
import br.com.joaopaulo.sicasegurancacomunicacao.model.LocalidadeProxima;
import br.com.joaopaulo.sicasegurancacomunicacao.repository.BarragemRepository;

@Service
public class BarragemService {

	@Autowired
	private BarragemRepository repository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ExternalApiService externalApiService;
	
	public Barragem getBarragemByCodigo(String codigo) {
		return repository.findByCodigo(codigo);
	}

	public AlertaDTO emiteAlerta(AlertaDTO alertaDTO) {
		Barragem barragem = getBarragemByCodigo(alertaDTO.getCodigoBarragem());
		
		StringBuilder sb = new StringBuilder();
		sb.append("SICA - Sistema de Controle Ambiental comunica que nosso módulo de Controle de Barragens identificou problemas na unidade ")
		  .append("[" + barragem.getCodigo() + "] - " + barragem.getNome() + ". \n")
		  .append("\n")
		  .append("A mensagem enviada foi a seguinte: \n")
		  .append(alertaDTO.getMensagem())
		  ;
		
		if (alertaDTO.getTipo().equals(TipoAlerta.EVACUACAO)) {
			sb.append("\n \n")
			  .append("A EVACUAÇÃO DEVERÁ SER IMEDIATA CONFORME PROCEDIMENTO A SEGUIR. \n")
			  .append("\n");
		}
		
		String mensagem = sb.toString();
		
		for (LocalidadeProxima localidade : barragem.getLocalidadesProximas()) {
			List<Destinatario> destinatariosEmail = new ArrayList<Destinatario>();
			List<Destinatario> destinatariosApi = new ArrayList<Destinatario>();
			
			for (Destinatario destinatario : localidade.getDestinatarios()) {
				if (destinatario.getTipoMensagem().equals(TipoMensagem.EMAIL)) {
					destinatariosEmail.add(destinatario);
				} else {
					destinatariosApi.add(destinatario);
				}
			}
		
			emailService.enviaMensagem(barragem, localidade, mensagem, alertaDTO, destinatariosEmail);
			externalApiService.enviaMensagem(barragem, localidade, mensagem, alertaDTO, destinatariosApi);
		}

		alertaDTO.setMensagemEnviada(mensagem);
		
		return alertaDTO;
	}
}

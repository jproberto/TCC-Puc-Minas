package br.com.joaopaulo.sicasegurancacomunicacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.joaopaulo.sicasegurancacomunicacao.dto.AlertaDTO;
import br.com.joaopaulo.sicasegurancacomunicacao.enumeration.TipoAlerta;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Barragem;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Destinatario;
import br.com.joaopaulo.sicasegurancacomunicacao.model.LocalidadeProxima;

@Service
public class EmailService extends AlertaService {

	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void enviaMensagem(Barragem barragem, LocalidadeProxima localidade, String mensagem, AlertaDTO alertaDTO, List<Destinatario> destinatarios) {
		String titulo = alertaDTO.getTipo().getValor().toUpperCase() + ": Barragem " + "[" + barragem.getCodigo() + "] - " + barragem.getNome(); 
		
		for (Destinatario destinatario : destinatarios) {
			StringBuilder sbLocalidade = new StringBuilder(mensagem);
			
			if (alertaDTO.getTipo().equals(TipoAlerta.EVACUACAO)) {
				alertaDTO.adicionaLocalidadeProxima(localidade);
				
				sbLocalidade.append("Contato de emergência: ") 
							.append(localidade.getProcedimentoEvacuacao().getContatoEmergencia() + "\n")
							.append("Procedimento: ")
							.append(localidade.getProcedimentoEvacuacao().getDescricaoProcedimento());
			} else {
				alertaDTO.adicionaLocalidadeProxima(localidade.cloneSemProcedimentoEvacuacao());
			}
			
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(destinatario.getEmail());
			mail.setSubject(titulo);
			mail.setText(sbLocalidade.toString());
			
			sender.send(mail);		
		}
	}
}

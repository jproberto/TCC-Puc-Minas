package br.com.joaopaulo.sicasegurancacomunicacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.joaopaulo.sicasegurancacomunicacao.model.Destinatario;

@Service
public class EmailService extends AlertaService {

	@Autowired
	private JavaMailSender sender;
	
	@Override
	protected void enviaMensagem(String titulo, String mensagem, Destinatario destinatario) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(destinatario.getEmail());
		mail.setSubject(titulo);
		mail.setText(mensagem);
		
		sender.send(mail);		
	}
}

package br.com.joaopaulo.sicasegurancacomunicacao.service;

import java.util.List;

import br.com.joaopaulo.sicasegurancacomunicacao.model.Destinatario;

public abstract class AlertaService {
	public void enviaMensagem(String titulo, String mensagem, List<Destinatario> destinatarios) {
		for (Destinatario destinatario : destinatarios) {
			enviaMensagem(titulo, mensagem, destinatario);
		}
	}
	
	protected abstract void enviaMensagem(String titulo, String mensagem, Destinatario destinatario);
}

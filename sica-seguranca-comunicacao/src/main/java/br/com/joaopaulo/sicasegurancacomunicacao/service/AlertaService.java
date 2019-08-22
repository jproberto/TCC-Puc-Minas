package br.com.joaopaulo.sicasegurancacomunicacao.service;

import java.util.List;

import br.com.joaopaulo.sicasegurancacomunicacao.dto.AlertaDTO;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Barragem;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Destinatario;
import br.com.joaopaulo.sicasegurancacomunicacao.model.LocalidadeProxima;

public abstract class AlertaService {
	public abstract void enviaMensagem(Barragem barragem, LocalidadeProxima localidade, String mensagem, AlertaDTO alertaDTO, List<Destinatario> destinatarios);
}

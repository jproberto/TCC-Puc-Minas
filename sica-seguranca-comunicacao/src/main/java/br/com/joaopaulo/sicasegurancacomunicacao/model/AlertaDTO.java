package br.com.joaopaulo.sicasegurancacomunicacao.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.joaopaulo.sicasegurancacomunicacao.enumeration.TipoAlerta;

@JsonInclude(Include.NON_NULL)
public class AlertaDTO {

	private String codigoBarragem;
	private String mensagem;
	private TipoAlerta tipo;
	
	private String mensagemEnviada;
	private List<LocalidadeProxima> localidadesProximas = new ArrayList<LocalidadeProxima>();

	public String getCodigoBarragem() {
		return codigoBarragem;
	}

	public void setCodigoBarragem(String codigoBarragem) {
		this.codigoBarragem = codigoBarragem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagemRecebida) {
		this.mensagem = mensagemRecebida;
	}

	public TipoAlerta getTipo() {
		return tipo;
	}

	public void setTipo(TipoAlerta tipo) {
		this.tipo = tipo;
	}

	public String getMensagemEnviada() {
		return mensagemEnviada;
	}

	public void setMensagemEnviada(String mensagemEnviada) {
		this.mensagemEnviada = mensagemEnviada;
	}
		
	public List<LocalidadeProxima> getLocalidadesProximas() {
		List<LocalidadeProxima> clone = new ArrayList<LocalidadeProxima>();
		clone.addAll(localidadesProximas);
		
		return clone;
	}
	
	public void adicionaLocalidadeProxima(LocalidadeProxima localidadeProxima) {
		localidadesProximas.add(localidadeProxima);
	}
	
	public void removeLocalidadeProxima(LocalidadeProxima localidadeProxima) {
		localidadesProximas.remove(localidadeProxima);
	}
}

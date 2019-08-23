package br.com.joaopaulo.sicacontrolebarragens.dto;

import br.com.joaopaulo.sicacontrolebarragens.enumeration.TipoAlerta;

public class AlertaDTO {
	private String codigoBarragem;
	private String mensagem;
	private TipoAlerta tipo;
	
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
}

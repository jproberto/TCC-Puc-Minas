package br.com.joaopaulo.sicasegurancacomunicacao.enumeration;

public enum TipoMensagem {
	EMAIL("e-mail"), API("api");
	
	private String valor;
	
	TipoMensagem(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

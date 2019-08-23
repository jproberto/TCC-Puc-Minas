package br.com.joaopaulo.sicacontrolebarragens.enumeration;

public enum TipoAlerta {
	INFORMACAO("informação"), AVISO("aviso"), RECOMENDACAO("recomendacao"), EVACUACAO("evacuacao");
	
	private String valor;
	
	TipoAlerta(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

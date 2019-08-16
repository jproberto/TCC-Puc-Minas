package br.com.joaopaulo.sicacontroleprocessos.enumeration;

public enum TipoOcorrencia {
	INFORMACAO("informação"), ALERTA("alerta"), ERRO("erro"), FATAL("fatal");
	
	private String valor;
	
	TipoOcorrencia(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

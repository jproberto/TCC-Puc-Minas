package br.com.joaopaulo.sicacontroleprocessos.enumeration;

public enum Recorrencia {
	INEDITA("inédita"), ESPORADICA("esporádica"), RECORRENTE("recorrente"), CONSTANTE("constante");
	
	private String valor;
	
	Recorrencia(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
package br.com.joaopaulo.sicacontroleprocessos.enumeration;

public enum Periodicidade {
	DIARIO("diário"), SEMANAL("semanal"), QUINZENAL("quinzenal"), MENSAL("mensal"), BIMESTRAL("bimestral"), TRIMESTRAL("trimestral"), SEMESTRAL("semestral"), ANUAL("anual");
	
	private String valor;
	
	Periodicidade(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

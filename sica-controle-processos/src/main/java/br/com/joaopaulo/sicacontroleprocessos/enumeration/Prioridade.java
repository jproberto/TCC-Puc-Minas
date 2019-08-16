package br.com.joaopaulo.sicacontroleprocessos.enumeration;

public enum Prioridade {
	MUITO_BAIXA("muito baixa"), BAIXA("baixa"), MEDIA("media"), ALTA("alta"), MUITO_ALTA("muito alta");
	
	private String valor;
	
	Prioridade(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

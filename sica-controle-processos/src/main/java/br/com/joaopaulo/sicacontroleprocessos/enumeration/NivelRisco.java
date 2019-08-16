package br.com.joaopaulo.sicacontroleprocessos.enumeration;

public enum NivelRisco {
	MUITO_BAIXO("muito baixo"), BAIXO("baixo"), MEDIO("medio"), ALTO("alto"), MUITO_ALTO("muito alto");
	
	private String valor;
	
	NivelRisco(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

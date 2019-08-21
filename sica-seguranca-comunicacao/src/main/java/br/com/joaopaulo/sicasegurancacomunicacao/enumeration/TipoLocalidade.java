package br.com.joaopaulo.sicasegurancacomunicacao.enumeration;

public enum TipoLocalidade {
	CIDADE_GRANDE("cidade grande"), CIDADE_PEQUENA("cidade pequena"), VILA("vila"), POVOADO("povoado"), BASE("base");
	
	private String valor;
	
	TipoLocalidade(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

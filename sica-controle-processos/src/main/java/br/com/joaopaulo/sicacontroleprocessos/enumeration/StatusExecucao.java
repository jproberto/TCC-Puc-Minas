package br.com.joaopaulo.sicacontroleprocessos.enumeration;

public enum StatusExecucao {
	CONCULUIDA_SUCESSO("concluída com sucesso"), CONCLUIDA_OCORRENCIA("concluída com ocorrência"), INTERROMPIDA_OCORRENCIA("interrompida por ocorrência"), INTERROMPIDA_SEM_MOTIVO("interrompida sem motivo especificado");
	
	private String valor;
	
	StatusExecucao(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

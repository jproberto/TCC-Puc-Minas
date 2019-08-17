package br.com.joaopaulo.sicacontroleprocessos.form;

public class ExecucaoProcessoForm {
					
	private String idExecucaoProcesso;
	private String observacaoExecucaoAtividade;
	private int indiceAtividade;

	public String getIdExecucaoProcesso() {
		return idExecucaoProcesso;
	}

	public void setIdExecucaoProcesso(String idExcecucaoProcesso) {
		this.idExecucaoProcesso = idExcecucaoProcesso;
	}

	public String getObservacaoExecucaoAtividade() {
		return observacaoExecucaoAtividade;
	}

	public void setObservacaoExecucaoAtividade(String observacaoExecucaoAtividade) {
		this.observacaoExecucaoAtividade = observacaoExecucaoAtividade;
	}

	public int getIndiceAtividade() {
		return indiceAtividade;
	}

	public void setIndiceAtividade(int indiceAtividade) {
		this.indiceAtividade = indiceAtividade;
	}

}

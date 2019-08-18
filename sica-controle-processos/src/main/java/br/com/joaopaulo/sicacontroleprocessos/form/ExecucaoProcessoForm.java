package br.com.joaopaulo.sicacontroleprocessos.form;

import br.com.joaopaulo.sicacontroleprocessos.enumeration.Recorrencia;
import br.com.joaopaulo.sicacontroleprocessos.enumeration.TipoOcorrencia;

public class ExecucaoProcessoForm {
					
	private String idExecucaoProcesso;
	private String observacaoExecucaoAtividade;
	private int indiceAtividade;
	
	private boolean ocorrenciaInterrompeuExecucao;
	private boolean ocorrenciaResolvida;
	private TipoOcorrencia tipoOcorrencia;
	private Recorrencia recorrenciaOcorrencia;
	private String observacaoOcorrencia;
	
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
	
	public boolean isOcorrenciaInterrompeuExecucao() {
		return ocorrenciaInterrompeuExecucao;
	}

	public void setOcorrenciaInterrompeuExecucao(boolean ocorrenciaInterrompeuExecucao) {
		this.ocorrenciaInterrompeuExecucao = ocorrenciaInterrompeuExecucao;
	}

	public boolean isOcorrenciaResolvida() {
		return ocorrenciaResolvida;
	}

	public void setOcorrenciaResolvida(boolean ocorrenciaResolvida) {
		this.ocorrenciaResolvida = ocorrenciaResolvida;
	}

	public TipoOcorrencia getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public Recorrencia getRecorrenciaOcorrencia() {
		return recorrenciaOcorrencia;
	}

	public void setRecorrenciaOcorrencia(Recorrencia recorrenciaOcorrencia) {
		this.recorrenciaOcorrencia = recorrenciaOcorrencia;
	}

	public String getObservacaoOcorrencia() {
		return observacaoOcorrencia;
	}

	public void setObservacaoOcorrencia(String observacaoOcorrencia) {
		this.observacaoOcorrencia = observacaoOcorrencia;
	}
}

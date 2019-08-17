package br.com.joaopaulo.sicacontroleprocessos.model;

import java.time.LocalDateTime;

public class ExecucaoAtividade {

	private String nome;
	private LocalDateTime horarioExecucao;
	private String observacao;
	private Ocorrencia ocorrencia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDateTime getHorarioExecucao() {
		return horarioExecucao;
	}

	public void setHorarioExecucao(LocalDateTime horarioExecucao) {
		this.horarioExecucao = horarioExecucao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
}

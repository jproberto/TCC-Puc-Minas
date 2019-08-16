package br.com.joaopaulo.sicacontroleprocessos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.joaopaulo.sicacontroleprocessos.enumeration.StatusExecucao;

public class ExecucaoProcesso {
	private LocalDateTime inicioExecucao;
	private LocalDateTime fimExecucao;
	private StatusExecucao status;
	@DBRef
	private Processo processo;
	private List<ExecucaoAtividade> execucaoAtividades = new ArrayList<ExecucaoAtividade>();
	
	public LocalDateTime getInicioExecucao() {
		return inicioExecucao;
	}

	public void setInicioExecucao(LocalDateTime inicioExecucao) {
		this.inicioExecucao = inicioExecucao;
	}

	public LocalDateTime getFimExecucao() {
		return fimExecucao;
	}

	public void setFimExecucao(LocalDateTime fimExecucao) {
		this.fimExecucao = fimExecucao;
	}

	public StatusExecucao getStatus() {
		return status;
	}

	public void setStatus(StatusExecucao status) {
		this.status = status;
	}
	
	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public List<ExecucaoAtividade> getExecucaoAtividades() {
		List<ExecucaoAtividade> clone = new ArrayList<ExecucaoAtividade>();
		clone.addAll(execucaoAtividades);
		
		clone.sort(new Comparator<ExecucaoAtividade>() {
			@Override
			public int compare(ExecucaoAtividade a1, ExecucaoAtividade a2) {
				return a1.getHorarioExecucao().compareTo(a2.getHorarioExecucao());
			}
		});
		
		return clone;
	}

	public void adicionarExecucaoAtividade(ExecucaoAtividade execucaoAtividade) {
		execucaoAtividades.add(execucaoAtividade);
	}
	
	public void removerExecucaoAtividade(ExecucaoAtividade execucaoAtividade) {
		execucaoAtividades.remove(execucaoAtividade);
	}
}

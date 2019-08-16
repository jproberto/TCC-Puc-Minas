package br.com.joaopaulo.sicacontroleprocessos.model;

import java.time.LocalDateTime;

import br.com.joaopaulo.sicacontroleprocessos.enumeration.Recorrencia;
import br.com.joaopaulo.sicacontroleprocessos.enumeration.TipoOcorrencia;

public class Ocorrencia {

	private LocalDateTime horario;
	private boolean emitiuAlerta;
	private boolean interrompeuExecucao;
	private boolean resolvida;
	private TipoOcorrencia tipo;
	private Recorrencia recorrencia;
	private String observacao;

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public boolean isEmitiuAlerta() {
		return emitiuAlerta;
	}

	public void setEmitiuAlerta(boolean emitiuAlerta) {
		this.emitiuAlerta = emitiuAlerta;
	}

	public boolean isInterrompeuExecucao() {
		return interrompeuExecucao;
	}

	public void setInterrompeuExecucao(boolean interrompeuExecucao) {
		this.interrompeuExecucao = interrompeuExecucao;
	}

	public boolean isResolvida() {
		return resolvida;
	}

	public void setResolvida(boolean resolvida) {
		this.resolvida = resolvida;
	}

	public TipoOcorrencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoOcorrencia tipo) {
		this.tipo = tipo;
	}

	public Recorrencia getRecorrencia() {
		return recorrencia;
	}

	public void setRecorrencia(Recorrencia recorrencia) {
		this.recorrencia = recorrencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}

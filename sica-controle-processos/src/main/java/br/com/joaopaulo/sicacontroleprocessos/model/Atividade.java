package br.com.joaopaulo.sicacontroleprocessos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.joaopaulo.sicacontroleprocessos.enumeration.NivelRisco;
import br.com.joaopaulo.sicacontroleprocessos.enumeration.Prioridade;

public class Atividade {
	private String nome;
	private String descricao;
	private String horarioExecucao;
	private NivelRisco nivelRisco;
	private Prioridade prioridade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHorarioExecucao() {
		return horarioExecucao;
	}

	public void setHorarioExecucao(String horarioExecucao) {
		SimpleDateFormat sdf  = new SimpleDateFormat("HH:mm");
		sdf.setLenient(false);
		
		try {
			@SuppressWarnings("unused")
			Date d = sdf.parse(horarioExecucao);
		} catch(ParseException e) {
			throw new IllegalArgumentException("Formato deve ser HH:mm");
		}
		
		this.horarioExecucao = horarioExecucao;
	}

	public NivelRisco getNivelRisco() {
		return nivelRisco;
	}

	public void setNivelRisco(NivelRisco nivelRisco) {
		this.nivelRisco = nivelRisco;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
}

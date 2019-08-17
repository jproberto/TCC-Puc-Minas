package br.com.joaopaulo.sicacontroleprocessos.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.joaopaulo.sicacontroleprocessos.enumeration.Periodicidade;

@Document
public class Processo {
	@Id
	private String id;
	
	private String titulo;
	private String descricao;
	private Periodicidade periodicidade;
	private boolean ativo;
	private List<Atividade> atividades = new ArrayList<Atividade>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Periodicidade getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(Periodicidade periodicidade) {
		this.periodicidade = periodicidade;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public List<Atividade> getAtividades() {
		List<Atividade> clone = new ArrayList<Atividade>();
		clone.addAll(atividades);
		
		clone.sort(new Comparator<Atividade>() {
			@Override
			public int compare(Atividade a1, Atividade a2) {
				return a1.getHorarioExecucao().compareTo(a2.getHorarioExecucao());
			}
		});
		
		return clone;
	}

	public void adicionarAtividade(Atividade atividade) {
		atividades.add(atividade);
	}
	
	public void removerAtividade(Atividade atividade) {
		atividades.remove(atividade);
	}	
}

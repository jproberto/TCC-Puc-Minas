package br.com.joaopaulo.sicasegurancacomunicacao.model;

import java.util.ArrayList;
import java.util.List;

import br.com.joaopaulo.sicasegurancacomunicacao.enumeration.TipoLocalidade;

public class LocalidadeProxima {

	private String nome;
	private TipoLocalidade tipo;
	private Long quantidadeHabitantes;
	private ProcedimentoEvacuacao procedimentoEvacuacao = new ProcedimentoEvacuacao();
	private List<Destinatario> destinatarios = new ArrayList<Destinatario>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoLocalidade getTipo() {
		return tipo;
	}

	public void setTipo(TipoLocalidade tipo) {
		this.tipo = tipo;
	}

	public Long getQuantidadeHabitantes() {
		return quantidadeHabitantes;
	}

	public void setQuantidadeHabitantes(Long quantidadeHabitantes) {
		this.quantidadeHabitantes = quantidadeHabitantes;
	}

	public ProcedimentoEvacuacao getProcedimentoEvacuacao() {
		return procedimentoEvacuacao;
	}

	public void setProcedimentoEvacuacao(ProcedimentoEvacuacao procedimentoEvacuacao) {
		this.procedimentoEvacuacao = procedimentoEvacuacao;
	}
	
	public List<Destinatario> getDestinatarios() {
		List<Destinatario> clone = new ArrayList<Destinatario>();
		clone.addAll(destinatarios);
		
		return clone;
	}

	public void adicionaDestinatario(Destinatario destinatario) {
		destinatarios.add(destinatario);
	}
	
	public void removeDestinatario(Destinatario destinatario) {
		destinatarios.remove(destinatario);
	}
	
	public LocalidadeProxima cloneSemProcedimentoEvacuacao() {
		LocalidadeProxima clone = new LocalidadeProxima();
		clone.setNome(nome);
		clone.setQuantidadeHabitantes(quantidadeHabitantes);
		clone.setTipo(tipo);
		
		for (Destinatario d : destinatarios) {
			clone.adicionaDestinatario(d);
		}
		
		clone.setProcedimentoEvacuacao(null);
		
		return clone;
	}
}

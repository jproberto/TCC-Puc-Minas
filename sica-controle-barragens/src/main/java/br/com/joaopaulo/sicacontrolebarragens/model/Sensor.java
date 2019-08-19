package br.com.joaopaulo.sicacontrolebarragens.model;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

	private String codigo;
	private String nome;
	private Boolean ativo;
	private List<Double> leituras = new ArrayList<Double>();

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Double> getLeituras() {
		List<Double> clone = new ArrayList<Double>();
		clone.addAll(leituras);
		
		return clone;
	}

	public void adicionarLeitura(Double leitura) {
		leituras.add(leitura);
	}
	
	public void removerLeitura(Double leitura) {
		leituras.remove(leitura);
	}
	
}

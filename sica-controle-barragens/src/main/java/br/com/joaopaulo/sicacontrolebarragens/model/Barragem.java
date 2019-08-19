package br.com.joaopaulo.sicacontrolebarragens.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Barragem {

	@Id
	private String id;
	private String codigo;
	private String nome;
	private Boolean ativo;
	private Localizacao localizacao;
	private List<Sensor> sensores = new ArrayList<Sensor>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String apelido) {
		this.nome = apelido;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public List<Sensor> getSensores() {
		List<Sensor> clone = new ArrayList<Sensor>();
		clone.addAll(sensores);
		
		return clone;
	}

	public void adicionarSensor(Sensor sensor) {
		sensores.add(sensor);
	}
	
	public void removerSensor(Sensor sensor) {
		sensores.remove(sensor);
	}
}

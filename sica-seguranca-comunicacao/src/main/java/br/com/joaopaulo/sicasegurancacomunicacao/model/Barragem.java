package br.com.joaopaulo.sicasegurancacomunicacao.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("barragemSeguranca")
public class Barragem {

	@Id
	private String id;
	private String codigo;
	private String nome;
	private List<LocalidadeProxima> localidadesProximas = new ArrayList<LocalidadeProxima>();
	
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

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<LocalidadeProxima> getLocalidadesProximas() {
		List<LocalidadeProxima> clone = new ArrayList<LocalidadeProxima>();
		clone.addAll(localidadesProximas);
		
		return clone;
	}

	public void adicionaLocalidadeProxima(LocalidadeProxima localidadeProxima) {
		localidadesProximas.add(localidadeProxima);
	}
	
	public void removeLocalidadeProxima(LocalidadeProxima localidadeProxima) {
		localidadesProximas.remove(localidadeProxima);
	}
}

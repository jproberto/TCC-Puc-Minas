package br.com.joaopaulo.externalservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)
public class AlertaDTO {

	private String barragem;
	private String tipoAlerta;
	private String mensagem;
	private String contatoEmergenciaEvacuacao;
	private String procedimentoEvacuacao;

	public String getBarragem() {
		return barragem;
	}

	public void setBarragem(String barragem) {
		this.barragem = barragem;
	}

	public String getTipoAlerta() {
		return tipoAlerta;
	}

	public void setTipoAlerta(String tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getContatoEmergenciaEvacuacao() {
		return contatoEmergenciaEvacuacao;
	}

	public void setContatoEmergenciaEvacuacao(String contatoEmergenciaEvacuacao) {
		this.contatoEmergenciaEvacuacao = contatoEmergenciaEvacuacao;
	}

	public String getProcedimentoEvacuacao() {
		return procedimentoEvacuacao;
	}

	public void setProcedimentoEvacuacao(String procedimentoEvacuacao) {
		this.procedimentoEvacuacao = procedimentoEvacuacao;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return super.toString();
	}
}

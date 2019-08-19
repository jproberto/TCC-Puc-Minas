package br.com.joaopaulo.sicacontrolebarragens.model;

public class Localizacao {

	private String cidade;
	private String estado;
	private Double latitude;
	private Double longitude;
	private String referência;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getReferência() {
		return referência;
	}

	public void setReferência(String referência) {
		this.referência = referência;
	}
	
}
package com.worktogether.entities;

import java.math.BigDecimal;

public class Geolocalizacao {
	
	private Long idGeolocalizacao; 
	private Long idEvento; 
	private String tipo; //TODO DominioTipoGeolocalizacao
	private BigDecimal raio; 
	private String localizacao;
	
	public Long getIdGeolocalizacao() {
		return idGeolocalizacao;
	}
	public void setIdGeolocalizacao(Long idGeolocalizacao) {
		this.idGeolocalizacao = idGeolocalizacao;
	}
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getRaio() {
		return raio;
	}
	public void setRaio(BigDecimal raio) {
		this.raio = raio;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	} 
	
}

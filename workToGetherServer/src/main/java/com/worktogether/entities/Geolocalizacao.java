package com.worktogether.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="geolocalizacao")
public class Geolocalizacao {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name="id")
	private Evento evento;
	
	@Enumerated(EnumType.STRING)
	private DominioTipoGeolocalizacao tipo; 
	
	@Column
	private BigDecimal raio;
	
	@Column
	private String localizacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public DominioTipoGeolocalizacao getTipo() {
		return tipo;
	}
	public void setTipo(DominioTipoGeolocalizacao tipo) {
		this.tipo = tipo;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	} 
	
}

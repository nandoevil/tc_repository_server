package com.worktogether.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQuery (callable= true, name ="callStoreProcedureEventosSugeridosGeo", query ="call sp_localizar_eventos_sugeridos(:latitudeA, :longitudeA, :id_usuario)", resultClass = Evento.class)
@Entity
@Table(name="geolocalizacao")
@XmlRootElement
public class Geolocalizacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_evento")
	private Long idEvento;
	
	@Enumerated(EnumType.STRING)
	private DominioTipoGeolocalizacao tipo; 
	
	@Column
	private double raio;
	
	@Column
	private BigDecimal latitude;
	
	@Column
	private BigDecimal longitude;
	
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
	public DominioTipoGeolocalizacao getTipo() {
		return tipo;
	}
	public void setTipo(DominioTipoGeolocalizacao tipo) {
		this.tipo = tipo;
	}
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	
	
}

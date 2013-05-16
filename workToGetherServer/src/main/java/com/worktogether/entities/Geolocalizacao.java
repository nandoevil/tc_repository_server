package com.worktogether.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne 
	@JoinColumn(name="id_evento")
	private Evento evento;
	
	@Enumerated(EnumType.STRING)
	private DominioTipoGeolocalizacao tipo; 
	
	@Column
	private double raio;
	
	@Column
	private double latitude;
	
	@Column
	private double longitude;
	
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
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}

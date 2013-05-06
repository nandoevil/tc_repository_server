package com.worktogether.entities;


import java.util.Date;

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

@Entity
@Table(name="presenca")
public class Presenca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne 
	@JoinColumn(name="id_evento")
	private Evento evento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	@Enumerated(EnumType.STRING)
	private DominioTipoPresenca tipoPresenca; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public DominioTipoPresenca getTipoPresenca() {
		return tipoPresenca;
	}
	public void setTipoPresenca(DominioTipoPresenca tipoPresenca) {
		this.tipoPresenca = tipoPresenca;
	}

}

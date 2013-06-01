package com.worktogether.entities;


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

@Entity
@Table(name="presenca")
@XmlRootElement
public class Presenca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_usuario")
	private Long idUsuario;
	
	@Column(name="id_evento")
	private Long idEvento;
	
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
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}

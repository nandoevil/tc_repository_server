package com.worktogether.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="presenca")
public class Presenca {
	
	private Usuario usuario; 
	private Evento evento;
	private Date dataHora;
	private String tipoPresenca; //TODO DominioTipoPresenca
	
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
	public String getTipoPresenca() {
		return tipoPresenca;
	}
	public void setTipoPresenca(String tipoPresenca) {
		this.tipoPresenca = tipoPresenca;
	}
	
	

}

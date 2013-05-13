package com.worktogether.dto;

import java.sql.Timestamp;

import com.worktogether.entities.Evento;

public class PresencaDTO {
	
	private Long id;
	private UsuarioDTO usuario;
	private EventoDTO evento;
	private Timestamp dataHora;
	//TODO implementar entidades
	//private DominioTipoPresenca tipo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public Timestamp getDataHora() {
		return dataHora;
	}
	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}
	public EventoDTO getEvento() {
		return evento;
	}
	public void setEvento(EventoDTO evento) {
		this.evento = evento;
	}
	
}

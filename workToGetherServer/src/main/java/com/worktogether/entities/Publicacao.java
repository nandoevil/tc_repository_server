package com.worktogether.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="publicacao")
public class Publicacao {
	
	private byte[] imagem; 
	private String redeSocial; //TODO DominioRedeSocial
	private String comentario; 
	private Long idEvento;
	
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public String getRedeSocial() {
		return redeSocial;
	}
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	} 
	
}

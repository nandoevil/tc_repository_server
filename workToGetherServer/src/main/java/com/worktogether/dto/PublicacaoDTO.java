package com.worktogether.dto;

public class PublicacaoDTO {
	
	private Byte imagem;
	//TODO implementar entidades
	//private DominioRedeSocial redeSocial;
	private String comentario;
	private Long idEvento;
	
	public Byte getImagem() {
		return imagem;
	}
	public void setImagem(Byte imagem) {
		this.imagem = imagem;
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

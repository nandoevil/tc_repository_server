package com.worktogether.entities;

public class Habilidade {
	
	private Long idHabilidade;
	private String descricao;
	private String tipo;
	
	public Long getIdHabilidade() {
		return idHabilidade;
	}
	public void setIdHabilidade(Long idHabilidade) {
		this.idHabilidade = idHabilidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

package com.worktogether.dto;

import java.util.Date;

public class HabilidadeDTO {
	
	private Long id;
	private String descricao;
	private String tipo;
	private Long dataHora;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getDataHora() {
		return dataHora;
	}

	public void setDataHora(Long dataHora) {
		this.dataHora = dataHora;
	}

}

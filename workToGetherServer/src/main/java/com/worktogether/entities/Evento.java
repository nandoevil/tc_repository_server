package com.worktogether.entities;

import java.sql.Date;
import java.util.List;

public class Evento {
	
	private Long idEvento; 
	private String descricao; 
	private Date dataHora; 
	private String situacao; 
	private List<Habilidade> habilidades; 
	private String objetivo; 
	private byte[] imagem; 
	private List<Geolocalizacao> geolocalizacoes; 
	private List<Presenca> presencas; 
	private List<Publicacao> publicacoes; 
	private String tipo; //TODO DominioTipoEvento 
	private boolean isSugerido;
	
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public List<Geolocalizacao> getGeolocalizacoes() {
		return geolocalizacoes;
	}
	public void setGeolocalizacoes(List<Geolocalizacao> geolocalizacoes) {
		this.geolocalizacoes = geolocalizacoes;
	}
	public List<Presenca> getPresencas() {
		return presencas;
	}
	public void setPresencas(List<Presenca> presencas) {
		this.presencas = presencas;
	}
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isSugerido() {
		return isSugerido;
	}
	public void setSugerido(boolean isSugerido) {
		this.isSugerido = isSugerido;
	} 
	
}

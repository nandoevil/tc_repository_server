package com.worktogether.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {
	
	@Id
	private Long id;
	
	@Column
	private String descricao;
	
	@Column
	private Date dataHora;
	
	@Column
	private String situacao;
	
	@Column
	private List<Habilidade> habilidades;
	
	@Column
	private String objetivo;
	
	@Column
	private byte[] imagem;
	
	@Column
	private List<Geolocalizacao> geolocalizacoes;
	
	@Column
	private List<Presenca> presencas;
	
	@Column
	private List<Publicacao> publicacoes;
	
	@Column
	private String tipo; //TODO DominioTipoEvento
	
	@Column
	private boolean isSugerido;
	
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

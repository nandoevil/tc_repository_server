package com.worktogether.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.worktogether.entities.Usuario;

public class EventoDTO {
	
	private Long id;
	private Usuario usuario;
	private String nome;
	private String descricao;
	private String objetivo;
	private byte[] imagem;
	private String tipo;
	private String situacao;
	private Date dataHora;
	private List<HabilidadeDTO> habilidades;
	private List<GeolocalizacaoDTO> geolocalizacoes;
	private List<PresencaDTO> presencas;
	private List<PublicacaoDTO> publicacoes;
	private double sugerido;
	private Long colocacao;
	private BigDecimal pontuacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Long getColocacao() {
		return colocacao;
	}
	public void setColocacao(Long colocacao) {
		this.colocacao = colocacao;
	}
	public double getSugerido() {
		return sugerido;
	}
	public void setSugerido(double sugerido) {
		this.sugerido = sugerido;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<HabilidadeDTO> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<HabilidadeDTO> habilidades) {
		this.habilidades = habilidades;
	}
	public List<GeolocalizacaoDTO> getGeolocalizacoes() {
		return geolocalizacoes;
	}
	public void setGeolocalizacoes(List<GeolocalizacaoDTO> geolocalizacoes) {
		this.geolocalizacoes = geolocalizacoes;
	}
	public List<PublicacaoDTO> getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(List<PublicacaoDTO> publicacoes) {
		this.publicacoes = publicacoes;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public List<PresencaDTO> getPresencas() {
		return presencas;
	}
	public void setPresencas(List<PresencaDTO> presencas) {
		this.presencas = presencas;
	}
	public BigDecimal getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(BigDecimal pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}

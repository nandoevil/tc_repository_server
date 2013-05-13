package com.worktogether.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private String apelido;
	private String telefone;
	private String email;
	private List<HabilidadeDTO> habilidades;
	private List<EventoDTO> eventos;
	private String senha;
	private List<PresencaDTO> presencas;
	private BigDecimal pontuacao;
	private List<PublicacaoDTO> publicacoes; 
	private byte[] imagem;
	private Date dataHora;
	private Long colocacaoRanking;
	
	public Long getColocacaoRanking() {
		return colocacaoRanking;
	}
	public void setColocacaoRanking(Long colocacaoRanking) {
		this.colocacaoRanking = colocacaoRanking;
	}
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
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public BigDecimal getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(BigDecimal pontuacao) {
		this.pontuacao = pontuacao;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public List<PresencaDTO> getPresencas() {
		return presencas;
	}
	public void setPresencas(List<PresencaDTO> presencas) {
		this.presencas = presencas;
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
	public List<HabilidadeDTO> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<HabilidadeDTO> habilidades) {
		this.habilidades = habilidades;
	}
	public List<EventoDTO> getEventos() {
		return eventos;
	}
	public void setEventos(List<EventoDTO> eventos) {
		this.eventos = eventos;
	}
	
}

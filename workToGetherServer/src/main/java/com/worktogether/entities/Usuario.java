package com.worktogether.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id; 
	
	@Column
	private String nome;
	
	@Column
	private String apelido;
	
	@Column
	private String telefone;
	
	@Column
	private String email;
	
	@Column
	private List<Habilidade> habilidades;
	
	@Column
	private List<Evento> eventos;
	
	@Column
	private Long senha;
	
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DELETE})
	@OneToMany(mappedBy="usuario")
	private List<Presenca> presencas;
	
	@Column
	private BigDecimal pontuacao;
	
	
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DELETE})
	@OneToMany(mappedBy="usuario")
	private List<Publicacao> publicacoes; 
	
	@Column
	private byte[] imagem;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
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
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public Long getSenha() {
		return senha;
	}
	public void setSenha(Long senha) {
		this.senha = senha;
	}
	public List<Presenca> getPresencas() {
		return presencas;
	}
	public void setPresencas(List<Presenca> presencas) {
		this.presencas = presencas;
	}
	public BigDecimal getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(BigDecimal pontuacao) {
		this.pontuacao = pontuacao;
	}
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	} 
	
}

package com.worktogether.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="usuario")
@XmlRootElement
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="nome")
	private String nome;
	
	@Column
	private String apelido;
	
	@Column
	private String telefone;
	
	@Column
	private String email;
	
	@ManyToMany
	@JoinTable(name= "usuario_habilidade" ,
	joinColumns=@JoinColumn(name= "id_usuario" ),
	inverseJoinColumns=@JoinColumn(name= "id_habilidade" ))
	private List<Habilidade> habilidades;
	
	@ManyToMany
	@JoinTable(name= "usuario_evento" ,
	joinColumns=@JoinColumn(name= "id_usuario" ),
	inverseJoinColumns=@JoinColumn(name= "id_evento" ))
	private List<Evento> eventos;
	
	@Column
	private String senha;
	
	@OneToMany 
	@JoinColumn(name="id_usuario")
	private List<Presenca> presencas;
	
	@Column
	private BigDecimal pontuacao;
	
	
	@OneToMany 
	@JoinColumn(name="id_usuario") //TODO Nao sei se esta certo
	private List<Publicacao> publicacoes; 
	
	@Lob
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
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
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

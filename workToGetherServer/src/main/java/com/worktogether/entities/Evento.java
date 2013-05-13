package com.worktogether.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQuery (callable= true, name ="callStoreProcedureEventosSugeridos", query ="call sp_eventos_sugeridos(:id_evento_list, :id_usuario, :visualizacao)", resultClass = Evento.class)
@Entity
@Table(name="evento")
@XmlRootElement
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@ManyToMany
	@JoinTable(name="evento_habilidade", 
	           joinColumns= @JoinColumn(name= "id_evento" ), 
	           inverseJoinColumns=@JoinColumn(name= "id_habilidade" ))
	private List<Habilidade> habilidades;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@Column
	private String objetivo;
	
	@Column
	private byte[] imagem;
	
	@OneToMany
	@JoinColumn(name="id_evento")
	private List<Geolocalizacao> geolocalizacoes;
	
	@OneToMany
	@JoinColumn(name="id_evento")
	private List<Presenca> presencas;
	
	@OneToMany
	@JoinColumn(name="id_evento")
	private List<Publicacao> publicacoes;
	
	@Enumerated(EnumType.STRING)
	private DominioTipoEvento tipo; 
	
	@Column
	private String situacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	@Column
	private double sugerido;
	
	@Column
	private Long colocacao;
	
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
	public DominioTipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(DominioTipoEvento tipo) {
		this.tipo = tipo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSugerido() {
		return sugerido;
	}
	public void setSugerido(double sugerido) {
		this.sugerido = sugerido;
	}
	public Long getColocacao() {
		return colocacao;
	}
	public void setColocacao(Long colocacao) {
		this.colocacao = colocacao;
	}

}

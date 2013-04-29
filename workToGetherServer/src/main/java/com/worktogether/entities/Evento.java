package com.worktogether.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	@Column
	private String situacao;
	
	@OneToMany
	@JoinTable(name="eventoHabilidade", 
	           joinColumns= @JoinColumn(name= "idEvento" ), 
	           inverseJoinColumns=@JoinColumn(name= "idHabilidade" ))
	private List<Habilidade> habilidades;
	
	@Column
	private String objetivo;
	
	@Column
	private byte[] imagem;
	
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DELETE})
	@OneToMany(mappedBy="evento")
	private List<Geolocalizacao> geolocalizacoes;
	
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DELETE})
	@OneToMany(mappedBy="evento")
	private List<Presenca> presencas;
	
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DELETE})
	@OneToMany(mappedBy="evento")
	private List<Publicacao> publicacoes;
	
	@Enumerated(EnumType.STRING)
	private DominioTipoEvento tipo; 
	
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
	public boolean isSugerido() {
		return isSugerido;
	}
	public void setSugerido(boolean isSugerido) {
		this.isSugerido = isSugerido;
	}
	public DominioTipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(DominioTipoEvento tipo) {
		this.tipo = tipo;
	} 
	
}

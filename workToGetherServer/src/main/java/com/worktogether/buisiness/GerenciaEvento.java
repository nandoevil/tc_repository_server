package com.worktogether.buisiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.worktogether.entities.Convite;
import com.worktogether.entities.Evento;
import com.worktogether.entities.Geolocalizacao;
import com.worktogether.entities.Presenca;
import com.worktogether.entities.Usuario;

@Stateless
public class GerenciaEvento {
	
	@PersistenceContext
	private EntityManager em;
	
	public Long cadastrarEvento(Evento evento){
		
		Evento e = em.merge(evento);
		Long id = e.getId();
		
		List<Geolocalizacao> list = e.getGeolocalizacoes();
		
		for (Geolocalizacao geolocalizacao : list) {
			geolocalizacao.setEvento(e);
			em.persist(geolocalizacao);
		}
		
		em.persist(e);
		
		return id;
	} 
	
	private void vincularUsuarioEvento(Usuario usuario, List<Evento> eventos){} 
	private void validarRaio(Geolocalizacao geoLocalizacao, String localizacaoAtual){} 
	private void validarConfirmacaoPresenca(Evento evento, String localizacaoAtual){} 
	private void salvarPresenca(Presenca presenca){} 
	private List<Evento> buscarEventos(Usuario usuario){
		return null;
	} 
	private List<Evento> buscarEventosSugeridos(Usuario usuario){
		return null;
	} 
	private List<Convite> enviarConviteAutomatico(Usuario usuario, String localizacao){
		return null;
	} 
	private String atualizarListaEventosUsuairo(Usuario usuario, List<Presenca> eventos){
		return null;
	} 
	private String confirmarPresenca(Presenca presencao, String localizacaoAtual){
		return null;
	} 
	private List<Evento> verificarAtualizacaoEventos(Long idUltimoEvento){
		return null;
	} 
	private List<Evento> marcarEventosSugeridos(List<Evento> eventos, List<Evento> eventosSugeridos){
		return null;
	} 
	private List<Convite> buscarEventosPontosProximos(String localizacao, Long idUsuario){
		return null;
	} 
	private void armazenarConvitesEnviados(Long idUsuario, List<Convite> convites){} 
}

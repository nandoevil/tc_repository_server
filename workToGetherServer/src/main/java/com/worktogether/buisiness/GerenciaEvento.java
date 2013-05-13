package com.worktogether.buisiness;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import com.worktogether.entities.Convite;
import com.worktogether.entities.DominioTipoEvento;
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
	
	public List<Evento> buscarEventos(Usuario usuario){
		//TODO REMOVER
		List<Evento> listteste = new ArrayList<Evento>();
		Evento ev = new Evento();
		ev.setId(new Long(1));
		Evento ev2 = new Evento();
		ev2.setId(new Long(2));
		
		listteste.add(ev);
		listteste.add(ev2);
		
		usuario.setEventos(listteste);
			
		List<Evento> list = usuario.getEventos();
		StringBuilder eventoIds = new StringBuilder();
		
		if(list != null && list.size() > 0){
			int size = list.size();
			
			for (int i=0, s = size; i < size; i++) {
				eventoIds.append(list.get(i).getId());
				
				if(i != size - 1){
					eventoIds.append(";");
				}
				
			}
		}
		
		Session session = (Session) em.getDelegate();
		Query query = session.getNamedQuery("callStoreProcedureEventosSugeridos");
		/*query.setParameter("id_evento_list", eventoIds.toString());
		query.setParameter("id_usuario", usuario.getId());
		query.setParameter("visualizacao", new Long(1));*/
		
		query.setParameter("id_evento_list", eventoIds.toString());
		query.setParameter("id_usuario", usuario.getId());
		query.setParameter("visualizacao", new Long(1));
		
		List eventoList = query.list();
		List<Evento> retornoList = new ArrayList<Evento>();
		
		for (int i=0, t = eventoList.size(); i < t; i++) {
			Evento e = (Evento) eventoList.get(i);
			e.getHabilidades();
			e.getPresencas();
			e.getGeolocalizacoes();
			e.getPublicacoes();
			retornoList.add(e);
		}
		
		return retornoList;
		
	} 
	
	//TODO Verificar modelagem
	public List<Evento> buscarEventosSugeridos(Usuario usuario) {
		try{
			
			if(usuario == null || usuario.getHabilidades() == null || usuario.getHabilidades().size() == 0){
				return null;
			}
			
			/*//TODO LOGICA PARA EVENTOS SUGERIDOS
			TypedQuery<Evento> qry = em.createQuery("select e from Evento e", Evento.class);
			qry.setParameter(1, email.trim());
			List<Evento> list = qry.getResultList();*/
			
			List<Evento> list = new ArrayList<Evento>();
			Evento e = new Evento();
			e.setId(new Long(1));
			e.setDescricao("Estudo");
			e.setNome("Novo Evento");
			e.setObjetivo("Novo");
			e.setSituacao("Ativo");
			e.setDataHora(new Date());
			e.setTipo(DominioTipoEvento.ESTUDO);
			e.setSugerido(0d);
			
			list.add(e);
			
			return list;
			
		}catch(Throwable e){
			return null;
		}
	} 
	
	private void vincularUsuarioEvento(Usuario usuario, List<Evento> eventos){} 
	private void validarRaio(Geolocalizacao geoLocalizacao, String localizacaoAtual){} 
	private void validarConfirmacaoPresenca(Evento evento, String localizacaoAtual){} 
	private void salvarPresenca(Presenca presenca){} 
	
	
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

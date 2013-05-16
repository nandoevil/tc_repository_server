package com.worktogether.buisiness;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import com.worktogether.dto.EventoDTO;
import com.worktogether.dto.HabilidadeDTO;
import com.worktogether.entities.Convite;
import com.worktogether.entities.Evento;
import com.worktogether.entities.Geolocalizacao;
import com.worktogether.entities.Habilidade;
import com.worktogether.entities.Presenca;
import com.worktogether.entities.Usuario;
import com.worktogether.gcm.GCMController;

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
	
	public List<EventoDTO> buscarEventos(Usuario usuario){
		//PEGA OS EVENTOS QUE O USUARIO ESTA VISUALIZANDO E CRIA UMA STRING
		//COM OS IDS PARA SER ENVIADO COM PARAMETRO A PROCEDURE
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
		
		//CHAMADA DA PROCEDURE SP_SUGERIR_EVENTOS PARA TODOS OS EVENTOS
		Session session = (Session) em.getDelegate();
		Query query = session.getNamedQuery("callStoreProcedureEventosSugeridos");
		query.setParameter("id_evento_list", eventoIds.toString());
		query.setParameter("id_usuario", usuario.getId());
		query.setParameter("visualizacao", new Long(1));
		
		query.setParameter("id_evento_list", eventoIds.toString());
		query.setParameter("id_usuario", usuario.getId());
		query.setParameter("visualizacao", new Long(1));
		
		List<Evento> eventoList = (List<Evento>) query.list();
		List<EventoDTO> retornoList = new ArrayList<EventoDTO>();
		
		for (int i=0, t = eventoList.size(); i < t; i++) {
			Evento entity = (Evento) eventoList.get(i);
			EventoDTO dto = new EventoDTO();
			
			dto.setId(entity.getId());
			dto.setNome(entity.getNome());
			dto.setDataHora(entity.getDataHora().getTime());
			dto.setColocacao(entity.getColocacao());
			dto.setDescricao(entity.getDescricao());
			dto.setObjetivo(entity.getObjetivo());
			dto.setImagem(entity.getImagem());
			dto.setSugerido(entity.getSugerido());
			
			List<Habilidade> habilidadesEntity = entity.getHabilidades();
			List<HabilidadeDTO> hlistDTO = new ArrayList<HabilidadeDTO>();
			
			for (Habilidade habilidade : habilidadesEntity) {
				HabilidadeDTO hDTO = new HabilidadeDTO();
				
				hDTO.setDescricao(habilidade.getDescricao());
				hDTO.setId(habilidade.getId());
				hDTO.setTipo(habilidade.getTipo());
				
				hlistDTO.add(hDTO);
			}
			
			dto.setHabilidades(hlistDTO);
			
			retornoList.add(dto);
		}
		
		return retornoList;
		
	} 
	
	//TODO Verificar modelagem
	public List<EventoDTO> buscarEventosSugeridos(Usuario usuario) {
		try{
			
			if(usuario == null || usuario.getHabilidades() == null || usuario.getHabilidades().size() == 0){
				return null;
			}
			
			//PEGA OS EVENTOS QUE O USUARIO ESTA VISUALIZANDO E CRIA UMA STRING
			//COM OS IDS PARA SER ENVIADO COM PARAMETRO A PROCEDURE
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
			
			//CHAMADA DA PROCEDURE SP_SUGERIR_EVENTOS PARA APENAS EVENTOS SUGERIDOS
			Session session = (Session) em.getDelegate();
			Query query = session.getNamedQuery("callStoreProcedureEventosSugeridos");
			query.setParameter("id_evento_list", eventoIds.toString());
			query.setParameter("id_usuario", usuario.getId());
			query.setParameter("visualizacao", new Long(1));
			
			List<Evento> eventoList = (List<Evento>) query.list();
			List<EventoDTO> retornoList = new ArrayList<EventoDTO>();
			
			for (int i=0, t = eventoList.size(); i < t; i++) {
				Evento entity = (Evento) eventoList.get(i);
				EventoDTO dto = new EventoDTO();
				
				dto.setId(entity.getId());
				dto.setNome(entity.getNome());
				dto.setDataHora(entity.getDataHora().getTime());
				dto.setColocacao(entity.getColocacao());
				dto.setDescricao(entity.getDescricao());
				dto.setObjetivo(entity.getObjetivo());
				dto.setImagem(entity.getImagem());
				dto.setSugerido(entity.getSugerido());
				
				List<Habilidade> hlist = entity.getHabilidades();
				List<HabilidadeDTO> hlistDTO = new ArrayList<HabilidadeDTO>();
				
				for (Habilidade habilidade : hlist) {
					HabilidadeDTO hDTO = new HabilidadeDTO();
					
					hDTO.setDescricao(habilidade.getDescricao());
					hDTO.setId(habilidade.getId());
					hDTO.setTipo(habilidade.getTipo());
				}
				
				dto.setHabilidades(hlistDTO);
				
				retornoList.add(dto);
			}
			
			return retornoList;
			
		}catch(Throwable e){
			return null;
		}
	} 
	
	//TODO MODELAR
	public void enviarConviteAutomatico(String usuarioInfo, String localizacao){
		
		if(usuarioInfo != null && !"".equalsIgnoreCase(usuarioInfo) && 
		   localizacao != null && !"".equalsIgnoreCase(localizacao)){
			
			String[] latiLong = localizacao.split(";");
			String[] ids = usuarioInfo.split(";");
			
			//CHAMADA DA PROCEDURE sp_localizar_eventos_sugeridos PARA APENAS EVENTOS SUGERIDOS
			Session session = (Session) em.getDelegate();
			Query query = session.getNamedQuery("callStoreProcedureEventosSugeridosGeo");
			query.setParameter("id_usuario", ids[0]);
			query.setParameter("latitudeA", latiLong[0]);
			query.setParameter("longitudeA", latiLong[1]);
			
			List<Evento> eventoList = (List<Evento>) query.list();
			for (Evento evento : eventoList) {
				new Thread(new GCMController(ids[0], evento)).start();
			}
		}
	} 
	
	
	private void vincularUsuarioEvento(Usuario usuario, List<Evento> eventos){} 
	private void validarRaio(Geolocalizacao geoLocalizacao, String localizacaoAtual){} 
	private void validarConfirmacaoPresenca(Evento evento, String localizacaoAtual){} 
	private void salvarPresenca(Presenca presenca){} 
	
	
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

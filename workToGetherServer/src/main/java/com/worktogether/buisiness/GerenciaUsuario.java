package com.worktogether.buisiness;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.worktogether.dto.EventoDTO;
import com.worktogether.dto.UsuarioDTO;
import com.worktogether.entities.Evento;
import com.worktogether.entities.Usuario;
import com.worktogether.webService.WSReturn;

@Stateless
public class GerenciaUsuario {
	
	@PersistenceContext
	private EntityManager em;
	
	public void validarDadosUsuario(Usuario usuario){} 
	
	public Long cadastrarUsuario(Usuario usuario) {
		
		Usuario u = em.merge(usuario);
		Long id = u.getId();
		
		em.persist(u);
		
		return id;
	}
	
	public List<UsuarioDTO> buscarRankingUsuario(BigDecimal  pontuacaoUltimo){
		try{
			boolean isPrimeiraConsulta = (pontuacaoUltimo == null);
			boolean isOutraConsulta = (!isPrimeiraConsulta && pontuacaoUltimo.doubleValue() > 0);
			
			if(!isPrimeiraConsulta && !isOutraConsulta){
				return new ArrayList<UsuarioDTO>();
			}
			//TODO BUG RETORNANDO MAIS DE UMA VEZ MESMO USUARIO
			boolean isId = (pontuacaoUltimo != null);
			
			StringBuilder sql = new StringBuilder("select u from Usuario u");
			
			if(!isPrimeiraConsulta && isOutraConsulta){
				sql.append(" where u.pontuacao > ?1");
			}
			
			sql.append(" order by u.pontuacao");
			
			TypedQuery<Usuario> qry = em.createQuery(sql.toString(), Usuario.class);
			qry.setMaxResults(10);
			
			if(!isPrimeiraConsulta && isOutraConsulta){
				qry.setParameter(1, pontuacaoUltimo);
			}
			
			List<Usuario> ranking = qry.getResultList();
			List<UsuarioDTO> usuarioList = new LinkedList<UsuarioDTO>();
			
			for (int i= 0, size = ranking.size(); i < size; i++) {
				Usuario usuario =  ranking.get(i);
				
				UsuarioDTO usu = new UsuarioDTO();
				
				usu.setId(usuario.getId());
				usu.setApelido(usuario.getApelido());
				usu.setNome(usuario.getNome());
				usu.setColocacaoRanking(new Long(i + 1));
				usu.setImagem(usuario.getImagem());
				
				usuarioList.add(usu);
				
			}
				
			return usuarioList;
			 
		}catch(NoResultException e){
			return null;
			
		}catch(Throwable e){
			return null;
			
		}
	}
	
	public WSReturn isEmailExistente(String email){
		WSReturn wr = new WSReturn();
		try{
			if(email == null || "".equalsIgnoreCase(email)){
				wr.setValue("Parâmetro inválido para validação do email");
			}
			
			TypedQuery<Usuario> qry = em.createQuery("select u from Usuario u where u.email = ?1", Usuario.class);
			qry.setParameter(1, email.trim());
			Usuario u = qry.getSingleResult();
			
			 wr.setValue("Email já cadastrado");
			 
			 return wr;
			
		}catch(NoResultException e){
			wr.setValue(DominioStatusRequsicao.SUCESS.toString());
			return wr;
			
		}catch(Throwable e){
			wr.setValue(DominioStatusRequsicao.SERVER_ERROR.toString());
			return wr;
		}
	}
	
	public List<Evento> sugerirEventosUsuario(Usuario usuario){
		return null;
	} 
	
	public String autenticarUsuario(Usuario usuario){
		try{
			if(usuario == null || usuario.getEmail() == null || usuario.getSenha() == null){
				return DominioStatusRequsicao.AUTENTICATION_ERROR.toString();
			}
			
			TypedQuery<Usuario> qry = em.createQuery("select u from Usuario u where u.email = ?1 and u.senha = ?2", Usuario.class);
			qry.setParameter(1, usuario.getEmail().trim());
			qry.setParameter(2, usuario.getSenha().trim());
			Usuario u = qry.getSingleResult();
			
			 return DominioStatusRequsicao.SUCESS.toString();
			 
			 
		}catch(NoResultException e){
			return DominioStatusRequsicao.DENIED.toString();
			
		}catch(Throwable e){
			return DominioStatusRequsicao.SERVER_ERROR.toString();
			
		}
	} 
	
	
	public Usuario findById(int id) {

		return em.find(Usuario.class, id);		
	}
	
	public List<Usuario> findByName(String name) {

		return em.createQuery("from Usuario p where p.name = ?1", Usuario.class)
				.setParameter(1, name)
				.getResultList();
	}
	
	public List<Usuario> findAll() {

		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}
	
	public Usuario update(Usuario usuario) {

		return em.merge(usuario);
	}
	
	public void remove(int id) {

		em.remove(this.findById(id));
	}

}

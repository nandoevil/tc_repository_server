package com.worktogether.buisiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.worktogether.entities.Evento;
import com.worktogether.entities.Usuario;

@Stateless
public class GerenciaUsuario {
	
	@PersistenceContext
	private EntityManager em;
	
	public void validarDadosUsuario(Usuario usuario){} 
	
	public List<Evento> cadastrarUsuario(Usuario usuario) {
		
		this.persist(usuario);
		
		return this.buscarEventosSugeridos(usuario);
	} 
	
	
	public String isEmailExistente(String email){
		try{
			
			if(email == null || "".equalsIgnoreCase(email)){
				return "Parâmetro inválido para validação do email";
			}
			
			TypedQuery<Usuario> qry = em.createQuery("select u from Usuario u where u.email = ?1", Usuario.class);
			qry.setParameter(1, email.trim());
			Usuario u = qry.getSingleResult();
			
			 return "Email já cadastrado no sistema";
			
		}catch(NoResultException e){
			return DominioStatusRequsicao.SUCESS.toString();
			
		}catch(Throwable e){
			return DominioStatusRequsicao.SERVER_ERROR.toString();
			
		}
	}
	
	//TODO Verificar modelagem
	public List<Evento> buscarEventosSugeridos(Usuario usuario) {
		try{
			
			if(usuario == null || usuario.getHabilidades() == null || usuario.getHabilidades().size() == 0){
				return null;
			}
			
			//TODO LOGICA PARA EVENTOS SUGERIDOS
			TypedQuery<Evento> qry = em.createQuery("select e from Usuario e", Evento.class);
			//qry.setParameter(1, email.trim());
			List<Evento> list = qry.getResultList();
			
			return list;
			
		}catch(Throwable e){
			return null;
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
	
	public void persist(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void remove(int id) {

		em.remove(this.findById(id));
	}

}

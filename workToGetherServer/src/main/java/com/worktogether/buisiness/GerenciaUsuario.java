package com.worktogether.buisiness;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.worktogether.entities.Evento;
import com.worktogether.entities.Usuario;

@Stateless
public class GerenciaUsuario {
	
	@PersistenceContext
	private EntityManager em;
	
	public void validarDadosUsuario(Usuario usuario){} 
	
	public List<Evento> cadastrarUsuario(Usuario usuario){
		
		this.persist(usuario);
		
		return new ArrayList<Evento>();
	} 
	public String isEmailExistente(String email){
		
		return "Usuário já cadastrado no sistema";
	} 
	public List<Evento> sugerirEventosUsuario(Usuario usuario){
		return null;
	} 
	public String autenticarUsuario(Usuario usuario){
		return null;
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

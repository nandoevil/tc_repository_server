package com.worktogether.buisiness;

import java.util.List;

import com.worktogether.dataBase.PersistenceFactory;
import com.worktogether.entities.Evento;
import com.worktogether.entities.Usuario;

public class GerenciaUsuario {
	
	private PersistenceFactory psf = PersistenceFactory.instance();
	
	public void validarDadosUsuario(Usuario usuario){} 
	
	public List<Evento> cadastrarUsuario(Usuario usuario){
		
		psf.persist(usuario);
		
		return null;
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

}

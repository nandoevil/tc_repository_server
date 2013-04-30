package com.worktogether.dataBase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistenceFactory {
	
	private static PersistenceFactory instance;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static final PersistenceFactory instance(){
		
		if(instance == null){
			instance = new PersistenceFactory();
			emf = Persistence.createEntityManagerFactory("WT-PU");
			em = emf.createEntityManager();
		}
		
		return instance;
	}
	
	public void persist(Object e){
		em.persist(e);
	}
	
	public void delete(Object e){
		em.remove(e);
	}
}

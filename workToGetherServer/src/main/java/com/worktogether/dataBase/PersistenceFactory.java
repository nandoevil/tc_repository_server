package com.worktogether.dataBase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistenceFactory {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PersistenceFactory(){
		
		this.emf = Persistence.createEntityManagerFactory("WT-PU");
		this.em = emf.createEntityManager();
		
	}
	
	public void persist(Object e){
		em.persist(e);
		this.close();
	}
	
	public void delete(Object e){
		em.remove(e);
	}
	
	private void close(){
		this.em.close();
		this.emf.close();
	}
}

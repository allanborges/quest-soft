package br.com.softbox.produces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class FabricaEntityManager {
	
	private EntityManagerFactory factory;
	
	public FabricaEntityManager(){
		factory = Persistence.createEntityManagerFactory("questPU");
	}
	
	@Produces
	@RequestScoped
	public EntityManager criaEntityManager(){
		return factory.createEntityManager();
	}
	

	public void fechaManager(@Disposes EntityManager manager){
		manager.close();
	}
	
}

package br.com.softbox.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.softbox.model.Pergunta;
import br.com.softbox.model.Quest;
import br.com.softbox.model.RespostaUsuario;

public class Persiste {
	
	private static EntityManager entityManager;
	

	public static void main(String[] args) {
		EntityManager entity = getEntityManager();
		
		entity.getTransaction().begin();
		
		Quest quest = new Quest();
		quest.setEnunciado("teste de enunciado");
		quest.setAberta(true);
		
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		
		Pergunta perg1 = new Pergunta();
		perg1.setPergunta("Qual seu nome ?");
		
		Pergunta perg2 = new Pergunta();
		perg2.setPergunta("Qual sua idade ?");
		
		Pergunta perg3 = new Pergunta();
		perg3.setPergunta("Qual seu sexo?");
		
		perguntas.add(perg1);
		perguntas.add(perg2);
		perguntas.add(perg3);
		
		quest.setPerguntas(perguntas);
		
		entity.persist(quest);
		
		//Resposta do usuario
		
		RespostaUsuario resp = new RespostaUsuario();
		resp.setEmail("allanborges@gmail.com");
		resp.setNome("Allan Borges");
		resp.setIdPergunta(perg1.getId());
		resp.setResposta("qualquer coisa");
		resp.setIdQuest(quest.getId());
		
		entity.persist(resp);
		
		entity.getTransaction().commit();
		
		entity.close();
		
	}
	
	private static EntityManager getEntityManager() {
	    EntityManagerFactory factory = Persistence
	            .createEntityManagerFactory("questPU");
	    if (entityManager == null) {
	        entityManager = factory.createEntityManager();
	    }
	 
	    return entityManager;
	}
	/*public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory;
    }*/

}

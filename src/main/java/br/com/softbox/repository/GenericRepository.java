package br.com.softbox.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import br.com.softbox.interceptors.Transactional;

public abstract class GenericRepository <T> implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Inject
    EntityManager manager;
	
	private Class<T> domain;
	
	GenericRepository(Class<T> clazz){
		domain = clazz;
	}

	
	public Session getSession(){
		return manager.unwrap(Session.class);
	}
	
	@Transactional
	public T buscaPorId(Long id){
		return (T) manager.find(domain, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> buscaPorExample(T domain){
		Session s = manager.unwrap(Session.class);
		Example expl = Example.create(domain);
		expl.enableLike(MatchMode.ANYWHERE);
		expl.ignoreCase();
		Criteria cri = s.createCriteria(this.domain, "domain");
		cri.add(expl);
		
		return cri.list();
	}
	
	@Transactional
	public T guardar(T domain){
		domain = manager.merge(domain);
		return domain;
	}
	
	@Transactional
	public void remover(Long id){
	 try{	
		T domain = buscaPorId(id);
		manager.remove(domain);
		manager.flush();
	 } catch(PersistenceException e){
		 throw new RuntimeException("Objeto não pode ser excluído.");
	 }	 
	}

}

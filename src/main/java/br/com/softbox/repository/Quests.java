package br.com.softbox.repository;

import java.util.List;

import br.com.softbox.model.Quest;

public class Quests extends GenericRepository<Quest> {

	private static final long serialVersionUID = 1L;
	
	public Quests() {
		super(Quest.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Quest> buscaTodasQuests(){
		return manager.createQuery("FROM Quest Order By id").getResultList();
	}
	
	public Quest carregaQuestAberta(Long id){
		return (Quest) manager.createQuery("FROM Quest quest WHERE quest.id = :id AND quest.aberta = true")
					.setParameter("id", id).getSingleResult();
	}
	
	public Quest carregaQuestFechada(Long id){
		return (Quest) manager.createQuery("FROM Quest quest INNER JOIN FETCH quest.perguntas "
				+ "WHERE quest.id = :id AND quest.aberta = false")
				.setParameter("id", id).getSingleResult();
		
	}
	
}

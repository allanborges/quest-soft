package br.com.softbox.services;

import java.util.List;

import javax.inject.Inject;

import br.com.softbox.model.Quest;
import br.com.softbox.repository.Quests;

public class QuestService {
	
	@Inject
	private Quests quests;
	
	public List<Quest> buscaTodasQuests(){
		return quests.buscaTodasQuests();
	}
	
	public Quest carregaQuestAberta(Quest quest){
		return quests.carregaQuestAberta(quest.getId());
	}
	
	public Quest carregaQuestFechada(Quest quest){
		return quests.carregaQuestFechada(quest.getId());
	}

}

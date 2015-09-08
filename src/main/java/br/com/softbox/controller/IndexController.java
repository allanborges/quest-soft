package br.com.softbox.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.softbox.services.QuestService;

@Controller
public class IndexController {

	@Inject
	private Result result;
	
	@Inject
	private QuestService questService;
	
	@Inject
	private EntityManager entity;

	protected IndexController() {
		
	}

	@Path("/")
	public void index() {
		this.result.include("questoes", questService.buscaTodasQuests());
	}
}
package br.com.softbox.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.softbox.exceptions.ServiceException;
import br.com.softbox.model.Quest;
import br.com.softbox.model.RespostaUsuario;
import br.com.softbox.services.QuestService;
import br.com.softbox.services.RespostaUsuarioService;

@Controller
public class QuestaoController {
	
	@Inject
	private Result result;
	
	@Inject
	private Validator validator;
	
	@Inject
	private QuestService questService;
	
	@Inject
	private RespostaUsuarioService respostaUsuarioService;
	
	
	protected QuestaoController() {
		
	}
	
	@Path("/teste")
	public void teste(){
		System.out.println("teste");
	}
	
	@Get
	@Path("/aberta/{questao.id}")
	public void visualizaQuestAberta(Quest questao){
		Quest questaoRetornada = questService.carregaQuestAberta(questao);
		this.result.include("questao", questaoRetornada);
	}
	
	@Get
	@Path("/fechada/{questao.id}")
	public void visualizaQuestFechada(Quest questao){
		Quest questaoRetornada = questService.carregaQuestFechada(questao);
		this.result.include("questao",questaoRetornada);
	}
	
	@Post
	public void responder(RespostaUsuario respostaUsuario){
	  try{	
		respostaUsuarioService.salvar(respostaUsuario);
		this.result.include("respostaValida", String.format("Resposta enviada com sucesso seu email: %s foi registrado !", 
											  respostaUsuario.getEmail()));
	  }catch (ServiceException ex ){
		  //mudar depois para o validator
		  this.result.include("emailInvalido", "O Email já foi usado para a questão");
		  validator.onErrorUsePageOf(IndexController.class).index();
	  }
	  this.result.redirectTo(IndexController.class).index();
	}

}

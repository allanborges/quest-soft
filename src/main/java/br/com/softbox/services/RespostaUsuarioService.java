package br.com.softbox.services;

import javax.inject.Inject;

import br.com.softbox.exceptions.ServiceException;
import br.com.softbox.model.RespostaUsuario;
import br.com.softbox.repository.RespostaUsuarios;

public class RespostaUsuarioService {
	
	@Inject
	private RespostaUsuarios respostaUsuarios;
	
	public void salvar(RespostaUsuario resposta){
		
		if (respostaUsuarios.verificaEmail(resposta.getEmail(), resposta.getIdQuest())){
			throw new ServiceException("Email já usado");
		}
		
		respostaUsuarios.guardar(resposta);
	}
	
	

}

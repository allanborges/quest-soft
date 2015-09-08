package br.com.softbox.repository;

import br.com.softbox.model.RespostaUsuario;

public class RespostaUsuarios extends GenericRepository<RespostaUsuario> {

private static final long serialVersionUID = 1L;
	
	public RespostaUsuarios() {
		super(RespostaUsuario.class);
	}
	
	/**
	 * Caso usuário já tenha respondido o questionário com esse email
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean verificaEmail(String email, Long idQuest){
		String jpql = "SELECT COUNT(*) FROM RespostaUsuario resp WHERE resp.email = :email AND resp.idQuest = :idQuest";
		Long result = (Long) manager.createQuery(jpql).
							 setParameter("email", email).
							 setParameter("idQuest",idQuest).
							 getSingleResult();
		
		return (result == null || result == 0 ? false : true);
	}
	
}

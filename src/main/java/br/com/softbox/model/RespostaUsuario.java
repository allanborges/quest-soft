package br.com.softbox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "tb_resposta_usuario")
public class RespostaUsuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Quest quest;
	private Pergunta pergunta;
	private String email;
	private String nome;
	private String resposta;
	private Long idQuest;
	private Long idPergunta;
	
	@Id
	@Column(name = "id_resposta")
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_quest",updatable = false, insertable = false)
	public Quest getQuest() {
		return quest;
	}
	public void setQuest(Quest quest) {
		this.quest = quest;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_pergunta",insertable = false, updatable = false)
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	@NotNull
	@Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotNull
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "resposta", columnDefinition = "text")
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	@Column(name = "id_quest",insertable = true)
	public Long getIdQuest() {
		return idQuest;
	}
	public void setIdQuest(Long idQuest) {
		this.idQuest = idQuest;
	}
	
	@Column(name = "id_pergunta",insertable = true)
	public Long getIdPergunta() {
		return idPergunta;
	}
	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}
	
	
}

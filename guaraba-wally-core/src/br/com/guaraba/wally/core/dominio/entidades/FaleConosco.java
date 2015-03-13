package br.com.guaraba.wally.core.dominio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class FaleConosco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
    @Column(length=100)
	private String nome;
    @Column(length=100)
	private String email;
    @Column(length=500)
	private String mensagem;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataCadastro;	
	
	public FaleConosco(){
		
	}
	
	public FaleConosco(String nome, String email, String mensagem,
			Date dataCadastro) {
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
		this.dataCadastro = dataCadastro;
	}

	public FaleConosco(Integer id, String nome, String email, String mensagem,
			Date dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
		this.dataCadastro = dataCadastro;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}
}

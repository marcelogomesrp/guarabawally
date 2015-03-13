package br.com.guaraba.wally.core.dominio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contato implements Serializable {
	
	private static final long serialVersionUID = -8504825064583605374L;
	@Column(name = "nomeContato", nullable=false, length=100)
    private String nome;
	@Column(length=15)
    private String telefone;
	@Column(length=100)
    private String email;
	@Column(nullable=false, length=20)
    private String login;
	@Column(nullable=false, length=100)
    private String senha;

    public Contato() {
    }
    public Contato(String nome, String telefone, String email, String login, String senha) {
        this();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nomeContato) {
        this.nome = nomeContato;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
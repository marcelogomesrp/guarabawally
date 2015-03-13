package br.com.guaraba.wally.web.controller;

import br.com.guaraba.commons.util.StringUtils;
import br.com.guaraba.commons.util.exception.GenericExceptionMessageType;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;
import br.com.guaraba.wally.core.dominio.servicos.IFornecedorService;
import br.com.guaraba.wally.core.dominio.servicos.impl.FornecedorService;
import br.com.guaraba.wally.web.controller.util.FacesUtils;

public class LoginBean {

	private String login;
	private String senha;
	private FornecedorBean fornecedorBeanAccessor;
	
	public LoginBean() { }

	private IFornecedorService getFornecedorService() {
		
		return new FornecedorService();
	}
	
	public String getLogin() {
		
		return this.login;
	}
	
	public void setLogin(String login) {
		
		this.login = login;
	}

	public String getSenha() {
		
		return this.senha;
	}
	
	public void setSenha(String senha) {
		
		this.senha = senha;
	}

	public void setFornecedorBeanAccessor(FornecedorBean fornecedorBeanAccessor) {
		this.fornecedorBeanAccessor = fornecedorBeanAccessor;
	}

	public FornecedorBean getFornecedorBeanAccessor() {
		return fornecedorBeanAccessor;
	}

	public String logar() {

		if(StringUtils.isNullOrEmpty(this.getLogin()) || StringUtils.isNullOrEmpty(this.getSenha())) {
			FacesUtils.adicionarMensagem("base_message", GenericExceptionMessageType.WARNING, "É necessário informar o login e a senha.");
			return null;
		}
		try {

			this.getFornecedorBeanAccessor().setFornecedor(this.getFornecedorService().carregarPorLoginSenha(this.getLogin(), this.getSenha()));
			
			if(this.getFornecedorBeanAccessor().getFornecedor() == null) {

				FacesUtils.adicionarMensagem("base_message", GenericExceptionMessageType.WARNING, "O fornecedor '".concat(this.getLogin()).concat("' não está cadastrado."));
				return null;
			}

		} catch (Exception e) {

			FacesUtils.adicionarMensagem("base_message", e, "Ocorreu uma falha ao tentar efetuar o login.");
			return null;
		}

		return "sucesso";
	}

	public String limpar() {

		this.setLogin(null);
		this.setSenha(null);
		this.getFornecedorBeanAccessor().setFornecedor(null);

		return "sucesso";
	}

	public String logoff() {
		
		this.limpar();
		
		FacesUtils.getSession().invalidate();
				
		return "logoff";
	}
}
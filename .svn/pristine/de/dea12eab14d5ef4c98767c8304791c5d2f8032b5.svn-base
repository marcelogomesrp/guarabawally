package br.com.guaraba.wally.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.guaraba.commons.util.exception.GenericExceptionMessageType;
import br.com.guaraba.enums.EstadosBrasilEnum;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;
import br.com.guaraba.wally.core.dominio.servicos.IFornecedorService;
import br.com.guaraba.wally.core.dominio.servicos.impl.FornecedorService;
import br.com.guaraba.wally.web.controller.util.FacesUtils;

public class FornecedorBean {

	private Fornecedor fornecedor = new Fornecedor();

	private IFornecedorService getFornecedorService() {
				
		return new FornecedorService();
	}
	
	public FornecedorBean() { }

	public void setFornecedor(Fornecedor fornecedor) {
		
		this.fornecedor = fornecedor;
	}
	public Fornecedor getFornecedor() {
		
		return this.fornecedor;
	}


	public String cadastrar() {

		try {

			this.getFornecedorService().cadastrar(this.getFornecedor());

		} catch (Exception e) {

			FacesUtils.adicionarMensagem("base_message", e, "Ocorreu uma falha ao tentar efetuar o cadastro.");

			return null;
		}

		FacesUtils.adicionarMensagem("base_message", GenericExceptionMessageType.INFO, "Seu cadastro foi realizado com sucesso!");

		this.limpar();

		return "sucesso";
	}
	
	public String salvar() {

		try {

			this.getFornecedorService().salvar(this.getFornecedor());

		} catch (Exception e) {

			FacesUtils.adicionarMensagem("base_message", e, "Ocorreu uma falha ao tentar salvar.");

			return null;
		}

		FacesUtils.adicionarMensagem("base_message", GenericExceptionMessageType.INFO, "Fornecedor salvo com sucesso!");

		//this.limpar();

		return "sucesso";
	}


	public List<SelectItem> getEstados() {
		
        List<SelectItem> estadosList = new ArrayList<SelectItem>();  

		for (EstadosBrasilEnum e : EstadosBrasilEnum.values()) {
			estadosList.add(new SelectItem(e.toString(), e.toString()));
		}
		return estadosList;
	}

	private void limpar() {
		this.fornecedor = new Fornecedor();
	}
	
	public String minhaConta()
	{
		return "sucesso";
	}
	
	public String editarEndereco()
	{
		return "sucesso";
	}
	
	public String editarContato()
	{
		return "sucesso";
	}
	
	public String editarSenha()
	{
		return "sucesso";
	}
}
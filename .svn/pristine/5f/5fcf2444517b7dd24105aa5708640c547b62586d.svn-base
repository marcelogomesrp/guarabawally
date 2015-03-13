package br.com.guaraba.wally.web.controller;

import java.util.List;

import javax.faces.model.ListDataModel;

import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.commons.util.exception.GenericExceptionMessageType;
import br.com.guaraba.wally.core.dominio.entidades.Anuncio;
import br.com.guaraba.wally.core.dominio.servicos.IAnuncioService;
import br.com.guaraba.wally.core.dominio.servicos.impl.AnuncioService;
import br.com.guaraba.wally.web.controller.util.FacesUtils;

public class AnuncioBean {

	private Anuncio anuncio;
	private ProdutoBean produtoBeanAccessor;
	private FornecedorBean fornecedorBeanAccessor;
	private ListDataModel items;

	public AnuncioBean() {
		this.anuncio = new Anuncio();
		this.anuncio.setLatitude(-21.193935);
		this.anuncio.setLongitude(-47.810655);
	}

	public Anuncio getAnuncio() {
		return this.anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	private IAnuncioService getAnuncioService() {

		return new AnuncioService();
	}

	public String cadastrar() {

		try {
			System.out.println("CADASTRAR" + "\nLatitude : "
					+ this.getAnuncio().getLatitude() + "\nLongitude : "
					+ this.getAnuncio().getLongitude() + "\nId : "
					+ this.getAnuncio().getId() + "\nInicio Vigencia : "
					+ this.getAnuncio().getInicioVigencia()
					+ "\nFim Vigencia : " + this.getAnuncio().getFimVigencia()
					+ "\nValor : " + this.getAnuncio().getValor()
					+ "\nAtivo : " + this.getAnuncio().getAtivo());

			Anuncio a = this.getAnuncio();
			a.setProduto(this.getProdutoBeanAccessor().getProduto());

			this.getAnuncioService().cadastrar(a);

		} catch (Exception e) {

			FacesUtils
					.adicionarMensagem("base_message", e,
							"Ocorreu uma falha ao tentar efetuar o cadastro do anuncio.");

			return null;
		}

		FacesUtils.adicionarMensagem("base_message",
				GenericExceptionMessageType.INFO,
				"O cadastro do anuncio foi realizado com sucesso!");

		this.limpar();

		return "sucesso";
	}

	public String salvar() {

		try {
			System.out.println("SALVAR" + "\nLatitude : "
					+ this.getAnuncio().getLatitude() + "\nLongitude : "
					+ this.getAnuncio().getLongitude() + "\nId : "
					+ this.getAnuncio().getId() + "\nInicio Vigencia : "
					+ this.getAnuncio().getInicioVigencia()
					+ "\nFim Vigencia : " + this.getAnuncio().getFimVigencia()
					+ "\nValor : " + this.getAnuncio().getValor()
					+ "\nAtivo : " + this.getAnuncio().getAtivo());

			this.getAnuncioService().salvar(this.anuncio);

		} catch (Exception e) {

			FacesUtils
					.adicionarMensagem("base_message", e,
							"Ocorreu uma falha ao tentar efetuar o cadastro do anuncio.");

			return null;
		}

		FacesUtils.adicionarMensagem("base_message",
				GenericExceptionMessageType.INFO,
				"O cadastro do anuncio foi realizado com sucesso!");

		this.limpar();

		return "sucesso";
	}

	private void limpar() {

		this.anuncio = new Anuncio();
	}

	public void setProdutoBeanAccessor(ProdutoBean produtoBeanAccessor) {
		this.produtoBeanAccessor = produtoBeanAccessor;
	}

	public ProdutoBean getProdutoBeanAccessor() {
		return produtoBeanAccessor;
	}

	public void setFornecedorBeanAccessor(FornecedorBean fornecedorBeanAccessor) {
		this.fornecedorBeanAccessor = fornecedorBeanAccessor;
	}

	public FornecedorBean getFornecedorBeanAccessor() {
		return fornecedorBeanAccessor;
	}

	public ListDataModel getItems() {

		try {

			this.items = new ListDataModel((List) this.getAnuncioService()
					.listarTodos(this.getFornecedorBeanAccessor().getFornecedor()));

		} catch (final Exception ex) {

			ex.printStackTrace();
		}

		return this.items;
	}

	public String visualizar() {
		this.getProdutoBeanAccessor().setProduto(null);

		ObterAnuncioDaLinhaSelecionadaDaTabela();

		System.out.println("VISUALIZANDO an�ncio : " + this.anuncio.getId()
				+ "\nDo produto : " + this.anuncio.getProduto().getNome());

		return "sucesso";
	}

	public String editar() {
		this.getProdutoBeanAccessor().setProduto(null);

		ObterAnuncioDaLinhaSelecionadaDaTabela();

		System.out.println("EDITANDO anuncio : " + this.anuncio.getId()
				+ "\nDo produto : " + this.anuncio.getProduto().getNome());

		this.produtoBeanAccessor.setProduto(this.anuncio.getProduto());

		return "sucesso";
	}

	public String excluir() {
		ObterAnuncioDaLinhaSelecionadaDaTabela();
		try {
			this.getAnuncioService().excluir(this.anuncio);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return "sucesso";
	}

	private void ObterAnuncioDaLinhaSelecionadaDaTabela() {
		this.setAnuncio((Anuncio) this.items.getRowData());
//		IAnuncioService anuncioService = new AnuncioService();
//
//		try {
//			this.setAnuncio(anuncioService.carregarPorId(this.getAnuncio()
//					.getId()));
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		System.out.println("Latitude : " + this.getAnuncio().getLatitude()
//				+ "\nLongitude : " + this.getAnuncio().getLongitude()
//				+ "\nId : " + this.getAnuncio().getId()
//				+ "\nInicio Vigencia : "
//				+ this.getAnuncio().getInicioVigencia() + "\nFim Vigencia : "
//				+ this.getAnuncio().getFimVigencia() + "\nValor : "
//				+ this.getAnuncio().getValor() + "\nAtivo : "
//				+ this.getAnuncio().getAtivo() + "\nProduto : "
//				+ this.getAnuncio().getProduto().getNome() + " \\ ("
//				+ this.getAnuncio().getProduto().getId() + ")");
	}

	public String visualizarProduto() {
		// TODO
		return "sucesso";
	}
}
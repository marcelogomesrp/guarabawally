package br.com.guaraba.wally.web.controller;

import java.util.List;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.commons.util.exception.GenericExceptionMessageType;
import br.com.guaraba.wally.core.dominio.entidades.Anuncio;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;
import br.com.guaraba.wally.core.dominio.entidades.Produto;
import br.com.guaraba.wally.core.dominio.servicos.IProdutoService;
import br.com.guaraba.wally.core.dominio.servicos.impl.FornecedorService;
import br.com.guaraba.wally.core.dominio.servicos.impl.ProdutoService;
import br.com.guaraba.wally.web.controller.util.FacesUtils;

public class ProdutoBean {

	private Produto produto;
	private FornecedorBean fornecedorBeanAccessor;
    private ListDataModel items;    
    private ListDataModel itemsPorFonecedor;    

	private IProdutoService getProdutoService() {
				
		return new ProdutoService();
	}
	
	public ProdutoBean() {
		
		this.produto = new Produto();
	}

	public void setProduto(Produto produto) {
		
		this.produto = produto;
	}
	
	public Produto getProduto() {
		
		return this.produto;
	}

	public String cadastrar() {

		try {
			Produto p = this.getProduto();
			p.setFornecedor(getFornecedorBeanAccessor().getFornecedor());

			this.getProdutoService().salvar(p);

		} catch (Exception e) {

			FacesUtils.adicionarMensagem("base_message", e, "Ocorreu uma falha ao tentar efetuar o cadastro do produto. \nEXCEPTION : " + e.getMessage());

			return null;
		}

		FacesUtils.adicionarMensagem("base_message", GenericExceptionMessageType.INFO, "O cadastro do produto foi realizado com sucesso!");

		this.limpar();

		return "sucesso";
	}

	public void limpar() {
		
		this.produto = new Produto();
		this.items = null;
		this.itemsPorFonecedor = null;
	}
	
	public List<Produto> getListaProdutos()
	{
		this.limpar();
		return this.listarTodos();
	}
	
	public ListDataModel getItems() {
		this.limpar();
		try {
			List<Produto> produtos = this.getProdutoService().listarTodos();
			if(produtos != null && produtos.size() > 0)
			{
				this.items = new ListDataModel(produtos);
			}
			
		} catch (Exception ex) {
			System.out.println("Erro ao fazer conversao");
		}
		return this.items;
	}
	
	public ListDataModel getItemsPorFornecedor() {
		this.limpar();
		try {
			Fornecedor f = this.fornecedorBeanAccessor.getFornecedor();
			FornecedorService fornecedorService = new FornecedorService();
			f = fornecedorService.carregarPorLoginSenha(f.getContato().getLogin(), f.getContato().getSenha());
			List<Produto> produtos = this.getProdutoService().findByFornecedor(f);
			if(produtos != null && produtos.size() > 0)
			{
				this.items = new ListDataModel(produtos);
			}

		} catch (Exception ex) {
			System.out.println("Erro ao fazer conversao" + "\nCausa" +ex.getCause() + "\nErro" + ex.getMessage());
		}
		return this.items;
	}

	public String visualizar()
	{
		ObterProdutoDaLinhaSelecionadaDaTabela();
		
        return "sucesso";
	}

	public String editar()
	{
		ObterProdutoDaLinhaSelecionadaDaTabela();
		
        return "sucesso";
	}
	
	public void setFornecedorBeanAccessor(FornecedorBean fornecedorBeanAccessor) {
		this.fornecedorBeanAccessor = fornecedorBeanAccessor;
	}

	public FornecedorBean getFornecedorBeanAccessor() {
		return fornecedorBeanAccessor;
	}

	public List<Produto> listarTodos()
	{
		this.limpar();
		try {
			
			return this.getProdutoService().listarTodos();
			
		} catch (Exception e) {

			FacesUtils.adicionarMensagem("base_message", e, "Ocorreu uma falha ao tentar listar todos os produtos.\nEXCEPTION : " + e.getMessage());

			return null;
		}
	}
	
	public String cadastrarAnuncio()
	{
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		ValueExpression ve = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{anuncioBean}", AnuncioBean.class);
		AnuncioBean anuncio = (AnuncioBean) ve.getValue(ctx.getELContext());
		Anuncio tt = new Anuncio();
		//tt.setValor(999999F);
		tt.setLatitude(-21.193935D);
		tt.setLongitude(-47.810655);
		anuncio.setAnuncio(tt);
		
		
		//anuncio.setProduto((Produto) this.items.getRowData());
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("anuncioBean", anuncio);
		
		ObterProdutoDaLinhaSelecionadaDaTabela();
		
        return "sucesso";
	}

	private void ObterProdutoDaLinhaSelecionadaDaTabela() {
		this.setProduto((Produto) this.items.getRowData());
	}

	public String efetuarLogin()
	{
		this.limpar();
		return "logar";
	}
	
	public String excluir()
	{
		ObterProdutoDaLinhaSelecionadaDaTabela();
		try {
			this.getProdutoService().excluir(this.produto);
			FacesUtils.adicionarMensagem("base_message", new Exception(), "Produto excluido com sucesso!");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return "sucesso";
	}
}
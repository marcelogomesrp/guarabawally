package br.com.guaraba.wally.web.controller;

public class IndexBean {

	private ProdutoBean produtoBeanAccessor;
	
	public String cadastrarse() {
	
		return "cadastrarFornecedor";
	}

	public String principal() {
		
		return "principal";
	}
	
	public String logar() {
		
		return "logar";
	}
	
	public String sobre() {
		
		return "sobre";
	}
	
	public String faleConosco() {
		
		return "faleconosco";
	}
	
	public String produtoCadastrar()
	{
		this.getProdutoBeanAccessor().limpar();
		return "cadastrarProduto";
	}
	
	public String produtoListar()
	{
		return "listarProdutos";
	}
	
	public String produtoListarPorFornecedor()
	{
		return "listarProdutosPorFonecedor";
	}
	
	public String anuncioCadastrar()
	{
		return "cadastrarAnuncio";
	}
	
	public String anuncioListar()
	{
		return "listarAnuncios";
	}	

	public String visualizar()
	{
		return "visualizar";
	}

	public void setProdutoBeanAccessor(ProdutoBean produtoBeanAccessor) {
		this.produtoBeanAccessor = produtoBeanAccessor;
	}

	public ProdutoBean getProdutoBeanAccessor() {
		return produtoBeanAccessor;
	}
}
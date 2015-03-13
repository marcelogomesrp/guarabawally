package br.com.guaraba.wally.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.guaraba.wally.core.dominio.entidades.Categoria;
import br.com.guaraba.wally.core.dominio.servicos.impl.CategoriaService;
import br.com.guaraba.wally.web.controller.util.FacesUtils;

public class CategoriaBean {

    private List<SelectItem> categorias;
	private CategoriaService categoriaService;
	
	public CategoriaBean()
	{	
		this.categoriaService = new CategoriaService();
		AtualizaListaDeCategorias();
	}
	
	private void AtualizaListaDeCategorias() {
		try
		{
			this.setCategorias(new ArrayList<SelectItem>());
	        List<Categoria> categoriasCadastradas = this.categoriaService.listarTodos();
	        for (Categoria categoria : categoriasCadastradas) {
	            this.getCategorias().add(new SelectItem(categoria.getId(), categoria.getNome()));
	        }	
		}
		catch(Exception e)
		{
			FacesUtils.adicionarMensagem("base_message", e, "Ocorreu uma falha ao tentar listar as categorias.");
		}        
    }
	
	public List<SelectItem> getCategorias()
	{
		return this.categorias;
	}
	
	public void setCategorias(List<SelectItem> categorias)
	{
        this.categorias = categorias;
    }
}

package br.com.guaraba.wally.core.dominio.servicos;

import java.util.List;

import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.wally.core.dominio.entidades.Categoria;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;
import br.com.guaraba.wally.core.dominio.entidades.Produto;

public interface IProdutoService {

	Produto carregarPorId(Integer id) throws ServiceException;

	Produto salvar(Produto produto) throws ServiceException;

	void excluir(Produto produto) throws ServiceException;

	List<Produto> findByFornecedorAndCategoria(Fornecedor fornecedor,
			Categoria categoria) throws ServiceException;

	List<Produto> findByFornecedor(Fornecedor fornecedor)
			throws ServiceException;

	List<Produto> findByCategoria(Categoria categoria)
			throws ServiceException;

	List<Produto> listarTodos() throws ServiceException;
}
package br.com.guaraba.wally.core.dao;

import java.util.List;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.dao.IDAOGenerico;
import br.com.guaraba.wally.core.dominio.entidades.Categoria;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;
import br.com.guaraba.wally.core.dominio.entidades.Produto;

public interface IProdutoDAO extends IDAOGenerico<Produto, Integer> {

    public List<Produto> FindProdutosByFornecedorAndCategoria(Fornecedor fornecedor, Categoria categoria) throws DataAccessException;
}
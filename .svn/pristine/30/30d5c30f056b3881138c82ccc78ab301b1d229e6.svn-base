package br.com.guaraba.wally.core.dao;

import java.util.List;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.dao.IDAOGenerico;
import br.com.guaraba.wally.core.dominio.entidades.Anuncio;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;

public interface IAnuncioDAO extends IDAOGenerico<Anuncio, Integer>  {

	List<Anuncio> listarPorCategoriaNomeDoProdutoEValor(final Integer categoriaId, final String nomeDoProduto, final Double valorAte);

	List<Anuncio> listarTodos(Fornecedor fornecedor) throws DataAccessException;
}
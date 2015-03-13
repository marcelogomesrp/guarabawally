package br.com.guaraba.wally.core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.dao.impl.DAOGenerico;
import br.com.guaraba.commons.dao.impl.HibernateUtil;
import br.com.guaraba.wally.core.dao.IProdutoDAO;
import br.com.guaraba.wally.core.dominio.entidades.Categoria;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;
import br.com.guaraba.wally.core.dominio.entidades.Produto;

public class ProdutoDAO extends DAOGenerico<Produto, Integer> implements IProdutoDAO {

    public ProdutoDAO() {

    	super(HibernateUtil.currentSession());
	}

	public List<Produto> FindProdutosByFornecedorAndCategoria(Fornecedor fornecedor, Categoria categoria) throws DataAccessException {
        
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("fornecedor", fornecedor);
        params.put("categoria", categoria);
        
        return this.listPesqPorParams("SELECT p FROM Produto p WHERE p.fornecedor = :fornecedor AND p.categoria = :categoria", params);
    }
}
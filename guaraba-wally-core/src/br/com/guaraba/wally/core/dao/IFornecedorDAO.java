package br.com.guaraba.wally.core.dao;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.dao.IDAOGenerico;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;

public interface IFornecedorDAO extends IDAOGenerico<Fornecedor, Integer> {

    public Fornecedor carregarPorLoginSenha(String login, String senha) throws DataAccessException;
}
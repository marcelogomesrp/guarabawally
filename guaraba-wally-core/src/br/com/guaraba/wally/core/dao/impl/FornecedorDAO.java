package br.com.guaraba.wally.core.dao.impl;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.dao.impl.DAOGenerico;
import br.com.guaraba.commons.dao.impl.HibernateUtil;
import br.com.guaraba.commons.util.StringUtils;
import br.com.guaraba.wally.core.dao.IFornecedorDAO;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;

public class FornecedorDAO extends DAOGenerico<Fornecedor, Integer> implements IFornecedorDAO {

    public FornecedorDAO() {

    	super(HibernateUtil.currentSession());
	}

	public Fornecedor carregarPorLoginSenha(String login, String senha) throws DataAccessException {
    	
    	Fornecedor fornecedor = new Fornecedor();
    	try {
	    	fornecedor.getContato().setLogin(login);
	    	fornecedor.getContato().setSenha(senha);
	    	
	    	return this.carregar(fornecedor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}
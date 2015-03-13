package br.com.guaraba.wally.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.dao.impl.DAOGenerico;
import br.com.guaraba.commons.dao.impl.HibernateUtil;
import br.com.guaraba.commons.util.NumberUtils;
import br.com.guaraba.wally.core.dao.IAnuncioDAO;
import br.com.guaraba.wally.core.dominio.entidades.Anuncio;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;

import com.mysql.jdbc.StringUtils;

public class AnuncioDAO extends DAOGenerico<Anuncio, Integer> implements IAnuncioDAO {

	public AnuncioDAO() {

		super(HibernateUtil.currentSession());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Anuncio> listarPorCategoriaNomeDoProdutoEValor(final Integer categoriaId, final String nomeDoProduto, final Double valorAte) {

		//final StringBuilder hql = new StringBuilder("from Anuncio a where 1=1");
		final StringBuilder hql = new StringBuilder("from Anuncio a where a.ativo = true" +
													" and a.inicioVigencia <= Now() " +
													" and a.fimVigencia >= Now()");

		if(!NumberUtils.isNullOrZero(categoriaId)) {

			hql.append(" and a.produto.categoria.id = :id");
		}

		if(!StringUtils.isNullOrEmpty(nomeDoProduto)) {

			hql.append(" and a.produto.nome like :nome");
		}

		if(!NumberUtils.isNullOrZero(valorAte)) {

			hql.append(" and a.valor <= :valor");
		}

		final Query query = this.getSession().createQuery(hql.toString());

		if(!NumberUtils.isNullOrZero(categoriaId)) {

			query.setInteger("id", categoriaId);
		}

		if(!StringUtils.isNullOrEmpty(nomeDoProduto)) {

			query.setString("nome", "%".concat(nomeDoProduto).concat("%"));
		}

		if(!NumberUtils.isNullOrZero(valorAte)) {
			query.setDouble("valor", valorAte);
		}

		return query.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Anuncio> listarTodos(final Fornecedor fornecedor) throws DataAccessException {

		return this.getSession()
					.createQuery("from Anuncio a where a.produto.fornecedor =:fornecedor")
					.setEntity("fornecedor", fornecedor)
					.list();
	}
}
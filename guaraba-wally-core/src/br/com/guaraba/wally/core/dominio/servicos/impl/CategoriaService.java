package br.com.guaraba.wally.core.dominio.servicos.impl;

import java.util.List;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.wally.core.dao.ICategoriaDAO;
import br.com.guaraba.wally.core.dao.impl.CategoriaDAO;
import br.com.guaraba.wally.core.dominio.entidades.Categoria;
import br.com.guaraba.wally.core.dominio.servicos.ICategoriaService;

public class CategoriaService implements ICategoriaService {

	private ICategoriaDAO categoriaDAO;

	public CategoriaService() {

		this.categoriaDAO = new CategoriaDAO();
	}

	public Categoria salvar(Categoria categoria) throws ServiceException {

		try {

			categoria = this.categoriaDAO.salvar(categoria);

		} catch (DataAccessException e) {

			throw new ServiceException(
					"Ocorreu um erro ao tentar salvar a categoria " + categoria,
					e);
		}

		return categoria;
	}

	public void excluir(Categoria categoria) throws ServiceException {

		try {

			this.categoriaDAO.excluir(categoria);

		} catch (DataAccessException e) {

			throw new ServiceException(
					"Ocorreu um erro ao tentar excluir a categoria "
							+ categoria, e);
		}
	}

	public List<Categoria> listarTodos() throws ServiceException {

		List<Categoria> categorias = null;

		try {

			categorias = this.categoriaDAO.listarTodos();

		} catch (DataAccessException e) {

			throw new ServiceException(
					"Ocorreu um erro ao tentar carregar todas as categorias.",
					e);
		}

		return categorias;
	}

	@Override
	public Categoria criar(String nome) throws ServiceException {

		Categoria novaCategoria = new Categoria();

		novaCategoria.setNome(nome);

		return this.salvar(novaCategoria);
	}

	@Override
	public Categoria carregarPorId(Integer id) throws ServiceException {

		try {
			return this.categoriaDAO.carregarPorId(id);
		}  catch (DataAccessException e) {

			throw new ServiceException(
					"Ocorreu um erro ao tentar carregar todas as categorias.",
					e);
		}
	}
}
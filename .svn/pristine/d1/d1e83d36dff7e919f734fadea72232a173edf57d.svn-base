package br.com.guaraba.wally.core.dominio.servicos.impl;

import java.util.List;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.commons.util.exception.GenericExceptionMessageType;
import br.com.guaraba.wally.core.dao.IAnuncioDAO;
import br.com.guaraba.wally.core.dao.impl.AnuncioDAO;
import br.com.guaraba.wally.core.dominio.entidades.Anuncio;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;
import br.com.guaraba.wally.core.dominio.servicos.IAnuncioService;

public class AnuncioService implements IAnuncioService {

	private IAnuncioDAO anuncioDAO;

	public AnuncioService() {

		this.anuncioDAO = new AnuncioDAO();
	}

	public Anuncio carregarPorId(Integer id) throws ServiceException {

		Anuncio anuncio = null;

		try {

			anuncio = this.anuncioDAO.carregarPorId(id);

		} catch (DataAccessException e) {

			throw new ServiceException(
					"Ocorreu um erro ao tentar carregar um anúncio com o id "
							+ id, e);
		}

		return anuncio;
	}

	public Anuncio salvar(Anuncio anuncio) throws ServiceException {

		try {
			try {
				if(PodeSerCadastrado(anuncio)) {
					anuncio = this.anuncioDAO.salvar(anuncio);
				}
			} catch (Exception e) {
				throw new ServiceException(
						"Ocorreu um erro ao tentar salvar o anúncio " + anuncio,
						e);
			}
		} catch (DataAccessException e) {

			throw new ServiceException(e.getMessage(), e);
		}

		return anuncio;
	}

	public Anuncio cadastrar(Anuncio anuncio) throws ServiceException {

		try {
			try {
				if(PodeSerCadastrado(anuncio)) {
					anuncio = this.anuncioDAO.salvar(anuncio);
				}
			} catch (Exception e) {
				throw new ServiceException(
						"Ocorreu um erro ao tentar cadastrar o anúncio "
								+ anuncio, e);
			}
		} catch (DataAccessException e) {

			throw new ServiceException(e.getMessage(), e);
		}

		return anuncio;
	}

	public void excluir(Anuncio anuncio) throws ServiceException {

		try {

			anuncio = this.anuncioDAO.excluir(anuncio);

		} catch (DataAccessException e) {

			throw new ServiceException(
					"Ocorreu um erro ao tentar excluir o anuncio " + anuncio, e);
		}
	}

	public List<Anuncio> listarTodos(final Fornecedor fornecedor)
			throws ServiceException {

		List<Anuncio> anuncios = null;

		try {

			anuncios = this.anuncioDAO.listarTodos(fornecedor);

		} catch (DataAccessException e) {

			throw new ServiceException(
					"Ocorreu um erro ao tentar listar todos os anuncios.", e);
		}

		return anuncios;
	}

	@Override
	public List<Anuncio> listarAnunciosPorCategoriaNomeDoProdutoEValor(
			final Integer categoriaId, final String nomeDoProduto,
			final Double valorAte) {

		return this.anuncioDAO.listarPorCategoriaNomeDoProdutoEValor(
				categoriaId, nomeDoProduto, valorAte);
	}

	private boolean PodeSerCadastrado(Anuncio anuncio) throws ServiceException {
		
		ServiceException serviceException = new ServiceException();
		
		if (anuncio.getInicioVigencia() == null) {
			serviceException
					.addMessage(GenericExceptionMessageType.WARNING,
							"É necessário informar a data de início de vigência do anúncio");
		}
		
		if (anuncio.getFimVigencia() == null) {
			serviceException
					.addMessage(GenericExceptionMessageType.WARNING,
							"É necessário informar a data de fim de vigência do anúncio");
		}
		
		if(anuncio.getFimVigencia().before(anuncio.getInicioVigencia()))
		{
			serviceException
			.addMessage(GenericExceptionMessageType.WARNING,
					"A data de início deve ser maior que a data de fim de vigência");
		}
		
		if (serviceException.hasMessages()) {

			throw serviceException;
		}
		
		return true;
	}
}
package br.com.guaraba.wally.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.guaraba.wally.core.dominio.entidades.Anuncio;
import br.com.guaraba.wally.core.dominio.entidades.Categoria;
import br.com.guaraba.wally.core.dominio.servicos.IAnuncioService;
import br.com.guaraba.wally.core.dominio.servicos.impl.AnuncioService;

@WebService
public class AnunciosWebService {

	private IAnuncioService getAnunciosService() {

		return new AnuncioService();
	}

	@WebMethod
	public List<Categoria> listarCategoriasPorNomeDoProdutoEValor(	@WebParam(name="nomeDoProduto") final String nomeDoProduto, 
																	@WebParam(name="valorAte") final Double valorAte) {

		final List<Categoria> categorias = new ArrayList<Categoria>();

		final List<Anuncio> anunciosPorCategoriaNomeDoProdutoEValor = this.getAnunciosService().listarAnunciosPorCategoriaNomeDoProdutoEValor(null, nomeDoProduto, valorAte);

		if(anunciosPorCategoriaNomeDoProdutoEValor != null) {

			for (final Anuncio anuncio : anunciosPorCategoriaNomeDoProdutoEValor) {

				if(!categorias.contains(anuncio.getProduto().getCategoria())) {

					categorias.add(anuncio.getProduto().getCategoria());
				}
			}
		}

		return categorias;
	}

	@WebMethod
	public List<Anuncio> listarAnunciosPorCategoriaNomeDoProdutoEValor(@WebParam(name="categoriaId") final Integer categoriaId, 
																		@WebParam(name="nomeDoProduto") final String nomeDoProduto,
																		@WebParam(name="valorAte") final Double valorAte) {

		return this.getAnunciosService().listarAnunciosPorCategoriaNomeDoProdutoEValor(categoriaId, nomeDoProduto, valorAte);
	}
}
package br.com.guaraba.wally.android.domain.repositorios;

import java.util.List;

import br.com.guaraba.wally.android.domain.model.Anuncio;
import br.com.guaraba.wally.android.domain.model.Categoria;
import br.com.guaraba.wally.domain.ws.AnuncioWebService;

public class RepositorioDeAnuncios {

	private final String url = "http://10.0.2.2:8080/guaraba-wally-ws/anuncios";
	
	public List<Categoria> listarCategoriasPorNomeDoProdutoEValor(final String nomeDoProduto, final Double valorAte) {

		return new AnuncioWebService(this.url)
								.listarCategoriasPorNomeDoProdutoEValor(nomeDoProduto, valorAte);
	}

	public List<Anuncio> listarAnunciosPorCategoriaNomeDoProdutoEValor( final Categoria categoria, 
																		final String nomeDoProduto,
																		final Double valorAte) {
		return new AnuncioWebService(this.url)
				.listarAnunciosPorCategoriaNomeDoProdutoEValor(categoria, nomeDoProduto, valorAte);
	}
}
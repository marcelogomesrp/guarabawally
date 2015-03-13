package br.com.guaraba.wally.cliente;

import java.text.DecimalFormat;
import java.util.List;

import br.com.guaraba.wally.ws.Anuncio;
import br.com.guaraba.wally.ws.AnunciosWebService;
import br.com.guaraba.wally.ws.AnunciosWebServiceService;
import br.com.guaraba.wally.ws.Categoria;

public class WSClientTest {

	public static void main(String[] args) {

		final AnunciosWebServiceService anuncioWebService = new AnunciosWebServiceService();
		final AnunciosWebService anunciosWebServicePort = anuncioWebService.getAnunciosWebServicePort();

		final String nomeDoProduto = "nike";
		final Double valorAte = 0d;
		final List<Categoria> categoriasPorNomeDoProdutoEValor = anunciosWebServicePort.listarCategoriasPorNomeDoProdutoEValor(nomeDoProduto, valorAte);

		if(categoriasPorNomeDoProdutoEValor == null || categoriasPorNomeDoProdutoEValor.size() == 0) {

			System.out.println("Não foram encontradas nenuma categorias para o produto nike"); 

		} else {

			for (final Categoria categoria : categoriasPorNomeDoProdutoEValor) {

				System.out.println("Categoria: ".concat(categoria.getNome()));

				final List<Anuncio> anuncios = anunciosWebServicePort.listarAnunciosPorCategoriaNomeDoProdutoEValor(categoria.getId(), nomeDoProduto, valorAte);
				
				for (final Anuncio anuncio : anuncios) {
		
					System.out.println(anuncio.getProduto().getNome() + 
							": R$ " + 
							new DecimalFormat("0,00").format(anuncio.getValor()) + 
							" longitude: " + anuncio.getLongitude() + 
							" e latitude: " + anuncio.getLatitude());
				}
			}
		}
	}
}
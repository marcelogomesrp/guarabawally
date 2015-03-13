package br.com.guaraba.wally.domain.ws;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import br.com.guaraba.wally.android.domain.model.Anuncio;
import br.com.guaraba.wally.android.domain.model.Categoria;
import br.com.guaraba.wally.android.domain.model.Fornecedor;
import br.com.guaraba.wally.android.domain.model.Produto;
import br.com.guaraba.wally.android.util.NumberUtils;

public class AnuncioWebService {

	private final String url;
	private final String NAMESPACE = "http://ws.wally.guaraba.com.br/";
	private final String WEBMETHOD_LISTAR_CATEGORIAS = "listarCategoriasPorNomeDoProdutoEValor";
	private final String WEBMETHOD_LISTAR_ANUNCIOS = "listarAnunciosPorCategoriaNomeDoProdutoEValor";

	public AnuncioWebService(final String url) {

		this.url = url;
	}

	public List<Categoria> listarCategoriasPorNomeDoProdutoEValor(final String nomeDoProduto, final Double valorAte) {

		final List<Categoria> categorias = new ArrayList<Categoria>();

		final SoapObject soap = new SoapObject(NAMESPACE, WEBMETHOD_LISTAR_CATEGORIAS);

		soap.addProperty("nomeDoProduto", nomeDoProduto);
		soap.addProperty("valorAte", valorAte == null ? "0" : valorAte.toString());

		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

		envelope.setOutputSoapObject(soap);

		final HttpTransportSE httpTransport = new HttpTransportSE(this.url);

		try {

			httpTransport.call("", envelope);
			
			final SoapObject bodyIn = (SoapObject)envelope.bodyIn;

			for (int i = 0; i < bodyIn.getPropertyCount(); i++) {

				final SoapObject tmp = (SoapObject)bodyIn.getProperty(i);
				final SoapPrimitive id = (SoapPrimitive)tmp.getProperty("id");
				final SoapPrimitive nome = (SoapPrimitive)tmp.getProperty("nome");

				categorias.add(new Categoria(NumberUtils.getInteger(id.toString()), nome.toString()));
			}

		} catch (final Exception e) {

			e.printStackTrace();
		}

		return categorias;
	}

	public List<Anuncio> listarAnunciosPorCategoriaNomeDoProdutoEValor( final Categoria categoria, 
																		final String nomeDoProduto,
																		final Double valorAte) {
		final List<Anuncio> anuncios = new ArrayList<Anuncio>();

		final SoapObject soap = new SoapObject(NAMESPACE, WEBMETHOD_LISTAR_ANUNCIOS);

		soap.addProperty("categoriaId", categoria.getId());
		soap.addProperty("nomeDoProduto", nomeDoProduto);
		soap.addProperty("valorAte", valorAte == null ? "0" : valorAte.toString());

		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

		envelope.setOutputSoapObject(soap);

		final HttpTransportSE httpTransport = new HttpTransportSE(this.url);

		try {

			httpTransport.call("", envelope);

			final SoapObject bodyIn = (SoapObject)envelope.bodyIn;

			for (int i = 0; i < bodyIn.getPropertyCount(); i++) {

				final SoapObject tmp = (SoapObject)bodyIn.getProperty(i);

				final SoapObject produtoSoap = (SoapObject)tmp.getProperty("produto");
				final Integer produtoId = 0;
				final SoapPrimitive produtoNome = (SoapPrimitive)produtoSoap.getProperty("nome");
				final SoapPrimitive produtoDescricao = (SoapPrimitive)produtoSoap.getProperty("descricao");

				final SoapObject fornecedorSoap = (SoapObject)produtoSoap.getProperty("fornecedor");
				final Integer fornecedorId = 0;
				final SoapPrimitive fornecedorCnpj = (SoapPrimitive)fornecedorSoap.getProperty("cnpj");
				final SoapPrimitive fornecedorNomeFantasia = (SoapPrimitive)fornecedorSoap.getProperty("nomeFantasia");
				final Fornecedor fornecedorDoAnuncio = new Fornecedor(fornecedorId, fornecedorCnpj.toString(), fornecedorNomeFantasia.toString());

				final Produto produtoDoAnuncio = new Produto(produtoId, produtoNome.toString(), produtoDescricao.toString(), categoria, fornecedorDoAnuncio);

				final Integer anuncioId = (i+1);
				final SoapPrimitive anuncioValor = (SoapPrimitive)tmp.getProperty("valor");
				final SoapPrimitive anuncioLongitude = (SoapPrimitive)tmp.getProperty("longitude");
				final SoapPrimitive anuncioLatitude = (SoapPrimitive)tmp.getProperty("latitude");

				anuncios.add(new Anuncio(anuncioId, 
							 			  produtoDoAnuncio,
							 			  NumberUtils.getDouble(anuncioValor.toString()),
							 			  NumberUtils.getDouble(anuncioLatitude.toString()),
							 			  NumberUtils.getDouble(anuncioLongitude.toString())));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return anuncios;
	}
}
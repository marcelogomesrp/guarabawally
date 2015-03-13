
package br.com.guaraba.wally.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.guaraba.wally.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListarAnunciosPorCategoriaNomeDoProdutoEValor_QNAME = new QName("http://ws.wally.guaraba.com.br/", "listarAnunciosPorCategoriaNomeDoProdutoEValor");
    private final static QName _ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse_QNAME = new QName("http://ws.wally.guaraba.com.br/", "listarAnunciosPorCategoriaNomeDoProdutoEValorResponse");
    private final static QName _ListarCategoriasPorNomeDoProdutoEValorResponse_QNAME = new QName("http://ws.wally.guaraba.com.br/", "listarCategoriasPorNomeDoProdutoEValorResponse");
    private final static QName _ListarCategoriasPorNomeDoProdutoEValor_QNAME = new QName("http://ws.wally.guaraba.com.br/", "listarCategoriasPorNomeDoProdutoEValor");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.guaraba.wally.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarCategoriasPorNomeDoProdutoEValorResponse }
     * 
     */
    public ListarCategoriasPorNomeDoProdutoEValorResponse createListarCategoriasPorNomeDoProdutoEValorResponse() {
        return new ListarCategoriasPorNomeDoProdutoEValorResponse();
    }

    /**
     * Create an instance of {@link ListarCategoriasPorNomeDoProdutoEValor }
     * 
     */
    public ListarCategoriasPorNomeDoProdutoEValor createListarCategoriasPorNomeDoProdutoEValor() {
        return new ListarCategoriasPorNomeDoProdutoEValor();
    }

    /**
     * Create an instance of {@link Contato }
     * 
     */
    public Contato createContato() {
        return new Contato();
    }

    /**
     * Create an instance of {@link Anuncio }
     * 
     */
    public Anuncio createAnuncio() {
        return new Anuncio();
    }

    /**
     * Create an instance of {@link ListarAnunciosPorCategoriaNomeDoProdutoEValor }
     * 
     */
    public ListarAnunciosPorCategoriaNomeDoProdutoEValor createListarAnunciosPorCategoriaNomeDoProdutoEValor() {
        return new ListarAnunciosPorCategoriaNomeDoProdutoEValor();
    }

    /**
     * Create an instance of {@link Produto }
     * 
     */
    public Produto createProduto() {
        return new Produto();
    }

    /**
     * Create an instance of {@link ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse }
     * 
     */
    public ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse createListarAnunciosPorCategoriaNomeDoProdutoEValorResponse() {
        return new ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse();
    }

    /**
     * Create an instance of {@link Categoria }
     * 
     */
    public Categoria createCategoria() {
        return new Categoria();
    }

    /**
     * Create an instance of {@link Fornecedor }
     * 
     */
    public Fornecedor createFornecedor() {
        return new Fornecedor();
    }

    /**
     * Create an instance of {@link Endereco }
     * 
     */
    public Endereco createEndereco() {
        return new Endereco();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarAnunciosPorCategoriaNomeDoProdutoEValor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wally.guaraba.com.br/", name = "listarAnunciosPorCategoriaNomeDoProdutoEValor")
    public JAXBElement<ListarAnunciosPorCategoriaNomeDoProdutoEValor> createListarAnunciosPorCategoriaNomeDoProdutoEValor(ListarAnunciosPorCategoriaNomeDoProdutoEValor value) {
        return new JAXBElement<ListarAnunciosPorCategoriaNomeDoProdutoEValor>(_ListarAnunciosPorCategoriaNomeDoProdutoEValor_QNAME, ListarAnunciosPorCategoriaNomeDoProdutoEValor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wally.guaraba.com.br/", name = "listarAnunciosPorCategoriaNomeDoProdutoEValorResponse")
    public JAXBElement<ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse> createListarAnunciosPorCategoriaNomeDoProdutoEValorResponse(ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse value) {
        return new JAXBElement<ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse>(_ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse_QNAME, ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarCategoriasPorNomeDoProdutoEValorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wally.guaraba.com.br/", name = "listarCategoriasPorNomeDoProdutoEValorResponse")
    public JAXBElement<ListarCategoriasPorNomeDoProdutoEValorResponse> createListarCategoriasPorNomeDoProdutoEValorResponse(ListarCategoriasPorNomeDoProdutoEValorResponse value) {
        return new JAXBElement<ListarCategoriasPorNomeDoProdutoEValorResponse>(_ListarCategoriasPorNomeDoProdutoEValorResponse_QNAME, ListarCategoriasPorNomeDoProdutoEValorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarCategoriasPorNomeDoProdutoEValor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wally.guaraba.com.br/", name = "listarCategoriasPorNomeDoProdutoEValor")
    public JAXBElement<ListarCategoriasPorNomeDoProdutoEValor> createListarCategoriasPorNomeDoProdutoEValor(ListarCategoriasPorNomeDoProdutoEValor value) {
        return new JAXBElement<ListarCategoriasPorNomeDoProdutoEValor>(_ListarCategoriasPorNomeDoProdutoEValor_QNAME, ListarCategoriasPorNomeDoProdutoEValor.class, null, value);
    }

}

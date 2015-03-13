
package br.com.guaraba.wally.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "AnunciosWebService", targetNamespace = "http://ws.wally.guaraba.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AnunciosWebService {


    /**
     * 
     * @param valorAte
     * @param nomeDoProduto
     * @return
     *     returns java.util.List<br.com.guaraba.wally.ws.Categoria>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarCategoriasPorNomeDoProdutoEValor", targetNamespace = "http://ws.wally.guaraba.com.br/", className = "br.com.guaraba.wally.ws.ListarCategoriasPorNomeDoProdutoEValor")
    @ResponseWrapper(localName = "listarCategoriasPorNomeDoProdutoEValorResponse", targetNamespace = "http://ws.wally.guaraba.com.br/", className = "br.com.guaraba.wally.ws.ListarCategoriasPorNomeDoProdutoEValorResponse")
    public List<Categoria> listarCategoriasPorNomeDoProdutoEValor(
        @WebParam(name = "nomeDoProduto", targetNamespace = "")
        String nomeDoProduto,
        @WebParam(name = "valorAte", targetNamespace = "")
        Double valorAte);

    /**
     * 
     * @param valorAte
     * @param nomeDoProduto
     * @param categoriaId
     * @return
     *     returns java.util.List<br.com.guaraba.wally.ws.Anuncio>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarAnunciosPorCategoriaNomeDoProdutoEValor", targetNamespace = "http://ws.wally.guaraba.com.br/", className = "br.com.guaraba.wally.ws.ListarAnunciosPorCategoriaNomeDoProdutoEValor")
    @ResponseWrapper(localName = "listarAnunciosPorCategoriaNomeDoProdutoEValorResponse", targetNamespace = "http://ws.wally.guaraba.com.br/", className = "br.com.guaraba.wally.ws.ListarAnunciosPorCategoriaNomeDoProdutoEValorResponse")
    public List<Anuncio> listarAnunciosPorCategoriaNomeDoProdutoEValor(
        @WebParam(name = "categoriaId", targetNamespace = "")
        Integer categoriaId,
        @WebParam(name = "nomeDoProduto", targetNamespace = "")
        String nomeDoProduto,
        @WebParam(name = "valorAte", targetNamespace = "")
        Double valorAte);

}
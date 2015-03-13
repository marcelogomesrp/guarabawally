
package br.com.guaraba.wally.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listarAnunciosPorCategoriaNomeDoProdutoEValor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listarAnunciosPorCategoriaNomeDoProdutoEValor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categoriaId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nomeDoProduto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valorAte" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarAnunciosPorCategoriaNomeDoProdutoEValor", propOrder = {
    "categoriaId",
    "nomeDoProduto",
    "valorAte"
})
public class ListarAnunciosPorCategoriaNomeDoProdutoEValor {

    protected Integer categoriaId;
    protected String nomeDoProduto;
    protected Double valorAte;

    /**
     * Gets the value of the categoriaId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCategoriaId() {
        return categoriaId;
    }

    /**
     * Sets the value of the categoriaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCategoriaId(Integer value) {
        this.categoriaId = value;
    }

    /**
     * Gets the value of the nomeDoProduto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    /**
     * Sets the value of the nomeDoProduto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeDoProduto(String value) {
        this.nomeDoProduto = value;
    }

    /**
     * Gets the value of the valorAte property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValorAte() {
        return valorAte;
    }

    /**
     * Sets the value of the valorAte property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValorAte(Double value) {
        this.valorAte = value;
    }

}

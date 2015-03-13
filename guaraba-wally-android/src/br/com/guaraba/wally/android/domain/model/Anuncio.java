package br.com.guaraba.wally.android.domain.model;

import java.io.Serializable;
import java.text.DecimalFormat;

import br.com.guaraba.wally.android.util.NumberUtils;

public class Anuncio implements Serializable {

	private static final long serialVersionUID = -489676753555943055L;

    private Integer id;

	private Produto produto;
	
	private Double valor;

    private Double latitude;

    private Double longitude;
	
	public Anuncio() { }
	
	public Anuncio(final Integer id, final Produto produto, final Double valor, final Double latitude, final Double longitude) { 
	
		this();
		this.setId(id);
		this.setProduto(produto);
		this.setValor(valor);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}

	public Integer getId() {

		return id;
	}
	private void setId(Integer id) {

		this.id = id;
	}

	public Double getLatitude() {

		return latitude;
	}
	private void setLatitude(Double latitude) {

		this.latitude = latitude;
	}

	public Double getLongitude() {

		return longitude;
	}
	private void setLongitude(Double longitude) {

		this.longitude = longitude;
	}

	public Produto getProduto() {
		
		return produto;
	}
	private void setProduto(final Produto produto) {

		this.produto = produto;
	}

	public Double getValor() {

		return this.valor;
	}
	private void setValor(final Double valor) {

		this.valor = valor;
	}
	public String getValorFormatado() {

		String valorFormatado = null;

		if(NumberUtils.isNullOrZero(this.getValor())) {

			valorFormatado = "R$ 0,00";

		} else {

			valorFormatado = new DecimalFormat("R$ 0.00").format(this.getValor());
		}		

		return valorFormatado;		
	}
}
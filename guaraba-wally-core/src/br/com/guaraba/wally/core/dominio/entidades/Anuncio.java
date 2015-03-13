package br.com.guaraba.wally.core.dominio.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Anuncio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date inicioVigencia;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fimVigencia;
	private Float valor;
	private Boolean ativo;
	private Double latitude;
	private Double longitude;
	@OneToOne
	private Produto produto;

	public Anuncio() {
	}

	public Anuncio(Date inicioVigencia, Date fimVigencia, Float valor,
			Boolean ativo, Double latitude, Double longitude, Produto produto) {

		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
		this.valor = valor;
		this.ativo = ativo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.produto = produto;
	}

	public Anuncio(Integer id, Date inicioVigencia, Date fimVigencia,
			Float valor, Boolean ativo, Double latitude, Double longitude,
			Produto produto) {

		this(inicioVigencia, fimVigencia, valor, ativo, latitude, longitude,
				produto);
		this.id = id;
	}

	public Integer getId() {

		return id;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (getId() != null ? getId().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Anuncio)) {
			return false;
		}
		Anuncio other = (Anuncio) object;
		if ((this.getId() == null && other.getId() != null)
				|| (this.getId() != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "br.com.guaraba.wally.core.dominio.entidades.Anuncio[id="
				+ this.getId() + "]";
	}
}
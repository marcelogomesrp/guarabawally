package br.com.guaraba.wally.core.dominio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "nome")
	private String nome;
	private String descricao;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Fornecedor fornecedor;

	public Produto() {
	}

	public Produto(String nome, String descricao, Categoria categoria,
			Fornecedor fornecedor) {

		this();
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
	}

	public Produto(Integer id, String nome, String descricao,
			Categoria categoria, Fornecedor fornecedor) {

		this(nome, descricao, categoria, fornecedor);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		if (this.categoria == null) {
			this.categoria = new Categoria();
		}
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "br.com.guaraba.wally.core.dominio.entidades[id=" + this.getId()
				+ "]";
	}
}
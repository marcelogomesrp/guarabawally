package br.com.guaraba.wally.android.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    
    private List<Produto> produtos;

    public Categoria() { 
    	
    	this.produtos = new ArrayList<Produto>();
    }
    public Categoria(String nome) {
    	this();
    	this.nome = nome;
    }
    public Categoria(Integer id, String nome) {
        this(nome);
    	this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

	public Iterable<Produto> getProdutos() {

		return produtos;
	}

	public void adicionarProduto(Produto produto) {
		
		this.produtos.add(produto);
	}

	public void removerProduto(Produto produto) {
		
		this.produtos.remove(produto);
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.guaraba.wally.core.dominio.entidades.Categoria[id=" + this.getId() + "]";
    }
}
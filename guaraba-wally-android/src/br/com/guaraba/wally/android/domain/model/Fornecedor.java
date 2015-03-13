package br.com.guaraba.wally.android.domain.model;

import java.io.Serializable;

public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 8514237812383539102L;
    private Integer id;
    private String cnpj;
    private String nomeFantasia;

    public Fornecedor() { }
    
    public Fornecedor(final Integer id) { 

    	this.setId(id);
    }
    
    public Fornecedor(final Integer id, final String cnpj, final String nomeFantasia) {

    	this(id);
    	this.setCnpj(cnpj);
    	this.setNomeFantasia(nomeFantasia);
    }

	public Integer getId() {

		return this.id;
    }
	private void setId(final Integer id) {

		this.id = id;
	}

    public String getCnpj() {

    	return this.cnpj;
    }
    public void setCnpj(final String cnpj) {

        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {

    	return this.nomeFantasia;
    }
    public void setNomeFantasia(final String nomeFantasia) {

    	this.nomeFantasia = nomeFantasia;
    }
}
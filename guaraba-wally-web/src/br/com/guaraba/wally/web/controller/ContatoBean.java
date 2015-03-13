package br.com.guaraba.wally.web.controller;

import br.com.guaraba.wally.core.dominio.entidades.FaleConosco;
import br.com.guaraba.wally.core.dominio.servicos.IFaleConoscoService;
import br.com.guaraba.wally.core.dominio.servicos.impl.FaleConoscoService;
import br.com.guaraba.wally.web.controller.util.FacesUtils;

public class ContatoBean {
	private FaleConosco faleConosco;

	public ContatoBean() {
		this.faleConosco = new FaleConosco();
	}

	public String enviaEmail() {
		try {
			IFaleConoscoService faleConoscoService = new FaleConoscoService();
			faleConoscoService.cadastrar(this.faleConosco);
			this.faleConosco = new FaleConosco();
		} catch (Exception e) {
			FacesUtils.adicionarMensagem("base_message", e,
					"Ocorreu uma falha ao tentar efetuar o cadastro.");
			return null;
		}
		return "sucesso";
	}

	public void setFaleConosco(FaleConosco faleConosco) {
		this.faleConosco = faleConosco;
	}

	public FaleConosco getFaleConosco() {
		return faleConosco;
	}

}

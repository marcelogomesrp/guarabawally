package br.com.guaraba.wally.core.dominio.servicos;

import java.util.List;

import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.wally.core.dominio.entidades.FaleConosco;

public interface IFaleConoscoService {

    void excluir(FaleConosco faleConosco) throws ServiceException;

    List<FaleConosco> listarTodos() throws ServiceException;

	FaleConosco cadastrar(FaleConosco faleConosco) throws ServiceException;
	
	void EnviarEmail(FaleConosco faleConosco) throws ServiceException, Exception, Exception;
	
}

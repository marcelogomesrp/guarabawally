package br.com.guaraba.wally.core.dominio.servicos;

import java.util.List;

import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.wally.core.dominio.entidades.Categoria;

public interface ICategoriaService {

    Categoria salvar(Categoria categoria) throws ServiceException;

    void excluir(Categoria categoria) throws ServiceException;

    List<Categoria> listarTodos() throws ServiceException;

	Categoria criar(String string) throws ServiceException;
	
	Categoria carregarPorId(Integer id) throws ServiceException;
	
}
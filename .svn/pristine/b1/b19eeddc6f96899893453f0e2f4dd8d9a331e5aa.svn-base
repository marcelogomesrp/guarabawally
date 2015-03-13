package br.com.guaraba.wally.core.dominio.servicos;

import java.util.List;

import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.wally.core.dominio.entidades.Anuncio;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;

public interface IAnuncioService {

    Anuncio salvar(Anuncio anuncio) throws ServiceException;

    Anuncio cadastrar(Anuncio anuncio) throws ServiceException;

    void excluir(Anuncio anuncio) throws ServiceException;

    List<Anuncio> listarTodos(Fornecedor fornecedor) throws ServiceException;

	Anuncio carregarPorId(Integer id) throws ServiceException;

	List<Anuncio> listarAnunciosPorCategoriaNomeDoProdutoEValor(final Integer categoriaId, final String nomeDoProduto, final Double valorAte);
}
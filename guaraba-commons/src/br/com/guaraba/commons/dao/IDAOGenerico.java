package br.com.guaraba.commons.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IDAOGenerico<T, ID extends Serializable> {

	public enum Orientation {
		
		ASC,
		DESC
	}

	public enum MatchMode {
		
		EXAT,
		END,
		ANYWHERE,
		START
	}

    T carregarPorId(ID id) throws DataAccessException;

    List<T> carregarPorId(List<ID> ids) throws DataAccessException;

    List<T> listarTodos() throws DataAccessException;

    List<T> listarTodos(String orderByColumn, Orientation orientation) throws DataAccessException;
 
    List<T> listarTodos(Integer firstResult, Integer maxResults, String orderByColumn, Orientation orientation) throws DataAccessException;

    List<T> listarTodosMenosEsse(ID id) throws DataAccessException;

    List<T> listarTodosTOP(Integer top, String orderbyColumn, Orientation orientation) throws DataAccessException;

	Integer contarTodos() throws DataAccessException;

    T carregar(T model, String... excludeProperty) throws DataAccessException;

    T carregar(T model, MatchMode matchMode, String... excludeProperty) throws DataAccessException;

    List<T> listarPorModelo(T model, String... excludeProperty) throws DataAccessException;

    List<T> listarPorModelo(T model, Integer firstResult, Integer maxResults, String... excludeProperty) throws DataAccessException;

    List<T> listarPorModelo(T model, Integer top, String orderByColumn, Orientation orientation, String... excludeProperty) throws DataAccessException;

    List<T> listarPorModelo(T model, MatchMode matchMode, String... excludeProperty) throws DataAccessException;

    T salvar(T model) throws DataAccessException;

    void salvar(List<T> model) throws DataAccessException;

    T excluir(T model) throws DataAccessException;

    void excluir(List<T> models) throws DataAccessException;

    void flush() throws DataAccessException;

    void clear() throws DataAccessException;
    
    List<T> listPesqPorParams(String query, Map<String, Object> params) throws DataAccessException;
}
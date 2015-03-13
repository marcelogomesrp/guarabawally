package br.com.guaraba.commons.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.guaraba.commons.dao.DataAccessException;
import br.com.guaraba.commons.dao.IDAOGenerico;
import br.com.guaraba.commons.util.StringUtils;

public abstract class DAOGenerico<T, ID extends Serializable> implements IDAOGenerico<T, ID> {

	private Session session;
    
	public DAOGenerico(Session session) {

		this.session = session;
	}

    @SuppressWarnings("unchecked")
    private Class<T> getGenericType() {
     
    	Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return (Class<T>) parameterizedType.getActualTypeArguments()[0];
        } else {
            return null;
        }        
    }
    
    protected Session getSession() {
    	
        return this.session;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<T> carregarPorId(List<ID> ids) throws DataAccessException {

		List<T> models = null;

		try {

			Criteria criteria = this.getSession().createCriteria(this.getGenericType());
			criteria.add(Restrictions.in("id", ids));

			models = criteria.list();

		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "carregarPorId(List<ID> ids)");
		}

    	return models;
	}

    @SuppressWarnings("unchecked")
	public T carregarPorId(ID id) throws DataAccessException {
        
    	T model = null;
    	
    	try {
    	
    		model = (T) this.getSession().load(getGenericType(), id);
    	
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "carregarPorId(ID id)");
		}

    	return model; 
    }

    public List<T> listarTodos() throws DataAccessException {
    	
    	List<T> models = null;
    	
    	try {
			
    		models = this.findByCriteria(null, null);
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listarTodos()");
		}

    	return models;
    }
    
    public List<T> listarTodos(String orderByColumn, Orientation orientation) throws DataAccessException {
    	
    	List<T> models = null;
    	
    	try {
			
    		models = this.findByCriteria(orderByColumn, orientation);
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listarTodos(String orderByColumn, Orientation orientation)");
		}

    	return models;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> listarTodosMenosEsse(ID id) throws DataAccessException {
    	
    	List<T> models = null;
    	
    	try {

        	Criteria criteria = this.getSession().createCriteria(getGenericType());
        	criteria.add(Restrictions.ne("id",id ));    	
        	
    		models = criteria.list();
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listarTodosMenosEsse(ID id)");
		}

    	return models;
	}
    
    @SuppressWarnings("unchecked")
	public List<T> listarTodos(Integer firstResult, Integer maxResults, String orderByColumn, Orientation orientation) throws DataAccessException {
    	
    	List<T> models = null;
    	
    	try {

        	Criteria criteria = this.getSession().createCriteria(getGenericType());
        	criteria.setFirstResult(firstResult);
        	criteria.setMaxResults(maxResults);
        	
        	if (!StringUtils.isNullOrEmpty(orderByColumn)) {
        		
        		if(orientation == null)
        			orientation = Orientation.ASC;
        		
    	    	if(orientation == Orientation.ASC) {	    		
    	    		criteria.addOrder(Order.asc(orderByColumn));
    	    		
    	    	} else {	    		
    	    		criteria.addOrder(Order.desc(orderByColumn));
    	    	}
        	}
        	
        	models = criteria.list();
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listarTodos(Integer firstResult, Integer maxResults, String orderByColumn, Orientation orientation)");
		}

    	return models;
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarTodosTOP(Integer top, String orderByColumn, Orientation orientation) throws DataAccessException {

    	List<T> models = null;
    	
    	try {

    		Criteria criteria = this.getSession().createCriteria(getGenericType());
    		
    		if(top != null && top > 0) {
	
    			criteria.setMaxResults(top);
    		}
        	
        	if(!StringUtils.isNullOrEmpty(orderByColumn)) {
        		
        		if(orientation == null)
        			orientation = Orientation.ASC;
        		
    	    	if(orientation == Orientation.ASC) {	    		
    	    		criteria.addOrder(Order.asc(orderByColumn));
    	    		
    	    	} else {	    		
    	    		criteria.addOrder(Order.desc(orderByColumn));
    	    	}
        	}
        	
        	models = criteria.list();
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listarTodosTOP(Integer top, String orderByColumn, Orientation orientation)");
		}

    	return models;
	}

    public List<T> listarPorModelo(T model, String... excludeProperty) throws DataAccessException {
    	
    	List<T> models = null;
    	
    	try {
        	
    		models = this.listarPorModelo(model, null, excludeProperty);
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listarPorModelo(T model, String... excludeProperty)");
		}

    	return models;
    }    

    @SuppressWarnings("unchecked")
    public List<T> listarPorModelo(T model, MatchMode matchMode, String... excludeProperty) throws DataAccessException {
    
    	List<T> models = null;
    	
    	try {
        	
    		models = this.findByExample(model, matchMode, excludeProperty).list();
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listarPorModelo(T model, MatchMode matchMode, String... excludeProperty)");
		}

    	return models;
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarPorModelo(T model, Integer top, String orderByColumn, Orientation orientation, String... excludeProperty) throws DataAccessException {

    	List<T> models = null;
    	
    	try {
        	
    		Criteria criteria = this.findByExample(model, excludeProperty);
    		
    		if(top != null && top > 0) {
    			
    			criteria.setMaxResults(top);
    		}
        	
        	if(!StringUtils.isNullOrEmpty(orderByColumn)) {
        		
        		if(orientation == null)
        			orientation = Orientation.ASC;
        		
    	    	if(orientation == Orientation.ASC) {
    	    		
    	    		criteria.addOrder(Order.asc(orderByColumn));
    	    		
    	    	} else {
    	    		
    	    		criteria.addOrder(Order.desc(orderByColumn));
    	    	}
        	}
        	
        	models = criteria.list();
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listarPorModelo(T model, Integer top, String orderByColumn, Orientation orientation, String... excludeProperty)");
		}

    	return models;
	}
    
	private Criteria findByExample(T model, String... excludeProperty) throws DataAccessException {
		
		return this.findByExample(model, null, excludeProperty);
	}
	
    private Criteria findByExample(T model, MatchMode matchMode, String... excludeProperty) throws DataAccessException {
    	
    	Criteria criteria = this.getSession().createCriteria(model.getClass());
    	Example example = null;
    	org.hibernate.criterion.MatchMode hibernateMatchMode = org.hibernate.criterion.MatchMode.ANYWHERE;
    	
    	if(model != null) {
    	
    		if(matchMode != null) {
    			
    			switch (matchMode) {
    			
					case ANYWHERE:
						
						hibernateMatchMode = org.hibernate.criterion.MatchMode.ANYWHERE;
						
						break;

					case EXAT:
						
						hibernateMatchMode = org.hibernate.criterion.MatchMode.EXACT;
						
						break;
						
					case END:
						
						hibernateMatchMode = org.hibernate.criterion.MatchMode.END;
						
						break;
						
					case START:
						
						hibernateMatchMode = org.hibernate.criterion.MatchMode.START;
						
						break;
						
					default:
						
						hibernateMatchMode = org.hibernate.criterion.MatchMode.ANYWHERE;
						break;
				}
    		}

	    	example = Example.create(model)
	    						.excludeZeroes()
	    							.ignoreCase()
	    								.enableLike(hibernateMatchMode);
	        
	    	if(excludeProperty != null) {
		        
	    		for (String exclude : excludeProperty) {
		        	
		        	example.excludeProperty(exclude);
		        }
	    	}
	       
	        criteria.add(example);
    	}
    	
        return criteria;
    }
	
    public T carregar(T model, String... excludeProperty) throws DataAccessException {
    	
    	T modelo = null;

    	try {
        	
    		modelo = this.carregar(model, null, excludeProperty);    
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "carregar(T model, String... excludeProperty)");
		}

    	return modelo;
    }

    public T carregar(T model, MatchMode matchMode, String... excludeProperty) throws DataAccessException {
    	
    	T modelo = null;

    	try {
        	
        	List<T> listModel = this.listarPorModelo(model, matchMode, excludeProperty);
        	
        	if (listModel != null && listModel.size() > 0) {
        	
        		modelo = listModel.get(0);
        	}
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "carregar(T model, MatchMode matchMode, String... excludeProperty)");
		}

    	return modelo;
    }

    @SuppressWarnings("unchecked")
    public List<T> listarPorModelo(T model, Integer firstResult, Integer maxResults, String... excludeProperty) throws DataAccessException {
       
    	List<T> models = null;
    	
    	try {
        	
        	Criteria criteria = this.findByExample(model, excludeProperty);
            criteria.setFirstResult(firstResult);
            criteria.setMaxResults(maxResults);        
            
            models = criteria.list();
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listarPorModelo(T model, Integer firstResult, Integer maxResults, String... excludeProperty)");
		}

    	return models;
    }    

	public Integer contarTodos() throws DataAccessException {
	    
		Integer quantidade = null;
    	
    	try {
        	
    		Criteria criteria = this.getSession().createCriteria(getGenericType());  
    		criteria.setProjection(Projections.rowCount());  
    		quantidade = ((Integer)criteria.list().get(0)).intValue(); 
    		
		} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "contarTodos()");
		}

    	return quantidade;
	}

    @SuppressWarnings("unchecked")
	public T salvar(T model) throws DataAccessException {
        
		T modelo = null;
    	
    	try {
        	
    		modelo = (T) this.getSession().merge(model);

    	} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "salvar(T model)");
		}

    	return modelo;
    }

	@Override
	public void salvar(List<T> models) throws DataAccessException {

		for (T model : models) {
			
			this.salvar(model);
		}
	}

    public void flush() throws DataAccessException {
    	
    	this.getSession().flush();
    }
    
    public void clear() throws DataAccessException {
    	
    	this.getSession().clear();
    }
    
    @SuppressWarnings("unchecked")
	protected List<T> findByCriteria(String orderByColumn, Orientation orientation, Criterion... criterion) {
   	
    	Criteria criteria = this.getSession().createCriteria(getGenericType());

    	for (Criterion c : criterion) {
    		criteria.add(c);
    	}
    	
    	if (!StringUtils.isNullOrEmpty(orderByColumn)) {
    		
    		if(orientation == null)
    			orientation = Orientation.ASC;
    		
	    	if(orientation == Orientation.ASC) {
	    		
	    		criteria.addOrder(Order.asc(orderByColumn));
	    		
	    	} else {
	    		
	    		criteria.addOrder(Order.desc(orderByColumn));
	    	}
    	}
    	
    	return criteria.list();
    }
    
    public T excluir(T model) throws DataAccessException {

    	try {
        	
    		this.getSession().delete(model);
    		model = null;

    	} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "excluir(T model)");
		}

    	return model;
    }
    
	@Override
	public void excluir(List<T> models) throws DataAccessException {
		
		for (T model : models) {
			
			this.excluir(model);
		}
	}

    @SuppressWarnings("unchecked")
	public List<T> listPesqPorParams(String query, Map<String, Object> params) throws DataAccessException {
        
    	List<T> models = null;
    	
    	try {
        	
        	Query q = this.getSession().createQuery(query);
            for (String chave : params.keySet()) {
                q.setParameter(chave, params.get(chave));
            }
            models = q.list();

    	} catch (Exception e) {

			throw new DataAccessException(e, this.getGenericType(), "listPesqPorParams(String query, Map<String, Object> params)");
		}

    	return models;
    }
}
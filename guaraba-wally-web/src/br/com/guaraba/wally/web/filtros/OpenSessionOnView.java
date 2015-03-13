package br.com.guaraba.wally.web.filtros;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.guaraba.commons.dao.impl.HibernateUtil;
import br.com.guaraba.wally.carga.Carga;
import br.com.guaraba.wally.test.CargaTest;
import br.com.guaraba.wally.test.ExecucaoDeTestes;

/**
 * Servlet Filter implementation class OpenSessionOnView
 */
public class OpenSessionOnView implements Filter {

	private Logger logger = Logger.getLogger(OpenSessionOnView.class.getName());

    /**
     * Default constructor. 
     */
    public OpenSessionOnView() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HibernateUtil.createSession("guaraba-wally-persistence-unit");

		HibernateUtil.openSession();

		try {

			HibernateUtil.currentSession().beginTransaction();

			chain.doFilter(request, response);

			HibernateUtil.currentSession().getTransaction().commit();

		} catch (Exception e) {

			logger.severe("Erro ao tentar executar o OpenSessionOnView: " + e.getMessage());

			HibernateUtil.roolbackCurrentSession();

			throw new ServletException(e.getMessage(), e);

		} finally {

			HibernateUtil.closeCurrentSession();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		this.executarTestes();
		
		this.efetuarCarga();
	}

	private void executarTestes() {

		try {

			//adiciona todos os testes que serão executados
			ExecucaoDeTestes.getInstance().adicionarTeste("Teste de Carga", new CargaTest());

			//executa os testes adicionados
			ExecucaoDeTestes.getInstance().executarTestes();

		} catch (Exception e) {

			logger.severe("Erro ao tentar executar os testes. Efetuando roolback. Erro: " + e.getMessage());
		}
	}

	private void efetuarCarga() {

		HibernateUtil.createSession("guaraba-wally-persistence-unit");

		HibernateUtil.openSession();

		try {

			HibernateUtil.currentSession().beginTransaction();
			
			Carga.getInstance().criarCategorias();

			HibernateUtil.currentSession().getTransaction().commit();

		} catch (Exception e) {

			logger.severe("Erro ao tentar executar a Carga de criação de categorias. Efetuando roolback. Erro: " + e.getMessage());
			
			HibernateUtil.roolbackCurrentSession();

		} finally {

			HibernateUtil.closeCurrentSession();
		}
	}
}
package br.com.guaraba.wally.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.guaraba.commons.dao.impl.HibernateUtil;
import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;
import br.com.guaraba.wally.core.dominio.entidades.Produto;
import br.com.guaraba.wally.core.dominio.servicos.IFornecedorService;
import br.com.guaraba.wally.core.dominio.servicos.IProdutoService;
import br.com.guaraba.wally.core.dominio.servicos.impl.FornecedorService;
import br.com.guaraba.wally.core.dominio.servicos.impl.ProdutoService;

public class CargaTest implements Testavel {

	private static Logger logger = Logger.getLogger(CargaTest.class.getName());

	@Override
	public void executar() {

		HibernateUtil.createSession("guaraba-wally-persistence-unit");

		HibernateUtil.openSession();
		
		try {

			HibernateUtil.currentSession().beginTransaction();

//			ICategoriaService categoriaService = new CategoriaService();
//
//			//carrega as categorias existentes
//			List<Categoria> todasCategorias = categoriaService.listarTodos();
//
//			logar("criarCategorias()", "Foram carregadas " + ((todasCategorias == null) ? "0" : todasCategorias.size()) + " categorias.");
//
//			//se não houver nenhuma
//			if(todasCategorias == null || todasCategorias.size() <= 0) {
//
//				logar("criarCategorias()", "É necessário criar as categorias. Criando as categorias padrões.");
//
//				//cria as categorias padrões
//				categoriaService.criar("Teste 1");
//				categoriaService.criar("Teste 2");
//				categoriaService.criar("Teste 3");
//				categoriaService.criar("Teste 4");
//
//				logar("criarCategorias()", "As categorias padrões foram criadas com sucesso!");
//			}

			IFornecedorService fornecedorService = new FornecedorService();
			Fornecedor fornecedor = fornecedorService.carregarPorLoginSenha("2", "2");
			IProdutoService produtoService = new ProdutoService();
			List<Produto> produtos = produtoService.findByFornecedor(fornecedor);
			if(produtos.size() > 0)
			{
				for (Produto produto : produtos) {
					System.out.println(produto.getNome() + " - ID : " + produto.getId());	
				}
				
			}
			
			//se chegou aqui é por que conseguiu efetuar a inserção com sucesso. Efetuando rollback.
			//HibernateUtil.currentSession().getTransaction().rollback();
			HibernateUtil.roolbackCurrentSession();

		} catch (ServiceException e) {

			logar("criarCategorias()", "Ocorreu um erro não tratado na criação das categorias padrões.", e);

		} finally {

			logar("criarCategorias()", "Finalizando carga..");

			HibernateUtil.closeCurrentSession();
		}
	}

	private static void logar(String metodo, String mensagem) {

		logar(metodo, mensagem, null);
	}

	private static void logar(String metodo, String mensagem, Throwable t) {
		
		mensagem = "[" + CargaTest.class.getName() + "] - [" + metodo + "] : " + mensagem + ".";
		
		if(t == null) {

			logger.log(Level.INFO, mensagem);

		} else {

			mensagem.concat(" Mensagem: ").concat(t.getMessage());

			logger.log(Level.SEVERE, mensagem, t);
		}
	}

}
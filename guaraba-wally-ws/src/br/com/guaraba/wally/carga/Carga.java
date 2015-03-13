package br.com.guaraba.wally.carga;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.guaraba.commons.service.impl.ServiceException;
import br.com.guaraba.wally.core.dominio.entidades.Categoria;
import br.com.guaraba.wally.core.dominio.entidades.Contato;
import br.com.guaraba.wally.core.dominio.entidades.Endereco;
import br.com.guaraba.wally.core.dominio.entidades.Fornecedor;
import br.com.guaraba.wally.core.dominio.servicos.ICategoriaService;
import br.com.guaraba.wally.core.dominio.servicos.IFornecedorService;
import br.com.guaraba.wally.core.dominio.servicos.impl.CategoriaService;
import br.com.guaraba.wally.core.dominio.servicos.impl.FornecedorService;

public class Carga {

	Logger logger = Logger.getLogger(Carga.class.getName());

	private static Carga instance;

	private ICategoriaService categoriaService;
	private IFornecedorService fornecedorService;

	private Carga() {

		this.categoriaService = new CategoriaService();
		this.fornecedorService = new FornecedorService();
	}

	public static Carga getInstance() {

		if (instance == null) {

			instance = new Carga();
		}

		return instance;
	}

	public void criarAdministradores() {
		try {
			
			this.logar("criarAdministradores()", "Iniciando a Carga de Fornecedores Administradores no sistema.");
			
			List<Fornecedor> todosFornecedores = this.fornecedorService.listarTodos();
			
			this.logar("criarAdministradores()","Foram carregados " + ((todosFornecedores == null) ? "0" : todosFornecedores.size()) + " fornecedores.");
			
			if(todosFornecedores == null || todosFornecedores.size() <= 0) {

				this.logar("criarAdministradores()","� necess�rio criar os fornecedores administradores. Criando fornecedores administradores.");

				Calendar cal = Calendar.getInstance();
				Date now = cal.getTime();
				//String nowString = DateUtils.formatarDataEmString(cal.getTime(), FormatoDeDataHoras.MesDiaAno);				

				Contato contato;
				Fornecedor fornecedor;
				Endereco endereco;
				
				contato =  new Contato();
				fornecedor = new Fornecedor();
				endereco = new Endereco();
				
				contato.setLogin("matheus");
				contato.setSenha("senha");
				contato.setEmail("matcabelo@gmail.com");
				contato.setTelefone("16 9773 5630");
				contato.setNome("Matheus");
				
				endereco.setBairro("Bairro");
				endereco.setCep("123");
				endereco.setCidade("Cidade");
				endereco.setEstado("SP");
				endereco.setComplemento("Complemento");
				endereco.setLogradouro("Logradouro");
				endereco.setNumero(123);
				
				fornecedor.setContato(contato);
				fornecedor.setEndereco(endereco);
				fornecedor.setCnpj("123l");
				fornecedor.setDataHoraCadastro(now);
				fornecedor.setNomeFantasia("Matheus");
				fornecedor.setRazaoSocial("Matheus");
				
				this.fornecedorService.cadastrar(fornecedor);
				
				this.logar("criarAdministradores()","Fornecedores administradores criados!");
			}
		} catch (Exception e) {
			
			this.logar("criarAdministradores()","Ocorreu um erro ao tentar criar os fornecedores administradores.", e);

		} finally {

			this.logar("criarAdministradores()", "Finalizando carga..");
		}
	}

	public void criarCategorias() {

		try {

			this.logar("criarCategorias()",	"Iniciando a Carga de Categorias no sistema. Verificando se há categorias cadastradas no sistema");

			// carrega as categorias existentes
			List<Categoria> todasCategorias = this.categoriaService.listarTodos();

			this.logar("criarCategorias()","Foram carregadas " + ((todasCategorias == null) ? "0" : todasCategorias.size()) + " categorias.");

			// se não houver nenhuma
			if (todasCategorias == null || todasCategorias.size() <= 0) {

				this.logar("criarCategorias()","É necessário criar as categorias. Criando as categorias padrões.");

				// cria as categorias padrões
				this.categoriaService.criar("Vestuario");
				this.categoriaService.criar("Calcados");
				this.categoriaService.criar("Instrumentos Musicais");
				this.categoriaService.criar("Alimentos");
				this.categoriaService.criar("Computadores");
				this.categoriaService.criar("Veiculos");

				this.logar("criarCategorias()","As categorias padrões foram criadas com sucesso!");
			}

		} catch (ServiceException e) {

			this.logar("criarCategorias()","Ocorreu um erro não tratado na criação das categorias padrões.", e);

		} finally {

			this.logar("criarCategorias()", "Finalizando carga..");
		}
	}
	
	private void logar(String metodo, String mensagem) {

		this.logar(metodo, mensagem, null);
	}

	private void logar(String metodo, String mensagem, Throwable t) {

		mensagem = "[" + Carga.class.getName() + "] - [" + metodo + "] : "
				+ mensagem + ".";

		if (t == null) {

			logger.log(Level.INFO, mensagem);

		} else {

			mensagem.concat(" Mensagem: ").concat(t.getMessage());

			logger.log(Level.SEVERE, mensagem, t);
		}
	}
}
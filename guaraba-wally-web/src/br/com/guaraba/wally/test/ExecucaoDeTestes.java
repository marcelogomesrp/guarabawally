package br.com.guaraba.wally.test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecucaoDeTestes {

	private static Logger logger = Logger.getLogger(CargaTest.class.getName());
	
	private static ExecucaoDeTestes testes = null;

	private Map<String, Testavel> testaveis;
	
	private ExecucaoDeTestes() { 
		
		this.testaveis = new HashMap<String, Testavel>();
	}

	public static ExecucaoDeTestes getInstance() {

		if(testes == null) {

			testes = new ExecucaoDeTestes();
		}

		return testes;
	}

	public void adicionarTeste(final String nomeDoTeste, final Testavel testavel) {
		
		this.testaveis.put(nomeDoTeste, testavel);
	}
	
	public void executarTestes() {

		logar("executarTestes()", "=========== Iniciando testes");

		for (String nomeDoTestavel : this.testaveis.keySet()) {

			logar("executarTestes()", "====================== Iniciando teste '".concat(nomeDoTestavel).concat("'"));

			try {

				this.testaveis.get(nomeDoTestavel).executar();

				logar("executarTestes()", "====================== O teste '".concat(nomeDoTestavel).concat("' foi executado com SUCESSO!"));

			} catch (Exception e) {

				logar("executarTestes()", "====================== O teste '".concat(nomeDoTestavel).concat("' foi executado com FALHA! Mensagem: ".concat(e.getMessage())));
			}
		}

		logar("executarTestes()", "=========== Finalizando testes");
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
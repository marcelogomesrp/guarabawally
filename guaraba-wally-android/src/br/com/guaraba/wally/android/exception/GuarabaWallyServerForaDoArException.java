package br.com.guaraba.wally.android.exception;

public class GuarabaWallyServerForaDoArException extends Exception {
	private static final long serialVersionUID = -4247673138385606234L;

	public GuarabaWallyServerForaDoArException() {

		super("Não foi possível conectar-se ao servidor.");
	}
	
}
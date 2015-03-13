package br.com.guaraba.commons.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EmailUtils {
	 
	public static boolean isEmailValido(String email) {
		Pattern padrao = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher pesquisa = padrao.matcher(email);
		return pesquisa.matches();		
	}

}

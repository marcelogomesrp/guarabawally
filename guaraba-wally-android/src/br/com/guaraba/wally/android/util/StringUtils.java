package br.com.guaraba.wally.android.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class StringUtils {

	private static final char[] SPECIAL_CHARACTERS = { '<', '>', '%', ';', ')', '(', '&', '+', '-', '\'', '\"', '.', '_', ',', ':', '=', '$', '@', '/' };

    public static boolean isNullOrEmpty(String string) {

		return isNullOrEmpty(string, true);
	}

	public static boolean isNullOrEmpty(String string, boolean trim) {

		return (string == null || ((trim) ? string.trim().length() == 0
				: string.length() == 0));
	}

	public static String removeSpecialCharacters(String value) {

		return removeSpecialCharacters(value, null);
	}

	public static String removeSpecialCharacters(String value, char... caracteresIgnorados) {

		for (char caractere : SPECIAL_CHARACTERS) {

			if (!contains(caracteresIgnorados, caractere)) {

				while (value.indexOf(String.valueOf(caractere)) > -1) {

					// value = value.replaceAll(String.valueOf(caractere), "");
					String aux = value.substring(0, value.indexOf(String.valueOf(caractere)));

					aux += value.substring(value.indexOf(String.valueOf(caractere)) + 1);

					value = aux;
				}
			}
		}

		return value;
	}

	private static boolean contains(char[] caracteres, char caractere) {

		if(caracteres != null) {
		
			for (char c : caracteres) {
	
				if (c == caractere) {
	
					return true;
				}
			}
		}

		return false;
	}

    public static String inputStreamToString(final InputStream stream) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        return sb.toString();
    }
}
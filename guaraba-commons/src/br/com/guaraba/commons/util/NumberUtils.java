package br.com.guaraba.commons.util;

public final class NumberUtils {

	public static long getLong(String numeroEmString) {

		long number = 0;

		if (!StringUtils.isNullOrEmpty(numeroEmString)) {

			// se não for um value numérico
			if (!isNumeric(numeroEmString)) {

				numeroEmString = getNumber(numeroEmString);
			}

			if (isNumeric(numeroEmString)) {

				number = Long.parseLong(numeroEmString);
			}
		}

		return number;
	}

	public static int getInteger(String numeroEmString) {

		int number = 0;

		if (!StringUtils.isNullOrEmpty(numeroEmString)) {

			// se não for um value numérico
			if (!isNumeric(numeroEmString)) {

				numeroEmString = getNumber(numeroEmString);
			}

			if (isNumeric(numeroEmString)) {

				number = Integer.parseInt(numeroEmString);
			}
		}

		return number;
	}

	public static Double getDouble(String numeroEmString) {

		Double number = 0d;

		if (!StringUtils.isNullOrEmpty(numeroEmString)) {

			// se não for um value numérico
			if (!isNumeric(numeroEmString)) {
				
				numeroEmString = StringUtils.removeSpecialCharacters(numeroEmString, ',');
				
				if(numeroEmString.contains(",")) {
					
					numeroEmString = numeroEmString.replace(',', '.');
				}
			}

			if (isNumeric(numeroEmString)) {

				number = Double.parseDouble(numeroEmString);
			}
		}

		return number;
	}
	
	public static boolean isNumeric(String number) {

		return isNumeric(number, false);
	}

	public static boolean isNumeric(String number, boolean apenasNumerosPositivos) {

		boolean isValida = false;

		try {

			//testa se é long
			long num = Long.parseLong(number);
			isValida = ((apenasNumerosPositivos) ? num > 0 : true);
			
		} catch (Exception e) {
			
			try {

				//testa se é double
				double num = Double.parseDouble(number);
				isValida = ((apenasNumerosPositivos) ? num > 0 : true);

			} catch (Exception ex) {
				
				try {
				
					//testa se é int
					int num = Integer.parseInt(number);
					isValida = ((apenasNumerosPositivos) ? num > 0 : true);
				
				} catch (Exception ex1) {
					
				}
			}
		}

		return isValida;
	}

	public static boolean isInteger(String str) {
		
		try {
			
			Integer.parseInt(str);
			
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
	}

	public static Integer getInteger(Object numeroEmObject) {

		int number = 0;

		if (numeroEmObject != null) {

			try {

				number = getInteger(numeroEmObject.toString());

			} catch (Exception ex) { }
		}

		return number;
	}

	public static long getLong(Object numeroEmObject) {

		long number = 0;

		if (numeroEmObject != null) {

			try {

				number = getLong(numeroEmObject.toString());

			} catch (Exception ex) {
			}
		}

		return number;
	}

	public static String getNumber(String numeroEmString) {

		boolean eNegativo = false;
		
		if (!StringUtils.isNullOrEmpty(numeroEmString)) {

			if(numeroEmString.startsWith("-")) {
				
				eNegativo = true;
			}
			
			numeroEmString = StringUtils.removeSpecialCharacters(numeroEmString);

			numeroEmString = numeroEmString.replaceAll(" ", "");
		}

		return ((eNegativo) ? "-".concat(numeroEmString) : numeroEmString);
	}

	public static boolean isNullOrZero(Long number) {
		
		return number == null || number == 0;
	}
	
	public static boolean isNullOrZero(Integer number) {
		
		return number == null || number == 0;
	}
	
	public static boolean isNullOrZero(Double number) {
		
		return number == null || number == 0;
	}
}
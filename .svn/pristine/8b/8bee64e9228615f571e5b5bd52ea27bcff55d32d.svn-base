package br.com.guaraba.commons.util;

import java.lang.reflect.Method;

public final class ReflectionUtils {

	public static  Object getFieldValueFromObject(Object object, String fieldName) {

		Object fieldValue = null;

		if(object != null && !StringUtils.isNullOrEmpty(fieldName)) {

			//se for um campo que é um objeto composto, como campo.getProp()
			if(fieldName.contains(".")) {

				Object objeto = getMethodValue(object, fieldName.substring(0, fieldName.indexOf(".")));

				fieldValue = getFieldValueFromObject(objeto, fieldName.substring(fieldName.indexOf(".")+1));

			} else { //se for um campo simples

				fieldValue = getMethodValue(object, fieldName);
			}
		}

		return fieldValue;
	}

	private static Object getMethodValue(Object object, String methoddName) {
		
		Object methodValue = null;
		
		for (Method methodGet : object.getClass().getDeclaredMethods()) {
		
			if(methodGet.getName().equalsIgnoreCase("get".concat(methoddName))) {

				try {

					methodValue = methodGet.invoke(object, (Object[])null);
					
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
		
		return methodValue;
	}
}
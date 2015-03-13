package br.com.guaraba.commons.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
	
	public enum FormatoDeDataHoras {

        DiaMesAno("dd/MM/yyyy"),
        Hora("HH:mm:ss"),
        MesDiaAno("MM/dd/yyyy"),
        DiaMESAno("dd MMMMM yyyy");
        
        // Outros formatos
		// ("yyyyMMdd")
		// ("dd.MM.yy")
		// ("MM/dd/yy")
		// ("yyyy.MM.dd G 'at' hh:mm:ss z")
		// ("EEE, MMM d, ''yy")
		// ("h:mm a")
		// ("H:mm:ss:SSS")
		// ("K:mm a,z")
		// ("yyyy.MMMMM.dd GGG hh:mm aaa")

		private final String descricao;

		FormatoDeDataHoras(String descricao) {
	        this.descricao = descricao;
		}

		public String toString() {
			
			return this.descricao;
		}
	}

	public static Date configurarHoraMinutosESegundos(Date data, int hora, int minutos, int segundos) {

		Calendar dataDeCriacaoHelper = Calendar.getInstance(TimeZone.getTimeZone("GMT-3:00"));

    	dataDeCriacaoHelper.setTime((data == null) ? new Date() : data);

		dataDeCriacaoHelper.set(
				
			dataDeCriacaoHelper.get(Calendar.YEAR), 
			dataDeCriacaoHelper.get(Calendar.MONTH), 
			dataDeCriacaoHelper.get(Calendar.DATE),
			hora, 
			minutos, 
			segundos
		);

    	return dataDeCriacaoHelper.getTime();
	}

	public static String formatarDataEmString(Date data, FormatoDeDataHoras formato){
		
		Format formatador = new SimpleDateFormat(formato.toString());	
		
		return formatador.format(data);
	}
}
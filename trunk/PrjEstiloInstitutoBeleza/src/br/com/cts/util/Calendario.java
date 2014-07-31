package br.com.cts.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Calendario {

	public static boolean isDate(String dataNascimentoCliente) throws ParseException {
		try{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateFormat.setLenient(false);
			dateFormat.parse(dataNascimentoCliente).toString();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
}
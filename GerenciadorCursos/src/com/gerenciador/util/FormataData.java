package com.gerenciador.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormataData {
	
	public static String Format(String data) throws ParseException{
			
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient (false); 
        String dataFormatada = dateFormat.format(data);
        
		return dataFormatada;
	}
}

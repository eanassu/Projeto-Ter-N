package br.com.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	String executar(HttpServletRequest request, 
			HttpServletResponse response);
}

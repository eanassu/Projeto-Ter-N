package br.com.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoAluno;

public class LogicaExcluir implements Logica {
	@Override
	public String executar(HttpServletRequest request, 
			HttpServletResponse response) {
		int ra = Integer.parseInt(request.getParameter("ra"));
		DaoAluno dao = new DaoAluno();
		dao.excluirPeloRa(ra);	
		return "/Alunos1.jsp";
	}
	
}

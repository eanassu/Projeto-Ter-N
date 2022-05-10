package br.com.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoAluno;
import br.com.vemprafam.pojo.Aluno;

public class LogicaAlterar implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int ra = Integer.parseInt(request.getParameter("ra"));
		DaoAluno dao = new DaoAluno();
		Aluno aluno = dao.buscarPeloRa( ra );
		request.setAttribute("aluno", aluno);
		return "/Alteracao.jsp";		
	}

}

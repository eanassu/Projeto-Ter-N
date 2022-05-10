package br.com.vemprafam.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoAluno;
import br.com.vemprafam.pojo.Aluno;

public class LogicaGravar implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int ra = Integer.parseInt(request.getParameter("ra"));
		String nome = request.getParameter("nome");
		double renda = Double.parseDouble(request.getParameter("renda"));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento=null;
		try {
			dataNascimento = format.
					parse(request.getParameter("dataNascimento"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		Aluno aluno = new Aluno(ra,nome,renda,dataNascimento,email);
		DaoAluno dao = new DaoAluno();
		dao.alterarAluno(aluno);
		return "/Alunos1.jsp";
	}

}

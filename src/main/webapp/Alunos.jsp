<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.vemprafam.pojo.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="br.com.vemprafam.dao.DaoAluno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alunos</title>
</head>
<body>
<table border="1">
<tr>
<th>RA</th><th>nome</th><th>data de nascimento</th><th>renda</th>
</tr>
<%
DaoAluno dao = new DaoAluno();
List<Aluno> alunos = dao.getAlunos();
for( Aluno aluno: alunos ) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	String dataNascimento = dateFormat.format(aluno.getDataNascimento());
	String renda = currencyFormat.format(aluno.getRenda());
%>
<tr>
<td><%=aluno.getRa()%></td><td><%=aluno.getNome()%></td><td><%=dataNascimento%></td>
<td><%=renda%></td>
</tr>
<%
} 
%>
</table>
</body>
</html>
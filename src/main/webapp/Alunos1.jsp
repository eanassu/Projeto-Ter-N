<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alunos</title>
</head>
<body>
<jsp:useBean id="dao" class="br.com.vemprafam.dao.DaoAluno"/>
<table border="1">
<tr>
<th>RA</th><th>nome</th><th>data de nascimento</th><th>renda</th>
</tr>
<c:forEach var="aluno" items="${dao.alunos}">
<tr>
<td>${aluno.ra}</td>
<td>${aluno.nome}</td>
<td><fmt:formatDate value="${aluno.dataNascimento}" 
	 pattern="dd/MM/yyyy"/></td>
<td><fmt:formatNumber value="${aluno.renda}" type="currency"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>
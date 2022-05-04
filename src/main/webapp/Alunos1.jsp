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
<th>e-mail</th>
</tr>
<c:forEach var="aluno" items="${dao.alunos}" varStatus="id">
<tr bgcolor="#${id.count%2==0?'aaee88':'ffffff' }">
<td>${aluno.ra}</td>
<td>${aluno.nome}</td>
<td><fmt:formatDate value="${aluno.dataNascimento}" 
	 pattern="dd/MM/yyyy"/></td>
<td><fmt:formatNumber value="${aluno.renda}" type="currency"/></td>
<td>
  <c:if test="${not empty aluno.email}">
  	<a href="mailto:${aluno.email}">${aluno.email}</a>
  </c:if>
  <c:if test="${empty aluno.email}">
  	e-mail não informado
  </c:if>
</td>
<td><a href="excluir?ra=${aluno.ra}">excluir</a></td>
<td><a href="alterar?ra=${aluno.ra}">alterar</a></td>
</tr>
</c:forEach>
</table>
<br/>
<a href="/Projeto">voltar</a>
</body>
</html>
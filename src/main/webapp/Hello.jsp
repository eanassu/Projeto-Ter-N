<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exemplo de JSP</title>
</head>
<body>
Primeira página JSP

<%
String msg = "Aula Backend";
%>

Teste <br/>

<%=msg%> <br/>

<% out.println(msg); 
System.out.println("Onde vai isto?");

%>

</body>
</html>
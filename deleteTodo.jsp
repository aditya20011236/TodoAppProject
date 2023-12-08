<%@page import="com.mydata.Dao.TodoDaoImple"%>
<%@page import="com.mysql.cj.result.YearToDateValueFactory"%>
<%@page import="com.mydata.Dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int i = Integer.parseInt(request.getParameter("id"));
	TodoDao td = new TodoDaoImple();
	int res = td.deleteTodo(i);

	if (res > 0) {
	%>
	<jsp:forward page="Home.jsp"></jsp:forward>
	<%
	} else {
	%>
	<h2>Try Again!!!</h2>
	<jsp:include page="Home.jsp"></jsp:include>
	<%
	}
	%>
</body>
</html>
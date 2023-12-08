<%@page import="com.mydata.model.Todo"%>
<%@page import="com.mydata.Dao.TodoDaoImple"%>
<%@page import="com.mydata.Dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Management Application</title>
<style>
    header{
    background-color: rgb(246, 86, 28);
    padding: 10px 10px;
}
body{
    margin-top: 0px;
}
footer{
    background-color: rgb(246, 86, 28);
    padding: 10px 10px;
    text-align: center;
    position: relative;
    color: aliceblue;
}
.logout{
    position: absolute;
    left: 91%;
    color: rgb(193, 195, 196);
    display: inline;
}
.todos{
    position: absolute;
    left: 7%;
    color: rgb(193, 195, 196);
    display: inline;

}
h1{
    
    position: relative;
    top: 10px;
    left: 10%;
    width: 300px;

    
}
Form,table{
    position: relative;
    left: 30%;
    width: 500px;
    
}
td{
    width: 400px;
}
.todoapp{
    color: azure;
    display: inline;
}
.javablue{
    font: 300;
    color: rgb(6, 6, 198);
}
.green{
    background-color: green;
    color:white;
}
h2{text-align: center;}
.a{
    text-decoration: rgb(246, 248, 248);
    color: aliceblue;
}

    </style>
</head>
<body>
<header><span class="todoapp">Todo App</span> <nav class="todos"> Todos</nav> <nav class="logout"><a class="a" href="Login.jsp">LogOut</a></nav> </header>
	<table border="1px" cellspacing="5px" cellpadding="10px">
<%
int i=Integer.parseInt(request.getParameter("id"));

TodoDao td=new TodoDaoImple();
Todo d=td.viewTodoById(i);

%>
<form action="UpdateTodoServlet" method="post">
 <h2>Edit Todo</h2>
<table>
	<tr>
		<td>ToDo Id</td>
		<td><input type="text" name="id" value="<%= d.getId()%>" ></td>
	</tr>
	<tr>
		<td>ToDo title</td>
		<td><input type="text" name="title" value="<%= d.getTitle()%>"></td>
	</tr>
	<tr>
		<td>ToDo Description</td>
		<td><input type="text" name="tododescription" value="<%= d.getTododescription()%>"></td>
	</tr>
	<tr>
		<td>ToDo Status</td>
		<td><input type="text" name="Todostaus" value="<%= d.getTodostaus()%>"></td>
	</tr>
	<tr>
		<td>ToDo TargetDate</td>
		<td><input type="text" name="targetdate" value="<%= d.getTargetdate()%>"></td>
	</tr>
	<tr>
		
		<td><input type="submit" value="save"></td>
	</tr>

</table>
</form>
<tr>
<tr>
<footer>&copy; <span class="todoapp">2019Copyright:</span><span class="javablue">JavaGuides</span></footer>
</body>

</html>
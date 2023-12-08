<%@page import="com.mydata.Dao.TodoDaoImple"%>
<%@page import="com.mydata.model.Todo"%>
<%@page import="com.mydata.Dao.TodoDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
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
table,tr,td{
    border-collapse: collapse;
    border: 1px solid gray;
}
h2{text-align: center;}
.a{
    text-decoration: rgb(246, 248, 248);
    color: aliceblue;
}

    </style>
</head>
<body>
 <h2>List Of Todos</h2>
<header><span class="todoapp">Todo App</span> <nav class="todos"> Todos</nav> <nav class="logout"><a class="a" href="Login.jsp">LogOut</a></nav> </header>
	<table border="1px" cellspacing="5px" cellpadding="10px">
		<tr>


			<td>Title</td>
			<td>Target Date</td>
			<td>ToDo status</td>
			<td>Actions</td>

		</tr>
		<%
		TodoDao td = new TodoDaoImple();

		List<Todo> list = td.viewAllTodo();

		for (Todo d : list) {
		%>
		<tr>


			<td><%=d.getTitle()%></td>
			<td><%=d.getTargetdate()%></td>
			<td><%=d.getTodostaus()%></td>

			<td><a href="updateTodo.jsp?id=<%=d.getId()%>">Edit</a></td>
			<td><a href="deleteTodo.jsp?id=<%=d.getId()%>">delete</a></td>
		</tr>

		<%
		}
		%>
	</table>
	<br>
	<br>
	<form action="AddTodo.jsp">
		<input type="submit" value="Add Todo">
	</form>
	<br>
    <br>
    
    
<footer>&copy; <span class="todoapp">2019Copyright:</span><span class="javablue">JavaGuides</span></footer>
</body>
</html>
<%@page import="org.hasan.models.Userinfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show-users</title>
</head>
<body>
<center>
	<table border="1">
		<%
			List<Userinfo> list = (List<Userinfo>)request.getAttribute("users");
			
			for(Userinfo userinfo : list)
			{
		%>
			<tr>
				<td><%=userinfo.getName()%></td>
				<td><%=userinfo.getEmail()%></td>
				<td><%=userinfo.getPass()%></td>
				<td><a href="update-user?email=<%=userinfo.getEmail()%>">update</a></td>
				<td><a href="delete-user?email=<%=userinfo.getEmail()%>">delete</a></td>
			</tr>
		<%
			}
		%>
	</table>
</center>
</body>
</html>
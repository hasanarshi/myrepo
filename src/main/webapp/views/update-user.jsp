<%@page import="org.hasan.models.Userinfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Userinfo ui = (Userinfo)request.getAttribute("data");
%>
<form action="update-user-data" method="post">
email<input type="email" value="<%=ui.getEmail()%>" name="email" readonly><br>
name<input type="text" value="<%=ui.getName()%>" name="name"><br>
password<input type="text" value="<%=ui.getPass()%>" name="pass"><br>
<input type="submit" value="update-info">
</form>
</body>
</html>
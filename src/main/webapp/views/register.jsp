<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
</head>
<body>
	<fieldset>
		<legend>register</legend>
		<form action="do-register" method="post">
			<pre>
			<i>Name</i>
			<input type="text" name="name" value=${un}>
			<i>Email</i>			
			<input type="email" name="email">
			<i>Password</i>
			<input type="password" name="pass">
			<input type="submit" value="Register">
			</pre>
		</form>
	</fieldset>
<fieldset>
	<button onclick="fx()">click here to know about us</button>
	<hr>
	<a href="show-users">click here to get a list of users</a>
</fieldset>
<script type="text/javascript">
	function fx() 
	{
		window.location = "about-us";
	}
</script>
</body>
</html>
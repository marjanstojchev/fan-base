<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>

function validateForm() {
	
	   var x = document.forms["loginForm"]["username"].value;
	   var y = document.forms["loginForm"]["password"].value;
	   
	   if (x =="" || y=="" ) {
	
		   var exists = document.getElementById('newDiv');
			if (!exists){
		
	var newDiv = document.createElement('div');
	newDiv.id = 'newDiv';
	
	var failParagraph = document.createElement("p");
	var failMessige = document.createTextNode("Please enter an Username and a Password.");
	
	failParagraph.appendChild(failMessige);
	newDiv.appendChild(failParagraph);
	
	var failDiv = document.getElementById("failDiv");
 
    failDiv.appendChild(newDiv);
			}
    	
        return false;
   	 	}
	
}
</script>

</head>
<body>
<%@ include file="header.jsp" %>
<br>
<%@ include file="navi.jsp" %>
<br>
<h2>Login</h2>
<br>
<form id="loginForm" name="loginForm"
		action="Login.do" onsubmit="return validateForm()" method="post">
		<table>
			<tr>
				<td>
					<span>Username</span>
				</td>
				<td>
					<input type="text" name="username" />
				</td>
			</tr>
			<tr>
				<td>
					<span>Password</span>
				</td>
				<td>
					<input type="password" name="password" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input name="loginButton" 
						type="submit" value="Login" />
				</td>
			</tr>
		</table>
	</form>
	<br>
	<div id="failDiv">
	</div>
	<br>
	
	<h2>First register if you still don't have an account.</h2>
	<a href="register.jsp">Register</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<%@ include file="header.jsp" %>
<br>
<% Integer fail = (Integer) request.getAttribute("fail");
Integer a=1;
  if (fail!=null && fail.equals(a)){ %>
<div class="navi">
<a href="about.jsp">About</a>
<a href="index.jsp">Home page</a>
<a href="register.jsp">Register</a>  
</div>
<br>
<br>
<H2>Registration failed</H2>
<br>
 The Username<p style="color:red"><%= request.getAttribute("username") %></p>is already taken. 
<% } else {  %>
<%@ include file="navi.jsp" %>
<br>
<br>
<H2>Registration successfull</H2>
<br>
<p>You are succesfully registered as Username:</p><%= request.getAttribute("username") %> 
<% } %> 

</body>
</html>
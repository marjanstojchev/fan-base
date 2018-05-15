
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.github.marjan87.fan_base.main.*, java.sql.*, java.io.OutputStream"  isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<%@ include file="meta.jsp"%>
</head>

<body>
	<%@ include file="header.jsp"%>
	<br>
	<%  try {
            if (request.getSession(false) == null) { %>
  	<h1>aidsajdak</h1>
           <% } else { %>
    
   <% if (session.getAttribute("username") == null || session.getAttribute("username").equals("")) { %>
    <%@ include file="navi.jsp" %> 
  <%} else { %>
     <%@ include file="loggedIn_navi.jsp" %>  
    <%
        }
            }
        } catch (Exception e) {
e.printStackTrace();
        }
    %>
<br>
<!-- <table> -->
	

<!--  <tr> -->
<%--     <td><%=rs.getString("Users.Username") %></td> --%>
<%--     <td><%=rs.getString("Images.Image_Name") %></td> --%>
    
<!-- </tr
> -->


<img src="http://localhost:8080/FanBase/Fanbase.do" alt="Smiley face" height="500" width=500">

<!-- </table> -->
</body>
</html>
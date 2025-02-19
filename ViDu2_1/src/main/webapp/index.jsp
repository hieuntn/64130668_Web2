<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
<center>
<h1> <b>Hello Ngoc Hieu</b></h1> 

<%= new Date().toString() %>
<%
int x;
x = 10;
int y = x + 10;
%>
<hr>
<%=y %>
<hr>
<%
out.print(y);
%>
</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 

String strA = request.getParameter("a");
int a = Integer.parseInt(strA);
String strB = request.getParameter("b");
int b = Integer.parseInt(strB);

out.print("Tổng của");
out.print(a);
out.print(" và ");
out.print(b);
out.print(" là ");
out.print(a+b);
%>
</body>
</html>
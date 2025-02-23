<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phép chia</title>
</head>
<body>
<% 

String strA = request.getParameter("a");
double a = Integer.parseInt(strA);
String strB = request.getParameter("b");
double b = Integer.parseInt(strB);

out.print("Thương của ");
out.print(a);
out.print(" và ");
out.print(b);
out.print(" là ");
out.print(String.format("%.2f", (a / b)));
%>
  
</body>
</html>
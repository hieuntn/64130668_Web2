<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%! int a = 20; int b;int c=0; %>
<% b=240;
 c = a+b;
	out.append("Kết quả là:");
	//out là đối tượng mặc định, luồng xuất kết quả cho client PrintWriter
	out.append(String.valueOf(c));
%>
<h2>Phương án khác: Xuất kiểu expression</h2>
<hr>
<%="Kết quả là:" %>
<%=c%>
</center>
</body>
</html>
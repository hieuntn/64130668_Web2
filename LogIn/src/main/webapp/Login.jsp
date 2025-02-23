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
String username = request.getParameter("username");
String password = request.getParameter("password");

// Kiểm tra thông tin đăng nhập
if (username != null && password != null) {
    if (username.equals("ABC") && password.equals("MNK")) {
        // Nếu đúng, chuyển đến trang UserProfile
        response.sendRedirect("UserProfile.html");
    } else {
        // Nếu sai, quay lại trang Login
        response.sendRedirect("login.html");
    }
}
%>
</body>
</html>
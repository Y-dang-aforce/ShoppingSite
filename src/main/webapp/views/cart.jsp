<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart</title>
</head>
<body>

<%
if (session == null || session.getAttribute("user") == null) {
    response.sendRedirect("login-in.jsp");
   
}
%>
<p>ここはカートです。</p>
<a href="userMenu.jsp">ホーム画面へ戻る</a>
</body>
</html>
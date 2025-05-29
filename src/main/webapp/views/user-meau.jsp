<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.beans.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録ホーム画面</title>
</head>
<body>
	<%
	User user = (User) session.getAttribute("user");
	if (user != null) {
	%>
	<p>
		ようこそ、<%=user.getFirstName()%> <%=user.getLastName()%>さん!
	</p>

	<%
	}
	%>
	
	<input type="submit" value="修正"><br>
	<input type="submit" value="削除"><br>
	<input type="submit" value="ログアウト">
</body>
</html>
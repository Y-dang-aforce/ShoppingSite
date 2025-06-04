<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.beans.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userEditConfirm</title>
</head>
<body>

<h1>登録する内容はよろしいですか?</h1>

<p>名前(姓)：<%= request.getParameter("lastName") %></p>
<p>名前(名)：<%= request.getParameter("firstName") %></p>
<p>住所：<%= request.getParameter("address") %></p>
<p>メールアドレス：<%= request.getParameter("mailAddress") %></p>

<%
  User user = (User)session.getAttribute("user");
%>

<form action="userEdit" method="post" style="display:inline;">
<input type="hidden" name="memberId" value="<%= user.getMemberId() %>">
<input type="hidden" name="password" value="<%= user.getPassword() %>">
<input type="hidden" name="lastName" value="<%= request.getParameter("lastName") %>">
<input type="hidden" name="firstName" value="<%= request.getParameter("firstName") %>">
<input type="hidden" name="address" value="<%= request.getParameter("address") %>">
<input type="hidden" name="mailAddress" value="<%= request.getParameter("mailAddress") %>">
<input type="submit" value="登録">
</form>

<form action="userEdit.jsp" method="post" style="display:inline;">
<input type="submit" value="もどる">
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.beans.userBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>修正登録完了</h1>
<%
  userBean user = (userBean)session.getAttribute("userBean");
%>
<p>更新された名前（姓）：<%= user.getLastName1() %></p>
<p>更新された名前（名）：<%= user.getFirstName1() %></p>
<p>更新された住所：<%= user.getAddress1() %></p>
<p>更新されたメール：<%= user.getMailAddress1() %></p>

<a href="userMenu.jsp">会員メニューへ戻る</a>
</body>
</html>
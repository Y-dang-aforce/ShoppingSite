<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.beans.User" %>

<%
    User user = (User)session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("loginIn.jsp"); 
        return;
    }
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserEdit</title>
</head>
<body>
<h1>会員情報編集画面</h1>
<form action="userEditConfirm.jsp" method="post">
<input type="hidden" name="memberId" value="<%= user.getMemberId() %>">
<input type="hidden" name="password" value="<%= user.getPassword() %>">
  
名前(姓)：
<input type="text" name="lastName"><br>
名前(名)：
<input type="text" name="firstName"><br>
住所：
<input type="text" name="address"><br>
メールアドレス：
<input type="email" name="mailAddress"><br>

<input type="submit" value="確認"><br>
</form>
<a href="userMenu.jsp">会員メニュー画面へ戻る</a>
</body>
</html>
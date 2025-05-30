<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.beans.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録ホーム画面</title>
<style>
  ul {
    list-style: none;         
    padding: 0;
    display: flex;            
    gap: 20px;               
  }

  li a {
    text-decoration: none;    
    color: pink;              
  }

  li a:hover {
    text-decoration: underline;  
  }
</style>

</head>
<body>
<nav>
	<ul>
		<li><a href="#商品情報">商品情報</a></li>
		<li><a href="cart.jsp">カート</a></li>
		<li><a href="#お気に入り">お気に入り</a></li>
		<li><a href="#注文履歴">注文履歴</a></li>
		<li><a href="#mypage">マイページ</a></li>
	</ul>	
	</nav>
 
	
	<input type="submit" value="修正"><br>
	<input type="submit" value="削除"><br>
	<form action="remove" method="get">
	<input type="submit" value="ログアウト">
	</form>
	
</body>
</html>
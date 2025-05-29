<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form</title>
</head>
<body>
<form action="login" method="post">
ID:
<input type="text" name="memberId">
パスワード:
<input type="password" name="password"><br>
<input type="submit" value="ログイン">
</form>

<form action="registration" method="get">
<input type="submit" value="新規会員登録">
</form>

</body>
</html>
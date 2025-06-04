<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<h1>新規会員登録</h1>
<form action="userAddConfirm.jsp" method="post" style="display:inline;">
ユーザーID:
<input type="text" name="memberId" pattern="[A-Za-z0-9]{1,255}" title＝"半角英数字を入力してください">半角英数字<br>
パスワード:
<input type="password" name="password" pattern="[A-Za-z0-9]{1,255}" title＝"半角英数字を入力してください">半角英数字<br>
名前(姓)：
<input type="text" name="lastName"><br>
名前(名)：
<input type="text" name="firstName"><br>
住所：
<input type="text" name="address"><br>
メールアドレス：
<input type="email" name="mailAddress"><br>

<input type="submit" value="確認">
</form>
<input type="submit" value="リセット"><br>

<a href="loginIn.jsp">ログイン画面へ戻る</a>
</form>

</body>
</html>
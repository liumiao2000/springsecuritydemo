<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>登陆</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	</head>
	<body>
		<div>
			<h2>登陆</h2>
			<form action="/mylogin/page" method="post">
				<input type="text" name="username" placeholder="请输入用户名"/>
				<input type="password" name="password" placeholder="请输入密码"/>
				<input type="submit" value="登陆"/>
			</form>
		</div>
	</body>
</html>
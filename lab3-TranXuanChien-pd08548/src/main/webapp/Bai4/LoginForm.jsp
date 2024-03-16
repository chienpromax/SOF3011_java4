<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Đăng nhập</h1>
	<mark>${message}</mark>
	<form action="LoginSeverlet" method="post">
		username: <input type="text" name="username" value="${username}"/> <br />
		password: <input type="text" name="password" value="${password}"/> <br />
		<input type="checkbox" name="remember" /> remember me?
		<hr />
		<button>Login</button>
	</form>
</body>
</html>
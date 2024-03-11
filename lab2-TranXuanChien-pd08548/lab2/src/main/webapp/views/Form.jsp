<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>TAM GIÁC</h1>
	<form action="TamGiacSeverlet" method="post">
		<input type="text" placeholder="Cạnh a" name="CanhA"><br>
		<input type="text" placeholder="Cạnh b" name="CanhB"><br>
		<input type="text" placeholder="Cạnh c" name="CanhC"><br>
		<hr>
		<button type="subbit" formaction="dien-tich">Tính diện tích</button>
		<button type="subbit" formaction="chu-vi">Tính chu vi</button>
	</form>
	<br>
	<h3>${message}</h3>
</body>
</html>
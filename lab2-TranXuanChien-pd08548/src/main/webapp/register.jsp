<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>custom regiter</h1>
	<hr>
	<form action="RegisterSeverlet" method="post">
		<input type="text" placeholder="name" name="name"> <br>
		<input type="text" placeholder="pass" name="pass"> <br>
		<input type="checkbox" name="favs" value="ms">music
		<input type="checkbox" name="favs" value="mv">movies
		<input type="checkbox" name="favs" value="sp">sport
		<br>
		<input type="submit" value="Register"> <br>
	</form>
	<h2>${message}</h2>
</body>
</html>
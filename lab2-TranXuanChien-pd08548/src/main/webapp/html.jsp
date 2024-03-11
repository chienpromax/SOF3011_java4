<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>post form</h2>
	<form action="hi" method="get">
		<input type="text" placeholder="Ten" name="name">
		<br>
		<input type="submit" name="submit" value="Send">
		<button>ok</button>
	</form>
	<h2>get form</h2>
	<form action="welcome" method="post">
		<input type="text" placeholder="Ten" name="name">
		<br>
		<input type="submit" name="submit" value="Send">
		<button>ok</button>
	</form>
</body>
</html>
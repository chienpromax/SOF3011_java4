<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chu vi dien tich hinh chu nhat</title>
</head>
<body>
	<form action="chuViDienTich" method="post">
		<label>Thông tin hình chữ nhật</label> <br> 
		<label>Chiều rộng</label> 
		<input type="text" name="numberA""> <br>
		<label>Chiều dài</label> <input type="text"name="numberB"> <br>
		<button type="submit" name="action">Tính</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Dang ki</title>
</head>

<body>
	<h1>Thông tin đã được đăng kí</h1>
	<ul>
		<li><img src="uploads/${staff.imageName }" class="img-fluid"
			width="400px" /></li>
		<li>Ten dang nhap: ${staff.username}</li>
		<li>Mat khau: ${staff.password}</li>
		<li>Gioi tinh: ${staff.gender ? 'Nam': 'Nu'}</li>
		<li>Lap gia dinh: ${staff.married ? '!FA': 'FA'}</li>
		<li>Quoc tich: ${staff.nationality}</li>
		<li>So thich: ${favorites}</li>
		<li>Ghi chu: ${staff.note}</li>
	</ul>
</body>
</html>
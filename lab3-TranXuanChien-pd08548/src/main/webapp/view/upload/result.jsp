<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Upload</title>
</head>
<body>
	<ul>
		<li>Hình ảnh:${image}<br />
			<img src="uploads/${image}" height="400px">
		</li>
		<li>Tài liệu:${document}<br />
			<a href="uploads/${document}">Kíck vào đây để tải về</a>
		</li>
	</ul>
</body>
</html>
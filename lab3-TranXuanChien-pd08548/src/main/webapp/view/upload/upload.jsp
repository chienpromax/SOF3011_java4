<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Upload</title>
</head>
<body>
	<h2>Upload Image and document</h2>
	<form action="/Lab3/upload" enctype="multipart/form-data" method="post">
		<label for="image" >Image</label>
		<input type="file" id="image" name="image" /><br>
		<label for="document">Document</label>
		<input type="file" id="document" name="document" />
		<hr />
		<button>Upload</button>
	</form>

</body>
</html>
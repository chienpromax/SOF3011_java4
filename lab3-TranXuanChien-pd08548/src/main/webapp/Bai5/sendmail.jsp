<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
</head>
<title>Email</title>
</head>

<body>
	<h2>Gửi mailL</h2>
	<form action="SenMailServelet" method="post">
		<div>
			<label>To:</label> <input type="text" name="to" placeholder="Enter Email">
		</div>
		<div>
			<label>Tiêu đề :</label> <input type="text" name="subject" placeholder="Enter Subject">
		</div>
		<div>
			<label for="content">Nội dung:</label>
			<textarea rows="3" name="content"></textarea>
		</div>
		<button type="submit">Send</button>
		<button type="reset">Cancel</button>
	</form>
	<br>
	<h2>${message}</h2>
</body>

</html>
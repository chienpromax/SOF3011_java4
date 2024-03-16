<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Đăng ký</h1>
	<form action="Staff" method="post">
		<input type="text" name="name" placeholder="Tên đăng nhập"> <br>
		Ngày sinh <br>
		<input type="text" name="birthday"> <br>
		<label for="">Giới tính</label>
		<input type="radio" name="gender" value="true"> nam
		<input type="radio" name="gender" value="false"> nữ <br>
		<input type="checkbox" name="married">Đã có gia đình?<br>
		quốc tịch: 
		<select name="country">
			<option value="MĨ">mĩ</option>
			<option value="anh">anh</option>
			<option value="pháp">pháp</option>
		</select> <br>
		<!-- bài 3 -->
        sở thích
        <input type="checkbox" name="hobbies" value="R">đọc sách
		<input type="checkbox" name="hobbies" value="T">du lịch
		<input type="checkbox" name="hobbies" value="M">âm nhạc
		<input type="checkbox" name="hobbies" value="O">khác <br>


		ghi chú
		<textarea name="notes" id="" cols="30" rows="10"></textarea>
		<hr>
		<button>Đăng kí</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Dang ki</title>
</head>

<body>
	<h1>Đăng kí</h1>
	<form action="staff" method="post" enctype="multipart/form-data">
		<label for="username">Tên đăng nhập:</label>
		<input type="text" name="username" /> <br>
		<label for="password">Mat khau:</label>
		<input type="password" name="password" /> <br>
		<label for="date">Ngay sinh:</label>
		<input type="date" name="date" /> <br>
		<label for="image">Hinh</label>
		<input type="file" name="image" /> <br>
		<label for="genderM">Gioi tinh:</label>
		<input type="radio" name="gender" value="true" />
		<label for="genderM">Nam</label>
		<input type="radio" name="gender" value="false" />
		<label for="genderF">Nu</label> <br>
		<input type="checkbox" name="married" value="true" />
		<label for="married">Ban con co don</label> <br>
		<label for="nationality">Quoc tich:</label> 
		<select name="nationality">
			<option value="vi">Viet Nam</option>
			<option value="us">My</option>
			<option value="jp">Nhat ban</option>
		</select><br>
		<label for="favorites">So thich:</label>
		<input type="checkbox" name="favorites" value="Read" />
		<label for="read">Doc sach</label>
		<input type="checkbox" name="favorites" value="Music" />
		<label for="music">Am nhac</label>
		<input type="checkbox" name="favorites" value="Tour" />
		<label for="tour">Du lich</label>
		<input type="checkbox" name="favorites" value="others" />
		<label for="others">Khac</label> <br>
		<label for="note">Ghi chu</label>
		<textarea name="note" rows="3"></textarea>
		<br>
		<button type="submit">Dang ki</button>
	</form>
</body>

</html>
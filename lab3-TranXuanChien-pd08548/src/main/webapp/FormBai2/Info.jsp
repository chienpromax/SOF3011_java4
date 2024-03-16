<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>thông tin đăng kí</h1>
        <p>
        tên đăng nhập: <h4>${bean.name}</h4> <br>
		Ngày sinh: <h4>${bean.birthday}</h4> <br>
		giới tính: <h4>${bean.gender}</h4> <br>
		trạng thái hôn nhân: <h4>${bean.married}</h4> <br>
		quốc tịch: <h4>${bean.country}</h4> <br>
		sở thích: <h4>${bean.hobbies}</h4><br>
		ghi chú: <h4>${bean.notes}</h4>
        </p>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<base href="/Lab7/">
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.user}">
        Welcome you
    </c:when>
		<c:otherwise>
        Welcome ${sessionScope.user.fullname}
        <a href="/fpoly/account/sign-out">Đăng xuất</a>
			<c:choose>
				<c:when test="${not empty sessionScope.user.admin}">
					<a href="/fpoly/admin/home/index">Quản trị</a>
				</c:when>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<p>${message}</p>
</body>
</html>

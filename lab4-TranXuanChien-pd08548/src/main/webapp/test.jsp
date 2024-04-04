<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num" value="20"></c:set>
	<c:if test="${num%2==0}">
		<h2>${num}iseven</h2>
	</c:if>

	<c:if test="${num%2!=0}">
		<h2>${num}isodd</h2>
	</c:if>

	<c:set var="num" value="20" />
	<c:choose>
		<c:when test="${num % 2 == 0}">
			<h2>${num}iseven</h2>
		</c:when>
		<c:otherwise>
			<h2>${num}isodd</h2>
		</c:otherwise>
	</c:choose>



	<h1>${param.user}</h1>
</body>
</html>
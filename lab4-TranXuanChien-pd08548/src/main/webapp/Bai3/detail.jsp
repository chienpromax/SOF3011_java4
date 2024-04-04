<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
</head>

<body>
<div class="container">
    <div class="row mt-4 m-2">
        <div class="card col-sm-4 bg-light mb-2 text-center">
            <img class="card-img-top mt-2" src="img/${itemImage}" />
            <p>Tên sản phẩm: ${param.itemName} </p>
            <p>Giá gốc:<strike>${param.itemPrice}</strike> Giá mới: ${param.itemPrice * (1 - param.itemDiscount)} </p>
            <p>Mức giá:
                <c:choose>
                    <c:when test="${param.itemPrice * (1 - param.itemDiscount) < 10}">Giá thấp</c:when>
                    <c:when test="${param.itemPrice * (1 - param.itemDiscount) > 500}">Giá cao</c:when>
                    <c:otherwise>Bình thường</c:otherwise>
                </c:choose>
            </p>
            <p>Ngày thêm: ${item.date} </p>
        </div>
    </div>
</div>


	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>

</html>
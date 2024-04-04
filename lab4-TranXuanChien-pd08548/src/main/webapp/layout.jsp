<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Bai1</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/style.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<body>
	<div class="container">
		<%@include file="Bai1/header.jsp"%>
		<%@include file="Bai1/menu.jsp"%>
		<div class="row">
			<article class="col-sm-9">
				<div class="row mt-2" style="margin-left: 1px">
					<div class="card col-sm-4 bg-light mb-2 text-center">
						<jsp:include page="Bai1/item.jsp">
							<jsp:param name="name" value="Iphone 12" />
							<jsp:param name="image" value="hong.png" />
						</jsp:include>
					</div>
					<div class="card col-sm-4 bg-light mb-2 text-center">
						<jsp:include page="Bai1/item.jsp">
							<jsp:param name="name" value="Ipad mini" />
							<jsp:param name="image" value="samsung.jfif" />
						</jsp:include>
					</div>
					<div class="card col-sm-4 bg-light mb-2 text-center">
						<jsp:include page="Bai1/item.jsp">
							<jsp:param name="name" value="Iphone 13" />
							<jsp:param name="image" value="xam.jfif" />
						</jsp:include>
					</div>
				</div>
				<div class="row mt-2" style="margin-left: 1px">
					<div class="card col-sm-4 bg-light mb-2 text-center">
						<jsp:include page="Bai1/item.jsp">
							<jsp:param name="name" value="Iphone 12 pro" />
							<jsp:param name="image" value="xanh.jfif" />
						</jsp:include>
					</div>
					<div class="card col-sm-4 bg-light mb-2 text-center">
						<jsp:include page="Bai1/item.jsp">
							<jsp:param name="name" value="dell g15" />
							<jsp:param name="image" value="dell.jfif" />
						</jsp:include>
					</div>
					<div class="card col-sm-4 bg-light mb-2 text-center">
						<jsp:include page="Bai1/item.jsp">
							<jsp:param name="name" value="dell g15" />
							<jsp:param name="image" value="dell.jfif" />
						</jsp:include>
					</div>
				</div>
			</article>
			<aside class="col-sm-3">
				<%@include file="Bai1/login.jsp"%>
				<%@include file="Bai1/category.jsp"%>
			</aside>
		</div>
		<%@include file="Bai1/footer.jsp"%>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
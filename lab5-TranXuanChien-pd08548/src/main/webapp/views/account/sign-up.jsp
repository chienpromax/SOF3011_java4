<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
	<title>Title</title>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<base href="/Lab5/">
	<!-- CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
</head>

<body>
	<div class="container">
		<div class="signup-form">
			<h2 class="form-title">Sign up</h2>
			<form class="account/sign-up" method="POST">
				<div class="form-group">
					<label class="form-label">User ID</label>
					<input  class="form-control mt-2" type="text" name="userId" placeholder="Username" />
				</div>
				<div class="form-group">
					<label class="form-label">Password</label>
					<input  class="form-control mt-2" type="password" name="password" placeholder="Password" />
				</div>
				<div class="form-group">
					<label class="form-label">Fullname</label>
					<input  class="form-control mt-2" type="text" name="fullname" placeholder="Fullname" />
				</div>
				<div class="form-group">
					<label class="form-label">Email</label>
					<input  class="form-control mt-2" type="email" name="email" placeholder="Your Email" />
				</div>
				<div class="form-check form-check-inline">
					<label class="ml-2">
						<input  class="form-control mt-2" class="form-check-input" name="admin" value="false" type="hidden" /></label>
				</div>
				<c:if test="${not empty message}">
					<div class="alert">${message}</div>
				</c:if>
				<c:if test="${not empty error}">
					<div class="alert">${error}</div>
				</c:if>
				<div class="form-group form-button">
					<input type="submit" class="btn btn-primary" value="Đăng ký" formaction="account/sign-up" />
				</div>
			</form>
		</div>
		<div class="signup-image">
			<a href="account/sign-in" class="signup-image-link">nhớ tì khoản</a>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
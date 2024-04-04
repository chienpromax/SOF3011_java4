<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">

<head>
    <title>${page.title}</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<base href="/assiment-java4/" />
    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
        integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
    <div class="container">
        <div class="row pt-3 pb-2">
            <div class="col-9">
                <h1>video online</h1>
            </div>
            <div class="col-3 text-right">
                <img src="/images/logo.png" alt="">
            </div>
        </div>
        <div class="row">
            <nav class="navbar navbar-expand-sm navbar-light bg-light">
                <div class="container">
                    <a class="navbar-brand" href="Homepage">OnEn</a>
                    <button class="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                        aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavId">
                        <ul class="navbar-nav me-auto mt-2 mt-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" href="Homepage" aria-current="page">Home
                                    <span class="visually-hidden">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Homepage">About us</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Homepage">Contact us</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Homepage">my favorites</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-bs-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">my account</a>
                                <div class="dropdown-menu" aria-labelledby="dropdownId">
                                	<c:if test="${ ! islogin}">
                                    	<a class="dropdown-item" href="login">Login</a>
                                    	<a class="dropdown-item" href="ForgotPassword">Forgot Password</a>
                                   		<a class="dropdown-item" href="registration">Registration</a>                                
                                	</c:if>
                                	<c:if test="${islogin}">
                                    	<a class="dropdown-item" href="Logoff">Logoff</a>
                                    	<a class="dropdown-item" href="ChangePassword">Change Password</a>
                                    	<a class="dropdown-item" href="EditProfile">Edit Profile</a>
                                  	</c:if>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <section class="row">
            <jsp:include page="${page.contentUrl}"></jsp:include>
        </section>
        <footer class="row">
            <div class="col text-center boder-top">
                <Strong>FPT poly 2024. all rights reserved.</Strong>
            </div>
        </footer>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
        
    <c:if test="${not empty page.scriptUrl}">
		<jsp:include page="${page.scriptUrl}"></jsp:include>
	</c:if>
</body>

</html>
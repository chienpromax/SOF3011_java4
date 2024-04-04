<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-3 col-6 pt-5">
	<form action="" method="POST">
	    <h2 class="text-center text-primary">Đăng nhập</h2>
	    <jsp:include page="/common/inform.jsp"></jsp:include>
		<div class="mb-3">
			<label for="" class="form-label">Username</label> <input type="text"
				class="form-control" name="username" id="" aria-describedby="helpId"
				placeholder="" />
		</div>
		<div class="mb-3">
			<label for="" class="form-label">Password</label> <input type="text"
				class="form-control" name="password" id="" aria-describedby="helpId"
				placeholder="" />
		</div>
		<hr>
		<div class="mb-3">
			<input type="checkbox" class="form-check-input" name="remember" id=""
				aria-describedby="helpId" placeholder="" /> <label for=""
				class="form-label">Remeber Me</label>
		</div>
		<div class="mb-3  text-center">
			<button class="btn btn-primary">Login</button>
		</div>
	</form>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-3 col-6 pt-5">
	<form action="" method="POST">
	    <jsp:include page="/common/inform.jsp"></jsp:include>
		<h2 class="text-center p-2 text-primary">Quên mật khẩu</h2>
		<div class="mb-3">
			<label for="" class="form-label">Username</label> <input type="text"
				class="form-control" name="username" placeholder="" />
		</div>
		<div class="mb-3">
			<label for="" class="form-label">Email</label> <input type="text"
				class="form-control" name="email" placeholder="" />
		</div>
		<hr>
		<div class="mb-3  text-center">
			<button class="btn btn-primary">Xác nhận</button>
		</div>
	</form>
</div>
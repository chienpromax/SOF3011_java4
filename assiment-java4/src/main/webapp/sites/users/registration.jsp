<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-3 col-6 pt-5">
	<form action="" method="POST">
		<h2 class="text-center text-primary">Đăng ký</h2>
		<jsp:include page="/common/inform.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-6">
				<div class="mb-3">
					<label for="" class="form-label">Username</label> <input
						type="text" class="form-control" name="username" id=""
						value="${user.username }" />
				</div>
				<div class="mb-3">
					<label for="" class="form-label">Password</label> <input
						type="text" class="form-control" name="password" id="" "/>
				</div>
			</div>
			<div class="col-md-6">
				<div class="mb-3">
					<label for="" class="form-label">Full name</label> <input
						type="text" class="form-control" name="fullname" id=""
						value="${user.fullname }" />
				</div>
				<div class="mb-3">
					<label for="" class="form-label">Email</label> <input type="text"
						class="form-control" name="email" id="" value="${user.email }" />
				</div>
			</div>
			<hr>
			<div class="mb-3  text-center">
				<button class="btn btn-primary">Đăng ký</button>
			</div>
		</div>
	</form>
</div>
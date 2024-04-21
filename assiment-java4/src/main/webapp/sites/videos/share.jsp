<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-3 col-6 pt-5">
	<form action="ShareVideo" method="POST">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<input type="hidden" name=videoId value="${videoId}" />
		<h2 class="text-center text-primary">Chia sẻ</h2>
		<div class="mb-3">
			<label for="" class="form-label">Nhập Email</label> <input
				type="text" class="form-control" name="email" id="email" placeholder="" />
		</div>
		<hr>
		<div class="mb-3  text-center">
			<button class="btn btn-primary">Share</button>
		</div>
	</form>
</div>
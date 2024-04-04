<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-3 col-6 pt-5">
    <form action="ChangePassword" method="POST">
        <h2 class="text-center p-2 text-primary">Đổi mật khẩu</h2>
        <jsp:include page="/common/inform.jsp"></jsp:include>
        <div class="mb-3">
            <label for="" class="form-label">Username</label> <input type="text"
                class="form-control" name="username" value="${username}"/>
        </div>
        <div class="mb-3">
            <label for="" class="form-label">Password</label> <input type="text"
                class="form-control" name="currentPassword" />
        </div>
        <div class="mb-3">
            <label for="" class="form-label">New Password</label> <input
                type="text" class="form-control" name="password" />
        </div>
        <div class="mb-3">
            <label for="" class="form-label">Confirm password</label> <input
                type="text" class="form-control" name="confirmPassword" />
        </div>
        <hr>
        <div class="mb-3  text-center">
            <button class="btn btn-primary">Xác nhận</button>
        </div>
    </form>
</div>

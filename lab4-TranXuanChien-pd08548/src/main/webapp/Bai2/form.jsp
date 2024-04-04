<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="/Userseverlet" method="post" class="row g-3 needs-validation">
    <div class="col-md-6">
        <label class="form-label">Username</label>
        <input type="text" name="username" class="form-control" value="${USER.username}">
    </div>
    <div class="col-md-6">
        <label class="form-label">Password</label>
        <input type="text" name="password" class="form-control" value="${USER.password}">
    </div>
    <div class="col-12">
        <div class="form-check">
            <input class="form-check-input" name="remember" type="checkbox" ${USER.remeber ? 'checked' : ''}>
            <label class="form-check-label" for="invalidCheck"> Remember Me? </label>
        </div>
    </div>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Create</button>
    </div>
</form>



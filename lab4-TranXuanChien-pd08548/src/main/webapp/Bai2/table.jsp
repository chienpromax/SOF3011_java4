<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="table-responsive-md">
    <h3>User list</h3>
    <table class="table table-warning table-bordered">
        <thead>
            <tr class="table-info">
                <th scope="col">Username</th>
                <th scope="col">Password</th>
                <th scope="col">Remember?</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${LIST_USER}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.remeber ? "Yes" : "No"}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


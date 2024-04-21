<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item" role="presentation">
		<button class="nav-link active" id="videoEditing-tab"
			data-bs-toggle="tab" data-bs-target="#videoEditing" type="button"
			role="tab" aria-controls="videoEditing" aria-selected="true">User
			Editing</button>
	</li>
	<li class="nav-item" role="presentation">
		<button class="nav-link" id="videoList-tab" data-bs-toggle="tab"
			data-bs-target="#videoList" type="button" role="tab"
			aria-controls="videoList" aria-selected="false">User list</button>
	</li>
</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="videoEditing"
		role="tabpanel" aria-labelledby="videoEditing-tab">
		<form action="" method="post">
			<div class="card">
				<div class="card-body">
					<div class="row ">
						<div class="col">
							<div class="mb-3">
								<label for="fullname" class="form-label">User name</label> <input
									type="text" class="form-control" name="username" id="username"
									aria-describedby="usernamehelp" placeholder="Nhập Tên"
									value="${user.username}" />
							</div>
							<div class="mb-3">
								<label for="fullname" class="form-label">Full name</label> <input
									type="text" class="form-control" name="fullname" id="fullname"
									aria-describedby="fullnamehelp" placeholder="Nhập Tên đầy đủ"
									value="${user.fullname}" />
							</div>
						</div>
						<div class="col">
							<div class="mb-3">
								<label for="password" class="form-label">Password</label> <input
									type="text" class="form-control" name="password" id="password"
									aria-describedby="passwordhelp" placeholder="Nhập mât khẩu"
									value="${user.password}" />
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email</label> <input
									type="text" class="form-control" name="email" id="email"
									aria-describedby="emailhelp" placeholder="Nhập Email"
									value="${user.email}" />
							</div>
						</div>
						<div class="form-group">
							<label for="role">Role</label>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="admin"
									id="admin" value="true"
									<c:if test="${user.admin}">checked</c:if>> <label
									class="form-check-label" for="admin">Admin</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="user"
									id="user" value="true"
									<c:if test="${!user.admin}">checked</c:if>> <label
									class="form-check-label" for="user">User</label>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="card-footer text-muted text-center">
					<button class="btn btn-primary"
						formaction="Admin/UsersManagement/create">Create</button>
					<button class="btn btn-primary"
						formaction="Admin/UsersManagement/update">Update</button>
					<button class="btn btn-primary"
						formaction="Admin/UsersManagement/delete">Delete</button>
					<button class="btn btn-primary"
						formaction="Admin/UsersManagement/reset">Reset</button>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade" id="videoList" role="tabpanel"
		aria-labelledby="videoList-tab">
		<table class="table table-stripe">
			<thead>
				<tr>
					<th>Username</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Role</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${users}">
				<tr>
					<td>${item.username}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>${item.admin ? 'Admin' : 'User'}</td>
					<td><a
						href="Admin/UsersManagement/edit?username=${item.username}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
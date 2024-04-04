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
									aria-describedby="usernamehelp" placeholder="Nhập Tên" /> <small
									id="usernamehelp" class="form-text text-muted">username
									is required</small>
							</div>
							<div class="mb-3">
								<label for="fullname" class="form-label">Full name</label> <input
									type="text" class="form-control" name="fullname" id="fullname"
									aria-describedby="fullnamehelp" placeholder="Nhập Tên đầy đủ" />
								<small id="fullnamehelp" class="form-text text-muted">fullname
									is required</small>
							</div>
						</div>
						<div class="col">
							<div class="mb-3">
								<label for="password" class="form-label">Password</label> <input
									type="text" class="form-control" name="password" id="password"
									aria-describedby="passwordhelp" placeholder="Nhập mât khẩu" />
								<small id="passwordhelp" class="form-text text-muted">password
									is required</small>
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email</label> <input
									type="text" class="form-control" name="email" id="email"
									aria-describedby="emailhelp" placeholder="Nhập Email" /> <small
									id="emailhelp" class="form-text text-muted">email is
									required</small>
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted text-center">
					<button class="btn btn-primary">Create</button>
					<button class="btn btn-primary">Update</button>
					<button class="btn btn-primary">Delete</button>
					<button class="btn btn-primary">Reset</button>
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
					<th>Password</th>
					<th>Email</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Chien123</td>
					<td>Chiến tx</td>
					<td>123123</td>
					<td>Chien@gmail.com</td>
					<td><a href="#"><i class="fa-solid fa-pen-to-square"
							aria-hidden="false"></i> Sửa</a> <a href="#"><i
							class="fa-solid fa-trash" aria-hidden="true"></i></i> Xóa</a></td>
				</tr>
				<tr>
					<td>Chien</td>
					<td>Chiến123</td>
					<td>123123123</td>
					<td>Chie123n@gmail.com</td>
					<td><a href="#"><i class="fa-solid fa-pen-to-square"
							aria-hidden="false"></i> Sửa</a> <a href="#"><i
							class="fa-solid fa-trash" aria-hidden="true"></i></i> Xóa</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
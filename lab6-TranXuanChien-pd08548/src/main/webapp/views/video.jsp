<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>

<body>
	<div class="container col-7 pt-2">
		<div class="border rounded bg-light pl-4 pr-4 p-3">
			<div class="row p-2 pl-3 pt-3 text-black text-center">
				<h2>Lab6</h2>
			</div>
			<div class="row p-2">
				<div class="col">
					<c:if test="${not empty message}">
						<div class="alert alert-success">${message}</div>
					</c:if>
					<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<form action="video" method="post">
						<div class="form-group pt-2">
							<label class="form-label">Nhập từ khóa:</label> <input
								type="text" name="search" placeholder="" class="form-control" />
						</div>
						<div class="form-group pt-2 text-center">
							<button class=" m-2 btn btn-primary" formaction="cau1">Tìm
								theo mã người dùng</button>
							<button class=" m-2 btn btn-primary" formaction="cau2">Tìm
								theo title</button>
							<button class=" m-2 btn btn-primary" formaction="cau3">Tìm
								theo mã video</button>
							<button class=" m-2 btn btn-primary" formaction="cau5">Lượt
								thích video</button>
							<button class=" m-2 btn btn-primary" formaction="cau8">Video
								đã thích theo title</button>
							<button class=" m-2 btn btn-primary" formaction="cau9">Video
								đã thích theo người dùng</button>
						</div>
						<hr>
						<div class="form-group pt-2">
							<input type="radio" name="favorite" value="true" checked>
							yêu thích&nbsp;&nbsp;&nbsp; <input type="radio" name="favorite"
								value="false"> không yêu thích &nbsp;&nbsp;
							<button class="btn btn-primary" formaction="cau4">Search</button>
						</div>
						<hr>
						<div class="form-group pt-2">
							<div class="row d-flex alight-item-center">
								<div class="col-3">
									<input type="date" name="mindate" class="form-control"
										placeholder="Min Date" />
								</div>
								<div class="col-3">
									<input type="date" name="maxdate" class="form-control"
										placeholder="Max Date" />
								</div>
								<button class="btn btn-primary mt-3" formaction="cau6">Search</button>
							</div>
						</div>
						<hr>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month1"
								name="months" value="1"> <label class="form-check-label"
								for="month1">1</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month2"
								name="months" value="2"> <label class="form-check-label"
								for="month2">2</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month3"
								name="months" value="3"> <label class="form-check-label"
								for="month3">3</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month4"
								name="months" value="4"> <label class="form-check-label"
								for="month4">4</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month5"
								name="months" value="5"> <label class="form-check-label"
								for="month5">5</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month6"
								name="months" value="6"> <label class="form-check-label"
								for="month6">6</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month7"
								name="months" value="7"> <label class="form-check-label"
								for="month7">7</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month8"
								name="months" value="8"> <label class="form-check-label"
								for="month8">8</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month9"
								name="months" value="9"> <label class="form-check-label"
								for="month9">9</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month10"
								name="months" value="10"> <label
								class="form-check-label" for="month10">10</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month11"
								name="months" value="11"> <label
								class="form-check-label" for="month11">11</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="month12"
								name="months" value="12"> <label
								class="form-check-label" for="month12">12</label>
						</div>
						<button class="btn btn-primary" formaction="cau7">Search</button>
						<hr>
						<div class="row">
							<div class="col-2">
								<button class="btn btn-primary" formaction="bai4">Random
									2</button>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="mb-3">
								<label for="inputYear" class="form-label">Nhập năm</label> <input
									type="number" class="form-control" name="year" id="inputYear" />
								<button class="btn btn-primary" formaction="bai4C2">Tìm</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<hr>
		<c:if test="${not empty video}">
			<div class="row pt-0 pl-3 pr-3">
				<ul class="list-group pb-2">
					<li class="list-group-item">Fullname: ${user.fullname}</li>
					<li class="list-group-item">Email: ${user.email}</li>
				</ul>
				<table class="table border border-dark">
					<thead class="thead-dark font-weight-bold table-primary text-white">
						<tr>
							<td>ID</td>
							<td>Title</td>
							<td>Views</td>
							<td>Active</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${video}">
							<tr>
								<th>${item.id}</th>
								<th>${item.title}</th>
								<th>${item.views}</th>
								<th>${item.active}</th>
							</tr>
						</c:forEach>
					<tbody>
				</table>
			</div>
		</c:if>

		<c:if test="${not empty months}">
			<div class="row pt-0 pl-3 pr-3">
				<table class="table border border-dark">
					<thead class="thead-dark font-weight-bold table-primary text-white">
						<tr>
							<td>ID</td>
							<td>Title</td>
							<td>Views</td>
							<td>Active</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${months}">
							<tr>
								<td>${item.id}</td>
								<td>${item.title}</td>
								<td>${item.views}</td>
								<td>${item.active}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>

		<c:if test="${not empty videos}">
			<div class="row pt-0 pl-3 pr-3">
				<table class="table border border-danger">
					<thead class="thead-dark font-weight-bold table-primary text-white">
						<tr>
							<td>ID</td>
							<td>Fullname</td>
							<td>Email</td>
							<td>Admin</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${videos}">
							<tr>
								<th>${item.id}</th>
								<th>${item.fullname}</th>
								<th>${item.email}</th>
								<th>${item.admin ? 'Admin' : 'User'}</th>
							</tr>
						</c:forEach>
					<tbody>
				</table>
			</div>
		</c:if>

		<c:if test="${not empty videoss}">
			<div class="row pt-0 pl-3 pr-3">
				<table class="table border border-danger">
					<thead class="thead-dark font-weight-bold table-primary text-white">
						<tr>
							<td>ID</td>
							<td>Fullname</td>
							<td>Email</td>
							<td>Admin</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${videoss}">
							<tr>
								<th>${item.id}</th>
								<th>${item.fullname}</th>
								<th>${item.email}</th>
								<th>${item.admin ? 'Admin' : 'User'}</th>
							</tr>
						</c:forEach>
					<tbody>
				</table>
			</div>
		</c:if>
		<c:if test="${not empty report}">
			<div class="row pt-0 pl-3 pr-3">
				<table class="table border border-dark">
					<thead class="thead-dark font-weight-bold table-primary text-white">
						<tr>
							<td>Title</td>
							<td>Likes</td>
							<td>Newest</td>
							<td>Oldest</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${report}">
							<tr>
								<th>${item.group}</th>
								<th>${item.likes}</th>
								<th>${item.newest}</th>
								<th>${item.oldest}</th>
							</tr>
						</c:forEach>
					<tbody>
				</table>
			</div>
		</c:if>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>

</html>
</html>
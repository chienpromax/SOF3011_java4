<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item" role="presentation">
		<button class="nav-link active" id="videoEditing-tab"
			data-bs-toggle="tab" data-bs-target="#videoEditing" type="button"
			role="tab" aria-controls="videoEditing" aria-selected="true">Video
			Editing</button>
	</li>
	<li class="nav-item" role="presentation">
		<button class="nav-link" id="videoList-tab" data-bs-toggle="tab"
			data-bs-target="#videoList" type="button" role="tab"
			aria-controls="videoList" aria-selected="false">Video list</button>
	</li>
</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="videoEditing"
		role="tabpanel" aria-labelledby="videoEditing-tab">
		<form action="" method="post" enctype="multipart/form-data">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-3">
							<div class="border border-primary p-3">
								<img src="${video.poster != null?video.poster: 'images/click.png' }" alt="" class="img-fluid">
								<div class="input-group mb-3">
									<input type="file" class="form-control" id="cover" name="cover">
									<label class="input-group-text" for="inputGroupFile02">Upload</label>
								</div>
							</div>
						</div>
						<div class="col-9">
							<div class="mb-3">
								<label for="Youtubeid" class="form-label">Youtubeid</label> <input
									type="text" class="form-control" name="videoid" id="Youtubeid"
									placeholder="Youtube ID"
									value="${not empty requestScope.video ? requestScope.video.videoid : ''}" />
							</div>
							<div class="mb-3">
								<label for="youtubetitle" class="form-label">Video title</label>
								<input type="text" class="form-control" name="title"
									id="youtubetitle" placeholder="Youtube Title"
									value="${not empty requestScope.video ? requestScope.video.title : ''}" />
							</div>
							<div class="mb-3">
								<label for="viewcount" class="form-label">View Count</label> <input
									type="text" class="form-control" name="views" id="viewcount"
									placeholder="View Count"
									value="${not empty requestScope.video ? requestScope.video.views : ''}" />
							</div>
							<div class="form-check form-check-inline">
								<label style="margin-right: 35px;"> <input type="radio"
									class="form-check-input" value="true" name="active" id="status"
									${not empty requestScope.video && requestScope.video.active ? 'checked' : ''}>
									Active
								</label> <label> <input type="radio" class="form-check-input"
									value="false" name="active" id="status"
									${not empty requestScope.video && !requestScope.video.active ? 'checked' : ''}>
									Inactive
								</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="description">Description</label>
							<textarea name="description" id="description" cols="20" rows="5"
								class="form-control">${not empty requestScope.video ? requestScope.video.description : ''}</textarea>
						</div>
					</div>
					
				</div>
				<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="card-footer text-muted text-center">
					<button class="btn btn-primary"
						formaction="Admin/VideoManagement/create">Create</button>
					<button class="btn btn-primary"
						formaction="Admin/VideoManagement/update">Update</button>
					<button class="btn btn-primary"
						formaction="Admin/VideoManagement/delete">Delete</button>
					<button class="btn btn-primary"
						formaction="Admin/VideoManagement/reset">Reset</button>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade" id="videoList" role="tabpanel"
		aria-labelledby="videoList-tab">
		<table class="table table-stripe">
			<thead>
				<tr>
					<th>Youtube ID</th>
					<th>Video Title</th>
					<th>View Count</th>
					<th>Status</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
				<c:forEach var="item" items="${videos}">
					<tr>
						<td>${item.videoid}</td>
						<td>${item.title}</td>
						<td>${item.views}</td>
						<td>${item.active? 'Active': 'Deactive'}</td>
						<td><a href="admin/edit?videoId=${item.videoid}">Edit</a>
							<a href="admin/delete?videoId=${item.videoid}">Delete</a></td>
					</tr>
				</c:forEach>
		</table>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item" role="presentation">
		<button class="nav-link active" id="favorite-tab" data-bs-toggle="tab"
			data-bs-target="#favorite" type="button" role="tab"
			aria-controls="favorite" aria-selected="true">favorite</button>
	</li>
	<li class="nav-item" role="presentation">
		<button class="nav-link" id="favoriteuser-tab" data-bs-toggle="tab"
			data-bs-target="#favoriteuser" type="button" role="tab"
			aria-controls="favoriteuser" aria-selected="false">favorite
			user</button>
	</li>
	<li class="nav-item" role="presentation">
		<button class="nav-link" id="shareriends-tab" data-bs-toggle="tab"
			data-bs-target="#shareriends" type="button" role="tab"
			aria-controls="shareriends" aria-selected="false">Share
			friend</button>
	</li>
</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="favorite" role="tabpanel"
		aria-labelledby="favorite-tab">
		<div class="table-responsive table-bordered mt-3">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Video title</th>
						<th>Favorite count</th>
						<th>Lasted Date</th>
						<th>Oldest Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${favList}">
						<tr>
							<td>${item.videoTitle }</td>
							<td>${item.favoriteCount }</td>
							<td>${item.newestDate }</td>
							<td>${item.oldestDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="tab-pane fade" id="favoriteuser" role="tabpanel"
		aria-labelledby="favoriteuser-tab">
		<form method="get">
			<div class="row mt3">
				<div class="col">
					<div class="form-group mb-3">
						<label for="" class="form-control">Video Title <select
							name="videoUserId" id="videoUserId" class="form-control m-3">
								<!-- <c:forEach var="item" items="${vidList}">
									<option value="${item.videoid}"
										${item.videoid == videoUserId ? 'selected' : ''}>${item.videoid}</option> 
										</c:forEach> -->
								<c:forEach var="item" items="${vidList}">
									<option value="${item.videoid}"
										${item.videoid == videoUserId ? 'selected' : ''}>${item.title}</option>
								</c:forEach>

						</select>
						</label>
						<button class="btn btn-primary">Report</button>
					</div>
					<div class="row">
						<div class="col mt-3">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Username</th>
											<th>Full name</th>
											<th>Email</th>
											<th>Favorite Date</th>
										</tr>
									</thead>
									<c:forEach var="item" items="${favUsers}">
										<tr>
											<td>${item.username }</td>
											<td>${item.fullname }</td>
											<td>${item.email }</td>
											<td>${item.likeDate}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade" id="shareriends" role="tabpanel"
		aria-labelledby="shareriends-tab">
		<form method="get">
			<div class="row mt3">
				<div class="col">
					<div class="form-group mb-3">
						<label for="" class="form-control">Video Title <select
							name="videoUserId" id="videoUserId" class="form-control m-3">
								<c:forEach var="item" items="${vidList}">
									<option value="${item.videoid}"
										${item.videoid == videoUserId ? 'selected' : ''}>${item.videoid}</option>
								</c:forEach>
						</select>
						</label>
						<button class="btn btn-primary">Report</button>
					</div>
					<div class="row">
						<div class="col mt-3">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Sender name</th>
											<th>Sender Email</th>
											<th>Receiver Email</th>
											<th>Sent Date</th>
										</tr>
									</thead>
									<c:if test="${not empty userShares}">
										<c:forEach var="item" items="${userShares}">
											<tr>
												<td>${item.username}</td>
												<td>${item.receiverEmail}</td>
												<td>${item.senderEmail}</td>
												<td>${item.shareDate}</td>
											</tr>
										</c:forEach>
									</c:if>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
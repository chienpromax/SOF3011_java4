<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-9">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<div class="row p-2">
	<c:forEach var="item" items="${videos}">
		<div class="col-3 mt-2">
			<div class="card text-center">
				<div class="card-body">
					<img class="img-fluid" width="95%" src="${ empty item.poster ? 'images/restream.jpg': item.poster }"
						alt="Title" />
					<!-- <h5 class="card-title">${item.description}</h4>  -->
					<p class="card-text">${item.title}</p>
				</div>
				<div class="card-footer">
					<a href="LikeVideo?videoId=${item.videoid }" class="btn btn-primary">Like</a> 
					<a href="ShareVideo?videoId=${item.videoid }"
						class="btn btn-primary">Share</a>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation"
				class="pt-3 d-flex justify-content-center">
				<ul class="pagination">
					<li class="page-item disabled"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item active" aria-current="page"><a
						class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<div class="col-3">
	<div class="row mt-3 mb-3">
		<div class="col">
			<div class="card">
				<div class="card-header">
					<h3>favorite</h3>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">anime</li>
					<li class="list-group-item">action</li>
					<li class="list-group-item">drama</li>
					<li class="list-group-item">horizon</li>
				</ul>
			</div>
		</div>
	</div>
</div>


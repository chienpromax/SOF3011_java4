<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="padding">
	<div class="heading py-2 d-flex ">
		<div>
			<div class="text-muted text-sm sr-item"></div>
			<h5 class="text-highlight sr-item">My Favorite</h5>
		</div>
		<span class="flex"></span> <br>
	</div>
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<div class="row">
		<c:forEach var="item" items="${listVideo}">
			<div class="col-lg-4 pb-3" style="text-align: center;" data-category="all">
				<div class="list-item">
					<div class="media">
						<a href="DetailVideo?videoId=${item.videoid}"
							class="media-body"> <img
							src="${ empty item.poster ? 'images/error.png': item.poster }"
							width="90%">
						</a>
						<div class="media-action "></div>
					</div>
					<div class="list-content">
						<div class="list-body">
							<p style="display: flex; justify-content: center; align-items: center">${item.title}</p>
						</div>
					</div>
					<div
						style="display: flex; justify-content: center; align-items: center;"
						class="card-footer">
						<a
							href="UnLike?videoId=${item.videoid}&username=${username}"
							class="btn btn-danger me-3">Unlike</a> <a
							href="ShareVideo?videoId=${item.videoid}"
							class="btn btn-primary me-3">Share</a>
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
					<li class="page-item disabled"><a class="page-link" href="FavoriteVideo"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="FavoriteVideo"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>

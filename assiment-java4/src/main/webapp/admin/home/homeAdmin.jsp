<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<div class="row p-2">
		<c:forEach var="item" items="${videos}">
			<div class="col-lg-4 mt-2">
				<div class="card text-center">
					<div class="card-body">
						<a href="DetailVideo?videoId=${item.videoid}" class="media-body">
							<img class="img-fluid" width="95%"
							src="${ empty item.poster ? 'images/error.png': item.poster }"
							alt="Title" />
						</a>
						<p class="card-text">${item.title}</p>
					</div>
					<div class="card-footer">
						<a href="LikeVideo?videoId=${item.videoid }"
							class="btn btn-primary">Like</a> <a
							href="ShareVideo?videoId=${item.videoid }"
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
					<c:if test="${currentPage > 1}">
						<li class="page-item"><a class="page-link"
							href="Homepage?page=${currentPage - 1}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>

					<c:forEach begin="1" end="${totalPages}" var="i">
						<li class="page-item ${currentPage == i ? 'active' : ''}"><a
							class="page-link" href="Homepage?page=${i}">${i}</a></li>
					</c:forEach>

					<c:if test="${currentPage < totalPages}">
						<li class="page-item"><a class="page-link"
							href="Homepage?page=${currentPage + 1}" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</div>


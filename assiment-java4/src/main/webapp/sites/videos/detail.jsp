<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-9">
	<div class="card mt-3">
		<jsp:include page="/common/inform.jsp"></jsp:include>
		<div class="card-body">
			<div class="row">
				<iframe width="100%" height="515" src="${video.linkvideo}"
					frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
					referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
			</div>
			<div class="row p-2">
				<h3>${video.title }</h3>
			</div>
			<div class="row p-2">
				<h4>${video.description}</h4>
			</div>
			<div class="row p-2">
				<p class="card-text">Lượt xem: ${video.views }</p>
			</div>
		</div>
		<div class="card-footer text-end">
			<a href="LikeVideo?videoId=${video.videoid }" class="btn btn-primary">Like</a>
			<a href="ShareVideo?videoId=${video.videoid }"
				class="btn btn-primary">Share</a>
		</div>
	</div>
</div>

<div class="col-3">
	<c:forEach var="item" items="${videos}">
		<div class="row mt-3 mb-3">
			<div class="col-8">
				<a href="DetailVideo?videoId=${item.videoid}" class="media-body">
					<img class="img-fluid" width="95%"
					src="${ empty item.poster ? 'images/restream.jpg': item.poster }"
					alt="Title" />
				</a>
			</div>
			<div class="col-4 border-left">
				<p>${item.title}</p>
			</div>
		</div>
	</c:forEach>
</div>
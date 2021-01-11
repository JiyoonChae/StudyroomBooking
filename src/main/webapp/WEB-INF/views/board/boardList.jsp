<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StudyRoom Booking</title>
	<c:import url="../template/bootStrap.jsp"></c:import>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
	<link href="../css/common/reset.css" rel="stylesheet" type="text/css">
	<link href="../css/common/header.css" rel="stylesheet" type="text/css">
	<link href="../css/common/footer.css" rel="stylesheet" type="text/css">
	<link href="../css/service/service_subtitle.css" rel="stylesheet" type="text/css">
	<link href="../css/service/notice.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<c:import url="../template/header.jsp"></c:import>
	<c:import url="../template/service_subtitle.jsp"></c:import>
	<div class="sub">
		<div class="article_title" >
			<h3>공지사항</h3>
			<p>스터디룸의 정보와 소식을 확인하실 수 있습니다.</p>
		</div>
	</div>
	<div class="container">
		<div class="inner">
			<!-- Search -->
			<div id="search" class="row">
				<div class="col-sm-8">
					<%-- <form id="frm" action="./${board}List">
						<input type="hidden" name="curPage" id="curPage" value=1>
						<div class="form-group" style="display:inline-block; width:25%; float:left;">
						  <select class="form-control" id="kind" name="kind">
						    <option>Title</option>
						    <option>Writer</option>
						    <option>Contents</option>
						  </select>
						</div>
						<div class="input-group" style="width:50%;" >
						    <input type="text" class="form-control" id="search" name="search" placeholder="Search" value="${pager.search}">
						    <div class="input-group-btn">
						      <button class="btn btn-default" type="submit">
						        <i class="glyphicon glyphicon-search"></i>
						      </button>
						    </div>
						  </div>
					</form> --%>
				</div>
			</div>

			<table class="table table-hover list_table">
				<colgroup>
					<col width="8%">
					<col width="*">
					<col width="14%">
					<col width="8%">
				</colgroup>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
				<c:forEach items="${page.content}" var="vo">
				<tr>
					<td class="num">${vo.num}</td>
					<td class="title"><a href="./noticeSelect?num=${vo.num}&hit=${vo.hit}">${vo.title}</a></td>
					<td class="regDate"><fmt:formatDate value="${vo.regDate}" pattern="yy/MM/dd HH:mm"/></td>
					<td class="hit">${vo.hit}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		
		<!-- Page -->
		<div class="pager">
			<ul class="pagination justify-content-center">
				<c:if test="${pager.prev}">
					<li class="page-item"><a href="./${board}List?page=${pager.startNum-2}">&#60;</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item page-btn" title="${i}"><a href="./${board}List?page=${i-1}">${i}</a>
				</c:forEach>
				<c:if test="${pager.next}">
					<li class="page-item"><a href="./${board}List?page=${pager.lastNum}">&#62;</a></li>
				</c:if>
			</ul>
		</div>
		
		<!-- //Page -->
		<c:if test="${member.type eq 3}">
		<p>
			<a href="${pageContext.request.contextPath}/notice/noticeWrite" class="btn btn-lg btn-write">글 작성</a>
		</p>
		</c:if>
	</div>
	<c:import url="../template/footer.jsp"></c:import>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$(".pager li.page-btn").click(function() {
			alert($(this).hasClass("on"));
			if(!$(this).hasClass("on")) {
				$(".pager .btn-page.on").removeClass("on");
				$(this).addClass("on");
				alert($(this).hasClass("on"));
			}
		});

		
	});

	var page = ${param.page};
	if($(".pager li.page-btn").attr("title").equal(page)) {
		alert($(this).html());
		
	}
	</script>
</div>
</body>
</html>
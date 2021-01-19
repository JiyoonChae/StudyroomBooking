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
	<link href="https://fonts.gstatic.com" rel="preconnect" >
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
	<link href="../css/common/reset.css" rel="stylesheet" type="text/css">
<!-- 	<link href="../css/common/header.css" rel="stylesheet" type="text/css"> -->
	<link href="../css/common/footer.css" rel="stylesheet" type="text/css">
	<link href="../css/service/service_subtitle.css" rel="stylesheet" type="text/css">
	<link href="../css/service/notice.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="sub">
		<c:import url="../template/subtitle/service_subtitle.jsp"></c:import>
		<div class="article_title" >
			<c:if test="${board eq 'notice'}">
				<h3>공지사항</h3>
				<p>스터디룸의 정보와 소식을 확인하실 수 있습니다.</p>
			</c:if>
		</div>
	</div>
	
	<div class="container">
		<div class="inner">
			<!-- Search -->
			<div class="search">
				<form id="frmSearch" action="./${board}List">
					<input type="hidden" name="page" value=0>
					<select name="searchType" id="searchType">
						<option value="all">전체</option>
						<option value="title">제목</option>
						<option value="contents">내용</option>
					</select>
					<input type="text" name="keyword" id="keyword" placeholder="검색어입력" value="${pager.keyword}">
					<a href="" class="search-btn"><img src="../images/service/search_btn.jpg" alt="검색"></a>
				</form>
			</div>
			<!-- //search -->
			
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
		<c:if test="${not empty page.content}">
		<div class="pager">
			<ul class="pagination justify-content-center">
				<c:if test="${pager.prev}">
					<li class="page-item"><a href="./${board}List?page=${pager.startNum-2}&searchType=${pager.searchType}&keyword=${pager.keyword}">&#60;</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item page-btn"><a href="./${board}List?page=${i-1}&searchType=${pager.searchType}&keyword=${pager.keyword}">${i}</a></li>
				</c:forEach>
				<c:if test="${pager.next}">
					<li class="page-item"><a href="./${board}List?page=${pager.lastNum}&searchType=${pager.searchType}&keyword=${pager.keyword}">&#62;</a></li>
				</c:if>
			</ul>
		</div>
		</c:if>		
		<!-- //Page -->
		
		<c:if test="${not empty member and member.type eq 3}">
		<p><a href="${pageContext.request.contextPath}/${board}/${board}Write" class="btn btn-lg btn-write">글 작성</a></p>
		</c:if>
	</div>
	<c:import url="../template/footer.jsp"></c:import>
	
	<script type="text/javascript">
		var page = ${param.page}+1;
		var searchType = '${param.searchType}';
		var keyword = '${param.keyword}';

		$(".pager li.page-btn").each(function() {
			if($(this).children().text() == page) {
				$(this).addClass("on");
				return false;
			}
		});

		$("#searchType").val(searchType);
				
		$(".search-btn").click(function() {
	 		searchType = $("select[name=searchType]").val();
			keyword = $("input[name=keyword]").val();
			
			$(this).attr("href", "./${board}List?page=0&searchType="+searchType+"&keyword="+keyword);
			$("#frmSearch").submit(); 
		});	
	</script>
</div>
</body>
</html>
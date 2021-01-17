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
<!--	<link href="../css/common/header.css" rel="stylesheet" type="text/css"> -->
	<link href="../css/common/footer.css" rel="stylesheet" type="text/css">
	<link href="../css/service/service_subtitle.css" rel="stylesheet" type="text/css">
	<link href="../css/service/notice.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<c:import url="../template/header.jsp"></c:import>
	<c:import url="../template/subtitle/service_subtitle.jsp"></c:import>
	<div class="sub">
		<div class="article_title" >
			<c:if test="${board eq 'faq'}">
				<h3>자주 묻는 질문</h3>
			</c:if>
		</div>
	</div>
	<div class="container">
		<div class="inner">
			<!-- Search -->
			<div class="search">
				<form method="post" id="frmSearch" action="./${board}List">
					<select name="searchType" id="searchType">
						<option>전체</option>
						<option>회원</option>
						<option>예약 및 결제</option>
						<option>취소 및 환불</option>
						<option>공간이용 및 후기</option>
						<option>기타</option>
					</select>
					<input type="text" name="keyword" id="keyword" placeholder="검색어입력" value="${param.keyword}">
					<a href="" class="search-btn"><img src="../images/service/search_btn.jpg" alt="검색"></a>
				</form>
			</div>
			<!-- //search -->
			
			<table class="table table-striped table-toggle table_faq">
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				<tbody>
					<c:forEach items="${page.content}" var="faq">
					<tr class="show">
						<td class="category">${faq.category}</td>
						<td class="question">
							<a href="" class="detail_view">${faq.title}<i class="detail_view_icon open"></i></a>
						</td>						
					</tr>
					<tr class="view">
						<td colspan="2">
							<div class="view_box">
								<div class="answer">${faq.contents}</div>
								<c:if test="${member.type eq 3 && member.id eq faq.writer}">
								<div class="btn-update-delete">
									<a href="./${board}Update?num=${faq.num}" class="btn btn-sm btn-outline-info">수정</a>
									<a href="./${board}Delete?num=${faq.num}" class="btn btn-sm btn-outline-danger">삭제</a>
								</div>
								</c:if>
							</div>
						</td>
					</tr>
					</c:forEach>
				</tbody>
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
					<li class="page-item page-btn" title="${i}"><a href="./${board}List?page=${i-1}&searchType=${pager.searchType}&keyword=${pager.keyword}">${i}</a>
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

		
		$(".detail_view").click(function() {
			alert("open : "+ $(this).children().hasClass("open"));
			alert("close : " + $(this).children().hasClass("close"));
			
			if($(this).children().hasClass("open")) {
				$(this).children().removeClass("open");
				$(this).children().addClass("close");
			} else {
				$(this).children().removeClass("close");
				$(this).children().addClass("open");
			}
		});
		
	</script>
</div>
</body>
</html>
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
	<link href="../css/common/footer.css" rel="stylesheet" type="text/css">
	<link href="../css/service/service_subtitle.css" rel="stylesheet" type="text/css">
	<link href="../css/mypage/reservationList.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="sub">
		<c:import url="../template/subtitle/mypage_subtitle.jsp"></c:import>
	
		<div class="article_title">
			<h3>예약내역 리스트</h3>
		</div>

		<div class="container">
			<div class="reservation_list">
				<section class="filter_area">
					<div class="inner_width">
						<div class="sorting_filter">
							<!-- <label for="sorting">예약번호순정렬</label> -->
							<select id="sort">
								<option selected="selected" value="revNum">예약번호순정렬</option>
								<option value="roomDate">이용일자순정렬</option>
							</select>
						</div>
						<div class="sorting_filter">
							<label for="sorting">전체</label> <select id="filter">
								<option selected="selected" value="all">전체</option>
								<option value="현장결제">현장결제</option>
								<option value="결제완료">결제완료</option>
								<option value="예약완료">예약완료</option>
								<option value="이용완료">이용완료</option>
								<!-- <option value="취소환불">취소환불</option>
								<option value="변경요청">변경요청</option> -->
							</select>
						</div>
					</div>
				</section>
				
				
				
				<div class="flex_wrap">
					<c:forEach items="${pageInfo.list}" var="vo" varStatus="i">
					<c:set var="now" value="<%=new java.util.Date() %>" />
					<c:set var="sysDate"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/></c:set>
					<c:set var="roomDate"><fmt:parseDate var="reservationDate" value="${i.current.roomDate}" pattern="yyyy-MM-dd"/>
										<fmt:formatDate value="${reservationDate}" pattern="yyyy-MM-dd"/></c:set>
					
					<article class="box box_reservation box_index${i.count}" <c:if test="${i.count % 2 ne 0}">style="float:left;"</c:if>>
						<div class="inner">
							<a href="javascript:void(0);">
								<div class="img_box">
									<span class="img"><img alt="룸사진" src="${vo.studyRoomsVO.fileUrl}"></span>
								</div>
								<div class="info_area">
									<div class="tags">
										<c:choose>
											<c:when test="${roomDate < sysDate}">
												<span class="tag tag_exploit_finish">이용완료</span>
											</c:when>
											<c:when test="${roomDate > sysDate and vo.payment eq '바로결제'}">
												<span class="tag tag_exploit_payment">결제완료</span>
											</c:when>
											<c:when test="${roomDate > sysDate and vo.payment eq '현장결제'}">
												<span class="tag tag_exploit_offline">${vo.payment}</span>
											</c:when>
											<c:otherwise><span class="tag tag_exploit_reserve">예약완료</span></c:otherwise>
										</c:choose>
										
									</div>
									<h3 class="tit_space">${vo.studyRoomsVO.roomName}</h3>
									<p class="dateTime"><!-- <span class="blind">날짜시간 정보 :</span> -->
										<span class="date">${vo.roomDate}</span>(<span class="day"></span>)
										${vo.startTime}시~${vo.endTime}시, ${vo.roomTime}시간
									</p>
									<p class="price"><!-- <span class="blind">금액 :</span> -->${vo.roomPrice}원</p>
								</div>
								<i class="sp_ico ico_page_next2"><span class="blind">자세히 보기</span></i>
							</a>
						</div>
					</article>
					</c:forEach>
				</div>
				
				<!-- Page -->
				<%-- <c:if test="${pageInfo.total ne 0}">
				<div class="pager">
					<ul class="pagination justify-content-center">
						<c:if test="${pageInfo.hasPreviousPage}">
							<li class="page-item"><a href="./reservationList?page=${pager.startNum-2}&searchType=${pager.searchType}&keyword=${pager.keyword}">&#60;</a></li>
						</c:if>
						<c:forEach begin="${pageInfo.startRow}" end="${pageInfo.endRow}" var="i">
							<li class="page-item page-btn"><a href="./reservationList?page=${i+1}">${i+1}</a></li>
						</c:forEach>
						<c:if test="${pageInfo.hasNextPage}">
							<li class="page-item"><a href="./${board}List?page=${pager.lastNum}&searchType=${pager.searchType}&keyword=${pager.keyword}">&#62;</a></li>
						</c:if>
					</ul>
				</div>
				</c:if>	 --%>	
				<!-- //Page -->
			</div>
		</div>
		<c:import url="../template/footer.jsp"></c:import>
		
	</div>
</div>
<script type="text/javascript" src="../js/mypage/reservationList.js"></script>
</body>
</html>
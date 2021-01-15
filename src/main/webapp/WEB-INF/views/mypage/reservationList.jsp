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
							<label for="sorting">예약번호순정렬</label> <select id="sort">
								<option selected="selected" value="[object Object]">예약번호순정렬</option>
								<option value="[object Object]">이용일자순정렬</option>
							</select>
						</div>
						<div class="sorting_filter">
							<label for="sorting">전체</label> <select id="filter">
								<option selected="selected" value="[object Object]">전체</option>
								<option value="[object Object]">승인대기</option>
								<option value="[object Object]">결제대기</option>
								<option value="[object Object]">예약확정</option>
								<option value="[object Object]">이용완료</option>
								<option value="[object Object]">취소환불</option>
								<option value="[object Object]">변경요청</option>
							</select>
						</div>
					</div>
				</section>
			</div>
		</div>
		<c:import url="../template/footer.jsp"></c:import>
	</div>
</div>
</body>
</html>
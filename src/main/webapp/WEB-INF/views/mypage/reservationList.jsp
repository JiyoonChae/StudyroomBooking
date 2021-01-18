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
					<article class="box box_reservation">
						<div class="inner">
							<a href="javascript:void(0);">
								<div class="img_box">
									<span class="img"><img alt="룸사진" src="../images/rooms/room_view01.jpg"></span>
								</div>
								<div class="info_area">
									<div class="tags">
										<span class="tag tag_exploit_finish">이용완료</span>
									</div>
									<h3 class="tit_space">2~4인룸</h3>
									<p class="text"><span class="blind">날짜시간 정보 :</span>2021.01.15(목) 18~20시, 2시간</p>
									<p class="price"><span class="blind">금액 :</span>12,000원</p>
								</div>
								<i class="sp_ico ico_page_next2"><span class="blind">자세히 보기</span></i>
							</a>
						</div>
					</article>
				</div>
				
			</div>
		</div>
		<c:import url="../template/footer.jsp"></c:import>
	</div>
</div>
</body>
</html>
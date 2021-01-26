<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확정  | StudyRoom Booking</title>
<link href="../css/common/subtitle.css" rel="stylesheet" type="text/css">
<link href="../css/res/resConfirm.css" rel="stylesheet" type="text/css">
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<!-- subTitle 부분 시작 -->
	<div class="subtitle">
		<ul class="title02">
			<h2>
				<span>studyㆍmeetㆍ work</span>
				<br>
				실시간 예약
			</h2>
		</ul>
	</div> <!-- subtitle end  -->
	
	<!-- 예약 확정 페이지 start ------------ -->
	<div class="contentbox">
		<div class="heading"><h3>예약 공간</h3>
			<span class="option"><strong class="price">1,500 원</strong>
			<em class="unit">/시간 (인)</em>
			</span>
		</div>
		<!--  이미지 뿌릴까말까,, 그럼 db에 저장해서 가져와야함. -->
		<div class="info_photo">
			<h4 class="rm_name">${room.roomName} (${room.min}~${room.max} 인실) </h4>
			<span class="photo"><img id="room" src="${room.fileUrl}" alt="room image"> </span>
		</div>
		<div class="facility_wrap">
			<ul class="facility_list">
				<li>tv/ 프로젝터 </li>
				<li>화이트 보드</li>
				<li>인터넷/wifi</li>
			</ul>
		</div>
		
		<article>
			<div class="heading"><h3>예약 정보</h3></div>
			<div class="reserve-info">
				<p class="reserve-date">예약 번호
				<span class="details"> ${resInfo.resVO.revNum }</span>
				</p>
				<p class="reserve-date">예약 날짜
				<span class="details"> ${resInfo.resVO.roomDate}  (${resInfo.resVO.roomTime} 시간)</span>
				</p>
				<p class="reserve-date">예약 인원
					<span class="details"> ${resInfo.resVO.roomUser} 인</span>
				</p>
			</div>
		</article>
		
		<article id="user_info">
			<div class="heading"><h3>예약자 정보</h3>
			
			</div>
			<div class="user-wrap">
				<dl class="flex_box">
					<dt class="flex tit">
						<label for="name">예약자</label>
					</dt>
					<dd class="flex">
						<input type="text" id="name" value="${member.name}" readonly="readonly">	
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="flex tit">
						<label for="phone">연락처</label>
					</dt>
					<dd class="flex">
						<input type="text" id="phone" value="${member.phone}" readonly="readonly">	
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="flex tit">
						<label for="email">이메일</label>
					</dt>
					<dd class="flex">
						<input type="text" id="email" value="${member.email }" readonly="readonly">	
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="flex tit">
						<label for="request">요청사항</label>
					</dt>
					<dd class="flex">
						<textarea name id="request" maxlength="500" placeholder="남기고 싶은 말을 적어주세요. (최대 500자)"></textarea>
						
					</dd>
				</dl>
			</div>
			
		</article>
		
		<!-- 결제 정보 start-->
			<article>
			<div class="heading"><h3>결제 정보</h3></div>
			<c:if test ="${resInfo.resVO.payment eq '바로결제'}"> 
				<div class="reserve-info">
					<p class="reserve-date">결제 번호
					<span class="details"> ${pay.merchant_uid}</span>
					</p>
					<p class="reserve-date">결제 완료 금액
					<span class="details"> ${pay.paid_amount} 원</span>
					</p>
					<p class="reserve-date">결제 날짜
						<span class="details"> ${pay.orderDate}</span>
					</p>
				</div>
			</c:if>
			<c:if test ="${resInfo.resVO.payment eq '현장결제'}"> 
				<div class="reserve-info">
					<p class="reserve-date">결제 할 금액
					<span class="details"> ${resInfo.resVO.roomPrice} 원</span>
					</p>
					
				</div>
			</c:if>
		</article>
		
		<!-- 결제정보 end -->
		
		
			<div class="confirm">	
				<button class="btn btn-warning" id="confirm">확인</button>
				</div>
	</div> <!--  contentsbox 끝> -->
	
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>
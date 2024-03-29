<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간 예약 | StudyRoom Booking</title>
<link href="../css/common/subtitle.css" rel="stylesheet" type="text/css">
<link href="../css/res/calendar.css" rel="stylesheet" type="text/css">
<link href="../css/res/roomImages.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>


<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
.swiper-container { width: 45px; height: 120px; }
ul, li {list-style: none;}
.reserve_time_wrap {overflow:hidden; background-color: #fff; }
.swiper-container {width:647px;}
.swiper-wrapper {position: relative; width:100%; height:100%; display: flex; box-sizing: content-box; margin: 0 auto;}

.time_list li {position:relative; float: left; height: 103px; width: 55px !important; padding: 47px 0 14px; }
span{vertical-align: top;}
.time.time_half {position:absolute; left:-8px; top:4px; width: auto; color: #b2b2b2; font-size: 9px; text-align: center;}
a {text-decoration: none; cursor: pointer;}
.time_box {display: table; position: relative; text-align: center; background-color: #ffd014;}
.time {position: absolute; left: -8px; top: -23px; width: 15px; text-align: center;}
span.price {color: #cc8c28; border:2px solid #ffc000; background-color:#ffd014; width: 45px; min-wsidth: 45px; height: 41px; padding:8px; vertical-align: middle; } 

.heading {position: relative; width:100%; padding-bottom: 8px; border-bottom: 2px solid #704de4; margin-top: 30px;}
.buttons {margin-top: 30px;}
.btn-res {background: #704de4; color:#fff; font-weight: bold;}
/* modal css*/
.modal-body {padding: 24px 26px 26px;}
.close {margin: 0 !important;}
.modal-header {padding:0;}
.modal-title {text-align:left;  padding: 20px 25px;  background: #704de4; font-size: 20px; color:#fff; box-sizing: border-box;}
.title {margin-top: 20px; font-size: 25px; line-height: 44px; color:#000; text-align: center;}
.reserve-info {margin-top:30px; border-top:2px solid #704de4;}
.reserve-info-wrap {padding: 0 20px; border-bottom: 1px solid #ccc;}
.reserve-info-wrap input {border:none; text-align: right; outline:none; font-weight: bold;}
.reserve-info-wrap li {position: relative; padding:20px 0 18px  100px; font-size:16px; text-align: right; border-bottom: 1px solid #ccc;}
.reserve-info-wrap .tit {position: absolute; left:0; color:#656565;}
#roomPrice {color: #704de4;}
</style>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		var IMP = window.IMP;
		IMP.init('imp85640668');
	 	})
</script>
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
	<!-- 스터디룸 이미지 파일 출력 -->
	<div class="imgContainer">
		<div class="img">
			<img src="http://localhost/images/rooms/room_view01.jpg" alt="2-3인용"> 
			<input type="radio" class="room" name="room" value="1"> 최대 2-3인실
		</div>
		<div class="img">
			<img src="../images/rooms/room_view02.jpg" alt="3-4인용"> 
			<input type="radio" class="room" name="room" value=2> 최대 3-4인실
		</div>
		<div class="img">
			<img src="../images/rooms/room_view03.jpg" alt="6-7인용"> 
			<input type="radio" class="room" name="room" value="3"> 최대 6-7인실
		</div>
		<div class="img">
			<img src="../images/rooms/room_view04.jpg" alt="8-9인용"> 
			<input type="radio" class="room" name="room" value="4"> 최대 8-9인실
		</div>
		<div class="img">
			<img src="../images/rooms/room_view05.jpg" alt="10-12인용"> 
			<input type="radio" class="room" name="room" value="5"> 최대 10-12인실
		</div>
	</div>
	<!--  이미지 출력 end -->
	
	<!-- 예약 정보 start: 날짜, 시간, 인원, 총 요금 출력 -->
	<div class="container" style="margin-top: 30px;">
		<!-- 달력 -->
		<div class="heading"><h5>날짜선택</h5></div>
		<div id="calendarForm"></div>
		
		<div class="heading"><h5>시간선택</h5></div>
			<!-- Slider main container -->
			<div class="reserve_time_wrap">
    		<div class="swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-free-mode">
        		<ul class="swiper-wrapper time_list" style="transition-duration: 0ms; transform: translate3d(0px, 0px, 0px);">
            		<li class="swiper-slide able swiper-slide-active"><span class="time time_half">오전</span> <a
                    	class="time_box"><span class="time">0</span> <span class="price">1,500</span></a></li>
            		<li class="swiper-slide able swiper-slide-next">
                 		<a class="time_box"><span class="time">1</span> <span class="price">1,500</span></a>
            		</li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time" >2</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">3</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">4</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">5</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">6</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">7</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">8</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">9</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">10</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">11</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able"><span class="time time_half">오후</span> <a class="time_box"><span
		                        class="time">12</span> <span class="price">1,500</span></a></li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">13</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">14</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">15</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">16</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                <a class="time_box"><span class="time">17</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">18</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">19</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">20</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">21</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">22</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able">
		                 <a class="time_box"><span class="time">23</span> <span class="price">1,500</span></a>
		            </li>
		            <li class="swiper-slide able"><span class="time time_half">익일</span> <a class="time_box"><span
		                        class="time">0</span> <span class="price">1,500</span></a></li>
		          
        	</ul><span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span>
  	 	 </div>
	</div>

	<!-- 선택된 예약 정보 출력 -->
	<div class="heading"> <h5>예약 일시</h5> </div>
		<div class="reservation">
		<div class="reserve_info" style="font-size:20px;"></div>
		<div class="time_info" style="font-size:20px;"></div>
		</div>
		
	<div class="heading" > <h5>인원 선택</h5></div>
		<div class="box_setting">
			<span class="input">
			<input type="number" id="users" name="users" value=1 min="1" max="12">
			</span>
		</div>
	

	<div class="heading"><h5>공간 사용료</h5></div>
		<div class="totalPrice" style="font-size:20px;"></div>
	

	<div class="buttons">	
		<input type="hidden" name="name" value="${member.name}" id="name">
		<input type="hidden" name="phone" value="${member.phone}" id="phone">
		<button class="btn btn-res" id="storePay" data-toggle="modal" data-target="#myModal">예약하기</button>
	</div>
	
</div> <!-- container 종료 -->

 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="display: block;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">예약 확정</h4>
        </div>
        <div class="modal-body">
          <p class="title">결제하시겠습니까? </p>
          <div class="reserve-info">
          <ul class="reserve-info-wrap">
          	<li><span class="tit">스터디룸 </span><input type="text" name="roomType" class="reserveRoom"></li>
          	<li><span class="tit">예약 날짜 </span> <input type="text" name="roomDate" class="reserveDate"></li>
          	<li><span class="tit">시작 시간 </span><input type="text" name="startTime" class="startTime"></li>
          	<li><span class="tit">종료 시간 </span><input type="text" name="endTime" class="endTime"></li>
          	<li><span class="tit">인원 </span><input type="text" name="roomUser" class="reserveUser"></li>
          	<li style="border-botton:none;"><span class="tit">총 금액</span> <input type="text" name="roomPrice" id="roomPrice"></li>
          </ul>
          </div>
        </div>
        <div class="modal-footer">
        	<p>예약을 확정 하시겠습니까?</p>
        
        	<button class="btn btn-warning" id="cardPay" title="바로결제">바로 결제</button>
          <button type="button" class="btn btn-res" data-dismiss="modal" id="confirmRes" title="현장결제">현장결제</button>
        </div>
      
    </div>
 </div> 
 </div> 


<script type="text/javascript" src="../js/calendar.js" ></script>
<script type="text/javascript" src="../js/import.js" ></script>
<script type="text/javascript">
var mySwiper = new Swiper('.swiper-container');



</script>
</body>
</html>
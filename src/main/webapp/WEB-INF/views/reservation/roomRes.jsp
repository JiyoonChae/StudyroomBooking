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

<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	.swiper-container {
    width: 45px;
    height: 120px;
}
ul, li {list-style: none;}
.reservat_time_wrap {overflow:hidden; background-color: #fff; }
.swiper-container {width:647px;}
.swiper-wrapper {position: relative; width:100%; height:100%; display: flex; box-sizing: content-box; margin: 0 auto;}

.time_list li {position:relative; float: left; height: 103px; width: 55px !important; padding: 47px 0 14px; }
span{vertical-align: top;}
.time.time_half {position:absolute; left:-8px; top:4px; width: auto; color: #b2b2b2; font-size: 9px; text-align: center;}
a {text-decoration: none; cursor: pointer;}
.time_box {display: table; position: relative; text-align: center; background-color: #ffd014;}
.time {position: absolute; left: -8px; top: -23px; width: 15px; text-align: center;}
span.price {color: #cc8c28; border:2px solid #ffc000; background-color:#ffd014; width: 45px; min-wsidth: 45px; height: 41px; padding:8px; vertical-align: middle; } 

.selected {border:2px solid #5940ac; background-color: #704de4; }
.heading {position: relative; width:100%; padding-bottom: 8px; border-bottom: 2px solid #704de4;}

</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
		<div class="subtitle">
		<ul class="title02">
			<h2>
				<span>studyㆍmeetㆍ work</span>
				<br>
				실시간 예약
			</h2>
		</ul>
	</div>
	<div class="container"> 
	<div id="calendarForm"></div>
	
	<div class="heading"><h5>시간선택</h5></div>
	<!-- Slider main container -->

	<div class="reserve_time_wrap">
    <div class="swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-free-mode">
        <ul class="swiper-wrapper time_list" style="transition-duration: 0ms; transform: translate3d(0px, 0px, 0px);">
            <li class="swiper-slide able swiper-slide-active"><span class="time time_half">오전</span> <a
                    class="time_box"><span class="time">0</span> <span class="price">1,500</span></a></li>
            <li class="swiper-slide able swiper-slide-next">
                <!----> <a class="time_box"><span class="time">1</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time" >2</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">3</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">4</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">5</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">6</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">7</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">8</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">9</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">10</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">11</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able"><span class="time time_half">오후</span> <a class="time_box"><span
                        class="time">12</span> <span class="price">1,500</span></a></li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">13</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">14</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">15</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">16</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">17</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">18</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">19</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">20</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">21</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">22</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able">
                <!----> <a class="time_box"><span class="time">23</span> <span class="price">1,500</span></a>
            </li>
            <li class="swiper-slide able"><span class="time time_half">익일</span> <a class="time_box"><span
                        class="time">0</span> <span class="price">1,500</span></a></li>
          
        </ul><span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span>
    </div>
</div>

<div class="heading"> <h5>예약 일시</h5> </div>
<div>2021. </div>
<div class="heading"><h5>공간 사용료</h5></div>

<button class="btn btn-warning">바로 결제</button>
<button class="btn btn-info">현장 결제</button>
</div>
<script type="text/javascript" src="../js/calendar.js" ></script>
<script type="text/javascript">
var mySwiper = new Swiper('.swiper-container');



</script>
</body>
</html>
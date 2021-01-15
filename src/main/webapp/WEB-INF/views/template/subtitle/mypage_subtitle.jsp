<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<div class="subtitle">
		<ul class="title02">
			<h2>
				<span>study ㆍ meet ㆍ work</span>
				<br>마이페이지
			</h2>
		</ul>
	</div>
	<div class="subtap">
		<ul>
			<li class="mypage">
				<a href="${pageContext.request.contextPath}/mypage/reservationList">예약내역 리스트</a>
			</li>
			<li class="member">
				<a href="${pageContext.request.contextPath}/member/myInfo">개인정보변경</a>
			</li>
		</ul>
	</div>
	
	<script type="text/javascript">
		var path = window.location.pathname;
		path = path.substring(path.indexOf("/")+1, path.lastIndexOf("/"));
		
		$(".subtap li").each(function() {
			if(path.match($(this).attr("class"))) {
				$(this).addClass("tapon");
				$(this).children().css("color", "#fff");
			}
		});		
	</script>
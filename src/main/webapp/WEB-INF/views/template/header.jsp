<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">StudyRoomBooking</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">공간(룸)소개</a></li>
					<li class="nav-item"><a class="nav-link" href="#">이용안내</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/res/roomRes">실시간예약</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/notice/noticeList?page=0&searchType=all&keyword=">고객지원</a></li>
				</ul>
			</div>
	
			<!-- 로그인 영역 -->
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<c:choose>
						<c:when test="${not empty member}">
							<c:if test="${member.type eq 3}">
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.request.contextPath}/admin/index">Admin</a>
								</li>
							</c:if>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.request.contextPath}/mypage/reservationList">MyPage</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogout">LogOut</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.request.contextPath}/member/memberJoin">Sign Up</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogin">LogIn</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<!-- //로그인 영역 -->
	
		</div>
	</nav>
</header>

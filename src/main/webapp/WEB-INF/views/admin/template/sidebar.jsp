<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">Home</div>
					<a class="nav-link" href="${pageContext.request.contextPath}/admin/index">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div>메인
					</a>
					<div class="sb-sidenav-menu-heading">Management</div>
					<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
						<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>매장
						<div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
					</a>
					<div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="${pageContext.request.contextPath}/admin/reservation/reservationList">예약현황</a> 
							<a class="nav-link" href="layout-static.html">고객리스트</a>
							<a class="nav-link" href="layout-static.html">1:1 문의</a>
						</nav>
					</div>
					<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
						<div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div> 직원
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
							<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth"> 관리
								<div class="sb-sidenav-collapse-arrow">
									<i class="fas fa-angle-down"></i>
								</div>
							</a>
							<div class="collapse" id="pagesCollapseAuth" data-parent="#sidenavAccordionPages">
								<nav class="sb-sidenav-menu-nested nav">
									<c:choose>
									<c:when test="${member.type eq 3}">
										<a class="nav-link" href="layout-static.html">직원리스트</a> 
										<a class="nav-link" href="layout-static.html">근태관리</a> 
										<a class="nav-link" href="layout-sidenav-light.html">급여계산</a>
									</c:when>
									<c:otherwise>
										<a class="nav-link" href="layout-static.html">출퇴근기록</a> 
										<a class="nav-link" href="layout-sidenav-light.html">근태관리</a>
									</c:otherwise>
									</c:choose>
								</nav>
							</div>
							<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError"> 게시판
								<div class="sb-sidenav-collapse-arrow">
									<i class="fas fa-angle-down"></i>
								</div>
							</a>
							<div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
								<nav class="sb-sidenav-menu-nested nav">
									<a class="nav-link" href="401.html">공지사항</a> 
									<a class="nav-link" href="404.html">직원채용</a> 
									<a class="nav-link" href="500.html">관리</a>
								</nav>
							</div>
						</nav>
					</div>
					<div class="sb-sidenav-menu-heading">Info</div>
					<a class="nav-link" href="charts.html">
						<div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div> 매출차트
					</a> <a class="nav-link" href="tables.html">
						<div class="sb-nav-link-icon"><i class="fas fa-table"></i></div> 근무일정 템플릿
					</a>
				</div>
			</div>
			<div class="sb-sidenav-footer">
				<div class="small">Logged in as:</div>
				Start Bootstrap
			</div>
		</nav>
	</div>
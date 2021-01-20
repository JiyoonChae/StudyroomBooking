<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<link href="../../css/admin/style.css" rel="stylesheet">
</head>
<body class="sb-nav-fixed">
	<header>
	<c:import url="../template/navigation.jsp"></c:import>
	</header>
	<!-- Page Wrapper -->
	<div id="layoutSidenav">    	
		<!-- Sidebar -->
        <c:import url="../template/sidebar.jsp"></c:import>
        <!-- End of Sidebar -->
        
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h1 class="mt-4">예약현황리스트</h1>
					<hr>
					<div class="card mb-4">
						<!-- <div class="card-header">
							<i class="fas fa-table mr-1"></i> 예약리스트
						</div> -->
						<div class="searchForm" style=" padding: 20px;">
							<form id="frmReservationSearch" action="">
								<input type="date" name="roomDate">
								<select name="order">
									<option>전체</option>
									<option>예약번호순</option>
									<option>예약날짜순</option>
									<option>결제구분순</option>
								</select>
								
							</form>							
						</div>
						
						<div class="card-body">
							<table class="table table-hover">
								<thead class="thead-dark">
									<tr>
										<td>예약번호</td>
										<td>예약자</td>
										<td>방번호</td>
										<td>예약시간정보</td>
										<td>인원</td>
										<td>이용날짜</td>
										<td>결제금액</td>
										<td>결제구분</td>										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="vo">
									<tr>
										<td>${vo.revNum}</td>
										<td>${vo.id}</td>
										<td>${vo.roomType}</td>
										<td>${vo.startTime}시 ~ ${vo.endTime}시 (총 ${vo.roomTime}시간)</td>
										<td>${vo.roomUser}</td>
										<td>${vo.roomDate}</td>
										<td>${vo.payment}</td>
										<td>${vo.roomPrice}</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</main>
			<c:import url="../template/footer.jsp"></c:import>
		</div>
	</div>
    <!-- End of Page Wrapper -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <!-- <script src="../../js/admin/template/scripts.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>\
</html>
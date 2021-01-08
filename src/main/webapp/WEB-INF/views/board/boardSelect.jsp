<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StudyRoom Booking</title>
	<c:import url="../template/bootStrap.jsp"></c:import>
	<%-- <c:import url="../template/bootstrap3.jsp"></c:import> --%>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
	<link href="../css/common/reset.css" rel="stylesheet" type="text/css">
	<link href="../css/common/header.css" rel="stylesheet" type="text/css">
	<link href="../css/common/footer.css" rel="stylesheet" type="text/css">
	<link href="../css/service/service_subtitle.css" rel="stylesheet" type="text/css">
	<link href="../css/service/notice.css?v=1" rel="stylesheet" type="text/css">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<div id="wrap">
	<c:import url="../template/header.jsp"></c:import>
	<c:import url="../template/service_subtitle.jsp"></c:import>
		<div class="sub">
			<div class="article_title">
				<h3>
					<c:if test="${board eq 'notice'}">공지사항</c:if>
				</h3>
				<p>StudyRoom Booking 모임공간의 정보와 소식을 확인하실 수 있습니다.</p>
			</div>

			<div class="container">
				<div class="inner">
					<table class="table select_table">
						<colgroup>
							<col width="15%">
							<col width="80%">
							<col width="*">
						</colgroup>
						<tr>
							<th>공지사항</th>
							<td class="title">${notice.title}</td>
						</tr>
						<tr>
							<td colspan="2" class="contents">${notice.contents}</td>
						</tr>
					</table>
				</div>
				<div class="btn btn_toList">
					<a href="./noticeList">목록으로</a>
				</div>
			</div>
		</div>
	<c:import url="../template/footer.jsp"></c:import>
</div>

</body>
</html>




		
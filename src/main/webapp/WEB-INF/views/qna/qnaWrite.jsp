<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StudyRoom Booking</title>
	<c:import url="../template/bootStrap.jsp"></c:import>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
	<link href="../css/common/reset.css" rel="stylesheet" type="text/css">
	<link href="../css/common/header.css" rel="stylesheet" type="text/css">
	<link href="../css/service/service_subtitle.css" rel="stylesheet" type="text/css">
	<link href="../css/service/notice.css" rel="stylesheet" type="text/css">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<div id="wrap">
	<c:import url="../template/header.jsp"></c:import>
	<c:import url="../template/service_subtitle.jsp"></c:import>
	<div class="sub">
		<div class="article_title" >
			<h3><c:if test="${board eq 'notice'}">공지사항 </c:if>작성</h3>
			<p></p>
		</div>

		<div class="container">
			<form action="./${board}Write" method="post" enctype="multipart/form-data" class="frm">
				<div class="form-group">
					<label for="title">제목</label>
					<input type="text" class="form-control" placeholder="제목을 입력하세요" id="title" name="title">
				</div>
				<div class="form-group">
					<label for="writer">작성자</label>
					<input type="text" class="form-control" value="${member.id}" id="writer" name="writer">
				</div>
				<div class="form-group">
					<!-- <label for="contents">내용</label> -->
					<textarea class="form-control" id="contents" name="contents"></textarea>
				</div>
				<!-- <div class="form-group">
					<label for="files">업로드</label>
					<input type="file" class="form-control" name="files">
					<input type="file" class="form-control" name="files">
				</div> -->
				<button type="submit" class="btn btn-lg btn-write">등록하기</button>
			</form>
		</div>
	</div>

	<script src="../js/service/noticeWrite.js"></script>
</div>
</body>
</html>
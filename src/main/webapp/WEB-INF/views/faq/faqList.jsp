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
</head>
<body>
<div id="wrap">
	<c:import url="../template/header.jsp"></c:import>
	<c:import url="../template/service_subtitle.jsp"></c:import>
	<div class="sub">
		<div class="article_title" >
			<h3><c:if test="${board eq 'faq'}">FAQ</c:if>작성</h3>
			<p></p>
		</div>
	</div>
	
	<div class="container">
		<form action="./${board}Write" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="writer">제목</label>
				<input type="text" class="form-control" id="title" placeholder="제목을 입력해주세요" name="title">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input type="text" class="form-control" id="writer" placeholder="작성자(로그인ID)" name="writer">
			</div>
			<div class="form-group">
				<label for="contents">내용</label>
				<textarea class="form-control" id="contents" name="contents"></textarea>
			</div>
			
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
	
</div>
</body>
</html>
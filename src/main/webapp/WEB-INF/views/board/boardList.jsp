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
	<link href="../css/common/service_sub.css" rel="stylesheet" type="text/css">
	<link href="../css/service/notice.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<c:import url="../template/header.jsp"></c:import>
	<c:import url="../template/service_subtitle.jsp"></c:import>
	<div class="sub">
		<div class="article_title" >
			<h3>공지사항</h3>
			<p>스터디룸의 정보와 소식을 확인하실 수 있습니다.</p>
		</div>
	</div>
	<div class="container">
			<div class="bbs">
			<!-- Search -->
			<div id="search" class="row">
				<div class="col-sm-8">
					<form id="frm" action="./${board}List">
						<input type="hidden" name="curPage" id="curPage" value=1>
						<div class="form-group" style="display:inline-block; width:25%; float:left;">
						  <select class="form-control" id="kind" name="kind">
						    <option>Title</option>
						    <option>Writer</option>
						    <option>Contents</option>
						  </select>
						</div>
						<div class="input-group" style="width:50%;" >
						    <input type="text" class="form-control" id="search" name="search" placeholder="Search" value="${pager.search}">
						    <div class="input-group-btn">
						      <button class="btn btn-default" type="submit">
						        <i class="glyphicon glyphicon-search"></i>
						      </button>
						    </div>
						  </div>
					</form>
				</div>
			</div>

				<table class="table table-hover">
					<tr>
						<th>번호</th>
						<th>내용</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					<tr>
						<td onclick="event.cancelBubble=true;">11</td>
						<td class="type01"><a href="Notice.View.php?articleIndex=193">[중요]
								거리두기 시행으로 인한 이용 변동사항 안내 (20/11/18 부터 ~ 별도공지시까지 적용 ) - 20.12.21
								(월) UPDATE</a></td>
						<td>관리자</td>
						<td>20/11/18(수)</td>
						<td>0</td>
					</tr>
				</table>
			</div>
			<div class="paging">
				<ul>
					<li class="on">1</li>
				</ul>
			</div>
		</div>	
</div>
</body>
</html>
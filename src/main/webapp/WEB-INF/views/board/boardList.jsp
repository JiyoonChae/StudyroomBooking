<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StudyRoomBooking</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
<link href="../css/member/memberLogin.css" rel="stylesheet" type="text/css">
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
 <c:import url="../template/subtitle.jsp"></c:import>
 
 <div class="article_title">
 	<p>셀스 스터디룸에 오신것을 환영합니다 <br>
 	로그인 후 다양한 서비스를 이용하세요!
 	</p>
 </div>
 
 <div class="login">
	<form action="./memberLogin" method="post" id="frm">
  <div class="form-group">
    <label for="id">ID</label>
    <input type="text" class="form-control" id="id" name="id">
  </div>
  <div class="form-group">
    <label for="pw">Password:</label>
    <input type="password" class="form-control" id="pw" name="pw">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  
  <div class="logbtn">로그인</div>
   <p class="save"> <input type="checkbox" id="save">아이디저장</p>
 	<p class="join">
 	<a href="#">아이디 찾기</a>
 	<a href="#">비밀번호 찾기</a>
 	<a href="#">회원가입</a>
 	</p>

<div class="naverbtn">
	<img>
	네이버 아이디로 로그인
</div> 
<br>
<div class="kakaobtn">
	<img>
	카카오 아이디로 로그인
</div>

<script type="text/javascript">
	$(".logbtn").click(function(){
		$("#frm").submit();
		})
</script>

</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | JY-StudyRoom</title>

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
 <!-- Login Form 시작 -->
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
    <label><input type="checkbox" id="save"> Remember me</label>
  </div>
  
  <!--  로그인 버튼  -->
  <div class="logbtn">로그인</div>

 	<p class="join">
 	<a href="#">아이디 찾기</a>
 	<a href="#">비밀번호 찾기</a>
 	<a href="#">회원가입</a>
 	</p>

<p>
	<div id="naverIdLogin"><a id="naverIdLogin_loginButton" href="#" role="button"><img src="https://static.nid.naver.com/oauth/big_g.PNG" width=320></a></div>
</p>
<div class="naverLogin">
	<a id="naverbtn" href="#">
		네이버 아이디로 로그인
	</a>
</div> 
<br>
<div class="kakaobtn">
	<a href="https://kauth.kakao.com/oauth/authorize?client_id=db6b291272bd77842e5db5fa28f52e1a&redirect_uri=http://localhost/auth/kakao/callback&response_type=code"><img class="kakaoLogin" alt="" src="../images/kakao_login.png" /></a>
	카카오 아이디로 로그인
</div>
</form>
</div>

<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script type="text/javascript">
	$(".logbtn").click(function(){
		$("#frm").submit();
		})



<!-- 네이버아디디로로그인 초기화 Script -->
	<!-- (3) LoginWithNaverId Javscript 설정 정보 및 초기화 -->
		window.name='opener';
		var naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "3mxLzdZN0uWCIguV1hC2",
				callbackUrl: "http://localhost/member/memberNaverLogin",
				isPopup: true,
				loginButton: {color: "green", type: 3, height: 60},
				callbackHandle: true
			}
		);
		/* (4) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();

		
		/* (4-1) 임의의 링크를 설정해줄 필요가 있는 경우 */
		$("#gnbLogin").attr("href", naverLogin.generateAuthorizeUrl());

		/* (5) 현재 로그인 상태를 확인 */
		window.addEventListener('load', function () {
			naverLogin.getLoginStatus(function (status) {
				if (status) {
					/* (6) 로그인 상태가 "true" 인 경우 로그인 버튼을 없애고 사용자 정보를 출력합니다. */
					setLoginStatus();
				}
			});
		});

		/* (6) 로그인 상태가 "true" 인 경우 로그인 버튼을 없애고 사용자 정보를 출력합니다. */
		function setLoginStatus() {
			var profileImage = naverLogin.user.getProfileImage();
			var nickName = naverLogin.user.getNickName();
			var imageViewer = '';
			if (profileImage) {
				imageViewer += '<br><br><img src="' + profileImage + '" height=50 /> <p>';
			}
			$("#naverIdLogin_loginButton").html(imageViewer + nickName + '님 반갑습니다.</p>');
			$("#gnbLogin").html("Logout");
			$("#gnbLogin").attr("href", "#");
			/* (7) 로그아웃 버튼을 설정하고 동작을 정의합니다. */
			$("#gnbLogin").click(function (e) {
				e.preventDefault();
				naverLogin.logout();
				location.replace('/oauth/sample/javascript_sample.html');
			});
		}
	</script>
<!-- // 네이버아이디로로그인 초기화 Script -->

</body>
</html>
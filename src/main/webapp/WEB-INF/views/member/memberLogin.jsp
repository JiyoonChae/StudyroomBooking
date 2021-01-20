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
<link href="../css/common/reset.css" rel="stylesheet" type="text/css">
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
   		 <input type="text" value="${cookie.remember.value}" class="form-control" id="id" name="id">
  	 </div>
 	 <div class="form-group">
    	<label for="pw">Password:</label>
    	<input type="password" class="form-control" id="pw" name="pw">
  	 </div>
  	<div class="checkbox">
     	<label><input type="checkbox" name="remember" value="check"> Remember me</label>
  	 </div>
  
	  <!--  로그인 버튼  -->
	  <div class="logbtn">로그인</div>
	</form>
	
	<div class="options">
 	<p class="join">
 	<a href="#" data-toggle="modal" data-target="#myModal">아이디 찾기</a><span>|</span>
 	<a href="#" data-toggle="modal" data-target="#pwModal">비밀번호 찾기</a><span>|</span>
 	<a href="${pageContext.request.contextPath}/member/memberJoin">회원가입</a>
 	</p>
	</div>
	
	<!-- sns 로그인 -->
	<div class="snsbtn">
		<div id="naverIdLogin">
			<a id="naverIdLogin_loginButton" href="#" role="button">
			<img class="naverLogin" src="https://static.nid.naver.com/oauth/big_g.PNG" width=320>
			</a>
		</div>
		<div class="kakao">
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=db6b291272bd77842e5db5fa28f52e1a&redirect_uri=http://localhost/auth/kakao/callback&response_type=code">
			<img class="kakaoLogin" alt="" src="../images/kakao_login.png" />
			</a>
		</div>
	</div> <!-- sns로그인 끝 -->

</div> <!-- 전체 div끝 -->



<!-- id찾기 Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">아이디 찾기</h4>
      </div>
      <div class="modal-body">
        <p>가입한 이름과 메일을 적어주세요</p>
         <div class="reserve-info">
          <ul class="reserve-info-wrap">
          	<li><span class="tit">이름 </span><input type="text" name="name" class="name"></li>
          	<li><span class="tit">email </span> <input type="text" name="email" class="email"></li>
          </ul>
          <button id="find">찾기</button>
          <div id="result"></div>
          <div id="findResult"></div>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div> <!-- id찾기 모달 end -->


<!-- pw찾기 Modal -->
<div id="pwModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">비밀번호 찾기</h4>
      </div>
      <div class="modal-body">
        <p>가입한 아이디와 메일주소를 적어주세요</p>
         <div class="reserve-info">
          <ul class="reserve-info-wrap">
          	<li><span class="tit">ID </span><input type="text" name="id" class="pw-id"></li>
          	<li><span class="tit">email </span> <input type="text" name="email" class="pw-email"></li>
          </ul>
          <button id="pwfind">찾기</button>
          <div id="pwResult"></div>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div> <!-- id찾기 모달 end -->











<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script type="text/javascript">
	$(".logbtn").click(function(){
		$("#frm").submit();
		})

	$("#find").click(function(){
		var name = $(".name").val();
		var email = $(".email").val();
		$.ajax({
			url:"./findMyId",
			type: "post",
			data: {name:name, email:email},
			success: function(data){
				console.log(data);
				//id받아서 
				$("#result").text("아이디 찾기 완료 ")
				$("#findResult").text(data).css("color", "blue");
				}
			})
		})

	//비번찾기: id,mail 일치 확인 - 일치하면 이멜로 랜덤비번보내기 -> db에 비번 update
	$("#pwfind").click(function(){
		var id = $(".pw-id").val();
		var email = $(".pw-email").val();
		$.ajax({
			url:"./findMyPw",
			type: "post",
			data: {id:id, email:email},
			success: function(data){
				console.log(data);
				if(data==1){
					alert("이메일로 임시 비밀번호를 전송하였습니다")
					$("#pwResult").text("이메일로 임시 비밀번호를 전송하였습니다").css("color", "blue");
					}else{
						alert("비밀번호 찾기에 실패했습니다. 다시 시도해주세요")
						}
				
				}
			})
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
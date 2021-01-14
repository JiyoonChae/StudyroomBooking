<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확정  | StudyRoom Booking</title>
<link href="../css/common/subtitle.css" rel="stylesheet" type="text/css">
<link href="../css/res/resConfirm.css" rel="stylesheet" type="text/css">
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<!-- subTitle 부분 시작 -->
	<div class="subtitle">
		<ul class="title02">
			<h2>
				<span>studyㆍmeetㆍ work</span>
				<br>
				실시간 예약
			</h2>
		</ul>
	</div> <!-- subtitle end  -->
	
	<!-- 예약 확정 페이지 start ------------ -->
	<div class="contentbox">
		<div class="heading"><h3>예약 공간</h3>
			<span class="option"><strong class="price">1,500 원</strong>
			<em class="unit">/시간 (인)</em>
			</span>
		</div>
		<!--  이미지 뿌릴까말까,, 그럼 db에 저장해서 가져와야함. -->
		<div class="info_photo">
			<h4 class="rm_name">2-3인실 </h4>
			<span class="photo"><img ></span>
		</div>
		<div class="facility_wrap">
			<ul class="facility_list">
				<li>tv/ 프로젝터 </li>
				<li>화이트 보드</li>
				<li>인터넷/wifi</li>
			</ul>
		</div>
		
		<article>
			<div class="heading"><h3>예약 정보</h3></div>
			<div class="reserve-info">
				<p class="reserve-date">예약 번호
				<span class="details"> ${resInfo.revNum }</span>
				</p>
				<p class="reserve-date">예약 날짜
				<span class="details"> ${resInfo.roomDate}  ${resInfo.roomTime} 시간</span>
				</p>
				<p class="reserve-date">예약 인원
					<span class="details"> ${resInfo.roomUser} 인</span>
				</p>
			</div>
		</article>
		
		<article id="user_info">
			<div class="heading"><h3>예약자 정보</h3>
			
			</div>
			<div class="user-wrap">
				<dl class="flex_box">
					<dt class="flex tit">
						<label for="name">예약자</label>
					</dt>
					<dd class="flex">
						<input type="text" id="name" value="${member.name}" readonly="readonly">	
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="flex tit">
						<label for="phone">연락처</label>
					</dt>
					<dd class="flex">
						<input type="text" id="phone" value="${member.phone}" readonly="readonly">	
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="flex tit">
						<label for="email">이메일</label>
					</dt>
					<dd class="flex">
						<input type="text" id="email" value="${member.email }" readonly="readonly">	
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="flex tit">
						<label for="request">요청사항</label>
					</dt>
					<dd class="flex">
						<textarea name id="request" maxlength="500" placeholder="남기고 싶은 말을 적어주세요. (최대 500자)"></textarea>
						
					</dd>
				</dl>
			</div>
			
		</article>
		
		<!-- 결제 정보 start-->
			<article>
			<div class="heading"><h3>결제 정보</h3></div>
			<div class="reserve-info">
				<p class="reserve-date">결제 번호
				<span class="details"> ${pay.merchant_uid}</span>
				</p>
				<p class="reserve-date">결제 완료 금액
				<span class="details"> ${pay.paid_amount} 원</span>
				</p>
				<p class="reserve-date">결제 날짜
					<span class="details"> ${pay.orderDate}</span>
				</p>
			</div>
		</article>
		
		<!-- 결제정보 end -->
		<!-- 서비스 동의 -->
		
			<article data-v-85987b28="" id="service-agree" class="box_form box_notice error">
				<div data-v-85987b28="" class="heading"><h3 data-v-85987b28="">서비스 동의</h3> <span data-v-85987b28="" class="option"><input data-v-85987b28="" type="checkbox" id="terms_agree" class="checkbox"> <label data-v-85987b28="" for="terms_agree">전체 동의</label></span></div> <div data-v-85987b28="" class="list_wrap terms_wrap"><ul data-v-85987b28="" class="notice_list"><li data-v-85987b28=""><input data-v-85987b28="" type="checkbox" id="term1" class="checkbox"> <label data-v-85987b28="" for="term1">
                    위 공간의 예약조건 확인 및 결제진행 동의
                    <span data-v-85987b28="" class="txt_required">(필수)</span></label></li> <li data-v-85987b28=""><input data-v-85987b28="" type="checkbox" id="term2" class="checkbox"> <label data-v-85987b28="" for="term2">
                    환불규정 안내에 대한 동의
                    <span data-v-85987b28="" class="txt_required">(필수)</span></label></li> <li data-v-85987b28="" class=""><div data-v-85987b28="" class="confirm_box"><input data-v-85987b28="" type="checkbox" id="term3" class="checkbox"> <label data-v-85987b28="" for="term3">
                      개인정보 제3자 제공 동의
                      <span data-v-85987b28="" class="txt_required">(필수)</span></label> <a data-v-85987b28="" class="btn_view_terms"><span data-v-85987b28="" class="sp_icon ico_view_terms"><em data-v-85987b28="" class="blind">내용보기</em></span></a></div> <div data-v-85987b28="" tabindex="0" class="scroll_box"><div data-v-85987b28="" class="terms"><ol data-v-85987b28=""><li data-v-85987b28="">1. 개인정보를 제공받는 자: 해당 공간의 호스트</li> <li data-v-85987b28="">
                          2. 제공하는 개인정보 항목
                          <ul data-v-85987b28=""><li data-v-85987b28="">- 필수항목: 네이버 아이디, 이름, 연락처, 결제정보(결제방식 및 결제금액)</li> <li data-v-85987b28="">- 선택항목: 이메일 주소</li></ul></li> <li data-v-85987b28="">3. 개인정보의 제공목적: 공간예약 및 이용 서비스 제공, 환불처리</li> <li data-v-85987b28="">4. 개인정보의 제공기간: 서비스 제공기간(단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 및 사전 동의를 득한 경우에는 해당 기간 동안 보관합니다.)</li> <li data-v-85987b28="">5. 개인정보의 제공을 거부할 권리: 개인정보 주체는 개인정보의 제공을 거부할 권리가 있으나, 공간 예약을 위해 반드시 필요한 개인정보의 제공으로서 이를 거부할 시 공간 예약이 어려울 수 있습니다.</li></ol></div></div></li> <li data-v-85987b28="" class=""><div data-v-85987b28="" class="confirm_box"><input data-v-85987b28="" type="checkbox" name="terms" id="term4" class="checkbox"> <label data-v-85987b28="" for="term4">
                      개인정보 수집 및 이용 동의
                      <span data-v-85987b28="" class="txt_required">(필수)</span></label> <a data-v-85987b28="" class="btn_view_terms"><span data-v-85987b28="" class="sp_icon ico_view_terms"><em data-v-85987b28="" class="blind">내용보기</em></span></a></div> <div data-v-85987b28="" tabindex="0" class="scroll_box"><div data-v-85987b28="" class="terms"><ol data-v-85987b28=""><li data-v-85987b28="">
                          1. 수집하는 개인정보의 항목
                          <p data-v-85987b28="" class="sub_term"><em data-v-85987b28="">-</em> 예약정보(성명, 이메일주소, 휴대전화번호), 결제정보(신용카드 번호 및 은행계좌정보 일부 등)
                          </p></li> <li data-v-85987b28="">
                          2. 개인정보의 이용목적
                          <p data-v-85987b28="" class="sub_term"><em data-v-85987b28="">-</em> 공간 예약 및 이용
                          </p></li> <li data-v-85987b28="">
                          3. 개인정보의 보관기간
                          <p data-v-85987b28="" class="sub_term"><em data-v-85987b28="">-</em> 예약 완료 후 관련 법령에 따라 5년간 개인정보를 보관합니다.
                          </p></li> <li data-v-85987b28="">
                          4. 개인정보의 수집 및 이용을 거부할 권리
                          <p data-v-85987b28="" class="sub_term"><em data-v-85987b28="">-</em> 개인정보 주체는 개인정보의 수집 및 이용을 거부할 권리가 있으나, 공간 예약을 위한 최소한의 개인정보 수집으로서 이를 거부할 시 공간 예약이 어려울 수 있습니다.
                          </p></li></ol></div></div></li></ul></div>
             </article>
		
			<div>	
				<button class="btn btn-warning" id="confirm">확인</button>
				</div>
	</div> <!--  contentsbox 끝> -->
	
	
</body>
</html>
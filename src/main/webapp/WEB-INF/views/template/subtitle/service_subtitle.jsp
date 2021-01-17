<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="subtitle">
		<ul class="title02">
			<h2>
				<span>study ㆍ meet ㆍ work</span>
				<br>고객지원
			</h2>
		</ul>
	</div>
	<div class="subtap">
		<ul>
			<li class="notice">
				<a href="${pageContext.request.contextPath}/notice/noticeList?page=0&searchType=all&keyword=">공지사항</a>
			</li>
			<li class="faq">
				<a href="${pageContext.request.contextPath}/faq/faqList">FAQ</a>
			</li>
			<li class="qna">
				<a href="${pageContext.request.contextPath}/qna/qnaWrite">1:1문의</a>
			</li>
		</ul>
	</div>

	<script type="text/javascript">
		var path = window.location.pathname;
		path = path.substring(path.indexOf("/")+1, path.lastIndexOf("/"));
		
		$(".subtap li").each(function() {
			if(path.match($(this).attr("class"))) {
				$(this).addClass("tapon");
				$(this).children().css("color", "#fff");
			}
		});		
	</script>

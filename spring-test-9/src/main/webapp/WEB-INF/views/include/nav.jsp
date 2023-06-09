<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="#">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="#">상품 정보 등록</a></li>
		<li class="nav-item">
			<c:if test="${not empty userInfo}">
				<span>${userInfo.name}님 환영합니다.</span>
				<a href="${root}/user/logout">로그아웃</a>
			</c:if>
			<c:if test="${empty userInfo}">
				<form method="post" action="${root}/user/login">
					<input type="text" name="id" /> 
					<input type="password" name="password" />
					<button>login</button>
				</form>
			</c:if>
		</li>
	</ul>
</nav>
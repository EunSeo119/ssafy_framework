<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<h1>SSAFY Shop</h1>

<c:if test="${empty userInfo}">
	<form action="${root}/user/login" method="post">
		<input type="text" name="userId" />
		<input type="password" name="userPassword" />
		<button>login</button>
	</form>
</c:if>

<c:if test="${not empty userInfo}">
	<c:out value="${userInfo.userId} 님 반갑습니다."></c:out>
	<a href="${root}/user/logout">로그아웃</a>
</c:if>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/board/list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/board/regist">상품 정보 등록</a></li>
	</ul>
</nav>
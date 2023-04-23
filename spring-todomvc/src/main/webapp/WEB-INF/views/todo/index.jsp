<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<head>
		<meta charset="utf-8">
		<title>TodoMVC</title>
		<link rel="stylesheet" href="${root}/resources/css/todo/app.css">
		<link rel="stylesheet" href="${root}/resources/css/todo/base.css">
		<link rel="stylesheet" href="${root}/resources/css/todo/index.css">
	</head>
	<body>
		<section class="todoapp">
			<header class="header">
				<h1>오늘의 할일</h1>
				<c:if test="${not empty userInfo}">
					<span>${userInfo.name}님 환영합니다.</span>
					<a href="logout">로그아웃</a>
				</c:if>
				<c:if test="${empty userInfo}">
					<form method="post" action="login">
						<input type="text" name="id" /> 
						<input type="password" name="password" />
						<button>로그인</button>
					</form>
				</c:if>
			<c:if test="${not empty userInfo}">
				<form action="regist" method="post">
					<input type="text" class="new-todo" placeholder="오늘의 할일을 적으세요?"
						name="content" autofocus>
				</form>
			</c:if>	
			<c:if test="${empty userInfo}">
				<form action="regist" method="post">
					<input type="text" class="new-todo" placeholder="오늘의 할일을 적으세요?"
						name="content" readonly autofocus>
					<%-- <input type="hidden" name="userId" value="${userInfo.id}"/> --%>
				</form>
			</c:if>	
			</header>
			<section class="main">
				<ul class="todo-list">
				<c:forEach var="todo" items="${list}">
					<li>
						<div class="view">
							<label>${todo.content}</label>
							<c:if test="${not empty userInfo}">
								<a href="delete?no=${todo.no}&userId=${userInfo.id}" class="destroy"></a>
							</c:if>
						</div>
					</li>	
				</c:forEach>				
				</ul>
			</section>
			<footer class="footer">
				<span class="todo-count">전체 <strong>${list.size()}</strong>개</span>
				<c:if test="${not empty userInfo}">
					<a href="clear" class="clear-completed">전체 지우기</a>
				</c:if>
			</footer>
		</section>
	</body>
</body>
</html>






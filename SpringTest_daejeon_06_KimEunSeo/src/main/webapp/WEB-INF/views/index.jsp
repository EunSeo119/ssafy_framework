<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}

a {
	margin: 10px;
}

.inputtitle {
	display: inline-block;
	width: 80px;
}
</style>

<%-- <%@ include file="header.jsp" %> --%>
</head>
<body>
<c:set var="root" value="${pageContext.request.contextPath}"/>
	<h1>출결 관리</h1>
		<c:if test="${empty userInfo}">
			<fieldset>
				<h1>로그인 해주세요.</h1>
				<form method="post" action="${root}/user/login">
	
					<label for="userid" class="inputtitle">아이디</label>
					<input type="text" name="userid" id="userid" >
					<br>
					<label for="userpw" class="inputtitle">비밀번호</label>
					<input type="password" name="userpw" id="userpw">
					<br>
					<input type="submit" value="로그인">
				</form>
			</fieldset>
		</c:if>
	<hr>
	<h4>
		<a href="${root}/board/regist">출결 이슈 등록</a>
	</h4>
	<h4>
		<a href="${root}/board/list">출결 이슈 목록</a>
	</h4>

</body>
</html>
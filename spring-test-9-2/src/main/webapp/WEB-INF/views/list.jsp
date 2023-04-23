<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./include/head.jsp" %>
</head>
<body>
	<%@ include file="./include/nav.jsp" %>

	<table>
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>재고수량</th>
		</tr>
		
	<c:forEach var="item" items="${list}">
		<tr>
			<td>${item.code }</td>
			<td>${item.model }</td>
			<td>${item.price }</td>
		</tr>
	</c:forEach>
	</table>

<%@ include file="./include/footer.jsp" %>
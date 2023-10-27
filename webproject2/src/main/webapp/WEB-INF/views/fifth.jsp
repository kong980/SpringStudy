<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fifth.jsp</title>
</head>
<body>
	<h1>fifth.jsp</h1>
	<c:out value="HI!">Hello!</c:out>
	<br>
	<h3>좋아하는 음식</h3>
	<c:forEach var="i" items="${tang}">
		${i}<br>
	</c:forEach>
	
	<h3>좋아하는 과일</h3>
	${f1 },	${f2 },	${f3 }
	
	<h3>좋아하는 요일</h3>
	<!-- 각각 뿌리기 -->
	${day[0]},${day[1]},${day[2]},${day[3]}
	<br>
	<!-- 리스트로 돌리기 -->
	<c:forEach var="i" items="${day }">
		${i }
	</c:forEach>
	
</body>
</html>
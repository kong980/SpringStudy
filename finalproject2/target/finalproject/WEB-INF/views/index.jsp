<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!-- 여기서 어떻게 session값을 꺼내오는가? request객체를 이용해서 session값을 가지고온다.
	EL에서는 requestScope를 사용할 수 없다. 그럼 session값은 어떻게 가져오는가?
	대신, pageContext 사용이 가능하다. .getSession(false) == null 과 같다면 세션이 없단 이야기
	? 그렇다면 ''null값을 넣어주고 : 아니면 id값을 넣어줘야지
	request.getSession(false) -> 세션여부
	request.session.getAttribute('id') -> 세션 값을 꺼내옴	
 -->
 
<c:set var="loginId" value="${pageContext.request.getSession(false) == null ? '' : pageContext.request.session.getAttribute('id')}"/>

<!-- logout : loginId가 비어있으면, Login이라고 출력을 하고 아니면 ID 출력-->
<%-- <c:set var="loginOut" value="${loginId == '' ? 'Login' : 'ID = '+loginId}" /> --%>
<c:set var="loginOut" value="${loginId == '' ? 'Login' : loginId.toString()}"/>
<!-- 경로 -->
<c:set var="loginOutLink" value="${loginId == '' ? '/member/login' : '/member/logout'}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fastcampus</title>
<link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="<c:url value='/'/>">Home</a></li>
			<li><a href="<c:url value='/board/list'/>">Board</a></li>
			<li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
			<li><a href="<c:url value='/member/add'/>">Sign in</a></li>
			<li><a href=""><i class="fa fa-search"></i></a></li>
		</ul>
	</div>
	<div style="text-align: center">
		<h1>This is HOME</h1>
		<h1>This is HOME</h1>
		<h1>This is HOME</h1>
	</div>
</body>
</html>
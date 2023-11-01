<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_list</title>
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

	<h1>글 수정</h1>
	<form action="<c:url value='/board/update'/>" method="post">
	<input type="hidden" name="bNo" value="${board.bNo}" />
		제목 : <input type="text" name="bTitle" value="${board.bTitle}"><br>
		<br> 글쓴이 : <input type="text" name="bWriter"
			value="${board.bWriter}" readonly="readonly"><br>
		<br> 내용 :
		<textarea rows="5" , cols="50" name="bContent">${board.bContent}</textarea>
		<br>
		<br>
		<input type="submit" value="수정" />
	</form>
</body>
</html>
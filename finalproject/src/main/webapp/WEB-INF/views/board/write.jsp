<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_write</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form method="post" action="<c:url value='/board/write'/>">
		제목<br>
		<input type="text" name="bTitle"/><br><br> 
		글쓴이<br>
		<input type="text" name="bWriter"/><br><br> 
		내용<br>
		<textarea rows="5" cols="50" name="bContent"></textarea><br><br>
		<input type="submit" value="글쓰기" />
	</form>
</body>
</html>
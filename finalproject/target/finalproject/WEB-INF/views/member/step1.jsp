<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>약관</h2>
	<p>약관 내용</p>
	<form method="post" action="<c:url value='/member/step2'/>">
		<label> <input type="checkbox" name="agree" value="true" />
			약관 동의
		</label> <input type="submit" value="다음 단계" />
	</form>
</body>
</html>
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

	<h2>���</h2>
	<p>��� ����</p>
	<form method="post" action="<c:url value='/member/step2'/>">
		<label> <input type="checkbox" name="agree" value="true" />
			��� ����
		</label> <input type="submit" value="���� �ܰ�" />
	</form>
</body>
</html>
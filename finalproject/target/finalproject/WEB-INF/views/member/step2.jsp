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
	<h2>ȸ�� ���� �Է�</h2>
	<form action="<c:url value='/member/step3'/>" method="post">
		<p>
			<label>�̸���:<br> <input type="text" name="email"
				id="email" />
			</label>
		</p>
		<p>
			<label>�̸�:<br> <input type="text" name="name" id="name" />
			</label>
		</p>
		<p>
			<label>�н�����:<br> <input type="password" name="password"
				id="password" />
			</label>
		</p>
		<p>
			<label>�н����� Ȯ��:<br> <input type="password"
				name="confirmPassword" id="confirmPassword" />
			</label>
		</p>
		<input type="submit" value="���� �Ϸ�" class="btn btn-primary" />
	</form>
</body>
</html>
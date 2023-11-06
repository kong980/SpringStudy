<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
	<title></title>
	<link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
	<style>
		* { box-sizing:border-box; }
		a { text-decoration: none; }
		form {
			width:400px;
			height:500px;
			display : flex;
			flex-direction: column;
			align-items:center;
			position : absolute;
			top:50%;
			left:50%;
			transform: translate(-50%, -50%) ;
			border: 1px solid rgb(89,117,196);
			border-radius: 10px;
		}
		input[type='text'], input[type='password'] {
			width: 300px;
			height: 40px;
			border : 1px solid rgb(89,117,196);
			border-radius:5px;
			padding: 0 10px;
			margin-bottom: 10px;
		}
		button {
			background-color: rgb(89,117,196);
			color : white;
			width:300px;
			height:50px;
			font-size: 17px;
			border : none;
			border-radius: 5px;
			margin : 20px 0 30px 0;
		}
		#title {
			font-size : 50px;
			margin: 40px 0 30px 0;
		}
		#msg {
			height: 30px;
			text-align:center;
			font-size:16px;
			color:red;
			margin-bottom: 20px;
		}
	</style>
</head>
<body>
<div id="menu">
	<ul>
		<li id="logo">fastcampus</li>
		<li><a href="<c:url value='/'/>">Home</a></li>
		<li><a href="<c:url value='/board/list'/>">Board</a></li>
		<li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
		<li><a href="<c:url value='/member/add'/>">Sign in</a></li>
		<li><a href=""><i class="fa fa-search"></i></a></li>
	</ul>
</div>
<form action="<c:url value="/member/login"/>" method="post" onsubmit="return formCheck(this);">
	<h3 id="title">Login</h3>
	<div id="msg">
		<c:if test="${not empty param.msg}"> <!-- param.msg 값이 비어있지 않다면 -->
			<i class="fa fa-exclamation-circle"> <%--${URLDecoder.decode(param.msg)}</i>  --%><!-- (param.msg)를 출력해라 -->
			${param.msg}</i>
		</c:if>	
	</div>
	<input type="text" name="id" value="${cookie.id.value}" placeholder="이메일 입력" autofocus required="required">
	<input type="password" name="pwd" placeholder="비밀번호">
	<input type="hidden" name="toURL" value="${param.toURL}">
	<button>로그인</button>
	<div>
		<label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}> 아이디 기억</label> |
		<a href="">비밀번호 찾기</a> |
		<a href="">회원가입</a>
	</div>
	<script>
		function formCheck(frm) {
			let msg ='';
			if(frm.id.value.length==0) {
				setMessage('id를 입력해주세요.', frm.id);
				return false;
			}
			if(frm.pwd.value.length==0) {
				setMessage('password를 입력해주세요.', frm.pwd);
				return false;
			}
			return true;
		}
		function setMessage(msg, element){
			document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
			if(element) {
				element.select();
			}
		}
	</script>
</form>
</body>
</html>
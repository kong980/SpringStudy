<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<body>
	<h2>Hello World!</h2>
	<ul>
		<li><a href="/first">first.jsp를 보여주세요</a></li>
		<li><a href="/second?p1=apple&p2=grape">second.jsp에 요청</a></li>
	</ul>
	<br>
	<h3>third.jsp</h3>
	<br>
	<form method="post" action="/third">
		name: <input type="text" name="name" /><br>
		age: <input type="text" name="age" /><br>
		point: <input type="text" name="point" /><br>
		<input type="submit" value="전송" /><br>
	</form>
	<br>
	<h3>fourth.jsp</h3>
	<br>
	<form method="get" action="/fourth">
		name: <input type="text" name="name" /><br>
		age: <input type="text" name="age" /><br>
		point: <input type="text" name="point" /><br>
		<!-- dto에 없는 값은 어떻게 전달해야하는가? -->
		chk: <input type="checkbox" name="chk" value="check"/>동의 여부<br>
		<input type="submit" value="전송" /><br>
	</form>
	<br>
	<h3>fifth.jsp</h3>
	<br>
	<a href="/fifth">다섯번째 요청</a>
</body>
</html>

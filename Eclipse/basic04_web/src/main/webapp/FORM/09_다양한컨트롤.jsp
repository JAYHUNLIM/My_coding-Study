<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다양한 컨트롤</title>
</head>
<body>
<h3> *다양한 컨트롤 연습* </h3>
<form method="post" action="09_ok.jsp">
	아이디: <input type="text" name="uid">
	<hr>
	비번: <input type="password" name="upw">
	<hr>
	이름: <input type="text" name="uname">
	<hr>
	내용: <textarea rows="5" cols="20" name="content"></textarea>
	<hr>
	숫자1: <input type="text" name="num"><br>
	숫자2: <input type="text" name="num"><br>
	숫자3: <input type="text" name="num"><br>
	
	성별:
	<input type="radio" name="gender" value="M">남
	<input type="radio" name="gender" value="F">여
	<hr>
	약관동의:
	<input type="checkbox" name="agree" value="Y">
	<hr>
	SMS: <input type="checkbox" name="sms">
	<hr>
	통신회사: <select name="telecom">
		<option value="sk">SK
		<option value="lg">LG
		<option value="ktf">KTF
	</select>
	<hr>
	<!--폼 컨트롤 요소이지만 본문에 출력은 안되는 요소  -->
	<input type="hidden" name="page" value="5">
	
	<hr>
	첨부파일: <input type="file" name="attach">
	<!-- 파일을 첨부해서 서버에 전송하려면 
	<form enctype="multipart/form-data">속성이 추가되어야 한다
	-->
	<hr>
	<input type="submit" value="전송">
</form>
</body>
</html>
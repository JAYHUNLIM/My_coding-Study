<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<h3> 글쓰기 결과</h3>
작성자:${requestScope.wname} <br>
제목:${requestScope.subject}<br>
내용:${requestScope.content}<br>
비밀번호:${requestScope.passwd}
<hr>

작성자:${wname}<br>
제목:${subject}<br>
내용:${content}<br>
비밀번호:${passwd}<br>

</body>
</html>
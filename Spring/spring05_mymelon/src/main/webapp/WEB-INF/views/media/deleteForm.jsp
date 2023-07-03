<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm</title>
<style>
* {
	font-family: gulim;
	font-size: 25px;
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="title">미디어 삭제</div>
<form action="delete.do" name="frm" method="post">
<input type="hidden" name="mediano" value="${requestScope.mediano}">

<div class="content">
<p>미디어 삭제할까요?</p>
<p> 관련 미디어 파일(mp3,mp4)도 전부 삭제됩니다</p>
</div>

<div class="bottom">
<input type="submit" value="삭제">
<input type="button" value="목록" onclick="location.href='/home.do'">
</div>


</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>msgView</title>
<style>
* {
	font-family: gulim;
	font-size: 25px;
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="title">MP4 듣기</div>
<div class="content">
<p><strong>${dto.title}</strong></p>
<img src="../storage/${dto.poster}" width="400px"><br>
<video src="../storage/${dto.filename}" autoplay="autoplay"></video>

</div>

<div class="bottom">
<input type="button" value="음원목록" onclick="location.href='list.do?mediagroupno=${dto.mediagroupno}'">
<input type="button" value="HOME" onclick="location.href='/home.do'">
</div>


</body>
</html>
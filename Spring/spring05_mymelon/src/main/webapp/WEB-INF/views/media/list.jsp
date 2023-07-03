<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<style>
* {
	font-family: gulim;
	font-size: 25px;
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="title">음원 목록</div>
<div class="content">
<input type="button" class="btn btn-secondary" value="음원등록" onclick="location.href='create.do?mediagroupno=${requestScope.mediagroupno}'">
<input type="button" class="btn btn-info" value="HOME" onclick="location.href='/home.do'">
<!-- 절대경로 -->
</div>
<table class="table">

<tr>
<th>번호</th>
<th>제목</th>
<th>등록일</th>
<th>음원파일명</th>
<th>수정/삭제</th>

</tr>


<c:forEach var="dto" items="${list}">
<tr>
<td>${dto.mediano}</td>
<td><a href="read.do?mediano=${dto.mediano}">${dto.title}</a></td>
<td>${dto.rdate}</td>
<td>
${dto.filename}  <br>
${dto.filesize}<br>
<c:set var="filesize" value="${fn:substringBefore(dto.filesize/1024, '.')}"></c:set>
 ${filesize}KB
</td>
<td>
 
<input type="button"  class="btn btn-primary" value="수정" onclick="location.href='update.do?mediano=${dto.mediano}'">
<input type="button" class="btn btn-warning" value="삭제" onclick="location.href='delete.do?mediano=${dto.mediano}'">
</td>

</tr>
</c:forEach>
</table>

</body>
</html>
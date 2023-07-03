<%@page import="kr.co.web.bbs.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
<br>
<h3> 글쓰기 결과</h3>

1.JSP
<hr>

<%
BbsDTO bdto=(BbsDTO)request.getAttribute("dto");
out.println("작성자:"+bdto.getWname()+"<br>");
out.println("제목:"+bdto.getSubject()+"<br>");
out.println("내용:"+bdto.getContent()+"<br>");
out.println("비밀번호:"+bdto.getPasswd()+"<br>");
%>
<hr>

2.EL
<hr>
<!--BbsDTO클래스에 반드시 GETTER SETTE함수가 존재해야 한다  -->
작성자:${dto.wname}<br>
제목:${dto.subject}<br>
내용:${dto.content}<br>
비번:${dto.passwd}

</body>
</html>
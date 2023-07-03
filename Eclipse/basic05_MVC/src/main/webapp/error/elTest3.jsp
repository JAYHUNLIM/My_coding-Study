<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>elTest3</title>
</head>
<body>
<h3> EL 내장객체</h3>
<%
	//1.JSP 내장객체
	//->pageContext,request,session,application
	
	//내부변수 선언 
	pageContext.setAttribute("kor",1000);//현재 페이지에서만 유효
	request.setAttribute("eng",1000);	//전역변수 
	session.setAttribute("mat",1000);	 //전역변수 모든페이지,시간
	application.setAttribute("sta",1000); //전역변수 모든페이지 
	%>
	
	1.JSP<hr>
	kor: <%=pageContext.getAttribute("kor")%><hr>
	eng:<%=request.getAttribute("eng")%>	<hr> 
	mat: <%=session.getAttribute("mat")%>	 <hr>
	sta: <%=application.getAttribute("sta")%> <hr> 
<% 
	//2.EL 내장객체(COLLECTION)
	// param,pageScope, requestScope, sessionScope, applicatinScope
	
	
	%>
	2.EL
	<hr>
	kor: ${pageScope.kor}
	eng: ${requestScope.eng}
	mat: ${sessionScope.mat}
	sta: ${applicationScope.sta}
	
	<hr>
	EL에서는 내장객체명을 생략할수 있다.
	<!-- page-> request-> session-> application순으로 자동 검색 -->
	<hr>
	kor: ${kor}
	eng: ${eng}
	mat: ${mat}
	sta: ${sta}
	<hr>
<!-- 각 Scope에 내장 변수명이 동일한 경우  -->	
<%
 pageContext.setAttribute("num", 500);
 request.setAttribute("num", 600);
 session.setAttribute("num", 700);
 application.setAttribute("num", 800);
 
 
%>	
num: ${num}	
<!--결과값 500
	내장 객체명이 생략되면 자동으로 작은 영역순으로 찾게 된다 -->	
<hr>	
<!-- 각 Scope의 내장 변수가 없는 경우  -->	
JSP:<%=request.getAttribute("uname")%>
<!--NULL-->
<hr>
EL:@${requestScope.uname}@
<!--빈 문자열-->	
</body>
</html>
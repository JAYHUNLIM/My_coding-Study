<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginResult</title>
</head>
<body>
<h3>회원 로그인 결과</h3>
1.JSP
<br>
아이디 :<%=session.getAttribute("s_uid") %><br>
비번 :<%=session.getAttribute("s_upw")%><br>

아이디 :<%=application.getAttribute("a_uid") %><br>
비번 :<%=application.getAttribute("a_upw")%><br>

아이디 :<%=request.getAttribute("r_uid") %><br>
비번 :<%=request.getAttribute("r_upw")%>
<hr>
 <%=request.getAttribute("msg") %><br>
 <%=request.getAttribute("img") %>
<hr> 
 2.표현언어 EL(EXPRESSION LANGUAGE)<br>
 아이디 : ${sessionScope.s_uid}<br>
 비번	:	${sessionScope.s_upw}<br>
 
 아이디 : ${applicationScope.a_uid}<br>
 비번	:	${applicationScope.a_upw}<br>
 
 아이디 : ${requestScope.r_uid}<br>
 비번	:	${requestScope.r_upw}<br>
 
 ${requestScope.msg}<br>
 ${requestScope.img}<br>
 <hr>
 <!--SCOPE는 생략 가능하다
 	ServletContext 순환순서 : pageContext-> request-> session-> application  -->
 3. Scope 생략<br>
 아이디:${s_uid}<br> 비번 :${s_upw}<br>
 아이디:${a_uid} <br>비번 :${a_upw}<br>
 아이디:${r_uid}<br> 비번 :${r_upw}<br>
<hr>
${msg} <br>
${img} 
 <hr>
</body>
</html>
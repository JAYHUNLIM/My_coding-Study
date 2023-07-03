<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP와 EL값 공유</title>
</head>
<body>
<h3>JSP와 EL값 공유</h3>
<%

//JSP와 EL은 현재 페이지에서는 서로 값을 공유할수없다
String uname="itwill";
%>
	이름(jsp):<%=uname%><hr> <!--itwill -->
	이름(el): ${uname}		<!--빈문자열 -->
<br>	
<hr>
<%
//현재 페이지에서  JSP와 EL이 서로 값을 공유하기 위해서는 pageScope를 활용한다
 pageContext.setAttribute("uid","korea");

%>
	아이디(JSP):<%=pageContext.getAttribute("uid")%> <!--korea  -->
	아이디(EL):${pageScope.uid} <!--korea  -->
	아이디(EL):${uid} <!--korea  -->
	
	
	
</body>
</html>
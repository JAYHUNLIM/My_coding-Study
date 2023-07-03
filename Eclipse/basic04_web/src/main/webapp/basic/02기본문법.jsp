<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02 기본문법</title>
</head>
<body>
<%
%>
<h3>기본문법</h3>
<hr>
<h4>대한민국</h4>
<hr>
1+2+3
<hr> 
<%
	//한줄 주석
	/*여러줄 주석  */
	/*
	스크립트릿(Scriptlet)
   - 일반적인 JAVA, JSP코드를 작성한다.
   - 메소드는 작성불가
   - TOMCAT WAS에 의해 JSP코드가 해석되고 결과값을 HTML문서로
   변환해서 FRONTEND단으로 응답해준다
	
	*/
	out.print("무궁화");
	out.print(123+456);
	out.print(5+7);
	out.print(8.9);
	out.print('X');
	
	/*
		http://localhost:9090/basic04_web/basic/02기본문법.jsp
		-http://  		프로토콜
	    -localhost:9090  내컴퓨터 포트번호
	    -basic04_web		Context root 프로젝트명
	    -basic/02기본문법.jsp  경로명 및 파일명
	    
	    Context root 가상의 경로: basic04_web
	    basic04_web의 실제 물리적 경로는 외부에서 접근 불가능
	    프로젝트명 basic04_web으로 접근해야 한다
	    http://localhost:9090/src/main/webapp/basic/02_JSP기본문법.jsp
	    
	    
	*/
	
	//HTML 태그를 JSP에서 사용하는 경우 "" 안에서 작성
	out.print("<h1>악마</h1>");
	out.print("<img src='../images/devil.png'>");
	out.print("<hr>");
%>

<%-- 
<% 	out.println("<style>.txt{color:red}</style>");
 	out.println("<span class=txt>오필승코리아</span>");
%>
 --%>
 
</body>
</html>
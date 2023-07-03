<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10_ok</title>
</head>
<body>
<%

//1.한글 인코딩
request.setCharacterEncoding("UTF-8");

//2.사용자가 입력한 정보를 가져오기
out.print(request.getParameter("uid"));
out.print("<hr>");

//3.요청한 사용자의 다양한 정보
out.print(request.getRemoteAddr());	//사용자 pc의 ip주소
out.print("<hr>");
out.print(request.getRemoteHost());	
out.print("<hr>");
out.print(request.getRemotePort());	
out.print("<hr>");
///////////////////////////////////////

out.print(request.getContextPath());	//	/basic04_web 해당 프로젝트이름
out.print("<hr>");

out.print(request.getRequestURL());		// http://localhost:9090/basic04_web/FORM/10_ok.jsp 
out.print("<hr>");						//사용자가 요청한 전체 경로의 페이지명 또는 명령어

out.print(request.getRequestURI());		// 	/basic04_web/FORM/10_ok.jsp
out.print("<hr>");						//사용자가 요청한 페이지명 또는 명령어
///////////////////////////////////////

//내부변수
//request.setAttribute("변수명","값");
//request.getAttribute("변수명");
request.setAttribute("user","KOREA");
out.print(request.getAttribute("user"));
Object obj =request.getAttribute("user");
String str= (String)obj;
out.print(str);
out.print("<hr>");
///////////////////////////

//내 컴퓨터입장에서 /images폴더의 실제 물리적 경로
out.print(application.getRealPath("/images"));
out.print("<hr>");
/*
아래 경로는 이클립스에서 톰캣서버를 실행한 경우
D:\202301\workspace
			 \.metadata
			  \.plugins
			  \org.eclipse.wst.server.core
			   \tmp1
			   \wtpwebapps
			   \basic04_web
			   \images
*/

%>
</body>
</html>
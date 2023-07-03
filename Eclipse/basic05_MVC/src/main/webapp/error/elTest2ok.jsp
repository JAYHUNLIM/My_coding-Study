<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>elTest2ok.jsp</title>
</head>
<body>
 <h3> 결과 페이지</h3>
 
 1.JSP 방식
  아이디:<%=request.getParameter("id")%>
  비번:<%=request.getParameter("pw")%>
 <hr> 
 2.EL 방식
  아이디: ${param.id}
  비번 : ${param.pw}
 
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>elTest2ok.jsp</title>
</head>
<body>
 <h3> ��� ������</h3>
 
 1.JSP ���
  ���̵�:<%=request.getParameter("id")%>
  ���:<%=request.getParameter("pw")%>
 <hr> 
 2.EL ���
  ���̵�: ${param.id}
  ��� : ${param.pw}
 
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="calc" class="net.testbean.Calcbean" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>절대값 팩토리얼 구하기</title>
</head>
<body>
<%
int num=Integer.parseInt(request.getParameter("num").trim());
out.print(calc.abs(num));
out.print("<hr>");

out.print(calc.fact(num));
out.print("<hr>");

	
%>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>computeok1</title>
</head>
<body>
<h3>계산결과</h3>
<h4>메소드 호출</h4>
<%
int num1=Integer.parseInt(request.getParameter("num1").trim());
int num2=Integer.parseInt(request.getParameter("num2").trim());

out.print(num1+"+" +num2 +"="+add(num1,num2));
out.print("<hr>");
out.print(num1+"-" +num2 +"="+sub(num1,num2));
out.print("<hr>");
out.print(num1+"*" +num2 +"="+mul(num1,num2));
out.print("<hr>");
out.print(num1+"/" +num2 +"="+div(num1,num2));
out.print("<hr>");
out.print(num1+"%" +num2 +"="+mod(num1,num2));
out.print("<hr>");

%>

<%!
//jsp 작성 영역
public int add(int a, int b){return a+b;}
public int sub(int a, int b){return a-b;}
public int mul(int a, int b){return a*b;}
public int div(int a, int b){return a/b;}
public int mod(int a, int b){return a%b;}
%>

</body>
</html>
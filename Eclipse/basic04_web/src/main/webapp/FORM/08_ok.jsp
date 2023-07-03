<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>08_ok.jsp</title>
</head>
<body>
<h3>계산 결과</h3>
<% 
//한글 인코딩 
request.setCharacterEncoding("utf-8");
int num1=Integer.parseInt(request.getParameter("num1").trim());
int num2=Integer.parseInt(request.getParameter("num2").trim());
String op=request.getParameter("op").trim();

int res1=0; //정수형 계산 결과
double res2=0.0;
if(op.equals("+")){
	res1=num1+num2;
}else if(op.equals("-")){
	res1=num1-num2;
}else if(op.equals("/")){
	res2=(double)num1/num2;
}else if(op.equals("*")){	
	res1=num1*num2;
}else if(op.equals("%")){
	res1=num1%num2;
}
%>
<table class="table table-striped">
<tr>
<td><%=num1%></td>
<td><%=op%></td>
<td><%=num2%></td>
<td>=</td>
<td>
<%
if(op.equals("/")){
	out.print(String.format("%.1f", res2));
}else{
	out.print(res1);
}


%>
</td>
</tr>
</table>

<%-- <% 
if(op.equals("+")){%>
<%=num1%> + <%=num2%> = <%=hap%>

<%} else if(op.equals("-")){%>
<%=num1%> - <%=num2%> = <%=minus%>	
<%}else if(op.equals("*")){%>

<%=num1%> * <%=num2%> = <%=gop%>	

<%}else if(op.equals("/")){%>
<%=num1%> / <%=num2%> = <%=nanum%>

<%}else if(op.equals("%")){
%>	
<%=num1%> % <%=num2%> = <%=num1%num2%>

<%} %> --%>
</body>
</html>
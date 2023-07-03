<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="ssi.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukList</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h3>성적 목록</h3>
<p><a href="sungjukForm.jsp">성적쓰기</a></p>
<table class="table">
<tr class="info" >
<th>이름</th>
<th>국어</th>
<th>영어</th>
<th>수학</th>
<th>등록일</th>
</tr>
<%
ArrayList<SungjukDTO> list = dao.list();
if(list==null){
	out.println("<tr>");
	out.println("<td colspan='5'>글없음</td>" );
	out.println("<tr>");
}else{
	for(int i=0;i<list.size();i++){
	dto=list.get(i);
	%>
	
	<tr>
		<td><a href="sungjukRead.jsp?sno=<%=dto.getSno()%>"> <%=dto.getUname() %></a></td>
		<td><%=dto.getKor() %></td>
		<td><%=dto.getEng() %></td>
		<td><%=dto.getMat() %></td>
		<td><%=dto.getWdate().substring(0,10) %></td>
	</tr>
	
	
	
	
	<%
	
}
}

%>
</table>

</body>
</html>
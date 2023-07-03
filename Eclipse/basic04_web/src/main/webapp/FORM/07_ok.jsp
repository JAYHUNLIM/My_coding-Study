<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>07_ok</title>
</head>
<body>
<h3>성적 결과</h3>
<%
	//request 내장 객체
	//-> 사용자가 요청한 모든 정보 
	//request.getParameter(""); 메소드
	//사용자가 입력한 정보를 개별적으로 가져올때
	//	request.getParameter("uname") 사용자가 입력한 uname값 가져온다
	/* 
	out.print(request.getParameter("uname"));
	out.print("<hr>");
	out.print(request.getParameter("kor"));
	out.print("<hr>");
	out.print(request.getParameter("eng"));
	out.print("<hr>");
	out.print(request.getParameter("mat")); */
	
	//METHOD=POST 간혹 한글이 깨지는 현상이 발생 
	// 한글 인코딩
	request.setCharacterEncoding("UTF-8");//조합형
	//request.setCharacterEncoding("EUC-KR");//완성형
	
	//사용자가 입력 요청한 정보를 개별적으로 가져오기
	String uname=request.getParameter("uname").trim();
	int kor=Integer.parseInt(request.getParameter("kor").trim());
	int eng=Integer.parseInt(request.getParameter("eng").trim());
	int mat=Integer.parseInt(request.getParameter("mat").trim());
	int aver=(kor+eng+mat)/3;
	
%>
<!--성적 결과 테이블 출력  -->
<table class="table table-bordered border-primary">
<tr>
<th class="success">이름</th>
<td><%=uname%></td>
</tr>

<tr>
<th class="success">국어</th>
<td><%=kor%></td>
</tr>

<tr>
<th class="success">영어</th>
<td><%=eng%></td>
</tr>

<tr>
<th class="success">수학</th>
<td><%=mat%></td>
</tr>
<tr class="active">
<th>평균</th>
<td><%=aver%></td>
</tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukDel</title>
</head>
<body>
<h3>성적삭제</h3>
<p>
<a href="sungjukForm.jsp">성적쓰기</a>
<a href="sungjukList.jsp">성적목록</a>
</p>

<%
 int sno= Integer.parseInt(request.getParameter("sno"));
 int cnt=dao.delete(sno);
 
 if(cnt==0){
		out.println("<p>성적입력이 실패</p>");
		out.println("<p><a href='javascript:history.back()'>다시시도</a></p>");
	}else{
		out.println("<script>");
		out.println("    alert('성적삭제 성공');");
		out.println(" location.href='sungjukList.jsp';");	//목록페이지 이동
		out.println("</script>");
	}
	

%>
</body>
</html>
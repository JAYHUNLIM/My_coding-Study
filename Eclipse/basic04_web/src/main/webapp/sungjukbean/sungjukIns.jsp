<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="net.sungjuk.*" %>
<jsp:useBean id="dao" class="net.sungjuk.SungjukDAO" scope="page"></jsp:useBean>
<jsp:useBean id="dto" class="net.sungjuk.SungjukDTO" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukIns</title>
</head>
<body>
<h3>성적 결과 페이지</h3>

<%
request.setCharacterEncoding("UTF-8");

String uname=request.getParameter("uname");
int kor=Integer.parseInt(request.getParameter("kor").trim());
int eng=Integer.parseInt(request.getParameter("eng").trim());
int mat=Integer.parseInt(request.getParameter("mat").trim());
String addr=request.getParameter("addr");

int aver=(kor+eng+mat)/3;
/* 1.DTO 객체를 사용하기 전  
int cnt = dao.insert(uname, kor, eng, mat, aver, addr);
*/

/* 2.DTO 객체를 사용하는 경우
//전달 값을 모두 DTO 객체에 담음
*/
dto.setUname(uname);
dto.setKor(kor);
dto.setEng(eng);
dto.setMat(mat);
dto.setAver(aver);
dto.setAddr(addr);

int cnt=dao.create(dto);



if(cnt==0){
	out.println("<p>성적입력이 실패</p>");
	out.println("<p><a href='javascript:history.back()'>재시도</a></p>");
}else{
	out.println("<script>");
	out.println("    alert('성적입력 성공');");
	out.println(" location.href='sungjukList.jsp';");	//목록페이지 이동
	out.println("</script>");
}




%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukUpdateProc</title>
</head>
<body>

<%
//값을 받아오기
	int sno = Integer.parseInt(request.getParameter("sno"));
	String uname = request.getParameter("uname");
	int kor = Integer.parseInt(request.getParameter("kor").trim());
	int eng = Integer.parseInt(request.getParameter("eng").trim());
	int mat = Integer.parseInt(request.getParameter("mat").trim());
	String addr = request.getParameter("addr");
	int aver = (kor + eng + mat) / 3;

	dto.setUname(uname);
	dto.setKor(kor);
	dto.setEng(eng);
	dto.setMat(mat);
	dto.setAver(aver);
	dto.setAddr(addr);
	dto.setSno(sno);

	int cnt=dao.update(dto);

	if (cnt == 0) {
		out.println("<p>성적수정 실패</p>");
		out.println("<p><a href='javascript:history.back()'>재시도</a></p>");
	} else {
		out.println("<script>");
		out.println("    alert('성적수정 성공');");
		out.println(" location.href='sungjukList.jsp';"); //목록페이지 이동
		out.println("</script>");
	}
	%>
</body>
</html>
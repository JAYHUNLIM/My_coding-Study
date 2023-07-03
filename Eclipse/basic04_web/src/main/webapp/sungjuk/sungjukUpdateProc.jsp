<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>sungjukUpdateProc</title>
</head>
<body>
<h3>성적수정결과</h3>
<p>
<a href="sungjukForm.jsp">성적쓰기</a>
<a href="sungjukList.jsp">성적목록</a>
</p>
<%

int sno= Integer.parseInt(request.getParameter("sno"));

request.setCharacterEncoding("UTF-8");
String uname=request.getParameter("uname");
int kor=Integer.parseInt(request.getParameter("kor").trim());
int eng=Integer.parseInt(request.getParameter("eng").trim());
int mat=Integer.parseInt(request.getParameter("mat").trim());
String addr=request.getParameter("addr");
int aver=(kor+eng+mat)/3;


Connection con=null;
PreparedStatement pstmt=null;


try{
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	String driver ="oracle.jdbc.driver.OracleDriver"; 
	Class.forName(driver);
	con= DriverManager.getConnection(url, user, password);

	StringBuilder sql=new StringBuilder();
	
	sql.append(" update sungjuk ");
	sql.append(" set uname=?,kor=?,eng=?,mat=?,aver=?,addr=?,wdate=sysdate ");
	sql.append(" where sno=? ");
	
	pstmt= con.prepareStatement(sql.toString());
	pstmt.setString(1,uname);
	pstmt.setInt(2,kor);
	pstmt.setInt(3,eng);
	pstmt.setInt(4,mat);
	pstmt.setInt(5,aver);
	pstmt.setString(6,addr);
	pstmt.setInt(7,sno);
	
	int cnt=pstmt.executeUpdate();
	if(cnt==0){
		out.println("<p>성적수정 실패</p>");
		out.println("<p><a href='javascript:history.back()'>재시도</a></p>");
	}else{
		out.println("<script>");
		out.println("    alert('성적수정 성공');");
		out.println(" location.href='sungjukList.jsp';");	//목록페이지 이동
		out.println("</script>");
	}
	
}catch(Exception e){
	out.println("오라클 연결 실패"+e);
	
}finally{
	
	try{
		if(pstmt!=null){
			pstmt.close();
		}
	}catch(Exception e){}
	
	try{
		if(con!=null){
			con.close();}
	}catch(Exception e){}
		
}
%>
</body>
</html>
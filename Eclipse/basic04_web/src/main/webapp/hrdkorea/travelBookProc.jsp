<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelBookProc</title>
</head>
<body>
<% 

//한글 인코딩
request.setCharacterEncoding("UTF-8");

String rno=request.getParameter("rno").trim();
String tcode=request.getParameter("tcode").trim();
String rjumin=request.getParameter("rjumin1").trim()+request.getParameter("rjumin2").trim();
String rname=request.getParameter("rname").trim();
String rphone1=request.getParameter("rphone1").trim();
String rphone2=request.getParameter("rphone2").trim();
String rphone3=request.getParameter("rphone3").trim();
String remail=request.getParameter("remail").trim();
String rstat=request.getParameter("rstat").trim();


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
	
	sql.append(" insert into tbl_reserve_01(rno,rjumin,rname,rphone1,rphone2,rphone3,remail,rstat,tcode) ");
	sql.append(" values(?,?,?,?,?,?,?,?,?)");
	
	pstmt=con.prepareStatement(sql.toString());
	pstmt.setString(1,rno);
	pstmt.setString(2, rjumin);
	pstmt.setString(3, rname);
	pstmt.setString(4, rphone1);
	pstmt.setString(5, rphone2);
	pstmt.setString(6, rphone3);
	pstmt.setString(7, remail);
	pstmt.setString(8, rstat);
	pstmt.setString(9, tcode);
	
	int cnt=pstmt.executeUpdate();
	if(cnt==0){
		out.println("<p>예약 실패</p>");
		out.println("<p><a href='javascript:history.back()'>재시도</a></p>");
	}else{
		out.println("<script>");
		out.println("    alert('예약 성공');");
		out.println(" location.href='travelList.jsp';");	//목록페이지 이동
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
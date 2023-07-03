<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String rno = request.getParameter("rno");

request.setCharacterEncoding("UTF-8");
String rname=request.getParameter("rname").trim();
String rjumin1=request.getParameter("rjumin1").trim();
String rjumin2=request.getParameter("rjumin2").trim();
String rjumin= rjumin1+rjumin2;

String rphone1=request.getParameter("rphone1").trim();
String rphone2=request.getParameter("rphone2").trim();
String rphone3=request.getParameter("rphone3").trim();

String rphone = rphone1+rphone2+rphone3;

String remail =request.getParameter("remail").trim();
String rstat=request.getParameter("rstat").trim();
String tcode=request. getParameter("tcode").trim();

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
	
	sql.append(" update tbl_reserve_01 ");
	sql.append(" set rname=?,rjumin=?,rphone1=?,rphone2=?,rphone3=?,remail=?,rstat=?,tcode=? ");
	sql.append(" where rno=? ");
	
	pstmt= con.prepareStatement(sql.toString());
	pstmt.setString(1,rname);
	pstmt.setString(2,rjumin);
	pstmt.setString(3,rphone1);
	pstmt.setString(4,rphone2);
	pstmt.setString(5,rphone3);
	pstmt.setString(6,remail);
	pstmt.setString(7,rstat);
	pstmt.setString(8,tcode);
	pstmt.setString(9, rno);
	
	int cnt=pstmt.executeUpdate();
	
	if(cnt==0){
		out.println("<p>예약 수정 실패</p>");
		out.println("<p><a href='javascript:history.back()'>재시도</a></p>");
	}else{
		out.println("<script>");
		out.println("    alert('예약수정 성공');");
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
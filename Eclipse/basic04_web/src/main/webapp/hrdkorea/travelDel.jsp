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

//sno값을 가져옴
String rno= request.getParameter("rno");

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
	sql.append(" Delete from tbl_reserve_01 ");
	sql.append(" where rno=? ");

	pstmt=con.prepareStatement(sql.toString());
	pstmt.setString(1, rno);
	
	int cnt=pstmt.executeUpdate();
	
	if(cnt==0){
		out.println("<p>삭제 실패</p>");
		out.println("<p><a href='javascript:history.back()'>다시시도</a></p>");
	}else{
		out.println("<script>");
		out.println("    alert('예약삭제 성공');");
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
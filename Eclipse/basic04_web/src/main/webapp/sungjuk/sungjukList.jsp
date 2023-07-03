<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
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
<p><a href="sungjukForm.jsp">[성적쓰기]</a></p>

<table class="table">
<tr class="secondary" >
<th>이름</th>
<th>국어</th>
<th>영어</th>
<th>수학</th>
<th>등록일</th>
</tr>
<% 
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

try{
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	String driver ="oracle.jdbc.driver.OracleDriver"; 
	Class.forName(driver);
	con= DriverManager.getConnection(url, user, password);
	//out.println("오라클 DB연결 성공");
	
	StringBuilder sql=new StringBuilder();
	sql.append(" select sno, uname, kor, eng, mat, wdate ");
	sql.append(" from sungjuk ");
	sql.append(" order by wdate desc ");
	
	pstmt=con.prepareStatement(sql.toString());
	rs=pstmt.executeQuery();
	if(rs.next()){
		do{
%>
		<tr class="success">
		<td><a href="sungjukRead.jsp?sno=<%=rs.getInt("sno")%>"><%=rs.getString("uname") %></a></td>
		<td><%=rs.getInt("kor") %></td>
		<td><%=rs.getInt("eng") %></td>
		<td><%=rs.getInt("mat") %></td>
		<td><%=rs.getString("wdate").substring(0,10) %></td>
		</tr>


<% 			
		}while(rs.next());
	}else{
		out.println("<tr>");
		out.println("<td colspan='5'>글 없음</td>");
		out.println("</tr>");
	}
	
}catch(Exception e){
	out.println("오라클 연결 실패"+e);
	
}finally{
	try{
		if(rs!=null){
			rs.close();
		}
	}catch(Exception e){}
	
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




</table>



</body>
</html>
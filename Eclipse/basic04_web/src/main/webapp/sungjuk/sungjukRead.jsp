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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>sungjukRead</title>
</head>
<body>
<h3>성적 상세보기</h3>
<p>
<a href="sungjukForm.jsp">성적쓰기</a>
<a href="sungjukList.jsp">성적목록</a>
</p>
<% 
//out.print(request.getParameter("sno"));
int sno= Integer.parseInt(request.getParameter("sno"));
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
	sql.append(" select sno,uname,kor,eng,mat,aver,addr,wdate ");
	sql.append(" from sungjuk ");
	sql.append(" where sno=? ");
	
	pstmt= con.prepareStatement(sql.toString());
	pstmt.setInt(1, sno);
	
	rs=pstmt.executeQuery();
	if(rs.next()){
%>
	<table class="table">
	<tr>
	<th class="danger">이름</th>
	<td><%=rs.getString("uname") %></td>
	</tr>
	<tr>
	<th class="danger">국어</th>
	<td><%=rs.getInt("kor") %></td>
	</tr>
	<tr>
	<th class="danger">영어</th>
	<td><%=rs.getInt("eng") %></td>
	</tr>
	<tr>
	<th class="danger">수학</th>
	<td><%=rs.getInt("mat") %></td>
	</tr>
	<tr>
	<th class="danger">평균</th>
	<td><%=rs.getInt("aver") %></td>
	</tr>
	<tr>
	<th class="danger">주소</th>
	<td><%=rs.getString("addr")%>
	<% 
	String addr= rs.getString("addr");
	if(addr.equals("Seoul")){
		out.print("서울");
	}else if(addr.equals("Jeju")){
		out.print("제주");
	}else if(addr.equals("Suwon")){
		out.print("수원");
	}else if(addr.equals("Busan")){
		out.print("부산");
	}
	
	%>
	</td>
	</tr>
	<tr>
	<th class="danger">작성일</th>
	<td><%=rs.getString("wdate") %></td>
	</tr>
	</table>
	<br><br>
	<a href="sungjukUpdate.jsp?sno=<%=sno%>">수정</a>
	&nbsp; &nbsp;
	<a href="sungjukDel.jsp?sno=<%=sno%>">삭제</a>
<%		
	}else{
		out.println("해당글 없음");
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
</body>
</html>
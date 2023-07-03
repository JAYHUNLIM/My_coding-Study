<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

<%-- 
<jsp:include page=""></jsp:include>	액션 태그
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelList</title>
<style>
a{text-decoration-line:none;}

header{background: darkblue;color: white; font-weight:bold;
 text-align: center;
 height:50px;
 font-size: 18pt;}
nav{background: lightblue;color: white;padding-top: 5px;}
footer{background: blue;color: white; text-align: center;
padding-top: 10px;
padding-bottom: 5px;}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<header>여행 예약 프로그램 ver2018-12</header>
<nav>
<jsp:include page="mainmenu.jsp"></jsp:include>
</nav>
<section>
<h3>여행 예약 프로그램 조회</h3>
<table class="table">
<tr class="info" >
<th>예약번호</th>
<th>주민번호</th>
<th>성명</th>
<th>성별</th>
<th>전화번호</th>
<th>여행상품</th>
<th>입금상태</th>
<th>금액</th>
<th>수정/삭제</th>
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
	

	StringBuilder sql=new StringBuilder();
	sql.append(" select tbl_reserve_01.tcode,tarea ,tdate,ttime,tday,thotel,tmoney,tair ");
	sql.append(" ,rno,rjumin,rname,rphone1,rphone2,rphone3,remail,rstat ");
	sql.append(" from tbl_tourcode_02 inner join  tbl_reserve_01 ");
	sql.append(" on tbl_tourcode_02.tcode = tbl_reserve_01.tcode ");
	sql.append(" order by tbl_reserve_01.tcode ");
	
	
	
	pstmt=con.prepareStatement(sql.toString());
	rs=pstmt.executeQuery();
	if(rs.next()){
		do{
%>
<tr class="success">
		<td><%=rs.getString("rno") %></td>
		<td><%=rs.getString("rjumin").substring(0,6) + "-" +rs.getString("rjumin").substring(6) %></td>
		<td><%=rs.getString("rname") %></td>
		
		<td>
		<%
		if(rs.getString("rjumin").substring(6,7).equals("1")){
		out.print("여자");
		}else{out.print("남자");} %>
		
		</td>
				
		<td><%=rs.getString("rphone1")+"-"+rs.getString("rphone2") +"-"+ rs.getString("rphone3") %></td>

		<td><%="[" + rs.getString("tcode")+ "]" + "-"
		+rs.getString("tarea") +"-"
		+rs.getString("tdate")+ "-"
		+rs.getString("ttime")+"-"
		+rs.getString("thotel")+"-"
		+rs.getString("tair")
		%></td>
		
		<td>
		<% String rstat=rs.getString("rstat");//상태코드
		if(rstat.equals("1")){
			out.print("미납");
		}else if(rstat.equals("2")){
			out.print("완납");
		}%></td>
		
		<td><%=String.format("\\%,d", rs.getInt("tmoney")) %></td>
		 <td>
		 	<input type="button" value="수정" onclick="location.href='travelUpdate.jsp?rno=<%=rs.getString("rno")%>'">
			<input type="button" value="삭제" onclick="location.href='travelDel.jsp?rno=<%=rs.getString("rno")%>'">
		 </td>
		</tr>
		
<% 	
		}while(rs.next());
	}else{
		out.println("<tr>");
		out.println("<td colspan='8'>예약 정보없음</td>");
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
</section>
<footer>
HRDKOREA Copyright&copy; 2018 All rights reserved.
Human Resources Development Service of Korea
</footer>

</body>
</html>
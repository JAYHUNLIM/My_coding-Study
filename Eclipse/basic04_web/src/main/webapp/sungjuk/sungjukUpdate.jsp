<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>sungjukUpdate</title>
</head>
<body>
<h3>성적 업데이트</h3>
<p>
<a href="sungjukForm.jsp">성적쓰기</a>
<a href="sungjukList.jsp">성적목록</a>
</p>
<%
//update에서 sno값 받아옴
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

	StringBuilder sql=new StringBuilder();
	
	//1.수정할 데이터를 먼저 가져온다
	sql.append(" select sno,uname,kor,eng,mat,aver,addr,wdate ");
	sql.append(" from sungjuk ");
	sql.append(" where sno=? ");
	
	pstmt= con.prepareStatement(sql.toString());
	pstmt.setInt(1, sno);
	
	rs=pstmt.executeQuery();
	if(rs.next()){
	//2.1의 내용을 폼에 출력 sungjukForm 참조
%>

<form action="sungjukUpdateProc.jsp" name="sungjukfrm" id="sungjukfrm" method="post">
<!--3.sno값도 form으로 정보를 전송할때 필요하기 때문에 hidden 속성으로 사용자에게는 보이지 않도록 해서
전달시킨다  -->
<input type="hidden" name="sno" value="<%=sno%>">
<table class="table table-hover">
<tr>
<th class="success">이름</th>
<td> <input type="text" name="uname" id="uname" value="<%=rs.getString("uname")%>" maxlength="50" required autofocus></td>
</tr>

<tr>
<th class="success">국어</th>
<td> <input type="number" name="kor" id="kor" value="<%=rs.getInt("kor")%>" size=5 min="0" max="100" placeholder="국어점수"></td>
</tr>
<tr>
<th class="success">영어</th>
<td> <input type="number" name="eng" id="eng" value="<%=rs.getInt("eng")%>" size=5 min="0" max="100" placeholder="영어점수"></td>
</tr>

<tr>
<th class="success">수학</th>
<td> <input type="number" name="mat" id="mat" value="<%=rs.getInt("mat")%>" size=5 min="0" max="100" placeholder="수학점수"></td>
</tr>

<tr>
<th class="success">주소</th>
<td>
<% String addr=rs.getString("addr"); %>
<select name="addr" id="addr">
<option value="Seoul" <%if(addr.equals("Seoul")){out.print("selected");} %>>서울</option>
<option value="Suwon" <%if(addr.equals("Suwon")){out.print("selected");} %>>수원</option>
<option value="Busan" <%if(addr.equals("Busan")){out.print("selected");} %>>부산</option>
<option value="Jeju" <%if(addr.equals("Jeju")){out.print("selected");} %>>제주</option>
</select>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input class="btn btn-primary" type="submit" value="수정">
<input class="btn btn-secondary" type="reset" value="취소">
 </td>
</tr>
</table>
</form>

<%	
	}else{
		out.println("해당 글 없음");
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
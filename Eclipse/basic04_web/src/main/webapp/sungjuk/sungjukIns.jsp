<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>sungjukIns</title>
</head>
<body>
<h3>성적 결과 페이지</h3>
<%
//한글 인코딩
request.setCharacterEncoding("UTF-8");
//사용자가 입력한 정보를 가져와서 변수에 담기
String name=request.getParameter("uname");
int kor=Integer.parseInt(request.getParameter("kor").trim());
int eng=Integer.parseInt(request.getParameter("eng").trim());
int mat=Integer.parseInt(request.getParameter("mat").trim());
String addr=request.getParameter("addr");

//평균
int aver=(kor+eng+mat)/3;
//out.println("요청 ip:"+request.getRemoteAddr());

//Oracle DB 연결 및 행 추가-----------
Connection con=null;
PreparedStatement pstmt=null;

try{
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	String driver ="oracle.jdbc.driver.OracleDriver"; 
	
	//2.드라이버 로딩
	Class.forName(driver);
	
	//3.오라클 db 서버 연결
	con= DriverManager.getConnection(url, user, password);
	//out.println("오라클 DB연결 성공");

	
	StringBuilder sql=new StringBuilder();
	sql.append("insert into sungjuk(sno,uname,kor,eng,mat,aver,addr,wdate)");
	sql.append("values(sungjuk_seq.nextval,?,?,?,?,?,?,sysdate)");
	
	pstmt=con.prepareStatement(sql.toString());
	pstmt.setString(1,name);
	pstmt.setInt(2, kor);
	pstmt.setInt(3, eng);
	pstmt.setInt(4, mat);
	pstmt.setInt(5, aver);
	pstmt.setString(6, addr);
	
	int cnt=pstmt.executeUpdate();
	if(cnt==0){
		out.println("<p>성적입력이 실패</p>");
		out.println("<p><a href='javascript:history.back()'>재시도</a></p>");
	}else{
		out.println("<script>");
		out.println("    alert('성적입력 성공');");
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
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
<title>travelBook</title>
<style>
a{text-decoration-line:none;}
header{background: darkblue;
color: white;
font-weight:bold;
text-align: center;
 height:50px;
 font-size: 18pt;}
nav{background: lightblue;color: white;padding-top: 5px;}
footer{background: blue;color: white;text-align: center; padding-top: 10px;
padding-bottom: 5px;}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script>
/*유효성 검사
예약번호 글자 ->8
상품코드를 선택 했는지
주민번호가 숫자형인지 6 7
예약자 전화가 숫자형인지 3 4 4
고객이메일에 @문자가 있는지
*/

function validate() {
	let rno =document.getElementById("rno").value;
	rno=rno.trim();
	if(rno.length!=8){
		alert("예약번호 8글자 입력")
		document.getElementById("rno").focus;
		return false;
}

let tcode=document.getElementById("tcode").value;
tcode=tcode.trim();
if(tcode.length==0){
	alert("상품코드 선택하세요");
	return false;
}

let rjumin1=document.getElementById("rjumin1").value;
rjumin1=rjumin1.trim();
if(rjumin1.length!=6 || isNaN(rjumin1)){
	alert("주민번호는 6자리 숫자를 입력해주세요");
	document.getElementById("rjumin1").focus;
	return false;
}

let rjumin2=document.getElementById("rjumin2").value;
rjumin2=rjumin2.trim();
if(rjumin2.length!=7 || isNaN(rjumin2)){
	alert("주민번호는 7자리 숫자를 입력해주세요");
	document.getElementById("rjumin2").focus;
	return false;
}

let rphone1=document.getElementById("rphone1").value;
rphone1=rphone1.trim();
if (rphone1.length!=3 || isNaN(rphone1)) {
	alert("전화번호 3자리를 입력해 주세요");
	document.getElementById("rphone1").focus;
	return false;
}

let rphone2=document.getElementById("rphone2").value;
rphone2=rphone2.trim();
if (rphone2.length!=4 || isNaN(rphone2)) {
	alert("전화번호 4자리를 입력해 주세요");
	document.getElementById("rphone2").focus;
	return false;
}

let rphone3=document.getElementById("rphone3").value;
rphone3=rphone3.trim();
if (rphone3.length!=4 || isNaN(rphone3)) {
	alert("전화번호 4자리를 입력해 주세요");
	document.getElementById("rphone3").focus;
	return false;
}

let remail=document.getElementById("remail").value;
remail=remail.trim();
if(remail.indexOf("@")==-1){
	alert("@문자를 포함해 주세요");
	document.getElementById("remail").focus;
	return false;
}
return true;
//서버로 전송
}
</script>
</head>
<body>
<header>여행 예약 프로그램 ver2018-12</header>
<nav>
<jsp:include page="mainmenu.jsp"></jsp:include>
</nav>
<section>

<h3>예약 등록하기</h3>
<form  name="travelfrm" id="travelfrm" method="post" action="travelBookProc.jsp" onsubmit="return validate()">
<table border="1" class="table">
<tr>
<th class="active">예약번호</th>
<td><input type="text" name="rno" id="rno" size="8" maxlength="8" required autofocus> </td>
</tr>

<tr>
<th class="active">상품코드</th>
<td><select name="tcode" id="tcode">
<option value="">상품선택</option>

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
	sql.append(" select tcode, tarea, tdate ");
	sql.append(" from tbl_tourcode_02 ");
	sql.append(" order by tcode ");
	
	pstmt=con.prepareStatement(sql.toString());
	rs=pstmt.executeQuery();
	
	if(rs.next()){
		String tname="";
		do{
		tname += "<option value='" + rs.getString("tcode") + "'>";
		tname += "[" + rs.getString("tcode")+ "]";
		tname += rs.getString("tarea");
		tname += rs.getString("tdate").substring(0,4)+"-";
		tname += rs.getString("tdate").substring(4,6)+"-";
		tname += rs.getString("tdate").substring(6);
		tname += " 출발";
		tname += "</option>";
	}while(rs.next());
		
	out.print(tname);	
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

</select> </td>
</tr>

<tr>
<th class="active">주민번호</th>
<td><input type="number" name="rjumin1" id="rjumin1" size="6" maxlength="6" required>
- <input type="number" name="rjumin2" id="rjumin2" size="7" maxlength="7" required> </td>
</tr>

<tr>
<th class="active">예약자 성명</th>
<td><input type="text" name="rname" id="rname" size="20" maxlength="20" required> </td>
</tr>

<tr>
<th class="active">예약자 전화</th>
<td><input type="text" name="rphone1" id="rphone1" size="3" maxlength="3" required> 
<input type="text" name="rphone2" id="rphone2" size="4" maxlength="4" required> 
<input type="text" name="rphone3" id="rphone3" size="4" maxlength="4" required> </td>
</tr>


<tr>
<th class="active">고객 이메일</th>
<td><input type="text" name="remail" id="remail" size="30" maxlength="30" required> </td>
</tr>

<tr>
<th class="active">결제상태</th>
<td><input type="radio" name="rstat" id="rstat" value="1" checked>미납 
<input type="radio" name="rstat" id="rstat" value="2">완납 
</td>
</tr>

<tr>
<td colspan="2">
<input type="submit" class="btn btn-success" value="예약">
<input type="reset" class="btn btn-warning" value="다시쓰기"> 
</td>
</tr>



</table>
</form>

</section>
<footer>
HRDKOREA Copyright&copy; 2018 All rights reserved.
Human Resources Development Service of Korea
</footer>
</body>
</html>
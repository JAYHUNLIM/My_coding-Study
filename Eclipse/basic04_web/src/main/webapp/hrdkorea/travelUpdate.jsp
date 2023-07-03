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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>travelUpdate</title>


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
	<h3>정보 수정</h3>
	<%
	//update에서 sno값 받아옴
	String rno = request.getParameter("rno");

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "1234";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);

		StringBuilder sql = new StringBuilder();

		//1.수정할 데이터를 먼저 가져온다
		sql.append(" SELECT rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode ");
		sql.append(" FROM tbl_reserve_01 ");
		sql.append(" where rno=? ");

		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, rno);

		rs = pstmt.executeQuery();
		if (rs.next()) {
			//2.1의 내용을 폼에 출력 sungjukForm 참조
	%>

	<form action="travelUpdateProc.jsp" name="travelUfrm" id="travelUfrm"
		method="post">

		<table class="table table-hover">
			<tr>
				<th class="active">예약번호</th>
				<td><input type="text" name="rno" id="rno" size="8"
					maxlength="8" value="<%=rs.getString("rno")%>" required autofocus>
				</td>
			</tr>


			<tr>
				<th class="active">상품코드</th>
				<td>
					<%String tcode=rs.getString("tcode"); %>
				<select name="tcode" id="tcode">
						<option value="">상품선택 </option>
						<option value="JJ01" <%if(tcode.equals("JJ01")){out.print("selected");}%>>[JJ01] 제주-20181201</option>
						<option value="JJ02" <%if(tcode.equals("JJ02")){out.print("selected");}%>>[JJ02] 부산-20181201</option>
						<option value="JJ03" <%if(tcode.equals("JJ03")){out.print("selected");}%>>[JJ03] 제주-20181204</option>
						<option value="JJ04" <%if(tcode.equals("JJ04")){out.print("selected");}%>>[JJ04] 제주-20181207</option>
						<option value="JJ05" <%if(tcode.equals("JJ05")){out.print("selected");}%>>[JJ05] 부산-20181209</option>
						<option value="JJ06" <%if(tcode.equals("JJ06")){out.print("selected");}%>>[JJ06] 제주-20181210</option>
				</select>
				</td>
				</tr>					
						
			<tr>
				<th class="active">주민번호</th>
				<td><input type="number" name="rjumin1" id="rjumin1" size="6"
					maxlength="6" value="<%=rs.getString("rjumin").substring(0, 6)%>"
					required> - <input type="number" name="rjumin2"
					id="rjumin2" size="7" maxlength="7"
					value="<%=rs.getString("rjumin").substring(6)%>" required>
				</td>
			</tr>

			<tr>
				<th class="active">예약자 성명</th>
				<td><input type="text" name="rname" id="rname" size="20"
					maxlength="20" value="<%=rs.getString("rname")%>" required>
				</td>
			</tr>

			<tr>
				<th class="active">예약자 전화</th>
				<td><input type="text" name="rphone1" id="rphone1" size="3"
					maxlength="3" value="<%=rs.getString("rphone1")%>" required>
					<input type="text" name="rphone2" id="rphone2" size="4"
					maxlength="4" value="<%=rs.getString("rphone2")%>" required>
					<input type="text" name="rphone3" id="rphone3" size="4"
					maxlength="4" value="<%=rs.getString("rphone3")%>" required>
				</td>
			</tr>


			<tr>
				<th class="active">예약자 이메일</th>
				<td><input type="text" name="remail" id="remail" size="30"
					maxlength="30" value="<%=rs.getString("remail")%>" required>
				</td>
			</tr>


			<tr>
				<th class="active">결제상태</th>
				<td>
					<%
					String rstat = rs.getString("rstat");

					%>
				<input type="radio" name="rstat" id="rstat" value="1" <%if(rstat.equals("1")){out.print("checked");}%>>미납 
				<input	type="radio" name="rstat" id="rstat" value="2"<%if (rstat.equals("2")) {out.print("checked");}%>>완납
				</td>
			</tr>


			<tr>
				<td colspan="2" align="center"><input class="btn btn-primary"
					type="submit" value="수정"> <input class="btn btn-secondary"
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>

	<%
	} else {
	out.println("해당 글 없음");
	}

	} catch (Exception e) {
	out.println("오라클 연결 실패" + e);

	} finally {
	try {
	if (rs != null) {
		rs.close();
	}
	} catch (Exception e) {
	}

	try {
	if (pstmt != null) {
		pstmt.close();
	}
	} catch (Exception e) {
	}

	try {
	if (con != null) {
		con.close();
	}
	} catch (Exception e) {
	}

	}
	%>


</body>
</html>
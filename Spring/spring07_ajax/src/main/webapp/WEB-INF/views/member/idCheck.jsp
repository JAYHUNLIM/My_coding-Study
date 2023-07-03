<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheck</title>
<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/jquery.cookies.js"></script>
</head>
<body>
<h3>회원등록폼</h3>
<form>
<table border="1" width="400px">
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" id="userid">
				<input type="button" value="아이디중복확인" id="btn_userid">    
				<br>
				<div id="panel" style="display:none"></div>
			</td>
		</tr>
		</table>
</form>

<script>
$("#btn_userid").click(function(){
	//alert();
 $.post("idcheckproc.do","userid=" + $("#userid").val().trim(),responseProc);
		//	요청 명령어,전달값, callback 함수				

});

function responseProc(result) {
	$("#panel").empty();
	$("#panel").html(result);
	$("#panel").show();
}

</script>


</body>
</html>
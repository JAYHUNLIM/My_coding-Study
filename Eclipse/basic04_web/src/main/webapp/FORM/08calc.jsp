<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08calc</title>
<script>
function validate() {
	let op=document.getElementById("op").value;
	op=op.trim();
	//alert();
	//연산기호 + - / * %
	if(!(op=='+' || op=='-' || op=='/'||op=='*'||op=='%')){
	alert("연산기호는 + - / * % 만 입력 가능!");	
	return false;
	}
	return true;
}

</script>
</head>
<body>
<h3>계산기 연습</h3>
<form name="calcfrm" id="calcfrm" method="get" action="08_ok.jsp" onsubmit="return validate()">
	첫번째 수 : <input type="number" name="num1" id="num1" min="0" max="100" required>
<hr>
	연산자: <input type="text" name="op" id="op" size="3" maxlength="1" required>
<hr>
	두번째 수:<input type="number" name="num2" id="num2" min="0" max="100" required>
<hr>
 <input type="submit" value="계산">
 <input type="reset" value="취소">
 </form>
</body>
</html>
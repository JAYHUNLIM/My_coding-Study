<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookTest</title>
<script src="../js/jquery-3.6.4.min.js"></script>
</head>
<body>
<h3>교재 선택</h3>
<select name="book" id="book">
<option>---selection---</option>
<option value="0">spring</option>
<option value="1">android</option>
<option value="2">jquery</option>
<option value="3">javascript</option>
</select>
<br>
<div id="display"></div>
<script>

$("#book").change(function(){
	//alert($(this).val());
	$.post("booksend.do","book="+ $(this).val(),responseProc);
	
});

function responseProc(result){
	//alert(result);
	$("#display").html("<img src='../images/" + result +"'>");
	
}

</script>


</body>
</html>
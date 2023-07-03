<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test02</title>
<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/jquery.cookies.js"></script>
</head>
<body>
<h3>$.ajax() 테스트</h3>
<button id="btn">서버에서 응답받기</button>
<div id="panel"></div>

<script>
//1. $.ajax()함수
// 형식 $.ajax({name:value, name:value, nmae:value})
/* $("#btn").click(function(){
	$.ajax({
		url:"message.do",	//요청 명령어
		type:"get",				//get 방식
		dataType:"text", 		//응답 메세지 타입
		error:function(error){
			alert("에러:"+error);
		},
		success:function(result){
			//alert("성공:"+result);
			
			$("#panel").append(result);
			
			//$("#panel").empty();
			//$("#panel").text(result);
			//$("#panel").html(result);
			
		}
		});
}); */
 
 
 //2. $.get()
 //AJAX를 GET방식으로 요청하는 함수
 // $.GET("요청명령어",CALLBACK 함수)
 $("#btn").click(function(){
	$.get("message2.do",responseProc);
});

function responseProc(result){
	$("#panel").append(result);	
}

 
 
</script>

</body>
</html>
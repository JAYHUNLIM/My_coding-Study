<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
<script src="../js/jquery-3.6.4.min.js"></script>
</head>
<body>
<h3>교재 검색</h3>
<form name="search" id="search">
<input type="text" name="keyword" id="keyword">
<input type="button" value="검색">
</form>

<div id="panel" style="display:none"></div>

<script>
//키를 누를때마다 서버랑 상호작용
$("#keyword").keyup(function(){
   // alert("test");
    if ($("#keyword").val()=="") {
        //검색어가 존재하지 않으면
        $("#panel").hide();//결과 출력하지 않음
    }
    // 1.keyword 값 가져오기
    // let params=$("#keyword").val();
    // alert(params);

    //2.본문 폼안의 모든 컨트롤 요소를 가져오기
    let params=$("#search").serialize();
    //alert(params);
//keyword=java

$.post("searchProc.do",params,responseProc);
});

function responseProc(data) {
    //alert(data);
	//2＃AJAX,AJAX 실전 프로그래밍
	if (data.length>0) { //응답 받은 내용이 있는지 
        let result=data.split("|"); //기호를 기준으로 문자열 분리
//    alert(result[0]); 
//		alert(result[1]); 
		let title=result[1].split(",");
		let str="";//최종 결과값
		$.each(title,function(index,key){
		//	alert(index);
		//	alert(key);
		str +="<a href='#'>"+key +"</a>";
		str +="<br>";
		
		});
		$("#panel").html(str);
		$("#panel").show();
	}else{
		$("#panel").hide();
	}
	
}

</script>
</body>
</html>
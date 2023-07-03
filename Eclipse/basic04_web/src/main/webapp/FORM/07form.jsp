<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07 form</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
function validate() {
	//alert();
	//이름은 5~20글자 이내에서 입력
	let uname=document.getElementById("uname").value;
	uname=uname.trim();
	if(uname.length<5 || uname.length>20){
		alert("이름 5~20글자 이내에서 입력");
		 return false;
	}
	return true;
}
</script>
</head>
<body>
<h3>성적 입력</h3>
<form name="sugnjukfrm" id="sugnjukfrm" method="post" action="07_ok.jsp" onsubmit="return validate()">
	이름:<input type="text"  class="form-control" name="uname" id="uname" maxlength="20" placeholder="이름을 입력" required="required">
	<hr>
	국어:<input type="number"  class="form-control" name="kor" id="kor" size="5" min="0" max="100" >
	<hr>
	영어:<input type="number"  class="form-control" name="eng" id="eng" size="5" min="0" max="100" >
	<hr>
	수학:<input type="number"  class="form-control" name="mat" id="mat" size="5" min="0" max="100" >
	<hr>
	<input type="submit" class="btn btn-primary" value="전송">
	<input type="reset"  class="btn btn-light" value="취소">
</form>
<!--
				[form 관련 다양한 속성들]
				사용자가 입력한 정보를 서버로 전송하기 위한 양식
				name: 폼이름. 서버에서 식별하기 위한 이름
				id : 폼아이디. Frontend단에서 식별자로 주로 사용
				method: 폼 전송방식. 	get | post. 생략시 기본 get
				action: 사용자가 요청한 정보를 서버가 받아서 처리할 결과 페이지
				enctype: 폼에서 파일을 첨부해서 서버로 전송하고자 할때 "multipart/form-data"
				
				[폼 전송방식]
				1. method = get
					-생략시 기본값
					-사용자가 입력 요청한 정보가 url 그대로 노출
					-한글 안깨짐
					-ok.jsp?서버로 전송되는 값들
						형식 : 요청페이지(명령어)?변수=값&변수=값&
					- 검색어
					
				2. method = post
					-사용자가 요청한 정보가 url에 노출되지 않고 패키지화 되어서 서버로 전송
					-(TOMCAT 9.0)이하 버전 에서는 한글이 깨진다
					-주민번호, 카드번호, 비번....
					
				-->
</body>
</html>
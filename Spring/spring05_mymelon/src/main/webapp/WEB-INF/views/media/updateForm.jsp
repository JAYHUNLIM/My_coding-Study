<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>createForm</title>
<style>
* {
	font-family: gulim;
	font-size: 25px;
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="title">음원 수정</div>
	<form name="frm" method="post" action="update.do" enctype="multipart/form-data" onsubmit="return updateCheck()">
	<input type="hidden" name="mediagroupno" value="${dto.mediagroupno}">
	<!-- 음원 목록을 유지하기 위해서 부모글 번호도 필요하다 -->
	<input type="hidden" name="mediano" value="${dto.mediano}">
	
	
		<table class='table'>
			<tr>
				<th>제목</th>
				<td><input type='text' name='title' size='50' value="${title}"></td>
			</tr>
			<tr>
				<th>포스터</th>
				<td>
				<img src="../storage/${dto.poster}" width="200px"><br>
				<input type='file' name='posterMF' size='50'  accept=".gif, .jpg, .png"></td>
			</tr>
			<tr>
				<th>미디어 파일</th>
				<td>
				등록된 파일: ${dto.filename}<br>
				<input type='file' name='filenameMF' size='50' accept=".mp3, .mp4"></td>
			</tr>

		</table>
		<div class="bottom">
			<input type="submit" value="음원수정">
			 <input type="button" value="음원목록"	onclick="location.href='list.do?mediagroupno=${dto.mediagroupno}'">
			<input type="button" value="HOME" onclick="location.href='/home.do'">

		</div>
	</form>
	
	<script>
function updateCheck() {
	let message="기존 미디어 파일은 삭제됩니다 \n 진행할까요?"
	if (confirm(message)) {
		location.href='update.do?mediano='+mediano;
		return true;
	}else {
		return false;
	}
}

</script>
</body>
</html>
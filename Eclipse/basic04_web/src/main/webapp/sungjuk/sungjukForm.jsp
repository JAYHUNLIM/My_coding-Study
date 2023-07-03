<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukForm</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h3>성적 입력 폼</h3>
<p>
<a href="sungjukList.jsp">[성적목록]</a></p>
<form action="sungjukIns.jsp" name="sungjukfrm" id="sungjukfrm" method="post">
<table class="table table-hover">
<tr>
<th class="success">이름</th>
<td> <input type="text" name="uname" id="uname" maxlength="50" required autofocus></td>
</tr>

<tr>
<th class="success">국어</th>
<td> <input type="number" name="kor" id="kor" size=5 min="0" max="100" placeholder="국어점수"></td>
</tr>
<tr>
<th class="success">영어</th>
<td> <input type="number" name="eng" id="eng" size=5 min="0" max="100" placeholder="영어점수"></td>
</tr>

<tr>
<th class="success">수학</th>
<td> <input type="number" name="mat" id="mat" size=5 min="0" max="100" placeholder="수학점수"></td>
</tr>

<tr>
<th class="success">주소</th>
<td>
<select name="addr" id="addr">
<option value="Seoul">서울</option>
<option value="Suwon">수원</option>
<option value="Busan">부산</option>
<option value="Jeju">제주</option>
</select>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input class="btn btn-primary" type="submit" value="전송">
<input class="btn btn-secondary" type="reset" value="취소">
 </td>
</tr>
</table>
</form>
</body>
</html>
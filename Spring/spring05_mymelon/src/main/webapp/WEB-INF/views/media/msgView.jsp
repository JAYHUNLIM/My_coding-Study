<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>msgView</title>
<style>
* {
	font-family: gulim;
	font-size: 25px;
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="title">알림</div>
<div class="content">
<dl>
<dd>${msg1 !=null ? img:""} ${msg1}</dd>
</dl>
<p>
${link1} ${link2}
</p>

</div>

</body>
</html>
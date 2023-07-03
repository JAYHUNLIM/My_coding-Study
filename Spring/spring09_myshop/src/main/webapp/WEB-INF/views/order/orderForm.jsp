<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link href="../css/main.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h3>주문서 작성</h3>
	<br>
	<form method="post" action="insert" onsubmit="return ordercheck()">
		<table border="1" class="table">
				<th>받는사람</th>
				<td><input type="text" name="receiver"></td>
			</tr>
			<tr>
				<th>받는주소</th>
				<td><input type="text" name="rece_address"></td>
			</tr>
			<tr>
				<th>배송메세지</th>
				<td><input type="text" name="message"></td>
			</tr>
			<tr>
				<th>결제구분</th>
				<td><select name="payment">
						<option value="cash">현금</option>
						<option value="card">카드</option>
				</select></td>
			</tr>

			<tr>
				<td colspan="2">
				<input type="submit" value="결제하기" class="btn btn-success"></td>
			</tr>
		</table>
	</form>

	<script>
		function ordercheck() {

			if (confirm("결제할까요")) {
				return true;
			} else {
				return false;
			}
		}
	</script>

</body>
</html>
</form>
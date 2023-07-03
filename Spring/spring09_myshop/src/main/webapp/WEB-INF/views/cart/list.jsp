<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link href="../css/main.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h3>장바구니 목록</h3>
<br>
<table border="1" class="table" style="text-align: center;'">
<tr class="info">
<th>아이디</th>
<th>번호</th>
<th>상품코드</th>
<th>상품단가</th>
<th>상품수량</th>
<th>총 가격</th>
<th>삭제</th>
</tr>

<c:forEach var="row" items="${list}">
<tr>
<td>${row.id}</td>
<td>${row.cartno}</td>
<td>${row.product_code}</td>
<td><fmt:formatNumber value="${row.price}" pattern="#,###" /></td>
<td>${row.qty }</td>
<td> <fmt:formatNumber value="${row.price*row.qty}" pattern="#,###" /></td>
<td><input type="button" value="삭제" class="btn btn-secondary btn-block" onclick="location.href='/cart/delete?cartno=${row.cartno}'"> </td>
</tr>

</c:forEach>
</table>
<br>

<input type="button" value="계속 쇼핑하기" onclick="location.href='/product/list'" class="btn btn-primary">
<input type="button" value="결제" onclick="order()" class="btn btn-danger">
<script>
//결제하기
function order() {
if (confirm("결제를 진행할까요?")) {  
location.href='/order/orderform'; 
}
    
}

</script>
</body>
</html>
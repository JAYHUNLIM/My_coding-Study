<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<link href="../css/main.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../js/jquery-3.6.4.min.js"></script>


<!-- onclick 함수 -->
<script>
function product_delete() {
    if (confirm("영구히 삭제됩니다.\n 진행 할까요")) {     
    document.productfrm.action="/product/delete";
    document.productfrm.submit();
    }
}

//

function product_update() {
    document.productfrm.action="/product/update";
    document.productfrm.submit();
}


</script>


</head>
<body>
<h3>상품수정/삭제/상세보기</h3>
<p>
<button type="button" onclick="location.href='/product/list'" class="btn btn-success">상품 전체목록</button>
</p>

<form name="productfrm" id="productfrm" method="post" enctype="multipart/form-data">
<table border="1" class="table table-striped">
    <tr>
        <td>상품명</td>
        <td> <input type="text" name="product_name" value="${product.PRODUCT_NAME}"> </td>
    </tr>
    <tr>
        <td>상품가격</td>
        <td> <input type="number" name="price" value="${product.PRICE}" > </td>
    </tr>
    <tr>
        <td>상품설명</td>
        <td> 
            <textarea rows="5" cols="60" name="description">${product.DESCRIPTION}</textarea>     
         </td>
    </tr>
    <tr>
        <td>상품사진</td>
		<td>
		<c:if test="${product.FILENAME !='-'}">
			<img src="/storage/${product.FILENAME}" width="100px">
		</c:if> 
		<input type="file" name="img"></td>
		</tr>
    <tr>
	   <td colspan="2" align="center">
	   <input type="hidden" name="product_code" value="${product.PRODUCT_CODE}">
	   <input type="button" value="상품수정" class="btn btn-info" onclick="product_update()">
	   <input type="button" value="상품삭제" class="btn btn-warning" onclick="product_delete()">
</td>
</tr>
</table>
</form>
<hr>
<!-- 댓글 -->


</body>
</html>
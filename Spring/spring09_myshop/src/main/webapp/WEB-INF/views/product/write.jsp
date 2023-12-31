<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
<link href="../css/main.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<body>
<h3>상품등록</h3>
<p>
<button type="button" onclick="location.href='list'" class="btn btn-success">상품 전체목록</button>
</p>

<form name="productfrm" id="productfrm" method="post" action="insert" enctype="multipart/form-data">
<table border="1" class="table table-striped">
    <tr>
        <td>상품명</td>
        <td> <input type="text" name="product_name"> </td>
    </tr>
    <tr>
        <td>상품가격</td>
        <td> <input type="number" name="price"> </td>
    </tr>
    <tr>
        <td>상품설명</td>
        <td> 
            <textarea rows="5" cols="60" name="description"></textarea>     
         </td>
    </tr>
    <tr>
        <td>상품사진</td>
        <td> <input type="file" name="img"> </td>
    </tr>
    <tr>
	   <td colspan="2" align="center">
	   <input type="submit" value="상품등록" class="btn btn-info">
</td>
</tr>
</table>

</form>
</body>
</html>
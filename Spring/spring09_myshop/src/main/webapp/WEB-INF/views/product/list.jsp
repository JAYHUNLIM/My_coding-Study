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
<h3>상품 목록</h3>
<p>
<button type="button" onclick="location.href='write'" class="btn btn-secondary">상품등록</button>
<button type="button" onclick="location.href='list'" class="btn btn-success">상품 전체목록</button>
</p>

<form action="search">
상품명: <input type="text" name="product_name">
<input type="submit" value="검색" class="btn btn-primary btn-sm" size="15" >
</form>



<hr>
상품 갯수: ${fn:length(list)}
<br><br>
<table class="table table-striped table-bordered table-dark">

<tr>
<c:forEach items="${list}" var="row" varStatus="vs">
<td align="center">
<c:choose>
<c:when test="${row.FILENAME != '-'}">
<img src="/storage/${row.FILENAME}" width="100px">
</c:when>
<c:otherwise>
등록된 사진 없음!
</c:otherwise>

</c:choose>
<br>
<%--do 방식으로 행에 대한 정보를 넘김
?를 사용해서 넘기는게 일반적이나 detail/${row.PRODUCT_CODE}처럼 값을 넘길수도 있다
   http://localhost:9095/product/detail/1 --%>
   <%--<a href="detail?product_code=${row.PRODUCT_CODE}"> ${row.PRODUCT_NAME}</a>--%>
상품명: 
<a href="detail/${row.PRODUCT_CODE}"> ${row.PRODUCT_NAME}</a>
<br>
상품가격: <fmt:formatNumber value="${row.PRICE}" pattern="#,###"/>
</td>
<!-- 테이블 한줄에 5칸씩 -->
<c:if test="${vs.count mod 5==0}">
</tr>
<tr>
</c:if>

</c:forEach>
</tr>

</table>


</body>
</html>
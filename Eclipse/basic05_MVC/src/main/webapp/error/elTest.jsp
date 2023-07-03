<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>elTest</title>
</head>
<body>
<h3>  El 표현 언어</h3>
  표현식 :<%=123%>
  표현식 :<%=123+321%>
  <hr>
  
  표현언어 : ${123}<hr>
  표현언어 : ${123+456}<hr>
  <h3> EL 에서 사용되는 연산자</h3>
  더하기 :${123+456}<hr>
  빼기 :${123-456}<hr>
  곱하기 :${123*456}<hr>
  나누기 :${123/456}<hr>
  나머지 :${123%456}<hr>
  <!-- 이클립스 인식 에러 웹에서는 작동오류 없음 -->
  나누기 :${123 div 456}<hr>
  나머지 :${123 mod 456}<hr>
 
  2가 3보다 작다 :${2<3}<hr>
  2가 3보다 크다 :${2 > 3}<hr>
  
  
</body>
</html>
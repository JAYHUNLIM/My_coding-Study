<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%--  지시자의 종류
<%@ taglib%>  JSTL Custom tag
<%@ include%> 공통페이지
<%@ page%>	
--%>

<%-- JSTL 사용하려면 Directive지정한다  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl</title>
</head>
<body>
<h3>JSTL</h3>

1.JSP 변수선언&nbsp;
<%int a=3; %>
a: <%=a%>
<hr>
2.JSTL 변수선언 &nbsp;
<c:set var="b" value="5" ></c:set>
<c:set var="c" value="7" />
b:${b},
c:${c}&nbsp;
b+c= ${b+c}
<hr>

3.출력 &nbsp;&nbsp;
<c:out value="2"></c:out>
<c:out value="${b}"></c:out>
<c:out value="${c}"></c:out>
<c:out value="${b+c}"></c:out>
<hr>

4.b,c변수 제거
<c:remove var="b"/>
<c:remove var="c"/>
<c:out value="${b}"></c:out> <!--빈값  -->
<c:out value="${c}"></c:out> <!--빈값  -->
<c:out value="${b+c}"></c:out> <!--0-->
<hr>

5.자바 객체 선언도 가능
<hr>
<c:set value="<%=new Date()%>" var="dt"></c:set>
오늘날짜 :${dt} <hr>
오늘날짜: <c:out value="${dt}"></c:out>
<hr>



</body>
</html>
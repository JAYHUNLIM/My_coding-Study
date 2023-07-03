<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%--  �������� ����
<%@ taglib%>  JSTL Custom tag
<%@ include%> ����������
<%@ page%>	
--%>

<%-- JSTL ����Ϸ��� Directive�����Ѵ�  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl</title>
</head>
<body>
<h3>JSTL</h3>

1.JSP ��������&nbsp;
<%int a=3; %>
a: <%=a%>
<hr>
2.JSTL �������� &nbsp;
<c:set var="b" value="5" ></c:set>
<c:set var="c" value="7" />
b:${b},
c:${c}&nbsp;
b+c= ${b+c}
<hr>

3.��� &nbsp;&nbsp;
<c:out value="2"></c:out>
<c:out value="${b}"></c:out>
<c:out value="${c}"></c:out>
<c:out value="${b+c}"></c:out>
<hr>

4.b,c���� ����
<c:remove var="b"/>
<c:remove var="c"/>
<c:out value="${b}"></c:out> <!--��  -->
<c:out value="${c}"></c:out> <!--��  -->
<c:out value="${b+c}"></c:out> <!--0-->
<hr>

5.�ڹ� ��ü ���� ����
<hr>
<c:set value="<%=new Date()%>" var="dt"></c:set>
���ó�¥ :${dt} <hr>
���ó�¥: <c:out value="${dt}"></c:out>
<hr>



</body>
</html>
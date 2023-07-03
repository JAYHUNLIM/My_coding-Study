<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>test3</title>
</head>
<body>
<h3>JSTL 함수</h3>
<c:set var="txt" value=" white space   "></c:set>
글자갯수:${fn:length(txt)}
<hr>
공백제거:@<c:out value="${fn:trim(txt)}"></c:out>@
<hr>
<c:set var="str" value="hi my name is waldo"></c:set>
문자열 자르기: ${fn:substring(str,3,9)}
<hr>
${fn:toLowerCase(str)}   <hr>
${fn:toUpperCase(str)}
<hr>
<%
//엔터를 br태그로 바꾸기
//JSP
String content="";
content=content.replace("\n","<br>");

//EL+JSTL
pageContext.setAttribute("cn","\n");


%>
<c:set var="content" value="hi   my name   is waldo"></c:set>
${content}
<hr>
${fn:replace(content,cn,"<br>")}
<hr>

<!-- 특수문자 변환 -->
<c:set var="text" value="Hi
	                         My <name> is
	                         'W   a   l   d     o'"></c:set>	
	                         
	${fn:escapeXml(text)}
	<hr>
	${fn:replace(fn:escapeXml(text), cn, "<br>")}
	${fn:replace(fn:replace(fn:escapeXml(text), cn, "<br>"), ' ' , '&nbsp;')}
</body>
</html>
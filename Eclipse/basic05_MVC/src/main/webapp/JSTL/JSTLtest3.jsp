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
<h3>JSTL �Լ�</h3>
<c:set var="txt" value=" white space   "></c:set>
���ڰ���:${fn:length(txt)}
<hr>
��������:@<c:out value="${fn:trim(txt)}"></c:out>@
<hr>
<c:set var="str" value="hi my name is waldo"></c:set>
���ڿ� �ڸ���: ${fn:substring(str,3,9)}
<hr>
${fn:toLowerCase(str)}   <hr>
${fn:toUpperCase(str)}
<hr>
<%
//���͸� br�±׷� �ٲٱ�
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

<!-- Ư������ ��ȯ -->
<c:set var="text" value="Hi
	                         My <name> is
	                         'W   a   l   d     o'"></c:set>	
	                         
	${fn:escapeXml(text)}
	<hr>
	${fn:replace(fn:escapeXml(text), cn, "<br>")}
	${fn:replace(fn:replace(fn:escapeXml(text), cn, "<br>"), ' ' , '&nbsp;')}
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl2ok</title>
</head>
<body>
<h3>��� ������</h3>
<c:set var="name" value="${param.name}"></c:set>
<c:set var="age" value="${param.age}"></c:set>

�̸�:${name} <c:out value="${name}"></c:out>
����:${age} <c:out value="${age}"></c:out>
<hr>
<!--���ǹ�  -->
<c:if test="${name=='itwill'}">����ȭ</c:if>
 
<!--���� ���ǹ� -->
<c:choose>
<c:when test="${age<10}">���</c:when>
<c:when test="${age<20}">û�ҳ�</c:when>
<c:otherwise>����</c:otherwise>
</c:choose>
<hr>
<c:forEach var="a" begin="1" end="${age}" step="1">
<c:out value="#"></c:out>
</c:forEach>

<hr>
	<c:forEach var="a" begin="1" end="${age}" step="1">
		<c:choose>
			<c:when test="${a%2==0}">
				<span style="color: blue">${a}</span>
			</c:when>

			<c:when test="${a%2==1}">
				<span style="color: red">${a}</span>
			</c:when>
		</c:choose>
	</c:forEach>

<hr>

<!-- varStatus="���¿� ����"
    	${vs.current} ���� for���� �ش��ϴ� ��ȣ
		${vs.index} 0������ ����
		${vs.count} 1������ ����
		${vs.first} ù ��°���� ����
		${vs.last} ���������� ����
		${vs.begin} for���� ���� ��ȣ
		${vs.end} for���� �� ��ȣ
		${vs.step} for���� ������
     --> 

<c:forEach var="b" begin="10" end="30" step="10"  varStatus="vs">
${vs.current}
	${vs.index} 
		${vs.count} 
		${vs.first} 
		${vs.last} 
		${vs.begin}
		${vs.end} 
		${vs.step} 
<hr>
</c:forEach>


</body>
</html>
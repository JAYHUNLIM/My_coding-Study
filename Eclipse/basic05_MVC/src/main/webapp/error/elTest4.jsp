<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP�� EL�� ����</title>
</head>
<body>
<h3>JSP�� EL�� ����</h3>
<%

//JSP�� EL�� ���� ������������ ���� ���� �����Ҽ�����
String uname="itwill";
%>
	�̸�(jsp):<%=uname%><hr> <!--itwill -->
	�̸�(el): ${uname}		<!--���ڿ� -->
<br>	
<hr>
<%
//���� ����������  JSP�� EL�� ���� ���� �����ϱ� ���ؼ��� pageScope�� Ȱ���Ѵ�
 pageContext.setAttribute("uid","korea");

%>
	���̵�(JSP):<%=pageContext.getAttribute("uid")%> <!--korea  -->
	���̵�(EL):${pageScope.uid} <!--korea  -->
	���̵�(EL):${uid} <!--korea  -->
	
	
	
</body>
</html>
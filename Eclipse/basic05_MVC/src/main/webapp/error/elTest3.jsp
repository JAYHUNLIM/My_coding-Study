<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>elTest3</title>
</head>
<body>
<h3> EL ���尴ü</h3>
<%
	//1.JSP ���尴ü
	//->pageContext,request,session,application
	
	//���κ��� ���� 
	pageContext.setAttribute("kor",1000);//���� ������������ ��ȿ
	request.setAttribute("eng",1000);	//�������� 
	session.setAttribute("mat",1000);	 //�������� ���������,�ð�
	application.setAttribute("sta",1000); //�������� ��������� 
	%>
	
	1.JSP<hr>
	kor: <%=pageContext.getAttribute("kor")%><hr>
	eng:<%=request.getAttribute("eng")%>	<hr> 
	mat: <%=session.getAttribute("mat")%>	 <hr>
	sta: <%=application.getAttribute("sta")%> <hr> 
<% 
	//2.EL ���尴ü(COLLECTION)
	// param,pageScope, requestScope, sessionScope, applicatinScope
	
	
	%>
	2.EL
	<hr>
	kor: ${pageScope.kor}
	eng: ${requestScope.eng}
	mat: ${sessionScope.mat}
	sta: ${applicationScope.sta}
	
	<hr>
	EL������ ���尴ü���� �����Ҽ� �ִ�.
	<!-- page-> request-> session-> application������ �ڵ� �˻� -->
	<hr>
	kor: ${kor}
	eng: ${eng}
	mat: ${mat}
	sta: ${sta}
	<hr>
<!-- �� Scope�� ���� �������� ������ ���  -->	
<%
 pageContext.setAttribute("num", 500);
 request.setAttribute("num", 600);
 session.setAttribute("num", 700);
 application.setAttribute("num", 800);
 
 
%>	
num: ${num}	
<!--����� 500
	���� ��ü���� �����Ǹ� �ڵ����� ���� ���������� ã�� �ȴ� -->	
<hr>	
<!-- �� Scope�� ���� ������ ���� ���  -->	
JSP:<%=request.getAttribute("uname")%>
<!--NULL-->
<hr>
EL:@${requestScope.uname}@
<!--�� ���ڿ�-->	
</body>
</html>
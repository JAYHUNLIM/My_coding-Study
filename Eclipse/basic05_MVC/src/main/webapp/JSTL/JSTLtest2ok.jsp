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
 <%
  String name=request.getParameter("name");
 int age=Integer.parseInt(request.getParameter("age"));
 
 out.print("�̸�:" +name +"<br>");
 out.print("����:"+age+"<br>" );
 
 // 10�̸� ���, 20�̸� û�ҳ�, ������ ���� ���
 if(age<10){
	 out.print("���");
 }else if(age>=10 && age<20){
	 out.print("û�ҳ�");
 }else{
	 out.print("����");
 }
 
 //2.1~���̱��� ¦���� �Ķ���, Ȧ���� ���������� ���
 for(int i=1;i<=age;i++){
	 if(i%2==0){
		 out.print("<span style='color:blue;'>"+i+"</span>");
	 }else{
		 out.print("<span style='color:red;'>"+i+"</span>");
	 }
 }
 
 out.print("<hr>");
 
 
 %>
</body>
</html>
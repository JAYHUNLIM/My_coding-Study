<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>elTest</title>
</head>
<body>
<h3>  El ǥ�� ���</h3>
  ǥ���� :<%=123%>
  ǥ���� :<%=123+321%>
  <hr>
  
  ǥ����� : ${123}<hr>
  ǥ����� : ${123+456}<hr>
  <h3> EL ���� ���Ǵ� ������</h3>
  ���ϱ� :${123+456}<hr>
  ���� :${123-456}<hr>
  ���ϱ� :${123*456}<hr>
  ������ :${123/456}<hr>
  ������ :${123%456}<hr>
  <!-- ��Ŭ���� �ν� ���� �������� �۵����� ���� -->
  ������ :${123 div 456}<hr>
  ������ :${123 mod 456}<hr>
 
  2�� 3���� �۴� :${2<3}<hr>
  2�� 3���� ũ�� :${2 > 3}<hr>
  
  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>errorTest</title>
</head>
<body>
<h3> ���� �޼��� Ȯ��</h3>
<%

	//1.http ���� 404- ã�� �� ����
	//http:localhost:9091/basic05_mvc/error/list.jsp


 	int num=Integer.parseInt(request.getParameter("kor"));
	out.print("num:"+num);
 
	//2.http ���� 500- ���μ��� ����
	//http:localhost:9091/basic05_mvc/error/list.jsp
	//? �ڿ� kor ���� �Ѱܾ� ������ �߻����� ����
	
	//������ �߻��ϴ� ���, �����޼����� ���� ������� �ʰ�, �ٸ��������� �̵��� �ʿ䰡 ����
	// web-inf/web.xml  ��ġ �����ڿ��� ����
	
 %>


</body>
</html>
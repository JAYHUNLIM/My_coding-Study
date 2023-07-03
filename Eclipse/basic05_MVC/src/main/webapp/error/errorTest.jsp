<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>errorTest</title>
</head>
<body>
<h3> 에러 메세지 확인</h3>
<%

	//1.http 상태 404- 찾을 수 없음
	//http:localhost:9091/basic05_mvc/error/list.jsp


 	int num=Integer.parseInt(request.getParameter("kor"));
	out.print("num:"+num);
 
	//2.http 상태 500- 내부서버 오류
	//http:localhost:9091/basic05_mvc/error/list.jsp
	//? 뒤에 kor 값을 넘겨야 에러가 발생하지 않음
	
	//에러가 발생하는 경우, 에러메세지를 직접 출력하지 않고, 다른페이지로 이동할 필요가 있음
	// web-inf/web.xml  배치 관리자에서 지정
	
 %>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09_ok</title>
</head>
<body>
 <h3>request 내부객체 다양한 메소드</h3>
 
 <%
 request.setCharacterEncoding("UTF-8");
 
 String uid =request.getParameter("uid").trim();
 String upw =request.getParameter("upw").trim();
 String uname =request.getParameter("uname").trim();
 String content =request.getParameter("content").trim();

 out.print(uid+"<hr>");
 out.print(upw+"<hr>");
 out.print(uname+"<hr>");
 out.print(content+"<hr>");
 
 //textarea 값은 엔터를 br 치환해서 출력
 content= content.replace("\n", "<br>");
 out.print(content +"<hr>");
 
 //name이 동일한 값을 request객체에서 가져오기
 //<input type="text" name="num">이 3개인 경우
 String[] num=request.getParameterValues("num");
for(int i=0;i<num.length;i++){
	out.print(num[i] +"<br>");
}

out.print("<hr>");
out.print("성별:"+request.getParameter("gender"));

out.print("<hr>");
out.print("약관동의:"+request.getParameter("agree"));
/* 
<input type="checkbox" name="agree" value="Y"> */
if(request.getParameter("agree")==null){
	out.print("약관에 동의하지 않음");
}else{
	out.print("약관에 동의함");
}
//type=radio value가 없는 경우 
//check 하면 on, 안하면 null
out.print("<hr>");
out.print("SMS:"+request.getParameter("sms"));

out.print("<hr>");
out.print("통신회사:"+request.getParameter("telecom"));

out.print("<hr>");
out.print("페이지:"+request.getParameter("page"));

out.print("<hr>");
out.print("첨부파일:"+request.getParameter("attach"));
/* 첨부된 파일을 가져오려면 다른 방식으로 request객체에 접근해야한다
request.getParameter("attach")는 실제 파일을 가지고 있는 것이 아니라
단순 파일명이 출력됐을뿐이다
*/
%>
 
</body>
</html>
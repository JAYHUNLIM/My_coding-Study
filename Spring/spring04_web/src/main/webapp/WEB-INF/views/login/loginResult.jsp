<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login result</title>
</head>
<body>
<h2> 로그인 결과</h2>
1.JSP
<%=request.getAttribute("message")%><br>
아이디(세션):<%=session.getAttribute("s_id")%><br>
비번(세션):<%=session.getAttribute("s_pw")%><br>
<hr>

2.EL
${requestScope.message}<br>
아이디(세션):${requestScope.s_id}<br>
비번(세션):${requestScope.s_pw}<br>


${message}<br>
아이디(세션):${s_id}<br>
비번(세션):${s_pw}<br>

</body>
</html>
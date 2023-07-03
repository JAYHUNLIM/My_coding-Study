<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukUpdate</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

	<h3>성적 상세보기</h3>
	<p>
		<a href="sungjukForm.jsp">성적쓰기</a> <a href="sungjukList.jsp">성적목록</a>
	</p>

	<%
	int sno = Integer.parseInt(request.getParameter("sno"));
	dto = dao.read(sno);
	if (dto == null) {
		out.println("해당 글 없음");
	} else {
	%>
	<form action="sungjukUpdateProc.jsp" name="sungjukfrm" id="sungjukfrm"
		method="post">
		<!--3.sno값도 form으로 정보를 전송할때 필요하기 때문에 hidden 속성으로 사용자에게는 보이지 않도록 해서
전달시킨다  -->
		<input type="hidden" name="sno" value="<%=sno%>">
		<table class="table table-hover">
			<tr>
				<th class="success">이름</th>
				<td><input type="text" name="uname" id="uname"
					value="<%=dto.getUname()%>" maxlength="50" required autofocus></td>
			</tr>

			<tr>
				<th class="success">국어</th>
				<td><input type="number" name="kor" id="kor"
					value="<%=dto.getKor()%>" size=5 min="0" max="100"
					placeholder="국어점수"></td>
			</tr>
			<tr>
				<th class="success">영어</th>
				<td><input type="number" name="eng" id="eng"
					value="<%=dto.getEng()%>" size=5 min="0" max="100"
					placeholder="영어점수"></td>
			</tr>

			<tr>
				<th class="success">수학</th>
				<td><input type="number" name="mat" id="mat"
					value="<%=dto.getMat()%>" size=5 min="0" max="100"
					placeholder="수학점수"></td>
			</tr>

			<tr>
				<th class="success">주소</th>
				<td>
					<%
					String addr = dto.getAddr();
					%> <select name="addr" id="addr">
						<option value="Seoul"
							<%if (addr.equals("Seoul")) {
	out.print("selected");
}%>>서울</option>
						<option value="Suwon"
							<%if (addr.equals("Suwon")) {
	out.print("selected");
}%>>수원</option>
						<option value="Busan"
							<%if (addr.equals("Busan")) {
	out.print("selected");
}%>>부산</option>
						<option value="Jeju"
							<%if (addr.equals("Jeju")) {
	out.print("selected");
}%>>제주</option>
				</select>
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input class="btn btn-primary"
					type="submit" value="수정"> <input class="btn btn-secondary"
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>

	<%
}
%>


</body>
</html>
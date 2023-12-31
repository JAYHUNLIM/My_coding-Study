package net.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 참조: https://docs.oracle.com/javaee/7/api/
 
 HttpServlet  클래스
  http 프로토콜 기반의 요청과 응답을 처리해 주는 클래스
  
  Welcome 서블릿 클래스
  web.xml에 등록해야 한다

 결과 확인
 http://localhost:9090/basic05_mvc/wel.do
*/
public class Welcome extends HttpServlet{
	//나의  클래스의 부모가 class    extends	상속(확장)
	//나의 클래스의 부모가 interface implements	상속(구현)
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get 방식으로 요청하면 호출됨
		// req: request와 동일	resp:response와 동일
		try {
			
			//html 문서 구조로 응답			
			resp.setContentType("text/html; charset=UTF-8");
			
			//단순 문자열 응답(AJAX)
			//resp.setContentType("text/plain; charset=UTF-8");
			
			//요청한 사용자에게 응답하기 위한 출력 객체
			PrintWriter out=resp.getWriter();
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print(" <meta charset='UTF-8'> ");
			out.print(" <title>welcome</title>");
			out.print("</head>");
			out.print("<body>");
			out.print("  <strong>대한민국</strong>    ");
			out.print("<hr>");
			out.print("	 <span style='color:red'>오필승코리아</span>	");
			out.print("<hr>");
			out.print("	 <table border='1'> ");
			out.print("<tr>");
			out.print("	<th>이름</th>		");
			out.print("	<td>무궁화</td>	");
			out.print("</tr>");
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
		} catch (Exception e) {
			System.out.println("요청 실패"+e);
		} 
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전송방식 post 방식으로 요청하면 호출함
		super.doPost(req, resp);
	}
	
}

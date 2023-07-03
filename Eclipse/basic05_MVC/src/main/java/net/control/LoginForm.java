package net.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet {
//외부 요청을 받아들여서 결과를 보내주는 클래스
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	http://localhost:9090/basic05_MVC/login.do
		
	// get 방식으로 요청
	//1.페이지 이동
	//resp.sendRedirect("control/loginForm.jsp");	
	//자식이랑 공유 X	
		
	//2.페이지 이동
	//자식이랑 공유
	String view="control/loginForm.jsp";
	RequestDispatcher rd=req.getRequestDispatcher(view);
	rd.forward(req, resp);
	
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		}
	
}

package net.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProc extends HttpServlet {
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// method=POST 방식
	// loginForm에서 입력한 정보를 받아옴
	
	try {
		//1.한글 인코딩
		req.setCharacterEncoding("UTF-8");
		
		//2. 사용자가 요청한 정보를 req에서 가져와서 변수에 옮겨 담기
		String uid=req.getParameter("uid").trim();
		String upw=req.getParameter("upw").trim();
		
		
		//요청한 사용자의  SESSION  객체 선언
		 HttpSession session=req.getSession();
		
		 //요청한 사용자의 applicatin 객체 선언
		 ServletContext application=req.getServletContext();
		 
		if (uid.equals("itwill")&&upw.equals("1111")) {
			//로그인 성공
			session.setAttribute("s_uid", uid);
			session.setAttribute("s_upw", upw);
			
			application.setAttribute("a_uid", uid);
			application.setAttribute("a_upw", upw);
			
			req.setAttribute("r_uid", uid);
			req.setAttribute("r_upw", upw);
			
			req.setAttribute("msg", "로그인 성공");
			req.setAttribute("img", "<img src='control/success.jpg' width='100px' height='100px'>");
			
		} else {
			//로그인 실패
			session.setAttribute("s_uid", "guest");
			session.setAttribute("s_upw", "guest");
			
			application.setAttribute("a_uid", "guest");
			application.setAttribute("a_upw", "guest");
			
			req.setAttribute("r_uid", "guest");
			req.setAttribute("r_upw", "guest");
			
			req.setAttribute("msg", "로그인 실패");
			req.setAttribute("img", "<img src='control/fail.png'>");
			
		}
	
	    //http://localhost:9090/basic05_MVC/login.do
		
		//페이지 이동 부모 자식 값 공유 X
		//resp.sendRedirect("control/loginResult.jsp");
		
		//페이지 이동 부모 자식간 값을 공유함
		String view="control/loginResult.jsp";
		RequestDispatcher rd=req.getRequestDispatcher(view);
		rd.forward(req, resp);
		
		} catch (Exception e) {
		System.out.println("요청 실패"+e);
	}
	
	
}
}

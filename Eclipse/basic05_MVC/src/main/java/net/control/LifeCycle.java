package net.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*		
	httpservlet 클래스의 계층도
	class generic {}
	class httpservlet extends generic{}
	class lifecycle extends httpservlet{}
	
 
 	httpservlet 생명주기
 	init() 서블릿이 호출되면 1번만 호출
	->servie()사용자가 요청할때 마다 계속 호출 doget,dopost 구분
 	
 	destroy()서버가 중지되면 1번만 호출된다

 
*/



/*
LIFECYCLE 서블릿을 /WEB-INF/web.xml에 등록해야함
결과 확인  http://localhost:9090/basic05_mvc/life.do

*/

public class LifeCycle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get 방식으로 요청하면 호출됨
		super.doGet(req, resp);
		System.out.println("doGet()호출...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 방식으로 요청하면 호출함
		super.doPost(req, resp);
		System.out.println("doPost()호출...");

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// URL을 통해서 요청이 들어오면, 전송방식  POST,GET방식으로 서비스를 요청했는지
		//판단해서 doGet,doPost함수를 구분해서 호출
		super.service(req, resp);
		System.out.println("service()호출...");
	}	

	@Override
	public void destroy() {
		// 서버가 중지되면, 자동으로 1번만 호출
		super.destroy();

		System.out.println("destroy()호출...");
	}

	@Override
	public void init() throws ServletException {
		// 서블릿이 최초로 호출될 경우 1번만 호출
		// 초기 환경 설정할 경우 사용
		super.init();
		System.out.println("init()호출...");
	}

}

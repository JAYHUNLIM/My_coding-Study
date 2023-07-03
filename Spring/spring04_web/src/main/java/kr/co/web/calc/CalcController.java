package kr.co.web.calc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Controller
public class CalcController {

	public CalcController() {
		System.out.println("●●●●CalcController() 객체 생성");
		
	}
	
	//URL에서 요청한 명령어 등록
	//@RequestMapping(value="",method=GET|POST) 
	// method 정의 하지 않으면  요청한 명령어를 GET->POST 순으로 찾아냄
	
	//결과 확인  http://localhost:9095/add.do?no1=3&no2=4
	@RequestMapping(value ="/add.do",method = RequestMethod.GET )
	public ModelAndView add(HttpServletRequest req) {
		
		//사용자가 요청한 정보를 가져오기
		//형변환후  result에 값을 넣기
		int no1=Integer.parseInt(req.getParameter("no1"));
		int no2=Integer.parseInt(req.getParameter("no2"));
		int result=no1+no2;		
		
		//view 페이지로 이동
		//-> Model
		//-> ModelAndView
		ModelAndView mav=new ModelAndView();
		mav.setViewName("calcResult");
		
		//같은 페이지가 아니기 때문에 전역변수가 필요함
		req.setAttribute("no1", no1);
		req.setAttribute("no2", no2);
		req.setAttribute("result", result);
		req.setAttribute("message","<h3>두수 사이의 합</h3>");
		req.setAttribute("img", "<img src='images/pepe1.png' width='200px'>");
		
		return mav;
	}//add
		
	//결과확인
	//http://localhost:9095/sub.do?no1=3&no2=4
	@RequestMapping(value ="/sub.do",method = RequestMethod.GET )
	public ModelAndView sub(HttpServletRequest req) {
		
		//사용자가 요청한 정보를 가져오기
		//형변환후  result에 값을 넣기
		int no1=Integer.parseInt(req.getParameter("no1"));
		int no2=Integer.parseInt(req.getParameter("no2"));
		int result=no1-no2;		
		
		//view 페이지로 이동
		//-> Model
		//-> ModelAndView
		ModelAndView mav=new ModelAndView();
		mav.setViewName("calcResult");
		
		//같은 페이지가 아니기 때문에 전역변수가 필요함
		req.setAttribute("no1", no1);
		req.setAttribute("no2", no2);
		req.setAttribute("result", result);
		req.setAttribute("message","<h3>두수 사이의 차</h3>");
		req.setAttribute("img", "<img src='images/pepe2.png' width='100px'>");
		
		return mav;
	}//add
	
		//결과확인
		//http://localhost:9095/gop.do?no1=3&no2=4
		@RequestMapping(value ="/gop.do",method = RequestMethod.GET )
		public ModelAndView gop(HttpServletRequest req) {
			
			//사용자가 요청한 정보를 가져오기
			//형변환후  result에 값을 넣기
			int no1=Integer.parseInt(req.getParameter("no1"));
			int no2=Integer.parseInt(req.getParameter("no2"));
			int result=no1*no2;		
			
			//view 페이지로 이동
			//-> Model
			//-> ModelAndView
			ModelAndView mav=new ModelAndView();
			mav.setViewName("calcResult");
			
			//같은 페이지가 아니기 때문에 전역변수가 필요함
			req.setAttribute("no1", no1);
			req.setAttribute("no2", no2);
			req.setAttribute("result", result);
			req.setAttribute("message","<h3>두수의 곱</h3>");
			req.setAttribute("img", "<img src='images/pepe2.png' width='100px'>");
			
			return mav;
		}//add
	
	
		//결과확인
				//http://localhost:9095/div.do?no1=3&no2=4
				@RequestMapping(value ="/div.do",method = RequestMethod.GET )
				public ModelAndView div(HttpServletRequest req,HttpServletResponse resp,HttpSession session) {
					
					//사용자가 요청한 정보를 가져오기
					//형변환후  result에 값을 넣기
					int no1=Integer.parseInt(req.getParameter("no1"));
					int no2=Integer.parseInt(req.getParameter("no2"));
					int result=no1/no2;		
					
					//view 페이지로 이동
					//-> Model
					//-> ModelAndView
					ModelAndView mav=new ModelAndView();
					mav.setViewName("calcResult");
					
					//같은 페이지가 아니기 때문에 전역변수가 필요함
					req.setAttribute("no1", no1);
					req.setAttribute("no2", no2);
					req.setAttribute("result", result);
					req.setAttribute("message","<h3>두수 나누기</h3>");
					req.setAttribute("img", "<img src='images/pepe2.png' width='100px'>");
					
					return mav;
				}//add
	
}

package kr.co.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//URL에서 요청,응답이 가능한 클래스 저장
@Controller 	//스프링 컨테이너(톰캣) 자동으로 객체 생성해준다
public class HomeController {

	public HomeController() {
		System.out.println("★★★★HomeController()객체 생성");
	}
	
	//요청 명령어를 등록하고, 실행의 주체는 메소드(함수)
	
	//결과 확인  http://localhost:9095/home.do
	
	@RequestMapping("/home.do")
	public ModelAndView home() {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("start");
		//  WEB-INF/views/start.jsp
		
		//request 전역 변수 활용하기. 뷰페이지와 값을 공유  
		//request.setAttribute 동일 함수
		mav.addObject("message","pa");
		mav.addObject("img","<img src='images/mouse.png'>");
		return mav;
	}
}

package kr.co.itwill;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {

	public HelloController() {
        System.out.println("-----HelloController()객체 생성됨");
    }//end
	
	//결과확인 http://localhost:9095/hello.do
    //요청명령어 등록후 실행의 주제는 메소드(함수)
    
	@RequestMapping("/hello.do")
    public ModelAndView hello() {
        ModelAndView mav=new ModelAndView();
        // application.properties 환경설정파일의 prefix와 suffix값을 조합해서 뷰페이지를 구성
        // /WEB-INF/views/hello.jsp
        mav.setViewName("hello"); //뷰페이지명
       
        //서로 다른 페이지 간에 값을 공유하기 위한 전역변수
        //->request,session,application
        
        //request.setAttribute함수와 동일
        mav.addObject("message","<p>ㅁㅁㅁㅁㅁㅁㅁ</p><p>welcome to my page</p>");
        
        return mav;
    }//hello() end
}

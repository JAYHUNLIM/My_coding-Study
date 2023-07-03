package kr.co.web.login;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCont {

	public LoginCont() {
		System.out.println("---LoginCont() 객체 생성됨");
	}
	
	//결과확인
	//http://localhost:9095/login.do
	@RequestMapping(value="/login.do",method = RequestMethod.GET)
	public String loginForm() {
		return "login/loginForm";
	}
	
	@RequestMapping( value ="/login.do",method = RequestMethod.POST)
	public ModelAndView loginProc(@ModelAttribute LoginDTO dto, HttpServletRequest req, HttpServletResponse res, HttpSession session) {
	
		String id=dto.getId();
		String pw=dto.getPw();
		//
		req.getParameter("id");
		req.getParameter("pw");
		
		ModelAndView mav=new ModelAndView();
		
		if (id.equals("itwill")&& pw.equals("1234")) {
			//로그인 성공
		mav.setViewName("login/loginResult");
		//전역 변수 session에 값 올리기
		 session.setAttribute("s_id", id);
		 session.setAttribute("s_pw", pw);
		 req.setAttribute("message","<h3>로그인 성공</h3>" );
		}else {
			//로그인 실패
			mav.setViewName("login/msgView");
			req.setAttribute("message", "<p>아이디 비번 일치하지 않음</p>");
			req.setAttribute("link", "<a href='javascript:history.back()'>다시시도</a>");
		}
		
		return mav;
	}
	
}//main end

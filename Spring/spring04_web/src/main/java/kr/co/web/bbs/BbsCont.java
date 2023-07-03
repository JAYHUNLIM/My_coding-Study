package kr.co.web.bbs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller 
public class BbsCont {

	public BbsCont() {
		System.out.println("----BbsCont() 객체 생성됨");
		
	}
	//결과 확인
	//http://localhost:9095/bbs/create.do
	
	@RequestMapping(value="/bbs/create.do", method = RequestMethod.GET)
	
	/*
	1.
	
	public ModelAndView bbsForm() {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("bbs/bbsForm");		
		return mav;
	}
	*/
	
	//2. 위의 방식과 동일하게 페이지 이동이 가능
	public String bbsForm() {
		return "bbs/bbsForm";
	}
	
	// 동일한 요청 명령어를 GET POST방식으로 구분해서 호출 가능하다
	@RequestMapping(value = "/bbs/create.do", method = RequestMethod.POST)
	
	/*
	
	public ModelAndView bbsIns(HttpServletRequest req) {

		// 사용자가 입력 요청한 정보 가져오기
		String wname = req.getParameter("wname").trim();
		String subject = req.getParameter("subject").trim();
		String content = req.getParameter("content").trim();
		String passwd = req.getParameter("passwd").trim();
	
		ModelAndView mav= new ModelAndView();
		mav.setViewName("bbs/bbsResult");	
	
		mav.addObject("wname", wname);
		mav.addObject("subject", subject);
		mav.addObject("content", content);
		mav.addObject("passwd", passwd);
		
		return mav;
	}
	*/
	
	//2. 매개변수를 dto객체로 하는 경우
	// 요구사항을 모두 지켜줘야 에러가 나지 않는다.
	// 해당 클래스에 반드시 폼 컨트롤 용소 이름으로 되어 있는 멤버변수와
	// 각 getter, setter함수가 있다는 전제 하에 가능하다
	// <input type=text name=wname>과  private string wname 이름이 동일해야한다
	//@ModelAttribute 생략 가능
	public ModelAndView bbsIns(@ModelAttribute BbsDTO dto) {
		//dto 값 확인 -콘솔창
		//System.out.println(dto.toString());
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("bbs/bbsResult2");
		mav.addObject("dto", dto);
		return mav;
		
	}
	
	
}

package kr.co.ajax.ajaxtest;

import java.io.PrintWriter;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxTestCont {

	public AjaxTestCont() {
	System.out.println("ajaxCont 객체 생성됨");	
	}
	
	//localhost:9095/ajaxtest01.do
	
	@RequestMapping("ajaxtest01.do")
	public String ajaxTest01() {
		return "ajax/ajaxTest01";
	}
	
	@RequestMapping("ajaxtest02.do")
	public String ajaxTest02() {
		return "ajax/ajaxTest02";
	}
	
	@RequestMapping(value="message.do",method = RequestMethod.GET)
	public void message(HttpServletResponse resp) {
		try {
			//UTF-8방식
			resp.setContentType("text/plain; charset=UTF-8");
			
			//요청한 사용자에게 응답하기 위한 출력객체
			 PrintWriter out=resp.getWriter();
			 out.println("서버에서 응답해준 메세지:");			 
			 out.println("무궁화 꽃이 피었습니다");
			 out.flush();
			 out.close();
			
			
		} catch (Exception e) {
			System.out.println("응답 실패"+e);
		}
	}
	
	//@ResponseBody 활용한 메세지 전송
	// jsp view를 이용하지 않음
	//response 객체에 직접 출력
	//return 값을 그대로 브라우저에 전송
	@ResponseBody
	@RequestMapping(value="message2.do",method = RequestMethod.GET)
	public String message2() {
		return "서버에서 응답한 메세지: GONE WITH THE WIND";
	}
	
	
}

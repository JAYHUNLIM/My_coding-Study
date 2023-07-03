package kr.co.ajax.member;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberCont {

	public MemberCont() {
		System.out.println("MemberCont()객체 생성");
	}
	//http://localhost:9095/member/idcheckform.do
	@RequestMapping("idcheckform.do")
	public String idcheckForm() {
		return "member/idCheck";
	}
	
	@RequestMapping("idcheckproc.do")
	@ResponseBody
	public String idCheckProc(HttpServletRequest req) {
		String userid = req.getParameter("userid").trim();
		String message = "";
		if (userid.length() < 5 || userid.length() > 15) {
			message = "<span style='color:blue;font-weight:bold'>아이디는 5~15글자 이내로 입력!</span>";
		} else {
			if (userid.equals("itwill") || userid.equals("webmaster")) {
				message = "<span style='color:red;font-weight:bold'>중복된 아이디!</span>";
			} else {
				message = "<span style='color:green;font-weight:bold'>사용가능한 아이디</span>";
			}
		} // if

		return message;
	}

	//쿠키를 활용하여 아이디 중복확인을 해야만 회원 가입이 가능하다
	@RequestMapping("idcheckcookieform.do")
	public String idCheckCookieForm() {
		return "/member/idCheck_cookie";
	}
	
	@RequestMapping("idcheckcookieproc.do")
	@ResponseBody
	public String idCheckCookieProc(HttpServletRequest req) {
		
		String userid=req.getParameter("userid").trim();
		String cnt="0";
		
		if (userid.equals("itwill") || userid.equals("webmaster")) {
			cnt="1";//중복
		}
		
		//text 응답
		//return cnt;
		
		//json 응답
		//pom.xml에 라이브러리 추가 필수
		JSONObject json=new JSONObject();
		json.put("count", cnt);	//key,value
		return json.toString();		
	}
	
	@RequestMapping(value="insert.do",method = RequestMethod.POST)
	public void insert(HttpServletRequest req) {
		System.out.println("아이디:"+req.getParameter("userid"));
		System.out.println("비번:"+req.getParameter("passwd"));
		System.out.println("이름:"+req.getParameter("name"));
		System.out.println("이메일:"+req.getParameter("email"));
	}//
	
}

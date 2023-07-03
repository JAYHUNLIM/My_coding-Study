package kr.co.itwill.cart;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

	public CartController() {
		System.out.println("CartController() 객체 생성");
	}
	
	@Autowired
	CartDAO cartDao;
	
	@RequestMapping("/insert")
	public String Cartinsert(@ModelAttribute CartDTO dto, HttpSession session)throws Exception {
		//로그인 기능을 구현했다면 session.getAttribute()
		//dto.setId(session.getAttribute("s_id"))
		dto.setId("test");
		//System.out.println(dto.toString());
		
		cartDao.CartInsert(dto);
		return "redirect:/cart/list";
	}
	
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) {
		//로그인시 String s_id=session.getAttribute("s_id")
		String s_id="test";
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cart/list");
		mav.addObject("list",cartDao.list(s_id));
		return mav;
	}
	/*
	@RequestMapping("/delete")
	public String delete(@RequestParam int cartno)throws Exception {	
		cartDao.cartDelete(cartno);
		return "redirect:/cart/list";	
	}
	*/
	
@RequestMapping("/delete")
	public String delete(int cartno,HttpSession session) {
	//dto에 없는 값은 map으로 넘긴다
	HashMap<String, Object> map=new HashMap<>();
		map.put("cartno", cartno);
		map.put("s_id","test");
		cartDao.cartDelete(map);
		return "redirect:/cart/list";
	}
	
}

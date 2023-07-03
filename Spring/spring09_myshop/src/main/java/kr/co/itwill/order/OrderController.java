package kr.co.itwill.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/order")
public class OrderController {
public OrderController() {
System.out.println(" OrderController() 객체 생성");
}
@Autowired
OrderDAO orderDao;

@RequestMapping("/orderform")
public String orderForm() {
	return "/order/orderForm";
	}

@RequestMapping("/insert")
public ModelAndView orderInsert(@ModelAttribute OrderDTO dto,HttpSession session) {
	ModelAndView mav=new ModelAndView();
	
	//오늘날짜 및 현재시각을 문자열  년월일시분초로 구성해서 반환하기
	SimpleDateFormat sd=new SimpleDateFormat("yyyyMMddHHmmss");
	String date=sd.format(new Date());
	//System.out.println(date);
	
	/*	
	 주문서 번호 생성 알고리즘 
	 최초주문 20230523171731 없으면 1
 			20230523171732 있으면 2

	대체로 문자열타입으로 관리를 한다
	숫자형으로 하는경우 long이 적합
					
	 */
	
	String orderno=orderDao.orderno(date);
	if(orderno.equals("1")) {
		orderno=date+"1";
	}else {
		int n=Integer.parseInt(orderno.substring(14))+1;
		orderno=date +n;
	}
	String s_id="test";
	//String s_id=session.getAttribute("s_id");실제구현
	
	//총 금액 계산하기
	int totalamount=orderDao.totalamount(s_id);
	//System.out.println(totalamount);
	
	//dto에 s_id, orderno,totalamount 담기
	dto.setOrderno(orderno);
	dto.setTotalamount(totalamount);
	dto.setId(s_id);
	
	//orderlist테이블에 행 추가
	 int cnt=orderDao.orderlistInsert(dto);
	// System.out.println("orderlist 행추가 결과:"+cnt);
	 //받는사람, 주소 공백인 경우 에러 발생 주의
	 if (cnt==1) {
		//장바구니 테이블에 있는 주문상품을 orderdetail 테이블에 옮겨 담기
		HashMap<String, String>map=new HashMap<>();
		map.put("orderno", orderno);
		map.put("s_id", s_id);
	
		int result=orderDao.orderdetailInsert(map);
		//System.out.println("orderdetail 행추가 결과  "+result);
		
		 //쇼핑카트 비우기
		 if (result!=0) {
		orderDao.cartDelete(s_id);
		
		//주문 내역서 메일 보내기
		
		mav.addObject("msg","<p>주문이 완료되었습니다</p>");
		mav.addObject("orderno","주문 번호:"+ orderno);
		mav.setViewName("/order/msgView");	// /web-inf/views/order/msgView.jsp
		
		
		}
		 
		
		
	}

	
	 
	return mav;
	
}
}

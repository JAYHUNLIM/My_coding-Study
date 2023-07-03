package kr.co.itwill.memo;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@controller +responsebody
@RestController 
public class MemoCont {

	public MemoCont() {
		System.out.println(" MemoCont() 객체 생성 확인");
	}
	@RequestMapping("/memolist")
	public JSONObject[] memolist() {
		JSONObject dto1=new JSONObject();
		dto1.put("memnono", 1);
		dto1.put("subject", "무궁화 꽃이 피었습니다");
		dto1.put("writer", "오필승");
		dto1.put("readcnt", 5);
		
		JSONObject dto2=new JSONObject();
		dto2.put("memnono", 2);
		dto2.put("subject", "바람과 함께 사라지다");
		dto2.put("writer", "코리아");
		dto2.put("readcnt", 7);
		
		JSONObject[] jsons = {dto1,dto2};
		return jsons;
	}//
}

package kr.co.ajax.book;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookCont {

	/*
	 http://localhost:9095/book/book.do
	*/
	public BookCont() {
	System.out.println("BookCont() 객체 생성");
	}
	
	@RequestMapping("book/book.do")
	public String bookTest() {
		return "book/bookTest";
	}
	
	@RequestMapping("book/booksend.do")
	@ResponseBody
	public String bookSend(HttpServletRequest req) {
	
		int bookIndex=Integer.parseInt(req.getParameter("book"));
		
		String img[]= {"spring.jpg","android.jpg","jquery.jpg","jsmasterbook.jpg"};
		
		return img[bookIndex];
	}
		// http://localhost:9095/book/searchForm.do	
	
	
	@RequestMapping("book/searchForm.do")
	public String booksearch() {
		return "book/searchTest";
	}
	
	@RequestMapping("book/searchProc.do")
	@ResponseBody
	public String searchProc(HttpServletRequest req) {
	  String keyword=req.getParameter("keyword").trim();
	
	  String message=""; //응답메세지
	  
	  if (keyword.length()>0) {
		//검색어가 존재 하는지?
		//		검색어: 자바 
	 ArrayList<String> list=search(keyword);
	//	 message=list.toString();
	//	 System.out.println(message);

	 
	//응답 메세지-> 개수, 찾은 문자열, 찾은 문자열
	// 			 3|자바, 자바 프로그래밍, 자바 안드로이드
	int size=list.size();
	if (size>0) {
		message += size +"|";
		for(int i=0;i<size;i++) {
			String title=list.get(i);
			message += title;
			if (i<size-1) {
				message +=",";
				//마지막에는 ,를 붙이지 않음
			}
		}
	}
	 
	}
	  //System.out.println(message);
	  return message;
		
	}


	public ArrayList<String> search(String keyword) {
		//검색하고자 하는 문자열
		// where title like'% %'
				 String[] keywords= {"Ajax", "Ajax 실전 프로그래밍", "자바",
	 "웹프로그래밍", "웹마스터", "자바 프로그래밍",
	  "자전거", "자라", "JSP 프로그래밍",
	"자바 안드로이드"};
	//keyword를 배열 첫글자부터 비교
    // 같으면 arraylist에 저장
	 ArrayList<String> list= new ArrayList<>();
	 for(String word:keywords) {
		 word=word.toUpperCase();
		 if (word.startsWith(keyword.toUpperCase())) {
			list.add(word);
			
		}
	 }
 
		return list;
	}


	
		 
		 
	
	
}

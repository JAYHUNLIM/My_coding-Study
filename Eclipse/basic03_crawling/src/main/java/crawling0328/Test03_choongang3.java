package crawling0328;

import java.util.Iterator;

import javax.xml.transform.ErrorListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test03_choongang3 {

	public static void main(String[] args) {
		// 중앙정보처리 공지사항 제목만 크롤링하기
		//12페이지 전부
		//참조:https://www.choongang.co.kr/html/sub07_01_n.php?page=12&mod=&idx=
		
		try {
			
			String url ="https://www.choongang.co.kr/html/sub07_01_n.php";
			
			//웹페이지 소스 1~12까지 가져오기
			for(int p=1;p<=12;p++) {
			String params="?page="+p+"&mod=&idx=";
			//System.out.println(params);
			Document doc=Jsoup.connect(url+params).get();
			//System.out.println(doc.toString());
			/*
			 요소 선택하기 
			  <tr class ="board_default_list">
			  <td class="default_title"> 청년취업 아카데미 취업캠프
			  </td>  
			  */
		Elements elements=doc.select(".board_default_list .default_title");
			for (Element element: elements) {
				System.out.println(element.text());
			}
			
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("크롤링 실패: "+e);
		}
		
		
		
	}

}

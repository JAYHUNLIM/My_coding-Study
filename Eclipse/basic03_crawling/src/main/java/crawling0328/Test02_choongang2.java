package crawling0328;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test02_choongang2 {

	public static void main(String[] args) {
		// 중앙정보처리 공지사항 제목만 크롤링하기
		//크롤링은 패턴을 찾기-반복
		//참조:https://www.choongang.co.kr/html/sub07_01_n.php?page=12&mod=&idx=
		
		try {
			
			String url ="https://www.choongang.co.kr/html/sub07_01_n.php";
			
			//웹페이지 소스 1~12까지 가져오기
			for(int p=1;p<=12;p++) {
			String params="?page="+p+"&mod=&idx=";
		System.out.println(params);
			
			//Document doc=Jsoup.connect(url+params).get();
			//System.out.println(doc.toString());
			
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("크롤링 실패: "+e);
		}
		
		
		
	}

}

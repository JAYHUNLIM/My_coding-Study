package crawling0328;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test01_choongang {

	public static void main(String[] args) {
		//웹 크롤링을 위해 jsoup 다운로드
		//크롤링은 패턴을 찾기-반복
		// 중앙정보처리 공지사항 제목만 크롤링하기
		
		try {
			
			String url ="https://www.choongang.co.kr/html/sub07_01_n.php";
			//웹페이지 소스 전부 가져오기
			
			
			
			
			Document doc=Jsoup.connect(url).get();
			System.out.println(doc.toString());
			
		} catch (Exception e) {
			System.out.println("크롤링 실패: "+e);
		}
		
		
		
	}

}

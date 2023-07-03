package crawling0328;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.xml.transform.ErrorListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test07_NAVER {

	public static void main(String[] args) {
		// 네이버 영화 평점 후기 크롤링하기
		// 	영화 사이트 내에 iframe으로 지정한 평점 사이트가 존재한다
		//	/movie/bi/mi/pointWriteFormList.naver?code=215932&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false
		//  "/절대 경로 HOME:https://movie.naver.com/movie/bi/mi/point.naver?code=215932"
		//	네이버 평점 후기 사이트
		//https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver?code=215932&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false	
		//&page=1		
		try {
			
			String url ="https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver";
					
			String params="?code=215932&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false";
			params +="&page=1";	//1페이지만 가져오기
			
			Document doc=Jsoup.connect(url+params).get();
			//System.out.println(doc.toString()); 
			 /*
			//1.평점 제목이 있는 요소
			//<span id="filtered_ment_0"></span>
			//<span id="filtered_ment_9"></span>
			
			for(int ment=0; ment<=9; ment++) {
				Elements elements=doc.select("#_filtered_ment_"+ment);
				for(Element element: elements) {
					System.out.println(element.text());
				}
			}
			*/

			//2.평점 제목이 있는 요소
			/*
			 	<div class="score_reple">
			 	<p>
			 		<span class="ico_viewer">관람객</span>
			 		<span id="_filtered_ment_0">마지막 클라이 맥스때~~ </span>
			 	
			 	</div>	
			 */
			//관람객 지우기	쓸모없는 요소
			Elements elements=doc.select(".score_reple p");
			elements.select(".ico_viewer").remove();
			
			for(Element element: elements) {
				System.out.println(element.text());
			}
			
		} catch (Exception e) {
			System.out.println("크롤링 실패: "+e);
		}
				
	}

}
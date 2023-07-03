package crawling0328;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.xml.transform.ErrorListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test08_NAVER2 {

	public static void main(String[] args) {
		// 네이버 영화 평점 후기 크롤링하기
		// 	ex)스즈메의 문단속 영화 평점 제목을 공감순으로 정렬후 크롤링하기	9441
		//	suzume.txt. 파일에 저장
		
		
		try {
			String filename="D:\\202301\\suzume.txt";
			FileWriter fw= new FileWriter(filename, true);
			PrintWriter  out= new PrintWriter(fw, true);
						
			String url ="https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver";
			String params="?code=215932&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false";
			params +="&order=sympathyScore";	//공감순
			params +="&page=";					//1페이지만 가져오기
			
			//945페이지
			//공감순	sympathyScore	최신순 newest	 평점높은순 highest 	평점낮은순 lowest
			
			for(int p=1;p<=945;p++) {
				System.out.println("데이터 수집중"+p);
				Document doc=Jsoup.connect(url+params+p).get();
				for(int ment=0;ment<=9; ment++) {
					Elements elements=doc.select("#_filtered_ment_"+ment);
					for(Element element : elements) {
						out.println(element.text());
					}
				}
			}
			
			fw.close();
			out.close();
			System.out.println("suzume.text 저장 완료");
			
		} catch (Exception e) {
			System.out.println("크롤링 실패: "+e);
		}
				
	}

}
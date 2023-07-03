package crawling0328;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.xml.transform.ErrorListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test06_ITWILL {

	public static void main(String[] args) {
		//  아이티윌 웹페이지의 공지사항 제목만 크롤링
		//->URL에 웹페이지 경로가 나오지 않는 경우
		/*
		 	bbsId: BBSMSTR_000000000071
			currentMenuNo: 1031100
			pageIndex: 4
			searchCondition: 0
			searchKeyword: 
			
			bbsId: BBSMSTR_000000000071
			currentMenuNo: 1031100
			pageIndex: 3
			searchCondition: 0
			searchKeyword: 
			
			https://www.itwill.co.kr/cmn/board/BBSMSTR_000000000071/bbsList.do?bbsId=BBSMSTR_000000000071
			&currentMenuNo=1031100
			&pageIndex=1
		  */
		
			/* 클래스 요소 제거하기
				<div class="list_item">
					<div class="a1">
				</div>	
				<div class="list_item">
					<div class="a1">
				</div>	
				Elements elements=doc.select(".list_item");
				//class="a1" 요소 제거하기
				 elements.select(" .a1").remove(); 
			 */
			
		
		
		try {
			String url ="https://www.itwill.co.kr/cmn/board/BBSMSTR_000000000071/bbsList.do";
		
			String filename="D:\\202301\\itwill.txt";
			FileWriter fw= new FileWriter(filename, true);
			PrintWriter  out= new PrintWriter(fw, true);
			
			//웹페이지 소스 1~12까지 가져오기
			for(int p=1;p<=4;p++) {
			String params="?bbsId=BBSMSTR_000000000071&currentMenuNo=1031100&searchCondition=&searchKeyword=&pageIndex="+p;
			Document doc=Jsoup.connect(url+params).get();
			
			//System.out.println(doc.toString());
			Elements elements=doc.select(".bgcol01");
			 elements.select(" .ac").remove();
			 
			 //Elements elements=doc.select(".bgcol01>td:nth-child(2)");
			 //Elements elements = doc.select(" .bgcol01 a");
			 
			for(Element element:elements) {
				System.out.println(element.text());
				out.println(element.text());
			}	
			}
			fw.close();
			out.close();
			
			
		} catch (Exception e) {
			System.out.println("크롤링 실패: "+e);
		}
				
	}

}
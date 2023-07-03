package crawling0328;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.xml.transform.ErrorListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test05_choongang5 {

	public static void main(String[] args) {
		// 전자정부 웹페이지에서 공지사항 제목만 크롤링해서
		// junja. TXT 파일에 저장하기
		//?변수=값&변수=값&변수=값&
		try {
			String url ="https://www.egovframe.go.kr/home/ntt/nttList.do";
		
			
			String filename="D:\\202301\\junja.txt";
			FileWriter fw= new FileWriter(filename, true);
			PrintWriter  out= new PrintWriter(fw, true);
			
			//웹페이지 소스 1~12까지 가져오기
			for(int p=10;p<=210;p+=10) {
			String params="?searchKey=&searchValue=&menuNo=74&bbsId=6=";
			 params="&pagerOffset"+p;
			Document doc=Jsoup.connect(url+params).get();
			//System.out.println(doc.toString());
			
			Elements elements=doc.select(".lnk");
			/*
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
			
			for (Element element: elements) {
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
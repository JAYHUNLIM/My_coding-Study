package oop0315;
import java.util.GregorianCalendar;
public class Test07_constructor {

	public static void main(String[] args) {
		//생성자 함수 (Constructor)
		//-> 클래스명과 동일한 함수
		//->new 연산자와 함께 메모리를 할당할때 사용한다
		//-> 오버로드가 가능하다
		
		//소멸자 함수(Destructor)-> 자바에는 없음!!
		//가비지 콜렉팅(Garbage Collecting)
        //->JVM이 자동으로 메모리 회수를 함.	
		
		
	GregorianCalendar today= new GregorianCalendar();
	if(today.isLeapYear(2023)) {
		System.out.println("윤년");
	}else {
		System.out.println("평년");
	}
		
	//문 서기1년~서기 2023년까지 윤년의 갯수를 구하시오
	//	GregorianCalendar 활용
//	1.
	int count_year=0;
	
	for(int i=1;i<=2023;i++) {
	if(today.isLeapYear(i)) {
		count_year++;
	}
	}
	System.out.println("윤년의 갯수:"+count_year);//502
	
	
//	2.
	int count_year1=0;
	
	for(int i=1;i<=2023;i++) {
	 if(i%4==0 && i%100!=0 || i%400==0) {
		count_year1++;
	}
	}
	
	System.out.println("윤년의 갯수:"+count_year1);
	//490
	
	
	
	
	
	}

}

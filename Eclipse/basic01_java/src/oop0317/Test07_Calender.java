package oop0317;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Test07_Calender {

	public static void main(String[] args) {
		// 날짜 관련 클래스(년월일시분초 요일)
		//GregorianCalendar
		//Date		
		//Calendar
		
		
		
		GregorianCalendar now =new GregorianCalendar();
		System.out.println(now.get(1));//2023 년도
		System.out.println(now.get(2));//2 (+1)  월 
		System.out.println(now.get(2)+1);//3월 
		System.out.println(now.get(5));//17일
		
		//test01_final.java 참조
		System.out.println(now.get(Calendar.YEAR));//2023 년도
		System.out.println(now.get(Calendar.MONTH));//2 (+1)  월 
		System.out.println(now.get(Calendar.MONTH)+1);//3월 
		System.out.println(now.get(Calendar.DATE));//17일

		System.out.println(now.get(Calendar.HOUR));//5시
		System.out.println(now.get(Calendar.MINUTE));//13분 
		System.out.println(now.get(Calendar.SECOND));//28초

		System.out.println(now.get(Calendar.HOUR_OF_DAY));//24시간 기준
		System.out.println(now.get(Calendar.DAY_OF_WEEK));//6 금요일(일요일:1 ~ 토요일:7기준)

		//날짜 데이터 구성하기		
		//1989년 5월 30일
		GregorianCalendar myBirth= new GregorianCalendar();
		myBirth.set(Calendar.YEAR,1989);
		myBirth.set(Calendar.MONTH,Calendar.MAY);
		myBirth.set(Calendar.DATE,30); 
		/////////////////////////////////////////////////
		
		//날짜 데이터 연산
		
		//now날짜에 3년 더하기	
		now.add(Calendar.YEAR,3);
		System.out.println(now.get(Calendar.YEAR));
		//now날짜에 5달빼기
		now.add(Calendar.MONTH, -5);
		System.out.println(now.get(Calendar.MONTH));
		
		//now날짜에 7일 더하기
		now.add(Calendar.DATE, 7);
		System.out.println(now.get(Calendar.DATE));
	}
}

package oop0320;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Jumin {
private String juminno;//주민번호 저장
public Jumin() {}
public Jumin(String juminno) {
	this.juminno=juminno;
}

public boolean validate() {
	boolean flag=false;
	//주민번호가 맞으면 flag 변수 값을 true 대입하시오
	
	
	Integer [] CHECKNUM = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};	//각 자리 곱할 값
	Integer [] save = new Integer[12];
	int hap=0;
	int size=save.length;
	
	for(int i = 0; i < size; i++) {
		//주민번호에서 한글자씩 가져와서 정수형 변환
		//charAt() '8'
		//substring "8"
		
		int num = Integer.parseInt(juminno.substring(i,i+1));
		save[i]= num*CHECKNUM[i];
		hap=hap+save[i];
	}
	int M= (11-(hap%11))%10; 
	//오류 검증 번호
	
	if(M==Integer.parseInt(juminno.substring(12))) {
		flag=true;
	}
	return flag;
}

public void disp() {
	//생년월일, 성별, 나이, 띠 출력
	/*
	 생년월일:1989년 12월 30일
	 성별: 남자
	 나이: 34 ->gregorian calendar클래스 이용
	 띠: ->태어난 %12 (0원숭이 1닭 2개~~11양)
	*/
	
	 GregorianCalendar now =new GregorianCalendar();
	int cYear=now.get(Calendar.YEAR); //2023
	int cMonth= now.get(Calendar.MONTH)+1;
	int cday=now.get(Calendar.DATE);
	//성별코드
	int myCode=Integer.parseInt(juminno.substring(6, 7));
	int myYear=0,myMonth=0,myDate=0;
	myYear=Integer.parseInt(juminno.substring(0, 2));
	myMonth=Integer.parseInt(juminno.substring(2, 4));
	myDate=Integer.parseInt(juminno.substring(4, 6));
	switch(myCode) {
	case 1:
	case 2:myYear=1900+myYear; break;
	case 3:
	case 4:myYear=2000+myYear;break;
		}
	
	//나이 구하기
	int myAge=cYear-myYear;
	String gender="";
	switch(myCode%2) {
	case 0: gender="여자"; break;	
	case 1: gender="남자"; break;
	}
	
	String[] animal= {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
	 System.out.println("주민번호:"+juminno);
	 System.out.println("생년월일:"+myYear+"년"+myMonth+"월"+myDate+"일");
	 System.out.println("나이:"+myAge);
	 System.out.println("성별:"+gender);
	 System.out.println("띠:"+animal[myYear%12]);
	 //살아온 날수 (네이버 날짜 계산기 참조)
	 int cdays =365*cYear + 30*cMonth + cday;
	 int mdays = 365*myYear+ 30*myMonth+ myDate;
	 int rdays= cdays-mdays;

	 System.out.println("살아온 날짜:"+rdays);
	 /*
//생년월일
int number = Integer.parseInt(juminno.substring(0, 2))+1900;
int gender = Integer.parseInt(juminno.substring(7, 8));
 System.out.print(number+"년");
 System.out.print(juminno.substring(2,4)+"월");
 System.out.println(juminno.substring(4,6)+"일");
  
 if((gender==1) || (gender==3)) {
	 System.out.println("성별:남자");
 }else {
	 System.out.println("성별:여자");
 }
 
 //나이 구하기
 GregorianCalendar now =new GregorianCalendar();
 System.out.println("만나이:"+(now.get(1)-number));
 //띠 구하기
 int age1 = number % 12; 
 if(age1==0) {
	 System.out.println("띠: 원숭이");
 }else if(age1==1) {
	 System.out.println("띠: 닭");
 }else if (age1==2) {
	 System.out.println("띠: 개");
 }else if(age1==3) {
	 System.out.println("띠: 돼지");
 }else if(age1==4) {
	 System.out.println("띠: 쥐");
 }else if(age1==5) {
	 System.out.println("띠: 소");
 }else if(age1==6) {
	 System.out.println("띠: 호랑이");
 }else if(age1==7) {
	 System.out.println("띠: 토끼");
 }else if(age1==8) {
	 System.out.println("띠: 용");
 }else if(age1==9) {
	 System.out.println("띠: 뱀");
 }else if(age1==10) {
	 System.out.println("띠: 말");
 }else {
	 System.out.println("띠: 양"); }
 
 */
}
}

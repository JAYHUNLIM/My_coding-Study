package oop0317;

import java.util.Calendar;

/* 1.final클래스 (종단 클래스)
final class Animal{
}

class Elephant extends Animal{
}
*/

//2.final메소드
class Fruit{
	void view() {}
final void disp() {}
}

class Apple extends Fruit{
	//자식클래스 extends 부모 클래스
@Override //annotation, 재정의(리폼)
void view() {
	}


//@Override
//void disp() {
//	
//}  에러 발생 final메소드는 더이상 override할수없다

}


public class Test01_final {

	public static void main(String[] args) {
		// final 마지막
		//변수	변수를 상수화 
		//함수	더 이상 리폼할수 없다(override)
		//클래스	종단클래스. 후손 클래스를 만들수 없다
		
		int a =3;
		a=5;
		//변수는 다른값으로 대입가능
		
		final int b=2;
		//b=4; 에러. final 변수는 다른값으로 대입불가능  const let
		//변수의 상수화
		System.out.println(Calendar.YEAR);//1
		System.out.println(Calendar.MONTH);//2
		System.out.println(Calendar.DATE);//5
		
		
		System.out.println(Calendar.HOUR);
		System.out.println(Calendar.MINUTE);
		System.out.println(Calendar.SECOND);
		
		
		/*
		 class Calender{
		 	static final  int YEAR=1;
		 	static final  int MONTH=2;
		 	static final  int DATE=5;	
		 	}
		  */
//		Calendar.YEAR=3; //에러.final 변수값은 변경 불가능
//		Math.PI=3.15; 	에러.
		
	}

}

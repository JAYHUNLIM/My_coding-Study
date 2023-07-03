package oop0315;

public class Test08_constructor {

	public static void main(String[] args) {
		// 생성자 함수 연습
		// school 클래스 생성후 연습합니다
		
		//new School();//객체 (object) 또는 instance
		new School();
		//값을 넣기 전 상태
		School one =new School();
		System.out.println(one.hashCode());
		one.calc();
		one.disp();
		//클래스에 데이터가 없는 상태면 null값을 가진다
		
		
		String a=new String();//빈문자열
		String b= null;//메모리 할당x.b라는 참조변수 선언만 해놓음
System.out.println(a.length());	//글자수 0
System.out.println(b.length());//NullPointerException
		

System.out.println("null");//문자열 상수


	}

}

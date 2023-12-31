package oop0313;

public class Test02_print {

	public static void main(String[] args) {
		// 콘솔창 출력
		System.out.print(123); //숫자 데이터
		System.out.print("SEOUL"); //문자열 데이터
		//출력하고 줄바꿈(엔터)
		System.out.println(123);
		System.out.println(456);
		System.out.println(789);
	
		//SYSO 입력후 CTRL + SPACE
		System.out.println();//콘솔창에서 줄바꿈
		
		//문자열 데이터 구분 기호 "
		System.out.println("JAVA");
		System.out.println("PYTHON");
		System.out.println(123);//숫자형
		System.out.println("456");//문자열형
		System.out.println();
		
		// " ' \ 등을 단순한 기호로 인식하고자 할때
		System.out.println("\"");
		System.out.println("\'");
		System.out.println("\\");
		
		//+연산자
		System.out.println(123+456);//579
		System.out.println("123"+"456");//"123456"
		System.out.println(123+"456");//"123456"
		System.out.println("123"+456);//"123456"
		System.out.println("123+456");//"123+456"
		
		
		
	}
}

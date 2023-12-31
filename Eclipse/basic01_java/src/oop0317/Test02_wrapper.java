package oop0317;

import java.lang.*;// 자바의 기본 패키지

public class Test02_wrapper {

	public static void main(String[] args) {
		// wrapper class 포장 클래스
		//기본 자료형을 참조형화 해 놓은 클래스들
		// 대부분 java.lang 패키지에 선언	
		/*
		 
		 기본형 		참조형
		 boolean	Boolean
		 short		Short
		 byte		Byte
		 int		Integer
		 long		Long
		 float		Float
		 char		Character
		 double		Double
		 */		
///////////////////////////////////////

		boolean boo1= true;
		Boolean boo2 = new Boolean("false");//deprecated 절판 
		Boolean boo3=true;
		
		System.out.println(boo1);
		System.out.println(boo2);
		System.out.println(boo3);
		System.out.println(boo3.toString());//"true"
		
///////////////////
		
	int in1=3;
	Integer in2=new Integer(5);
	Integer in3=7;
	System.out.println(in1);
	System.out.println(in2);
	System.out.println(in3);
	System.out.println(in2.toString());//5
	System.out.println(in3.doubleValue());//7.0
//////////////////////////
	System.out.println(Integer.toBinaryString(15));//"1111"2진수
	System.out.println(Integer.toOctalString(15));//17 8진수
	System.out.println(Integer.toHexString(15));//"f" 16진수

	System.out.println(Integer.max(2, 4));//4
	System.out.println(Integer.min(2, 4));//2
	System.out.println(Integer.sum(2, 4));//6
		
	System.out.println(Integer.parseInt("123"));  //"123" ->123
//	NumberFormatException 오류 발생. 숫자가 아닌 문자
//	System.out.println(Integer.parseInt("KOREA"));

	long lo1=3L;
	Long lo2=new Long(5);
	Long lo3=7L;
	
	double dou1=2.5;
	Double dou2=new Double("3.5");
	Double dou3=6.7;
	
//실수형 값들 중에서 정수의 합을 구하시오 2+3+6
	int hap=(int)dou1+dou2.intValue()+dou3.intValue();
	System.out.println(hap);
////////////////////////////////////////////	
	
	char ch1='R';
	Character ch2='m';
	Character ch3= new Character('a');
	
	System.out.println(ch1);
	System.out.println(ch2);
	System.out.println(ch3);

	System.out.println(Character.isWhitespace(' '));//공백여부
	System.out.println(Character.toLowerCase('R'));//소문자로 변환
	System.out.println(Character.toUpperCase('a'));//대문자로 변환
	}

}

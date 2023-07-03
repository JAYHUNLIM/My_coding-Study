package oop0313;

public class Test04_operator {

	public static void main(String[] args) {
		// 연산자
		//산술, 비교(관계), 논리연산자
		//삼항, 대입, 1증감 연산자
		
		System.out.println(5/3);//1
		System.out.println(5%3);//2

		System.out.println(3/5);//0 *java는 정수 계산시 소수점이 없다
		System.out.println(3%5);//3
	
		System.out.println(3.0/5.0);//0.6
		System.out.println(3/5.0);//0.6
		System.out.println(3.0/5);//0.6
		System.out.println(3/5.);//0.6
		/////////////////////////////////
		
		//bit 연산자
		
		//1.비트곱, 비트합연산자
		System.out.println(5&3);//1
		System.out.println(5|3);//7
		//논리곱 and &&
		//논리합 or ||
		/*
		 	2진수: 0 1
		 	8진수: 0 1 2 3 4 5 6 7 
		 	10진수: 0 1 2 3 4 5 6 7 8 9
		 	16진수: 0 1 2 3 4 5 6 7 8 9 a b c d e f  
		 	
		 	16 32 64 128
		 	8 4 2 1
		 	10진수 5를 2진수 변환:101
		 	10진수 3을 2진수 변환:	11
		 	10진수 9를 2진수 변환:1001
		 	10진수 35를 2진수변환:100011
		 	
		 			&&  연산       ||
		 	5:00000101	      00000101
		 	3:00000011	      00000011
		 	------			-----------	
		 	각 자릿수마다 곱	 각자릿수를 더하기	
		 	 00000001		  00000111
		 	  
		 	bit->8개 ->1byte 최소단위
		 	
		 */
		
		//2. 비트 부정 연산자
		//논리 부정 not !true	
		System.out.println(~5);//-6
		// ~(00000101)->11111010
		// 각 자릿수의 반대
		
		//3.shift 연산자
		//3은 이동 비트 수를 나타낸다
		System.out.println(16<<3);//128 left shift  16*(2^3)
		System.out.println(16>>3);//2 right shift	16/(2^3)
		/*
		  16을 2진수 변환	00010000   00010000
				 		 <<3		  >>3
		 				10000000   00000010
		 				--------- ----------
		 				128				 2
		 				
		 */
		
		
	}

}

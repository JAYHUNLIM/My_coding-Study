package oop0315;

public class Test02_overload {

	public static void hap(int a) {
		System.out.println(a);
	}
	public static void hap(int a, int b) {
		System.out.println(a+b);
	}
	
	public static void hap(double a) {
		System.out.println(a);
	}
	public static void hap(double a, double b) {
		System.out.println(a+b);
	}
	/*
	 * 에러 발생. 함수의 리턴형은 메소드 오버로딩의 조건이 아니다
	public static int hap(double a, double b) {
		
	}
	*/
	public static void main(String[] args) {
		//METHOD OVERLOAD 함수명 중복 정의
		//->함수명을 중복해서 사용할수 있다
		
		//메소드 오버로딩 전제조건
		//->매개변수의 갯수가 달라야 한다
		//->매개변수의 자료형이 달라야 한다
		
		hap(3);
		hap(2,4);
		hap(5.6);
		hap(9.8, 7.6);
		
//		절대값 구하기
		System.out.println(Math.abs(-3));// int 형
		System.out.println(Math.abs(4l));// long형
		System.out.println(Math.abs(5.6f));// float 형
		System.out.println(Math.abs(7.8d));// double형
		
		
		
	}

}

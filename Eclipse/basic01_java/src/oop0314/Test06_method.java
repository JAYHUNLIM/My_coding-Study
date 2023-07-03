package oop0314;

public class Test06_method {

	//메소드 작성 영역
	//void return값이 없다
	
	public static void test1() {
		System.out.println("java");
	}//test1 end
	
	public static void test2() {
		System.out.println("python");
		return; //함수를 호출한 시점으로 되돌아간다
				//마지막 return 명령어는 생략 가능
	}
	
	public static void test3(int a) {
		System.out.println(a);
		return;
	}
	
	public static void test4(int a,int b, int c) {
		System.out.println(a+b+c);
		return;
	}
	public static void test5 (double a, double b) {
		System.out.println(a+b);
	}
	
	public static void test6(char c, byte n) {
		for(int a=1;a<=n;a++) {
			System.out.print(c);
		}
	}
	public static void main(String[] args) {
		//method 메소드
		//함수, function, 프로시저		
		//1.리턴값이 없는 함수
		
		//1) 전달값(argument value)없는 경우
			test1();//함수호출
			test2();
			test1();
			
		//2)전달값이 있는 경우
		test3(10);
		test4(20,30,40);
		test5(1.2, 3.4);
		
		//문제 #기호를 100번 출력하시오
		byte num =100;
		char ch='#';
		test6(ch,num);
	}
}

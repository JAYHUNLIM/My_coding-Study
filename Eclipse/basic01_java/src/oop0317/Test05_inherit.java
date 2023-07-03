package oop0317;

public class Test05_inherit {

	public static void main(String[] args) {
		//상속 inheritance
		/*
		 	-재활용 
		 	-부모와 자식, 조상과 후손(파생), super와 sub
		 	-extends 확장, implements 구현
		 	-형식) 자식 extends 부모{}	    
		  */
//클래스 기반 
//클래스에서 다중상속은 불가능(부모가 2개)
		
		//AA클래스 생성하고 실습
		
		
		AA aa=new AA();
		aa.one();
		aa.two();
//		aa.zero();
//		에러 private 속성은 클래스 내부에서만 접근가능
		System.out.println("---------------------");
		
		BB bb=new BB();
		bb.three();
		bb.one();
		bb.two();
//		bb.zero(); 에러. private 속성은 상속되지 않음.
		System.out.println("---------------------");
		CC cc=new CC();
		cc.four();
		cc.three();
		cc.two();
		cc.one();
		System.out.println("----------------------");
	}
}

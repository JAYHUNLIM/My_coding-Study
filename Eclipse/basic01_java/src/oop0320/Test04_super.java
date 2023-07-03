package oop0320;

public class Test04_super {

	public static void main(String[] args) {
		//super 부모, 조상
		//superclasses 부모클래스들
		//subcalssed 자식 클래스들

		//super: 자식클래스에서 부모 클래스의 멤버에 접근할때
		//super() : 자식 클래스의 생성자 함수가 부모 클래스의 생성자 함수를 호출할때
		
		//this	: 멤버변수와 지역변수를 구분하기 위해
		//this(): 자신의 생성자 함수가 자신의 생성자 함수를 호출할때
		
		//school 클래스 생성후 실습
		
		//상속관계에서 생성자 함수 호출순서
		//->부모 생성자가 먼저 호출되고 자신의 생성자 함수가 호출된다
		//School()->MiddleSchool()
		MiddleSchool ms= new MiddleSchool();
		ms.disp();
		//School()->HighSchool()
		HighSchool hs =new HighSchool();
		hs.disp();
	}
}

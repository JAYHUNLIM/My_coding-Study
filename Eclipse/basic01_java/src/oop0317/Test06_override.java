package oop0317;
//Korea.java파일과 연동
public class Test06_override {

	public static void main(String[] args) {
		// method override 함수 재정의 
		//->상속관계에서 물려받은 다시 수정(리폼)
		
		//Korea 클래스 생성후 실습
		
		//1.오버라이드 하기 전
		Seoul se= new Seoul();
		se.view();
		se.disp();
		//부모가 물려준 그대로 출력
		//2.오버라이드 한 후
		Busan bu =new Busan();
		bu.view();//final method 상속은 가능하지만 오버라이드 불가능
		bu.disp();
		
	}

}

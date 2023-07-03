package oop0321;

import oop0321.WebProgram.Language;
import oop0321.WebProgram.Smart;

public class Test06_inner {

	public static void main(String[] args) {
		// 내부클래스 inner class
		//->클래스 내부에서 선언된 클래스
		////////////////////////////
		
		//Web Program클래스 생성후 실습
		
		WebProgram  web= new WebProgram();
		web.print();
		
		//에러 내부 클래스는 직접 접근 불가능
		//Language lang= new Language();
		//Smart sm= new Smart();
		
		//내부 클래스는 외부에서 단계적으로 접근할수 있다
		Language lang = new WebProgram().new Language();
		lang.display();
		
		Smart sm= new WebProgram().new Smart();
		sm.display();
		
		/*
		 	안드로이드 (구글에서 만든 모바일 전용 os)
		  	class R{
		  	class id{
		  		String btn="버튼";}
		  	}
		  	접근 방식 R.id.btn
		  	자바
			코틀린, GO
			MYSQL MariaDB
		  	
		  	
		  */
	}
}

package oop0320;

public class Test01_getset {

	public static void main(String[] args) {
		//getter와 setter함수 
		
		/*
		 ※함수명 작성 규칙
		 	-is함수명()	대부분 boolean형으로 변환
		 	-to함수명()	to뒤의 값을 반환
		 	-get함수명()	대부분 return값이 존재
		 	-set함수명()	원하는 값으로 세팅할 때  
		 */
		
		//getter함수명을 작성하는 규칙
		//->get멤버변수의 첫글자 대문자 바꾼후 함수명()
		
		
		//Setter함수명을 작성하는 규칙
		//->Set멤버변수의 첫글자 대문자 바꾼후 함수명()
		
		//BbsDTO클래스 생성후 실습
		
		BbsDTO dto=new BbsDTO();
		dto.setBbsno(1);
		dto.setWriter("홍길동");
		dto.setSubject("무궁화 꽃이 피었습니다");
		
		System.out.println(dto.getBbsno());
		System.out.println(dto.getWrite());
		System.out.println(dto.getSubject());
		
		
	}

}

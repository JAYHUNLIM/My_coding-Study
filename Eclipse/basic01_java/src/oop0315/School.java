package oop0315;

class School {
//멤버변수field
private String name;
private int kor, eng, mat;
private int aver;

//생성자 함수 constructor
//자동생성 굳이 만들 이유가 없다
//클래스 명과 동일한 함수
//리턴형이 없음
//public void school(){}사용하지 않도록 주의
	public School() {
		System.out.println("School() 호출....");
	}
	//기본 생성자 함수
	//default constructor

//멤버함수method
	public void calc() {
		aver=(kor+eng+mat);
	}
	
	public void disp() {
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(mat);
		System.out.println(aver);
	}
	
}//

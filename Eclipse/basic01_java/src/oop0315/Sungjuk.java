package oop0315;

class  Sungjuk {//package 생략되어 있다
			 //클래스명의 첫글자는 대문자로 한다
	
//멤버변수 field
public String name;//클래스 외부에서 접근가능
int kor, eng, mat;//PACKAGE 생략되어 있다

//보통 멤버변수는 private으로 숨겨 놓는다
private int aver;	//SUNGJUK 내부에서만 접근 가능
	
//멤버함수 method
private void view() {}


void calc()	{
//package 생략 가능
//클래스 내부의 멤버들 간에는 access modifier와 상관없이 접근 가능
aver= (kor+eng+mat)/3;
view();
	
}

public void disp() {
	System.out.println(name);
	System.out.println(kor);
	System.out.println(eng);
	System.out.println(mat);
	System.out.println(aver);
}

}//end

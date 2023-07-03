package oop0316;

public class Score {
	//멤버변수 field
private String name="손흥민";
private int kor, eng, mat;
private int aver;

//생성자 함수 constructor는 오버로딩하면 기본생성자함수는 생성되지 않음
//기본 생성자 함수는 수동으로 생성할것을 추천
public Score() {
	
}

public Score(String name, int kor, int eng, int mat) {
	//this.멤버변수= 지역변수
	this.name= name;
	this.kor=kor;
	this.eng=eng;
	this.mat=mat;
	this.aver=(kor+eng+mat)/3;
}
	
public void disp() {
String name="박지성"; //지역변수의 우선순위가 가장 높음
System.out.println(name); //박지성
System.out.println(this.name); //손흥민
System.out.println(this.kor);
System.out.println(this.eng);
System.out.println(this.mat);
System.out.println(this.aver);
}
	
	
}

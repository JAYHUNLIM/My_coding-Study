package oop0316;

class School {
//멤버 변수 field column property attribute
private String name;
private int kor, eng, mat;
private int aver;
	
//생성자 함수
public School(){
	System.out.println("school() 호출!");
}
//생성자 함수도 오버로드 가능
public School(String n) {
	name=n;
}
public School(int k, int e, int m) {
	kor=k;
	eng=e;
	mat=m;
}

public School(String n,int k, int e, int m) {
	name=n;
	kor=k;
	eng=e;
	mat=m;
}
//멤버함수	
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




}

package oop0315;// 현재 클래스의 저장 위치. 한번만 선언한다
//클래스를 사용하려면 저장위치(패키지) 선언하고 사용한다
import java.io.*;
import java.sql.*;
import java.util.Arrays;
//해당 클래스를 직접 선언
import java.awt.*;	//gui 클래스 선언
import javax.swing.*;// gui 클래스 선언
import oop0314.*;

/*
 	Access Modifier 접근제어, 접근수정
 	->private		비공개 , 클래스 내부에서만 접근 가능.은닉할 수 있다
 	 package		생략한다. 현재 package(oop0315)내에서만 접근 가능하다
 	 protected	   상속관계에 있는 클래스가 다른 패키지에 있는 경우 접근가능하다
 	 public		 	공개. basic01_java프로젝트내에서 모두 접근 가능하다

  */



public class Test06_class {

	public static void main(String[] args) {
		//클래스와 객체 (object) 
		//-> 클래스명의 첫글자 대문자로 한다	
		//->구성멤버: 멤버변수(field column), 멤버함수(method)
		
//	System.out.println(Math.E);//멤버변수
//	System.out.println(Math.PI);
//	System.out.println(Math.abs(-3));//멤버 함수
				
//★sungjuk클래스 생성후 테스트 	

//자료형	
//기본자료형	
//참조자료형(reference) -> 클래스

//new 연산자
//클래스를 사용하려면 메모리를 할당하고 사용한다(클래스 객체, instance)	
//형식 new 클래스명()

// 객체 지향 프로그램 (Object Oriented Program)		

//기본자료형
//int a=3;//int는 메모리 4바이트 할당

//참조자료형
//RAM(Random ACCESS MEMORY) heap 영역에 메모리가 할당되고 주소가 발생된다
//new Sungjuk(); -> 객체 object 혹은 instance
/////////////////////////////////////////////

//참조변수	 주소를 저장가능:메모리가 할당된 곳의 주소를 가리킨다	
Sungjuk sj = new Sungjuk(); //100번지 		

//.연산자
//참조 변수를 통해 객체에 접근하는 연산자
sj.name="김연아";
sj.kor=100;
sj.eng=95;
sj.mat=80;
//sj.aver 에러 발생.private속성은 클래스 외부에서 접근불가

sj.calc();
sj.disp();
//sj.view 에러 발생.private속성은 클래스 외부에서 접근불가
///////////////////////////////////

Sungjuk one = new Sungjuk();
one.name="박지성";
one.kor=20;
one.eng=30;
one.mat=35;

one.calc();
one.disp();

Sungjuk two = new Sungjuk();
two.name="홍길동";
two.kor=100;
two.eng=95;
two.mat=90;

two.calc();
two.disp();

//////////////////////////////////////////


//참조변수가 가지고 있는 객체의 주소값
System.out.println(one.hashCode());
System.out.println(two.hashCode());

int i=3;
int j=i;

Sungjuk tmp= two;
System.out.println(tmp.hashCode());

tmp.disp();


}
}

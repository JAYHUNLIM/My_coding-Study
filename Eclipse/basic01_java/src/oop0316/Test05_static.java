package oop0316;

public class Test05_static {

	public static void main(String[] args) {
		// static 정적
		//->변수(정적변수, 클래스 변수), 함수
		//-> 메모리 생성 1번, 소멸도 1번 된다
		//->new 연산자를 이용해서 별도의 객체 생성없이 사용가능
		
		
		//static은 클래스명으로 직접 접근 가능하다
		//->클래스명.변수
		//->클래스명.함수()
//		
//		System.out.println(Math.PI);클래스명.변수
//		System.out.println(Math.abs(-3)); 클래스명. 함수
//		System.out.println(String.format("%.2f", 12.3456));
		//////////////////////////////////////////////////
		
		//Sawon 클래스를 생성하고 실습
		
//		static변수와 static함수는 클래스명으로 직접 접근한다
		System.out.println(Sawon.COMPANY);
		System.out.println(Sawon.SUDANG);
		System.out.println(Sawon.TAX);
		Sawon.line();
		 
//		1.static 특징을 적용하지 않은 경우
		Sawon one = new Sawon("1001","홍길동",100);
		//나의 세금
		double myTax=one.pay*one.TAX;
		//나의 총 지급액 = 급여-세금+수당
		int total=(int)(one.pay- myTax + one.SUDANG);// 100-3+10
		
		System.out.println("회사:"+one.COMPANY);
		System.out.println("사번:"+one.sabun);
		System.out.println("이름:"+one.name);
		System.out.println("급여:"+one.pay);
		System.out.println("수당:"+one.SUDANG);
		System.out.println("세금:"+myTax);
		System.out.println("총지급액:"+total);
		one.line();
		
//		2.static의 특징을 적용한 경우
		Sawon two= new Sawon("1002","진달래",200);
		myTax=two.pay*Sawon.TAX;
		total=(int)(two.pay-myTax+Sawon.SUDANG);

		System.out.println("회사:"+Sawon.COMPANY);
		System.out.println("사번:"+two.sabun);
		System.out.println("이름:"+two.name);
		System.out.println("급여:"+two.pay);
		System.out.println("수당:"+Sawon.SUDANG);
		System.out.println("세금:"+myTax);
		System.out.println("총지급액:"+total);
		Sawon.line();
		
//////////////////////////////////////////////////
		
	//3.static 변수의 연산(continue) 연산이 이어진다
//-> 생성도 1번, 소멸도 1번 
		Sawon kim= new Sawon("1003","진달래",300);
		Sawon lee= new Sawon("1004","진달래",400);
		
		System.out.println(kim.SUDANG);//10
		System.out.println(kim.SUDANG);//10
		
		kim.SUDANG=kim.SUDANG+1;//10+1
		System.out.println(kim.SUDANG);
		lee.SUDANG=lee.SUDANG+1;//12
		System.out.println(lee.SUDANG);
		
		Sawon.SUDANG=Sawon.SUDANG+1;//12+1
		System.out.println(Sawon.SUDANG);//추천
		System.out.println(kim.SUDANG);
		System.out.println(lee.SUDANG);
		
	}

}

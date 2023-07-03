package oop0321;

public class Test03_interface {

	public static void main(String[] args) {
		// 인터페이스 interface
		/*
		 -추상 메소드만 구성되어 있다
		 -추상 클래스보다 더 추상화 되어 있다 
		 -상속: extends 확장, implements 구현
		*/
		
		// 인터페이스 creature 생성후 실습
		
		//에러. 인터페이스는 직접 개체 생성 불가
		//Creature creature = new Creature();
		
		//인터페이스에서 다형성
		Creature creature=null;
		
		creature = new Tiger();
		creature.kind();
		creature.breathe();
		
		creature= new Salmon();
		creature.kind();
		creature.breathe();
		
		
	}
}

package oop0321;

abstract class Animal {	//추상클래스
String name;
void view() {}//일반 메소드
abstract void disp(); //추상 메소드(미완성)
}
//추상 클래스를 상속받은 자식 클래스는 반드시 추상메소드를완성해야한다(override)
class Elephant extends Animal{

	@Override
	void disp() {	
	System.out.println("점보");
	}
	
}

class Tuna extends Animal{

	@Override
	void disp() {
		System.out.println("니모");
	}
	
}

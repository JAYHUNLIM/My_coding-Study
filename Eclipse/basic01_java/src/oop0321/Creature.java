package oop0321;

public interface Creature {
//void disp() {}에러. 본체가있는 메소드는 사용불가
	abstract void kind(); //추상 메소드
	void breathe();		 //abstract 생략가능

}


class Tiger implements Creature{

	@Override
	public void kind() {
		System.out.println("포유류");
	}

	@Override
	public void breathe() {
		System.out.println("허파");
	}
	}

class Salmon implements Creature{

	@Override
	public void kind() {
		System.out.println("어류");
	}

	@Override
	public void breathe() {
		 System.out.println("아가미");
	}
	}

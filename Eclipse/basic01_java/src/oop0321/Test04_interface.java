package oop0321;
class Unit{
	int currentHP;
	int x,y;
}

interface Movable{
	void move(int x,int y);
}

interface Attackable{
	void attack(Unit u);
}

//인터페이스 간 상속은 다중상속이 가능하다
interface Fightable extends Movable,Attackable{
	
}

class Fight extends Unit implements Fightable{
	//클래스 입장에서 클래스는 단일 상속만 가능
	@Override
	public void attack(Unit u) {
				
	}
	
	@Override
	public void move(int x, int y) {
			
	}

}

class Tetris extends Unit implements Movable,Attackable{
	//클래스 입장에서 클래스는 단일상속만 가능하고,
	//인터페이스는 다중구현이 가능
	@Override
	public void attack(Unit u) {}

@Override
public void move(int x, int y) {}
	
}


public class Test04_interface {

	public static void main(String[] args) {
		// 클래스와 인터페이스의 상속
	
		
		
		
		
	}
}

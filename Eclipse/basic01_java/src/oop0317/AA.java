package oop0317;
//종단 클래스는 상속 받을수 없다
//final class AA{}
class AA {
	private void zero() {}
	public void one() {
		System.out.println("AA.one()...");}
	public void two() {
		System.out.println("AA.two()...");}
}

//자식 클래스 BB 부모 AA
class BB extends AA{
	public void three() {
		System.out.println("BB.three...");
	}
}

class CC extends BB{
	public void four() {
		System.out.println("CC.four...");
	}
}
/*
 
 에러 발생.
 클래스간의 상속은 단일상속만 가능
class DD{
	public void five() {
		System.out.println("DD.five...");
	}
}

class EE extends AA,DD{	}

*/
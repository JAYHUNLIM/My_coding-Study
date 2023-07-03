package oop0321;

class Test{
	
	//1.각각의 try catch 문을 이용한 예외처리
	/*
	 public void view() {
		try {
			int a=3/0;
		} catch (Exception e) {
			System.out.println(e);
		}
	}//view()
	
	public void disp() {
		try {
			int a= Integer.parseInt("Korea");
		} catch (Exception e) {
			System.out.println(e);
		}
	}//disp()
	*/
	//2. throws 이용한 예외처리
	public void view() throws Exception{
		int a=3/0;
	}
	
	public void disp() throws NullPointerException, NumberFormatException {
		int a= Integer.parseInt("KOREA");
	}
	//synchronized
	//os가 개입해서 문제가 발생하지 않도록 조정하는 기법
	public synchronized void login() {
	}
}

public class Test08_throws {

	public static void main(String[] args) {
		//throws문	
		//->메소드 호출시 예외처리를 한꺼번에 모아서 처리
		// try catch문 내부에서 호출을 해야한다
		
		try {
			Test test=new Test();
			//test.view();
			test.disp();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

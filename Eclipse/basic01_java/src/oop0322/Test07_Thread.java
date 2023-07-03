package oop0322;

class MyThread3 implements Runnable{
	private int num;
	private String name;
	
	public MyThread3() {}
	public MyThread3(int num, String name) {
		this.num=num;
		this.name=name;
	}
	
	@Override
	public void run() {
		for(int a=0; a<num;a++) {
			System.out.println(name+":"+a);
		}	
	}
}


public class Test07_Thread {

	public static void main(String[] args) {
		//3. Runnable 인터페이스를 이용해서 쓰레드를 구현한 경우
		/*
		 	Interface Runnable{}
		 	class Thread implements Runnable{}
		 	 
		 */
		
		Thread t1= new Thread(new MyThread3(1000,"★"));
		Thread t2= new Thread(new MyThread3(1000,"★★"));
		Thread t3= new Thread(new MyThread3(1000,"★★★"));
		
		t1.start();
		t2.start();
		t3.start();
	}

}

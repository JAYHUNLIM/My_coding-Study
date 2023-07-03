package oop0322;

import java.util.Iterator;

class MyThread1{
	private int num;
	private String name;
	
	public MyThread1() {}
	public MyThread1(int num, String name) {
		this.num=num;
		this.name=name;
	}

public void start() {
	run();
}
public void run() {
	for(int a=0; a<num;a++) {
		System.out.println(name+":"+a);
	}
}
}

public class Test05_thread {

	public static void main(String[] args) {
		// Thread 클래스
		//->하나의 프로그램이나 하나의 메소드가 cpu자원을 전부 점유하는것을 방지
		
		//1.쓰레드를 사용하지 않는 경우
		//앞의 작업이 끝나기 전까지 무한대기 -> 비효율
		MyThread1 t1= new MyThread1(1000,"★");
		MyThread1 t2= new MyThread1(1000,"★★");
		MyThread1 t3= new MyThread1(1000,"★★★");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
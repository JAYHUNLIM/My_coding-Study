package kr.co.di;

public class HelloPOJO {

	public static void main(String[] args) {
		
		IHello hello=null;
		
		hello= new MessageKO();
		hello.sayHello("손흥민");

	}

}

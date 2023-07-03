package oop0321;

interface IMessage{
	public void msgPrint();	//추상 메소드
}

class Message implements IMessage{
	@Override
	public void msgPrint() {
		System.out.println("Message 클래스");
		
	}
}
public class Test05_anonymous {

	public static void main(String[] args) {
		//익명 내부객체 anonymous class
		
		//에러. 인터페이스는 직접 개체 생성할 수 없다
		//IMessage msg= new IMessage();
		
		//1.구현 클래스
		Message msg= new Message();
		msg.msgPrint();
		
		//2.다형성
		IMessage imess= new Message();
		imess.msgPrint();
		
		//3.익명 객체
		//-> 필요한 곳에 일시적으로 생성
		//-> 이벤트가 발생할 때만 실행
		//->모바일 응용 앱, javascript, jquery등에서 많이 사용
		//->$("button").click(){}
		IMessage mess= new IMessage() {
			
			@Override
			public void msgPrint() {
				System.out.println("익명내부객체");
				
			}
		};
		
		mess.msgPrint();
		System.out.println(mess);
		
	}
}

package oop0321;

public class Test07_exception {

	public static void main(String[] args) {
		// 예외처리 exception
		/*
		 	-자바 클래스 실행시 발생하는 에러
		 	-try~catch
		 	-finally
		 	-throws
		 	
		 */
		
		//1.예외처리 하지 않은 경우
		
//		System.out.println(1);	  //EXCEPTION이 발생되면 프로그램은 정상적으로 종료되지 않음
//		System.out.println(3/0);  //ArithmeticException
//		System.out.println(5);
//		System.out.println("END");
		
		/*
		//2.예외처리를 한 경우
		//-> EXCEIPTION이 발생하더라도 정상적으로 프로그램은 종료시킬수 있다.
		try {
			System.out.println(1);
			System.out.println(3);
			System.out.println(5);
			//예외 발생이 예상되는 코드작성
		}catch(ArithmeticException e) {
			System.out.println(e);
			//예외가 발생되었을때 처리할 코드 작성
		}
				
		System.out.println("END");
		/*
		//3.
		try {
			System.out.println(1);
			int[]num= new int [3];
			//num[5]=7;
			System.out.println(9);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} 
		System.out.println("END");
		*/
		//////////////////////////////////////////////
		
		//4.
		/*
		try {
			System.out.println(1);
			int num= Integer.parseInt("KOREA");
			System.out.println(3);
			System.out.println(num);
		}catch (NumberFormatException e) {
			System.out.println(e);
		}
		System.out.println("END");
		*/
		//5.
		/*
		try {
			System.out.println(1);
			Integer inte=null;
			System.out.println(5/inte);
		}catch (NullPointerException e) {
			System.out.println(e);
		}System.out.println("END");
		*/
		
		//6. 다중 catch문
		/*
		try {
			int a=2/0;
			int b= Integer.parseInt("Korea");
			int[] num=new int[3];
			num[5]=7;
		}catch (ArithmeticException e) {
			System.out.println(e);
		}catch (NumberFormatException e) {
			System.out.println(e);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}catch (NullPointerException e) {
			System.out.println(e);
		}
		
		System.out.println("END");
		*/
		//7.다형성
		//exception: 모든 예외 발생의 조상 클래스
		/*
		try {
			int a=2/0;
			int b= Integer.parseInt("Korea");
			int[] num=new int[3];
			num[5]=7;
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("END");
		
		*/
		//8.Finally 문
		//->예외가 발생하거나, 발생하지 않더라도 무조건 실행
		try {
			System.out.println("open");
			System.out.println(1/0);  //오류발생
		}catch (Exception e) {
			System.out.println(e);
		}finally{
			System.out.println("CLOSE");
		//	try {}catch{}
		}System.out.println("END");
		
}
}

package oop0320;

public class Test03_quiz {

	public static void main(String[] args) {
		// 연습문제
		
		//문1. 주민번호의 각 숫자의 합을 구하시오. character클래스와 charAt()함수이용
		//8+9+1+2+3+0+1+2+3+4+5+6+7
			String jumin="8912301234567";
			int hap=0;
			for(int i=0;i<jumin.length();i++) {
			char ch = jumin.charAt(i);//'8'
			hap=hap+Character.getNumericValue(ch);
			}
			System.out.println(hap);
		// getNumericValue() 특정 문자열 데이터의 숫자 값을 return 시키는 method
		// 숫자값을 가지고 있지 않은 경우 -1을 return 해줌 
		// 0이나 음의정수가아닌 숫자로 나타내지 못하는 경우 -2값을 return한다	
			
			
		//문2.대소문자를 서로 바꿔서 출력하시오.  character클래스와 charAt()함수 이용
		//gONE wITH The Wind
		String str="gONE wITH The Wind";
	
		for(int i=0; i<str.length(); i++) {
			if('A'<=str.charAt(i) && str.charAt(i)<='Z'){
				System.out.print((char)(str.charAt(i)+32));
			}else {
				System.out.print((char)(str.charAt(i)-32));}
		}
			////////////////////////////////////////////////
			
				
				for(int a=0;a<str.length();a++) {
				char ch= str.charAt(a);
				if(Character.isUpperCase(ch))	{
					System.out.print(Character.toLowerCase(ch));
				}else if(Character.isLowerCase(ch)) {
					System.out.print(Character.toUpperCase(ch));
				}else {
					System.out.print(ch);
				}
			
			
			}
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
				
	}

}

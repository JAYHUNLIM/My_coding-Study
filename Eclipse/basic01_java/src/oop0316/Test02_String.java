package oop0316;

import java.util.Iterator;
import java.util.StringTokenizer;

public class Test02_String {

	public static void main(String[] args) {
		//문자열 관련 클래스
		String str="HAPPY";
		String name= new String("HAPPY");
		
		if(str==name) {
			System.out.println("일치");
		}else {
			System.out.println("다르다");
		}
		// 참조 변수값을 비교 
		//내용을 비교 한것이 아니다
		//문자열에서 내용을 비교하려면 == 연산자 사용하지 말고 equals()함수를 이용할것
		if(str.equals(name)) {
			System.out.println("일치");
			
		}else {
			System.out.println("불일치");
		}
		
		//문자열의 갯수가 0인지?
		if (str.isEmpty()) {
			System.out.println("empty");
		} else {
			System.out.println("not empty");
		}
		
		//특정 문자를 기준으로 문자열 분리
		str=new String("gone with the Wind");
		String [] word=str.split(" ");
		for (int i=0; i<word.length;i++) {
			System.out.println(word[i]);		
		}

///////////
//문자열에서 공백 문자를 기준으로 분리하기
StringTokenizer st= new StringTokenizer(str, " ");
while(st.hasMoreElements()) {
	//토큰에 문자가 존재하는지 물어봄
	System.out.println(st.nextToken());//토큰할 문자열 가져오기
	
}		
	
//////////////////////////////////////////////////


//문자열 연산속도
//String < StringBuffer< StringBuilder

String s1="";
System.out.println(s1.length());

s1 = s1+"one";
System.out.println(s1.length());
s1= s1+"two";
System.out.println(s1.length());

s1=s1+"three";
System.out.println(s1.length());
System.out.println(s1);

//모든 문자열 지우기(빈 문자열 대입)
s1="";
System.out.println(s1.length());
System.out.println("#"+s1+"#");

/////////////////////////////	
StringBuilder s2= new StringBuilder();
s2.append("SEOUL");
System.out.println(s2.length()+s2.toString());


s2.append("Jeju");
System.out.println(s2.length()+s2.toString());


s2.append("Busan");
System.out.println(s2.length()+s2.toString());
//모든 문자열 지우기
s2.delete(0, s2.length());
System.out.println(s2.length());



StringBuffer s3=null;
//NullPointerException
//System.out.println(s3.length());



	}

}

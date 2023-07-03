package oop0316;

public class Test03_quiz {

	public static void main(String[] args) {
		//String 관련 연습문제
		
		//문1) 이메일 주소에 @문자 있으면
        //    @글자 기준으로 문자열을 분리해서 출력하고
        //    @문자 없다면 "이메일주소 틀림" 메세지를 출력하시오        
        /*    
              출력결과
              webmaster
              itwill.co.kr
        */
		
		//
		
String email= new String("webmaster@itwil.co.kr");
	
	if(email.indexOf("@")==9){
		System.out.println(email.substring(0, 9));
		System.out.println(email.substring(10,21));
	}else {
	System.out.println("이메일 주소 틀림");
}
	
	/////////////////////////////////
	if(email.indexOf("@")==-1){
	System.out.println("이메일 주소 틀림");
	}else {
	//	

		int pos =email.indexOf("@");
		System.out.println(pos);//9
		
		String id= email.substring(0,pos);//0,9-1
		String server= email.substring(pos+1);//10~마지막까지
	
		System.out.println(id);
		System.out.println(server);
}	
	
System.out.println("");	
	
		//////////////////////////////
//	문2. 이미지 파일만 첨부(.png.jpg.gif)	
//		출력결과		
//		파일명:sky2023.03.16
//		확장명:jpg
//
String path= new String("i:/frontend/iamges/sky2023.03.16.gif");		

//path에서 마지막"/" 기호의 순서값
int lastSlash=path.lastIndexOf("/");
System.out.println(lastSlash);

//전체 파일명
String file=path.substring(lastSlash+1);
System.out.println("전체 파일명:" + file);

//file에서 마지막 "." 기호의 순서값
int lastDot=file.lastIndexOf(".");
System.out.println(lastDot);//13

//파일명
String filename= file.substring(0,lastDot);
System.out.println("파일명:"+filename);

//확장명
String ext=file.substring(lastDot+1);
System.out.println("확장명:"+ext);
System.out.println("");

//확장명을 전부 소문자로 변경
ext=ext.toLowerCase();

if(ext.equals("png")||ext.equals("gif")||ext.equals("jpg")) {
	System.out.println("파일이 전송되었음");
}else {
	System.out.println("이미지파일이 아님");
}


//////////////////////////////////	
if(path.lastIndexOf("jpg")==33) {
	System.out.println("파일명:"+path.substring(19,32));
	System.out.println("확장명:"+path.substring(33,36));
}else if(path.lastIndexOf("png")==33) {
	System.out.println("파일명:"+path.substring(19,32));
	System.out.println("확장명:"+path.substring(33,36));
}else if(path.lastIndexOf("gif")==33){
	System.out.println("파일명:"+path.substring(19,32));
	System.out.println("확장명:"+path.substring(33,36));
}else {
	System.out.println("이미지 파일이 아님");
}
	


		
	}

}

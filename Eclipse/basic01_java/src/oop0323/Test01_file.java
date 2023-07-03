package oop0323;

import java.io.File;

public class Test01_file {

	public static void main(String[] args) {
		// file 클래스 
		// 예외처리를 해줘야한다 파일이 있는지 확인이 필요
		//->파일과 관련된 정보를 알수있다
		//->파일명, 파일크기, 확장명, 파일타입~
		
		try {
			//예외발생 예상되는 코드 작성
			//경로명+파일명
			//경로명으로 \기호를 사용하려면 \\기호를 2번씩 사용함
			//String pathname="D:\\202301\\pdf\\20230309_java.pdf";
			
			//경로명으로 /기호도 사용 가능하다
			String pathname="D:/202301/pdf/20230309_java.pdf";
			
			//file 클래스에 파일 담기
			File file = new File(pathname);
			
			if (file.exists()) {
				System.out.println("파일이 존재함");
			
				long filesize = file.length();
				System.out.println("파일크기:"+filesize);
				System.out.println("파일크기:"+filesize/1024+"kb");
				System.out.println("파일크기:"+filesize/1024/1024+"mb");
			
				String filename= file.getName();
				System.out.println("파일명:"+filename);
				
				//파일 삭제
				//->실제 파일이 삭제되니 복사본 남겨놓기!
				//삭제된 파일은 휴지통에도 남아있지 않다
				
				/* 
				  if (file.delete()) {
					System.out.println(filename+"파일이 삭제되었음");
				} else {
					System.out.println(filename+"파일 삭제 실패");
				}
				*/
				
				//파일명과 확장명을 분리해서 출력하시오
				//파일명:20230309_java
				//확장명:pdf
				 int last_dot= filename.lastIndexOf("."); 		 
				 String f_name= filename.substring(0,last_dot);			 
				 String ext= filename.substring(last_dot+1);
				 System.out.println("확장자명:"+ext);
				 System.out.println("파일명:"+f_name);
				 
			}else {
				System.out.println("파일이 없음");
			}
			
			} catch (Exception e) {  
			//예외 발생시 처리할 코드를 작성
			System.out.println(e);
		}
		
		System.out.println("END");
		
		
		
		
		
		
	}

}

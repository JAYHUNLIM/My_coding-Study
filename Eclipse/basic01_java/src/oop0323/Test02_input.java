package oop0323;

import java.io.FileInputStream;

public class Test02_input {

	public static void main(String[] args) {
		//파일 입출력(txt)
		//file: txt pdf xls csv ppt jpg
		
		//byte: 1바이트 할당 
		//char: 2바이트 할당
		
		//1.byte형 ->한글깨짐
		String filename="D:/202301/workspace/basic01_java/src/oop0323/data.txt";
		
		FileInputStream fis= null;
		try {
			fis= new FileInputStream(filename);
			while(true) {
			int data=fis.read(); //1byte 읽기
			if(data==-1) {//파일의 끝인지 물어봄 end of file
				break;
			}
			//System.out.println(data);
			System.out.printf("%c",data);	//한글파일 깨져서 출력
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				if(fis!=null) {fis.close();}
			} catch (Exception e) {
				
			}
		}
		
		
		
		
		
	}
}

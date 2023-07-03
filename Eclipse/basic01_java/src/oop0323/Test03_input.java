package oop0323;

import java.io.FileReader;

public class Test03_input {

	public static void main(String[] args) {
		// 2.char 기반 -> 한글 안깨짐
		String filename="D:/202301/workspace/basic01_java/src/oop0323/data.txt";
	     FileReader fr= null;
	     
	     try {
	    	 fr= new FileReader(filename);
	    	 while(true) {
	    		 int data= fr.read();
	    		 if (data==-1) {
					break;
				}
	    		 System.out.printf("%c",data);
	    	 }
		} catch (Exception e) {
			System.out.println("파일읽기 실패"+e);
		}finally {
			try {
				if (fr!=null) {
					fr.close();
				}
			} catch (Exception e) {
				
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}

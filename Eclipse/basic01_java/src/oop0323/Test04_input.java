package oop0323;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test04_input {

	public static void main(String[] args) {
		//3. 메모장 파일의 내용을 엔터단위로 가져오기
		String filename="D:/202301/workspace/basic01_java/src/oop0322/Buyer.java";
	
		FileReader fr= null;
		BufferedReader br= null;
		 int num =0;//행번호 추가하기
		 try {
	    	//1.파일 가져오기
			 fr= new FileReader(filename);
			 
			//2.엔터 단위로 끊어서 읽기 위해 옮겨 담기
			 br= new BufferedReader(fr);
			 while(true) {
				 String line= br.readLine();
				//엔터 기준으로 한줄씩 가져오기
				 
				 if(line==null) { //파일의 끝인지
					 break;
				 }
				 System.out.printf("%d %s\n",++num,line);
				 //20행마다 밑줄긋기
				 if(num%20==0) {
					 System.out.println("---------------------");
				 }
			 }
			 
		} catch (Exception e) {
			System.out.println("파일읽기 실패"+e);
		}finally {
			try {
				if (br!=null) {
					br.close();
				}
			} catch (Exception e) {
				
			}
			
			 try {
				 if (fr!=null) {
					fr.close();
				 }
			} catch (Exception e) {
				
			}
		}
	
	
	
	
	
	
	
		
		
		
	}
}

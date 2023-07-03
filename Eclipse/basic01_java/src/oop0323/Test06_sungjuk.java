package oop0323;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Test06_sungjuk {

	public static void main(String[] args) {
		// 문제 성적프로그램
		//성적 입력자료를 가져와서, 성적 결과 파일 완성하기(result.txt)
		/*
		 1.입력 데이터파일: sungjuk.txt
		 
		 2.결과 파일 : result. txt
		 
		 						성 / 적 / 결 /과
              -------------------------------------------------------
              이름     국어   영어  수학   평균  등수   결과
              -------------------------------------------------------                       
              라일락    100  100  100   100   1    합격 ********** 장학생
              진달래     50   55   60    55   4    불합격 *****
              개나리     95   95   35    75   3    재시험 *******
              무궁화     80   85   90    85   2    합격 *******
		 
              홍길동     60   40   30    43   5    불합격 ****
              ------------------------------------------------------
		 */
		
		String inName="D:\\202301\\sungjuk.txt";
		String outName="D:\\202301\\result.txt";
		
		//엔터를 기준으로 불러와서 ,기준으로 나누기
		FileReader fr=null;
		BufferedReader br=null;
		
		
		FileWriter fw=null;
		PrintWriter out=null;
		
		
		
		try {
			//1. 데이터 저장 변수 선언
			String [] result = new String[5];
			String [] name =new String[5];
			int [] kor= new int[5];
			int [] eng= new int[5];
			int [] mat= new int[5];
			int [] aver= new int[5];
			int [] rank= {1,1,1,1,1};
			
			int size=name.length;	//5
			int i=0;
			
			//2.데이터 입력파일 (sungjuk.txt가져와서 내용을 읽기)
			fr=new FileReader(inName);			
			br= new BufferedReader(fr);//줄단위로 읽어오기
			
			while(true) {
				String line= br.readLine();
				if(line==null) { //파일의 끝인지
					 break;
				 }//if
				//,기준으로 split으로 문자열 분리후 변수 저장
				String[] word = line.split(",");
				name[i]= word[0].trim();
				kor[i]= Integer.parseInt(word[1].trim());
				eng[i]= Integer.parseInt(word[2].trim());
				mat[i]= Integer.parseInt(word[3].trim());
				i++; //다음 사람
			}//while
			//3. 평균 구하기
			for(int a=0;a<size;a++){
			     aver[i]= (kor[i]+eng[i]+mat[i])/3 ;
			     }
			
			
			//4. 등수 구하기 평균을 기준
	for(int m=0;m<size; m++){
    for(int n=0; n<size; n++){
        if (aver[m]<aver[n]) {
            rank[m]=rank[m]+1;
        }
    }
}
			 
			
			
			
			//5.result.txt 결과 출력하기
			fw = new FileWriter(outName,false);
			out= new PrintWriter(fw,true);
			out.println("성/적/결/과");
			out.println("---------------------------------------------");
			out.println("이름   국어     영어     수학     평균   등수   결과");
			out.println("---------------------------------------------");
			out.println(rank);
		
//			if (aver[i]>=70) {
//			    if(kor[i]<40 || mat[i]<40 || eng[i]<40){
//			   result +="재시험";
//			    }else{
//			    result +="합격";}
//			}else{
//			    result+="탈락";  
//			}

		
			
		} catch (Exception e) {
			System.out.println("성적프로그램 실패:"+e);
		}finally {
			try {
				if (br!=null) {
					br.close();
				}
			} catch (Exception e) {
				
			}
			
			try {
				if(fr!=null) {
					fr.close();
				}
				
			} catch (Exception e) {
				
			}
			
			try {
				if(out!=null) {
					out.close();
				}
			} catch (Exception e) {
			
			}
			try {
				if(fw!=null) {
					fw.close();
					}
			} catch (Exception e) {
				
			}
			
		}
		
		
		
		
		
		
		
	}

}

package oop0314;

import java.util.Arrays;

public class Test05_sort {

	public static void main(String[] args) {
		//정렬 sort
		/*
		 -정렬 유형: 오름차순과 내림차순
		 -정렬 방식
		  삽입정렬	insertion
		  선택정렬	selection
		  버블정렬	bubble	 
		  
		 -selection sort 알고리즘
		  9 8 7 6 5 ->5 6 7 8 9
		  맨앞의 숫자를 기준으로 비교
		  9 8 7 6 5 ->8 9 7 6 5 -> 7 9 8 6 5 -> 6 9 8 7 5 -> 5 9 8 7 6 
		 -----------------step1
		  5 8 9 7 6 ->5 7 9 8 6 -> 5 6 9 8 7
		 -----------------------step2
		  5 6 8 9 7
		  5 6 9 8 7 
		  -------------
		   5 6 7 8 9 		   
		   
		 	bubble sort 알고리즘 첫번째 단계에 가장 큰 숫자가 맨뒤로
		 	9 8 7 6 5 -> 5 6 7 8 9
		    앞에서부터 하나씩 비교
		    8 9 7 6 5	8 7 9 6 5  8 7 6 9 5  8 7 6 5 9
		    --------
		    7 8 6 5 9  7 6 8 5 9  7 6 5 8 9
		    ----------
		    6 7 5 8 9   6 5 7 8 9
		    --------
		    5 6 7 8 9
		    		    
		  */
		
		
		int[] su= {9,8,7,6,5};
		Arrays.sort(su);
		
		for (int idx = 0; idx<su.length;idx++) {
			System.out.println(su[idx]);			
		}
		
		
		
	}//
}//

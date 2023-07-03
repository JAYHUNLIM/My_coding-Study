package oop0315;

public class Test04_quiz {

		public static double sd(int[] aver) {
			int size= aver.length;//5
			//aver 각 요소의 누적 합 구하기//436
			double hap=0.0;
			for(int i=0;i<size;i++) {
				hap= hap + aver[i];			 
			}
			double avg= hap/size;//87.2
			
			
			
			double sum=0.0;//편차들의 총 합계
			for(int i=0; i<size;i++) {
//				aver 각 요소에서avg값과 차이를 구하고 
			double d= aver[i]-avg;
			//2.avg 87.2와의 차이값을 전부 양수로 바꾼다
			d=Math.abs(d);
			//위에서 나온 편차를 누적
			sum= sum+d;
			
			}//3. 표준편차 return
			return sum/size;
			
			}
			
		


		
	
	public static void main(String[] args) {
		// 문제 표준편차 구하기
		int[] aver= {85,90,93,86,82};
		double result= sd(aver);
		System.out.printf("표준편차: %.2f", result);
		
		
		
		/*
		 1.aver의 평균(87.2) 구하고 aver의 각 요소에서 87.2를 뺀다
			 85 2.2
			 90 2.8
			 93 5.8
			 86 -1.2
			 82 -5.2
		 2. 1의값을 전부 양수로 바꾼다-> 편차
			 2.2 abs
			 2.8
			 5.8
			 1.2
			 5.2
		3. 2의 편차들의 평균값 -> 표준편차
		 						3.44	 
		 
		 
		  
		  */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

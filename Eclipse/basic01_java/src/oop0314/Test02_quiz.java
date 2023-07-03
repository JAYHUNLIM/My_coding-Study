package oop0314;

import java.util.Iterator;


public class Test02_quiz {

	public static void main(String[] args) {
		//문1)알파벳을 아래와 같이 한줄에 5개씩 출력하시오
        /*
            ABCDE
            FGHIJ
            KLMNO
            PQRST
            UVWXY
            Z
        */	
		
		//ascii code A=65~ Z=90
		
	
		int count=0;
		for(char ch='A';ch<='Z';ch++) {
			count++;
			System.out.print(ch);
			if(count%5==0) {
				System.out.println();
			}
		}
		System.out.println();
		
		//문2)아래와 같이 출력하시오
	     /*
        ####
         ###
          ##
           #
	      	*/
		
		for(int c=1; c<=4;c++){
		    for(int d=1; d<=4; d++){
		    	if(c<=d) {
		    		System.out.print("#");
		    	}else {
		    		System.out.print(" ");;
		    	}
		    }
		    System.out.println();
	}
		
System.out.println();		
		//문3)다음식의 결과값을 구하시오
        /*
               1   2   3   4   5      99
               ─ - ─ + ─ - ─ + ─ ...  ──   = 0.688172
               2   3   4   5   6      100
        */
		double bunsu=0.0;
		boolean flag=false;
		for(int h=1;h<=99;h++) {
			if(flag) {
					bunsu= bunsu-(h/(double)(h+1));
					flag=false;
				}else {
					bunsu= bunsu+ (h/(double)(h+1));
					flag= true;
			}
			}
	System.out.println(bunsu);
	System.out.println();
		
		
		//문4)아래와 같이 계산해서 출력하시오
        /*    
             1+....+10=55
            11+....+20=155
            21+....+30=255

            81+....+90=
            91+....+100=955   
        */
		int tot=0;
		for (int f =10; f<=100; f=f+10){
		    for(int g=f-9; g<=f; g=g+1){
		        tot= tot+g;    
		    } 
		   
		 // System.out.println(1+"..."+"+"+ f +"="+tot);
		  
		  System.out.printf("%d + ... + %d = %d\n",(f-9) ,f,tot);
		   tot=0;//초기화 필수
		}
		
		//문5)어느 달팽이는 낮에는 3cm올라가고, 밤에는 2.5cm 내려온다고 할때
        //   달팽이가 13cm의 나무 꼭대기에 올라가려면 며칠이 걸리는지 구하시오
		//21일 while
		
		//13()
		
		int tree=13,day=3;
		double night=2.5;
		double t_tot=0;
		
	if((tree-night) % (day-night)==0) {
		t_tot=(tree-night)/(day-night);	
	}else {
		
		t_tot=(tree-night)/(day-night)+1;
		
	}
	System.out.println(t_tot);
	
	int days=0;
	double snail=0.0;
	while(true) {
		days++;
		snail=snail+3.0;
	if(snail>=13.0) {
		break;
	}else {
		snail= snail-2.5;
		
	}	
	}
	System.out.println(days+"일");
}
}
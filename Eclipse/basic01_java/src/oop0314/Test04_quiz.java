package oop0314;

public class Test04_quiz {

	public static void main(String[] args) {
		//배열 연습문제
		char[] ch={'I','t','W','i','l','l'};
		int size=ch.length;//6
		
		//문 1. 대소문자 갯수를 각각구하시오		
		//대문자 2개 소문자 4개
		int cnt_dae=0;
		int cnt_so=0;
		
		
		for(int i=0; i<ch.length; i++) {
		if('A'<=ch[i] && ch[i]<='Z'){
			cnt_dae ++;
			
		}else {
			cnt_so ++;
		}
		
		}
		System.out.println("대문자"+cnt_dae+"개");
		System.out.println("소문자"+cnt_so+"개");
		
////////////////////////////강사코드
		int upper=0;
		int lower=0;
		
		for(int i=0;i<size;i++) {
			if(ch[i]>='A'&& ch[i]<='Z')
				upper ++;
		
	
		if(ch[i]>='a'&& ch[i]<='z') {
			lower ++;}
		}
		System.out.printf("대문자 수:%d\n",upper);
		System.out.printf("소문자 수:%d\n",lower);
		
		//2.대소문자를 서로 바꿔서 출력하시오
		//->iTwILL
		for(int i=0; i<ch.length; i++) {
			if('A'<=ch[i] && ch[i]<='Z'){
				System.out.print((char)(ch[i]+32));
				
			}else {
				System.out.print((char)(ch[i]-32));
			}
		}
System.out.println(" ");

////////////////////////강사코드		
for(int i=0; i<ch.length; i++) {
	if('A'<=ch[i] && ch[i]<='Z'){
		System.out.printf("%c",(ch[i]+32));
		
	}else {
		System.out.printf("%c",(ch[i]-32));
	}
}
System.out.println(" ");

	
		
		//3.모음의 갯수를 구하시오 AEIOU aeiou			
		//->모음의 갯수	
		int cnt_mo=0;
		for(int i=0; i<ch.length; i++) {
			if(ch[i]=='A'|| ch[i]=='E'|| ch[i]=='I'|| ch[i]=='O' || ch[i]=='U'||ch[i]=='O'|| ch[i]=='a'
					||ch[i]=='e'|| ch[i]=='i'|| ch[i]=='o'|| ch[i]=='u') {
				cnt_mo ++;
				
		}
			
		}						
	
		System.out.println(cnt_mo+"개");
	
//////////////////강사코드
int mo=0; //모음의 갯수
for(int i=0; i<size;i++) {
	char c=ch[i];
	if(c>='A' && c<='Z') {//대문자인지?
		c=(char)(c+32);//소문자로 변경
}
	switch(c) {
	case 'a':
	case 'e':
	case 'i':
	case 'o':
	case 'u':mo++;
		
			
}
}
System.out.printf("\n모음의 갯수: %d\n",mo);

			
		//4.각행의 모음의 갯수를 구하시오
		//str[0] 2개  str[1] 1개  str[2] 2개
		
		char[][] str= {
				{'Y','e','a','r'},
				{'M','o','n','t','h'},
				{'D','a','t','e'}				
		};
		

		
		 int cnt_str=0;
		int row=str.length;  //3
		for (int r=0;r<row;r++) {
			int col=str[r].length;
			for(int c=0;c<col;c++) {
				if(str[r][c] =='A'|| str[r][c] =='E'|| str[r][c] =='I'|| str[r][c] =='O' || str[r][c] =='U'||str[r][c] =='O'||str[r][c] =='a'
						||str[r][c] =='e'|| str[r][c] =='i'|| str[r][c] =='o'|| str[r][c] =='u' ) {
					cnt_str ++;

				}
			}
			System.out.print("각행의 모음 갯수"+cnt_str+"개"+"\n");
			cnt_str=0;
		}
		
///////////////////////////////////////		
int ro= str.length;		
int count=0;

for(int s=0;s<ro;s++) {
	int cols=str[s].length;
	for(int p=0;p<cols;p++) {
		char t=str[s][p];
		if(t>='A'&& t<='Z') {
			t=(char)(t+32);
		}
		switch(t) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':count++;
			
		}
		
		
	}
	
	System.out.printf("\nstr[%d]행의 모음의 갯수:%d개",s,count);
	count=0;//각 행마다 모음의 갯수를 구하기 때문에 초기화
}
		
System.out.println();
		//5.대각선 방향의 각 요소의 합을 구하시오	
		//대각선 오른아래 방향의 합 4+9+7 num[0][0]+num[1][1]+num[2][2]
		//대각선 왼쪽아래 방향 합	2+9+6	num[0][2]+num[1][1]+num[2][0]

		int [][] num= {
				{4,3,2},
				{5,9,1},
				{6,8,7}
				};
		
		int sum=0;
		int sum2=0;
		for(int i=0; i<num.length; i++) {
			for(int c=0;c<=2;c++) {
				if(i==c) {
				sum= sum+ num[i][c];
				}
				if(i+c == num.length-1){
                    sum2 = sum2+ num[c][i];
                }
				
			}
		}
System.out.println(sum);
System.out.println(sum2);
////////////////////////////////////////
int hap1=0;//대각 오른
int hap2=0;//대각 왼		
for(int i=0;i<=2;i++) {
	hap1=hap1+num[i][i];
	hap2=hap2+num[i][2-i];
}		
System.out.printf("\n 대각선 오른방향 합:%d",hap1);
System.out.printf("\n 대각선 왼쪽방향 합:%d",hap2);
	}
}
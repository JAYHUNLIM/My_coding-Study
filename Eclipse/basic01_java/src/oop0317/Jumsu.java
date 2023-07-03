package oop0317;

public class Jumsu {

//멤버변수
//번호
//이름
//ox표시
//점수
//등수	
private int no;//번호
private String name;
private char[] ox= new char[5];
private int [] answer= new int[5];
//답안지 제출
public int score;
public int rank;

	
	
	
//생성자 함수
public Jumsu() {
	
}
public Jumsu(int no, String name, int a0,int a1, int a2,int a3, int a4)
{this.no=no;
this.name=name;
this.answer[0]=a0;
this.answer[1]=a1;
this.answer[2]=a2;
this.answer[3]=a3;
this.answer[4]=a4;
this.rank=1;
}//멤버함수
	
public void compute() {
	//정답
	int[] dap= {3,3,3,3,3};
	//(dap[0]==answer[0]) 
	//(dap[1]==answer[1])
	//(dap[2]==answer[2]) 
	//(dap[3]==answer[3])
	//(dap[4]==answer[4])
//문제 정답 dap과 제출한 답안을 비교해서 ox를 구하고
//	맞은 갯수에 따라서 점수를 구하시오(1차원 배열)
	for(int i=0; i<5;i++) {
		if(dap[i]==answer[i]) {
			ox[i]='o';
			score= score+20;
		}else{
			ox[i]='x';
		}
		
	}
	
////////////////////////////////	
//	int count=0;
//for(int i=0; i<answer.length; i++) {
//	if (answer[i]==3) {
//		count ++;
//		ox[i]= 'o';
//	}else {
//		ox[i]= 'x';
//	}
//}
//score= count * 20;	
//	
			

}
	
	

public void disp() {
	System.out.print(no+" ");
	System.out.print(name+" ");
	System.out.print(ox[0]+" ");
	System.out.print(ox[1]+" ");
	System.out.print(ox[2]+" ");
	System.out.print(ox[3]+" ");
	System.out.print(ox[4]+" ");
	System.out.print(score+" ");
	System.out.print(rank+"");
	System.out.println();
}


}

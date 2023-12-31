package oop0322;
//상품구매 관련 클래스
class Buyer {
		private int myMoney=1000;//나의 총 재산
		private int myMileage=0;//나의 마일리지 점수(bonus point)
		private int i=0;		

//상품을 구매했을때 어떤 상품을 구매 했는지 저장(나의 구매상품 목록)	
Product [] item = new Product[10];

/*
Product
+------------+-------------+-------------+--
|  SmartTV   |   Notebook  |  HandPhone  |  ~~
+------------+-------------+-------------+--
item[0]       item[1]       item[2]      ~~
*/

public Buyer() {}
//다형성 이용 자식이 부모 클래스에 들어갈수 있음
//함수를 따로 3개씩 만들 필요가 없음
//메소드 오버로드(함수명 중복정의)
/*
public void buy(SmartTV a) {}

public void buy(Notebook a) {}

public void buy(HandPhone a) {}
*/

public void buy(Product p) {
	if (this.myMoney<p.price) {
		System.out.println("잔액이 부족합니다");
		 return;
	}
	
	item[i++]=p;								  //구매한 상품을 저장
	this.myMoney= this.myMoney-p.price; 		 //나의 재산은 감소
	this.myMileage=this.myMileage+p.bonusPoint; //마일리지는 증가
}

	public void disp() {
		//구매한 상품 목록
		//구매 상품 목록과 구매한 상품의 총 합계 금액을 구하시오
		////모범 답안
		StringBuffer shoplist= new StringBuffer();
		int hap=0;
		for(int n=0;n<item.length;n++) {
			if(item[n]==null) {
				break;
			}
				shoplist.append(item[n].toString()+" ");
				//사용 금액
				hap= hap+item[n].price;
				}
		
		/*
		
		int size=item.length;
		for(int i=0; i<size;i++) {
			if(item[i]!=null) {
				shoplist.append(item[i]);
				hap= hap+item[i].price;
			}
		}
		 	*/								
		
		System.out.println("구매 상품 목록:" +shoplist);
		System.out.println("사용 금액:" +hap);
		System.out.println("나의 남은 재산:" +this.myMoney);
		System.out.println("나의 남은 마일리지:"+this.myMileage);
	}
}

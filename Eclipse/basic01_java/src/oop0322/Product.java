package oop0322;

import oop0320.Test04_super;

class Product extends Object{
	public int price;	  //상품가격
	public int bonusPoint;//마일리지 
		
	public Product() {}
	
	public Product(int price) {
		this.price= price;
		//상품가격의 10%를 보너스 점수 책정
		this.bonusPoint=(int)(price*0.1);
		
	}
}

class SmartTV extends Product{
		public SmartTV(){
			super(100); //상품가격 price 100, bonus 10
		}
		@Override
		public String toString() {
			return "스마트TV";
		}
}

class Notebook extends Product{
	public Notebook() {
		super(200);// price 200 bonus 20
	}
	@Override
	public String toString() {
		return "노트북";
	}
}

class HandPhone extends Product{
	public HandPhone() {
		super(150); //price 150 bonus 15
	}
	@Override
	public String toString() {
		return "핸드폰";
	}
}
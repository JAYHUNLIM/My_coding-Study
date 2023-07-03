package oop0322;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Test01_List {

	public static void main(String[] args) {
	//Java Collection Framework
	//->자료를 모아서 저장할수 있는 클래스 및 인터페이스
	/*
	 	List: 순서(index)가 있다. 인덱스는 0부터 시작
	 		 Vector, ArrayList
	 	Set: 순서가 없다
	 		 Hashset
	 	Map: 순서가 없다. key와 value로 구성되어 있다
	 		HashMap, Properties~
	 		
	 		
	 	interface List{}
	 	class Vector implements List {}
	 	class ArrayList implements List{}
	 	
	 	interface Set{}
	 	class HashSet implements Set{}
	 	
	 	interface Map{}
	 	class HashMap implements Map{}
	 	class Properties implements Map{}
	 	
	 	//다형성 
	 	List list = new Vector()
	 	List list = new ArrayList()
	 	Set set = new HashSet()
	 	Map map = new HashMap()
	 		 		 	
	 */
	 
	//배열: 자료를 모아 놓을 수 있다
	int [] num= new int[100];
		
	//1.List 계열
	//<E> Element 요소
	Vector vec= new Vector();
	vec.add(3);
	vec.add(2.4);
	vec.add('r');
	vec.add("korea");
	vec.add(new Integer(5));
	vec.add(new Double(5.2));
	
	//Integer inte = new Integer(5); old version
	//Integer inte = 5;				 new version
	
	System.out.println(vec.size());  //6 요소의 갯수
	for(int i=0; i<vec.size(); i++) {
		System.out.println(vec.get(i));
	}

	vec.remove(0); //0번째 요소 삭제
	System.out.println(vec.size());
	
	vec.removeAllElements();		//모든 요소를 삭제하기
	System.out.println(vec.size());//0
	
	if(vec.isEmpty()) {  //요소가 없는지 확인
		System.out.println("비어있다");
	}else {
		System.out.println("비어있지 않다");
	}
	
	List list =new ArrayList();
	list.add(2);
	list.add(6.7);
	list.add('j');
	list.add("seoul");
	
	System.out.println(list.size()); //4
	
	//문 list 요소를 전부 삭제하시오.remove()를 이용
	//list를 위에서부터 지우면 리스트가 흐트러진다
	//list를 끝에서부터 지워야 한다
	
	for(int i =list.size()-1; i>=0; i--) {
		list.remove(i);
	}
	System.out.println(list.size()); //0
	
	}
}
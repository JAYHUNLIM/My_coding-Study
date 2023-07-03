package oop0322;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

class Mountain{
	String name;
	int height;
	
	public Mountain() {
		
	}
	public Mountain(String name, int height) {
		this.name=name;
		this.height=height;
	}
}


public class Test03_Generic {

	public static void main(String[] args) {
		//제네릭 Generic
		/*
			-요소를 수집하는 경우 특정 자료형으로 제한 할수있다
			-<E>		Element
			-<K,V>		Key, Value
			-<T>		
			-<?>
			-<클래스>
		  	-<>
		  */
		//int형만 num 배열에 대입 가능
		int[] num=new int[3];

		//Vector<int> 기본 자료형은 올수없다. 에러
		Vector<String> vec= new Vector<>();
		vec.add("개나리");
		vec.add("진달래");
		vec.add(new String("무궁화"));
		//vec.add(3); 에러
		//vec.add(4.5);에러
		//vec.add(new Character('r'));에러
		
		for(int i=0; i<vec.size();i++) {
			String str= vec.get(i);
			System.out.println(str);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(new Integer(5));
		//list.add(2.4);에러
		//list.add("korea");에러
		
		HashSet<Double> set= new HashSet<>();
		set.add(1.2);
		set.add(new Double(3.5));
		//set.add(7); 에러
		//set.add(""); 에러
		
		HashMap<String, Character> map = new HashMap<>();
		map.put("one",'r');
		map.put("two",new Character('r'));
		//map.put("one",""); 에러
		System.out.println(map.get("one"));
		
		
		Mountain m1= new Mountain("한라산",1950);
		Mountain m2= new Mountain("관악산",1500);
		Mountain m3= new Mountain("북한산",1000);

		ArrayList<Mountain> moun= new ArrayList<>();
		moun.add(m3);
		moun.add(m2);
		moun.add(m1);
		//moun.add(""); 에러
		
		for(int i=0; i<moun.size();i++) {
			Mountain m =moun.get(i);
			System.out.println(m.name);
			System.out.println(m.height);
		}
	}
}

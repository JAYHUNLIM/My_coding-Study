package net.testbean;

public class Calcbean {
	
	public int abs(int su) {
		return Math.abs(su);
	}

	
	public long fact(int su) {
		return (su==0)? 1:su * fact(su-1);
	}
	
}

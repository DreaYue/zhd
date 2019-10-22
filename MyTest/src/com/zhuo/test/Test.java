package com.zhuo.test;

public class Test {

	public static void main(String[] args) {
		
		Persion man = new Man();
		man.action="success";
		man.getConclusion();
		
		man.action="failed";
		man.getConclusion();
		
		man.action="love";
		man.getConclusion();		
		
		Persion women = new Women();
		women.action = "success";
		women.getConclusion();
		
		women.action = "failed";
		women.getConclusion();
		
		women.action = "love";
		women.getConclusion();
		
	}
}

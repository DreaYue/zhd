package com.zhuo.test;

public class Women extends Persion{

	@Override
	public void getConclusion() {

		if(action == "success"){
			System.out.println("多是有个不靠谱的");
		}
		if(action == "failed"){
			System.out.println("眼泪汪汪;谁也劝不了");
		}
		if(action == "love"){
			System.out.println("懂也要装不懂");
		}
	}

}

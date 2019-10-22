package com.zhuo.test;

public class Man extends Persion{

	//重写父类的方法:
	@Override
	public void getConclusion() {
		
		if(action == "success"){
			System.out.println("多半是有有一个强大的靠山");
		}
		if(action == "failed"){
			System.out.println("门头喝酒;谁也不用劝");
		}
		if(action == "love"){
			System.out.println("凡是不懂的也要装懂");
		}	
	}
}

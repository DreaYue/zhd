package com.test;

import java.util.HashMap;
import java.util.Map;

public class Tt {

	public static void main(String[] args) {
		
		Map<Object,Object> map = new HashMap<>();
		map.put(null, "aa");
		System.out.println(map.get(null));
		
	}
}

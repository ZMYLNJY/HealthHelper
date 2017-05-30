package com.nku.healthhelper.util;

import java.util.HashMap;

public class StringUtil {

	public StringUtil() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 将字符串转化成hashmap。形如：key:value;key2:value2……，变成(key,value)的map.
	 * @param source 需要转换的字符串
	 * @return 转换之后的hashmap
	 */
	public static HashMap<String, Double>StringToHashMap(String source){
		HashMap<String, Double> hashMap = new HashMap<String, Double>();
		
		String[] sourceMap = source.split(";");
		for (String string : sourceMap) {
			String[] entryString = string.split(":");
			hashMap.put(entryString[0], Double.parseDouble(entryString[1]));
		}
		
		return hashMap;
	}

}
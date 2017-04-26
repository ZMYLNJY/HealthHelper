package com.nku.healthhelper.entity;


import java.util.HashMap;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.nku.healthhelper.util.StringUtil;

@AVClassName("Food")
public class Food extends AVObject {
	
	public Food() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Food(String theClassName) {
		super(theClassName);
		// TODO Auto-generated constructor stub
	}

//	about foodname
	/*public void setFoodName(String foodName){
		put("foodName", foodName);
	}*/
	/**
	 * 获取Food对象的食物名称
	 * @return 食物名称
	 */
	public String getFoodName(){
		return getString("foodName");
	}
	
//	about type
/*	public void setType(String type){
		put("type", type);
	}*/
	/**
	 * 获取食物种类，应该是固定的几种种类
	 * @return 食物种类
	 */
	public String getType(){
		return getString("type");
	}
	
//	about description

	/*public void setDescription(String description){
		put("description", description);
	}*/
	/**
	 * 获取食物描述
	 * @return 食物描述
	 */
	public String getDescription(){
		return getString("description");
	}
	
//	about calorie
/*	public void setCalorie(double calorie){
		put("calorie", calorie);
	}*/
	/**
	 * 获得食物的热量，应该是每百克所含有的热量
	 * @return
	 */
	public double getCalorie(){
		return getDouble("calorie");
	}
	
//	about the name of photo
/*	public String getPhotoName(){
		return getString("photoName");
	}*/
	/**
	 * 获取食物的图标，暂时不知道存在本地还是存在云端比较好？？？
	 * @return 食物图标文件
	 */
	public AVFile getPhotoFile(){
		return getAVFile("photoFile"); 
	}
	
	/**
	 * 获得该食物的推荐指数。以double形式存储，后续自行处理。
	 * @return 食物的推荐指数
	 */
	public double getRating(){
		return this.getDouble("rating");
	}
	
	/**
	 * 设置食物的推荐指数，应该在某个用户打分或更改打分后自动调用，重新计算。
	 * @param recommend 新计算出的推荐指数
	 */
	public void setRating(double rating){
		put("rating", rating);
	}
//	about 营养成分
/*	*//**
	 * 获取食物的营养成分列表
	 * @return 
	 *//*
	public String getNurition(){
		return this.getString("nutrition");
	}*/
	/**
	 * 获取食物的营养成分列表，以hashmap形式
	 * key的值有fat		脂肪含量（克）
					protein	蛋白质（克）
					carbon	碳水化合物（克）
					Ca		钙（以下为毫克）
					Mg		镁
					K		钾
					Cu		铜
					Zn		锌
					Na		钠
	 * @return 食物营养成分
	 */
	public HashMap<String, Double> getNutrition(){
		String nutrition = this.getString("nutrition");
		return StringUtil.StringToHashMap(nutrition);
	}
	
/*//	about 营养成分
	public HashMap<String, Double> getNutrition(){
		HashMap<String, Double> hashMap = new HashMap<String, Double>();
		hashMap.put("fat", getDouble("fat"));
		hashMap.put("protein", getDouble("protein"));
		hashMap.put("carbonhydro", getDouble("carbonhydro"));
		hashMap.put("Ca", getDouble("Ca"));
		hashMap.put("Mg", getDouble("Mg"));
		hashMap.put("K", getDouble("K"));
		hashMap.put("Cu", getDouble("Cu"));
		hashMap.put("Zn", getDouble("Zn"));
		hashMap.put("Na", getDouble("Na"));
		return hashMap;
	}*/
}
/*Food：食物	
Foodname	食物名称
	Type	种类
	Description	描述（找食小助手）
	Calorie	卡路里（千卡）
	Fat		脂肪含量（克）
	Protein	蛋白质（克）
	Carbonhydro	碳水化合物（克）
	Ca		钙（以下为毫克）
	Mg		镁
	K		钾
	Cu		铜
	Zn		锌
	Na		钠*/

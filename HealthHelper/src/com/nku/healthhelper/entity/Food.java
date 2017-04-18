package com.nku.healthhelper.entity;

import java.util.HashMap;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;

@AVClassName("Food")
public class Food extends AVObject {

	public Food() {
		// TODO Auto-generated constructor stub
	}

//	about foodname
	/*public void setFoodName(String foodName){
		put("foodName", foodName);
	}*/
	public String getFoodName(){
		return getString("foodName");
	}
	
//	about type
/*	public void setType(String type){
		put("type", type);
	}*/
	public String getType(){
		return getString("type");
	}
	
//	about description
	public void setDescription(String description){
		put("description", description);
	}
	public String getDescription(){
		return getString("description");
	}
	
//	about calorie
/*	public void setCalorie(double calorie){
		put("calorie", calorie);
	}*/
	public double getCalorie(){
		return getDouble("calorie");
	}
	
//	about the name of photo
/*	public String getPhotoName(){
		return getString("photoName");
	}*/
	public AVFile getPhotoFile(){
		return getAVFile("photoFile");
	}
	
//	about 营养成分
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
	}
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

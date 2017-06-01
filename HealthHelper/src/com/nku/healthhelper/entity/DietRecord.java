package com.nku.healthhelper.entity;


import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;

@AVClassName("Dietrecord")
public class DietRecord extends AVObject {

	public static String ZAO_FAN = "早饭";
	public static String WU_FAN = "午饭";
	public static String WAN_FAN = "晚饭";
	
	public DietRecord() {
		// TODO Auto-generated constructor stub
	}

//	about user
	public void setUser(AVUser users){
		put("user", users);
	}
	public AVUser getUser(){
		return getAVUser("user");
	}
	
//	about date
	public void setDate(String date){
		put("date", date);
	}
	public String getDate(){
		return getString("date");
	}
	
//	about Kind
	public void setKind(String kind){
		put("kind", kind);
	}
	public String getKind(){
		return getString("kind");
	}
	
//	about weight
	public void setWeight(String weight){
		put("weight", weight);
	}
	public String getWeight(){
		return getString("weight");
	}
/*	
//	about food
	public void setFoodList(List<Food> listFood){
		if(null == listFood) return;
		addAll("foodList", listFood);
	}
	@SuppressWarnings("unchecked")
	public List<Food> getFoodList(){
		return getList("foodList");
	}
	public int getFoodListCount(){
		return getFoodList().size();
	}
	public void addFoodList(Food food){
		addUnique("foodList", food);
	}
	public void removeFoodList(Food food){
		List<Food> list = new ArrayList<Food>();
		list.add(food);
		removeAll("foodList", list);
	}*/
	
//	about food detail
//	public void setFoodList(List<DietRecordDetail> listFood){
//		if(null == listFood) return;
//		addAll("foodList", listFood);
//	}
//	@SuppressWarnings("unchecked")
//	public List<DietRecordDetail> getFoodList(){
//		return getList("foodList");
//	}
//	public int getFoodListCount(){
//		return getFoodList().size();
//	}
//	public void addFoodList(DietRecordDetail food){
//		addUnique("foodList", food);
//	}
//	public void removeFoodList(DietRecordDetail food){
//		List<DietRecordDetail> list = new ArrayList<DietRecordDetail>();
//		list.add(food);
//		removeAll("foodList", list);
//	}
	public void setFood(Food food){
		put("food", food);
	}
	public Food getFood(){
		return (Food)getAVObject("food");
	}
	
	
//	about calories
	public void setCalories(double calories){
		put("calories", calories);
	}
	public double getCalories(){
		return getDouble("calories");
	}
}

/*Dietrecord：饮食记录
Username
Date	日期
Kind		餐别（早午晚）
Weight	分量
Foodname	（多个）
Calories	总共热量*/
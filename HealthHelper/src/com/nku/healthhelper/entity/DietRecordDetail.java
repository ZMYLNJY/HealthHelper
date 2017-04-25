package com.nku.healthhelper.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import android.os.Parcel;

@AVClassName("DietRecorDetail")
public class DietRecordDetail extends AVObject {

	public DietRecordDetail() {
		// TODO Auto-generated constructor stub
		super();
	}

	public DietRecordDetail(String theClassName) {
		super(theClassName);
		// TODO Auto-generated constructor stub
	}

	public DietRecordDetail(Parcel in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	
//	food name
	public void setFood(Food food){
		put("food", food);
	}
	public String getFood(){
		return this.getString("food");
	}
	
//	food weight
	public void setFoodWeight(double weight){
		put("weight", weight);
	}
	public Double getFoodWeight(){
		return this.getDouble("weight");
	}
	
//	food calories
	public void setFoodCalories(double calories){
		put("calories", calories);
	}
	public Double getFoodCalories(){
		return this.getDouble("calories");
	}
}

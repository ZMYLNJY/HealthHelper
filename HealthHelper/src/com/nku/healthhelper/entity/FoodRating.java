package com.nku.healthhelper.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import android.os.Parcel;

@AVClassName("FoodRating")
public class FoodRating extends AVObject {

	public FoodRating() {
		// TODO Auto-generated constructor stub
		super();
	}

	public FoodRating(String theClassName) {
		super(theClassName);
		// TODO Auto-generated constructor stub
	}

	public FoodRating(Parcel in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	
//	about rating
	/**
	 * 设置某用户对该食物的推荐指数。
	 * @param rating 推荐指数，注意：范围应该在0~5之间，包括0和5.
	 */
	public void setRating(double rating){
		put("rating", rating);
	}
	
	/**
	 * 获得该用户对该食物的推荐指数。
	 * @return 推荐指数
	 */
	public double getRating(){
		return this.getDouble("rating");
	}

	/**
	 * 设置该条打分的打分者。一般为当前用户。
	 * @param user 打分者
	 */
	public void setRater(Users user){
		put("rater", user);
	}
	
	/**
	 * 获得该条打分的打分者。
	 * @return 打分者
	 */
	public Users getRater(){
		return (Users)this.getAVUser("rater");
	}
	
	/**
	 * 设置该条打分的被打分的食物。
	 * @param food 被打分的食物
	 */
	public void setFood(Food food){
		put("food", food);
	}
	
	/**
	 * 获得该条打分的被打分的食物
	 * @return 被打分的食物
	 */
	public Food getFood(){
		return (Food)this.getAVObject("food");
	}
}

package com.nku.healthhelper.task;


import java.util.Arrays;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.nku.healthhelper.callback.MyCheckIsRatedCallback;
import com.nku.healthhelper.callback.MyGetFoodByNameCallback;
import com.nku.healthhelper.callback.MyGetFoodByTypeCallback;
import com.nku.healthhelper.callback.MyRateFoodByOneCallback;
import com.nku.healthhelper.callback.MyUpdateRatingByAllCallback;
import com.nku.healthhelper.callback.MyUpdateRatingByOneCallback;
import com.nku.healthhelper.entity.Food;
import com.nku.healthhelper.entity.FoodRating;
import com.nku.healthhelper.entity.Users;

import android.app.Activity;

public class FoodTask {
	
	private Activity activity;
	
	private String tag1;
	
	public FoodTask(Activity activity, Object... tags) {
		// TODO Auto-generated constructor stub
		super();
		this.activity = activity;
		if(tags != null && tags.length != 0){
			this.tag1 = tags[0].toString();
		}
	}

	/**
	 * 根据食物名称模糊查询食物。完成后调用MyGetFoodByNameCallback。
	 * @param name 食物名称
	 */
	public void getFoodByName(String name){
		AVQuery<Food> foodQuery = new AVQuery<Food>("Food");
		foodQuery.whereContains("foodName", name);
		foodQuery.findInBackground(new MyGetFoodByNameCallback(activity, tag1));
	}
	
	/**
	 * 根据食物种类查询食物。完成后调用MyGetFoodByTypeCallback。
	 * @param type 食物类别
	 */
	public void getFoodByType(String type){
		AVQuery<Food> foodQuery = new AVQuery<Food>("Food");
		foodQuery.whereEqualTo("type", type);
		foodQuery.findInBackground(new MyGetFoodByTypeCallback(activity));
	}

	/**
	 * 检测某用户对某事物是否打过分。完成后调用MyCheckIsRatedCallback。
	 * @param rater 打分者，一般为当前用户
	 * @param food 被打分的食物
	 */
	public void checkIsRated(Users rater, Food food){
		final AVQuery<FoodRating> raterQuery = new AVQuery<FoodRating>("FoodRating");
		raterQuery.whereEqualTo("rater", rater);
		final AVQuery<FoodRating> foodQuery = new AVQuery<FoodRating>("FoodRating");
		foodQuery.whereEqualTo("food", food);
		
		@SuppressWarnings("unchecked")
		AVQuery<FoodRating> query = AVQuery.and(Arrays.asList(raterQuery,foodQuery));
		query.findInBackground(new MyCheckIsRatedCallback(activity,rater,food));
	}
	
	/**
	 * 某用户对某食物进行打分。一般在检测到该用户还未对该食物进行打分的前提下调用。完成后调用MyRateFoodByOneCallback.
	 * @param user 打分的人
	 * @param food 被打分的食物
	 * @param rating 打的分数
	 */
	public void rateFoodByOne(Users rater, Food food, double rating){
		FoodRating foodRating = new FoodRating();
		foodRating.setFood(food);
		foodRating.setRater(rater);
		foodRating.setRating(rating);
		foodRating.saveInBackground(new MyRateFoodByOneCallback(activity,food));
	}
	
	/**
	 * 某用户对某食物进行打分的更新。一般在检测到该用户已经对该食物打过分的前提下调用。完成后调用MyUpdateRatingByOneCallback。
	 * @param rater 打分的用户
	 * @param food 被打分的食物
	 * @param rating 打的分数
	 * @param objectId 该条记录的id :在检测时可以获得
	 */
	public void updateRatingByOne(Users rater, Food food, double rating, String objectId){
		FoodRating fRating = (FoodRating) AVObject.createWithoutData("FoodRating", objectId);
		fRating.setRating(rating);
		fRating.saveInBackground(new MyUpdateRatingByOneCallback(activity,food));
	}
	
	/**
	 * 在FoodRating中的数据发生更新时，需要调用此方法进行该食物总体推荐指数的更新。完成后调用MyUpdateRatingByAllCallback.
	 * @param food 需要进行更新的食物
	 */
	public void updateRatingByAll(Food food){
		AVQuery<FoodRating> query = new AVQuery<FoodRating>("FoodRating");
		query.whereEqualTo("food", food);
		query.findInBackground(new MyUpdateRatingByAllCallback(activity,food));
	}
	
	
}
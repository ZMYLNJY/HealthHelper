package com.nku.healthhelper.task;


import com.avos.avoscloud.AVQuery;
import com.nku.healthhelper.callback.MyGetFoodByNameCallback;
import com.nku.healthhelper.entity.Food;

import android.app.Activity;

public class FoodTask {
	
	private Activity activity;

	public FoodTask(Activity activity) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
	}

	/**
	 * 根据食物名称模糊查询食物。完成后调用MyGetFoodByNameCallback。
	 * @param name 食物名称
	 */
	public void getFoodByName(String name){
		AVQuery<Food> foodQuery = new AVQuery<Food>("Food");
		foodQuery.whereContains("foodName", name);
		foodQuery.findInBackground(new MyGetFoodByNameCallback(activity));
	}
	
	

}

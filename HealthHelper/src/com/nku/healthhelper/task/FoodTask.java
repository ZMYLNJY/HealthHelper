package com.nku.healthhelper.task;


import com.avos.avoscloud.AVQuery;
import com.nku.healthhelper.entity.Food;

import android.content.Context;

public class FoodTask {
	
	private Context context;

	public FoodTask(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public void getFoodByName(String name){
		AVQuery<Food> foodQuery = new AVQuery<Food>("Food");
		foodQuery.whereContains("foodName", name);
		
	}

}

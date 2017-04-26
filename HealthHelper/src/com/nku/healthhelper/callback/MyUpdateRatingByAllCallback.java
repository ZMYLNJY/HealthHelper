package com.nku.healthhelper.callback;

import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.FindCallback;
import com.nku.healthhelper.entity.Food;
import com.nku.healthhelper.entity.FoodRating;

import android.app.Activity;
import android.widget.Toast;

/**
 * 调用更新食物的总体推荐指数时，进行查询所有打分后调用的callback。
 * @author Administrator
 *
 */
public class MyUpdateRatingByAllCallback extends FindCallback<FoodRating> {

	private Activity activity;
	private Food food;
	
	public MyUpdateRatingByAllCallback(Activity activity, Food food) {
		// TODO Auto-generated constructor stub
		super();
		this.activity =activity;
		this.food = food;
	}

	@Override
	public void done(List<FoodRating> list, AVException e) {
		// TODO Auto-generated method stub
		if (null == e) {
			//查询成功，计算出总体推荐指数并进行更新。
				//list不应该为空的。
			double rating = 0.0;
			for (FoodRating foodRating : list) {
				rating += foodRating.getRating();
			}
			rating /= list.size();
			
			food.setRating(rating);
			food.saveInBackground();
			
		} else {
			//查询失败
			Toast.makeText(activity.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
	}

}

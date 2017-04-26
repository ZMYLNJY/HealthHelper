package com.nku.healthhelper.callback;


import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SaveCallback;
import com.nku.healthhelper.entity.Food;
import com.nku.healthhelper.task.FoodTask;

import android.app.Activity;

/**
 * 某用户对某食物进行打分后调用的callback。
 * @author Administrator
 *
 */
public class MyRateFoodByOneCallback extends SaveCallback {

	private Activity activity;
	private Food food;
	
	public MyRateFoodByOneCallback(Activity activity, Food food) {
		// TODO Auto-generated constructor stub
		super();
		this.activity = activity;
		this.food = food;
	}

	@Override
	public void done(AVException e) {
		// TODO Auto-generated method stub
		if (null == e) {
			//打分成功。
			
			//首先需要更新一下食物的总体推荐指数。这里不能删除！
			new FoodTask(activity).updateRatingByAll(food);
			
				//你的代码。。。
		} else {
			//打分失败，发生异常错误。
				//你的代码。。。
		}
	}



}

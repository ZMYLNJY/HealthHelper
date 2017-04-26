package com.nku.healthhelper.callback;

import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.FindCallback;
import com.nku.healthhelper.entity.Food;
import com.nku.healthhelper.entity.FoodRating;
import com.nku.healthhelper.entity.Users;

import android.app.Activity;

/**
 * 检测某用户对某事物是否打分后调用的callback。
 * @author Administrator
 *
 */
public class MyCheckIsRatedCallback extends FindCallback<FoodRating> {

	private Activity activity;
	private Users rater;
	private Food food;
	private String objectId;
	
	public MyCheckIsRatedCallback(Activity activity, Users rater, Food food) {
		// TODO Auto-generated constructor stub
		super();
		this.activity = activity;
		this.food = food;
		this.rater = rater;
	}

	@Override
	public void done(List<FoodRating> list, AVException e) {
		// TODO Auto-generated method stub
		if (null == e) {
			if (list.isEmpty()) {
				//查询结果为空，说明该用户对该食物还未打过分。可以进行打分或是xxx操作。
					//你的代码。。。
				
				
			} else {
				//获得该条记录的id。若不需要修改打分则可以不要
				objectId = list.get(0).getObjectId();
				//查询结果不为空，说明该用户对该事物已经打过分了。可以进行修改打分或是xxx操作。
					//你的代码。。。
				
			}
		} else {
			//查询出现异常错误。
				//你的代码
			
		}
	}

}

package com.nku.healthhelper.task;

import java.util.Arrays;

import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.nku.healthhelper.callback.MyCreateRecordCallBack;
import com.nku.healthhelper.callback.MyGetRecordListCallBack;
import com.nku.healthhelper.entity.DietRecord;
import com.nku.healthhelper.entity.Food;

import android.app.Activity;

public class DietRecordTask {

	private Activity activity;
	
	public DietRecordTask(Activity activity) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
	}
	
	/**
	 * 添加一条饮食记录。完成后调用MyCreateRecordCallBack。
	 * @param date 饮食记录日期
	 * @param kind 饮食餐别
	 * @param weight 食物分量
	 * @param food 食物
	 * @param users 用户
	 */
	public void createRecord(String date, String kind, double weight, Food food, AVUser users){
		DietRecord dietRecord = new DietRecord();
		dietRecord.setDate(date);
		dietRecord.setFood(food);
		dietRecord.setFoodName(food.getFoodName());
		dietRecord.setKind(kind);
		dietRecord.setUser(users);
		dietRecord.setCalories(weight * food.getCalorie() / 100);
		dietRecord.setWeight(weight + "");
		dietRecord.saveInBackground(new MyCreateRecordCallBack(activity));
	}
	
	/**
	 * 根据登录的user获得该用户上传的饮食记录。完成后调用MyGetRecordListCallBack。
	 * @param users 登录的用户
	 * @param date 上传日期
	 */
	public void getRecordList(AVUser users, String date){
		final AVQuery<DietRecord> userQuery = new AVQuery<DietRecord>("Dietrecord");
		userQuery.whereEqualTo("user", users);
		final AVQuery<DietRecord> dateQuery = new AVQuery<DietRecord>("Dietrecord");
		dateQuery.whereEqualTo("date", date);
		
		@SuppressWarnings("unchecked")
		AVQuery<DietRecord> query = AVQuery.and(Arrays.asList(userQuery,dateQuery));
		query.findInBackground(new MyGetRecordListCallBack(activity));
	}

}

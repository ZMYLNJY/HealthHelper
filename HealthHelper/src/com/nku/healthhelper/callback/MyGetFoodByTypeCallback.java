package com.nku.healthhelper.callback;

import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.FindCallback;
import com.nku.healthhelper.entity.Food;

import android.app.Activity;

/**
 * 通过食物类别进行食物的展示，查询后调用的callback
 * @author Administrator
 *
 */
public class MyGetFoodByTypeCallback extends FindCallback<Food> {

	private Activity activity;
	
	public MyGetFoodByTypeCallback(Activity activity) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
	}
	
	@Override
	public void done(List<Food> list, AVException e) {
		// TODO Auto-generated method stub
		if (null == e) {
			//成功查询后的前台代码
				//你的代码
			
			//注意判断非空
			/*Food food = list.get(0);
			EditText edtResult = (EditText)activity.findViewById(R.id.edt_Main_Result);
			edtResult.setText(food.getFoodName() + " : " + food.getDescription());*/
			
		} else {
			//查询失败后的前台代码
				//你的代码
		}
	}

}

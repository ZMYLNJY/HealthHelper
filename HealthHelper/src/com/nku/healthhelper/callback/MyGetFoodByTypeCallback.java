package com.nku.healthhelper.callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.FindCallback;
import com.nku.healthhelper.FoodActivity;
import com.nku.healthhelper.FoodDetailsActivity;
import com.nku.healthhelper.R;
import com.nku.healthhelper.adapter.FoodInfoAdapter;
import com.nku.healthhelper.entity.Food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 通过食物类别进行食物的展示，查询后调用的callback
 * @author Administrator
 *
 */
public class MyGetFoodByTypeCallback extends FindCallback<Food> {

	private Activity activity;
	private FoodInfoAdapter foodInfoAdapter;
	private List<Map<String, Object>> foodItems;
	private ListView foodListView;
	
	public MyGetFoodByTypeCallback(Activity activity) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
	}
	
	@Override
	public void done(List<Food> list, AVException e) {
		// TODO Auto-generated method stub
		foodItems = new ArrayList<Map<String,Object>>();
		if (null == e) {
			//成功查询后的前台代码
			//注意判断非空
			/*Food food = list.get(0);
			EditText edtResult = (EditText)activity.findViewById(R.id.edt_Main_Result);
			edtResult.setText(food.getFoodName() + " : " + food.getDescription());*/
			//Toast.makeText(activity.getApplicationContext(), list.toString(), Toast.LENGTH_SHORT).show();;
			foodListView = (ListView)activity.findViewById(R.id.lvFoodInfo);
			for(int i=0;i<list.size();i++){
				Map<String, Object> tempMap = new HashMap<String, Object>();
				Food food = list.get(i);
				tempMap.put("food", food);
//				tempMap.put("FoodImage", food.getPhotoFile());
//				tempMap.put("FoodName", food.getFoodName());
//				tempMap.put("FoodHit", food.getCalorie());
				foodItems.add(tempMap);
			}
			foodInfoAdapter = new FoodInfoAdapter(activity.getApplicationContext(), foodItems); //创建适配器   
			foodListView.setAdapter(foodInfoAdapter);
			foodListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View view,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					Food food = (Food) view.getTag(R.id.btnAddCompare);
					
					Log.e("food", food.toString());
					
					Intent checkFoodIntent = new Intent(activity,FoodDetailsActivity.class);
					Bundle bundle = new Bundle();
					bundle.putParcelable("food", food);
					checkFoodIntent.putExtra("food", bundle);
//					checkFoodIntent.putExtra("food", food);
					activity.startActivity(checkFoodIntent);
				}
			});
			
		} else {
			//查询失败后的前台代码
			//你的代码
			Log.e("check failed", "type didn't found!");
			Intent intent = new Intent(activity.getApplicationContext(),FoodActivity.class);
			activity.startActivity(intent);
		}
	}

}

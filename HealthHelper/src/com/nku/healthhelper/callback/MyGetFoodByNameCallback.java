package com.nku.healthhelper.callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.FindCallback;
import com.nku.healthhelper.FoodDetailsActivity;
import com.nku.healthhelper.FoodInfoActivity;
import com.nku.healthhelper.R;
import com.nku.healthhelper.adapter.FoodInfoAdapter;
import com.nku.healthhelper.adapter.FoodSearchAdapter;
import com.nku.healthhelper.adapter.FoodSearchAdapter.MyOnclickListener;
import com.nku.healthhelper.entity.Food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 通过食物名称进行模糊查询得到食物对象列表的callback
 * @author Administrator
 *
 */
public class MyGetFoodByNameCallback extends FindCallback<Food> {

	private Activity activity;
	private FoodSearchAdapter foodSearchAdapter;
	private FoodInfoAdapter foodInfoAdapter;
	private List<Map<String, Object>> foodItems;
	private ListView foodListView;

	
	private String tag1;

	public MyGetFoodByNameCallback(Activity activity, Object... params) {
		// TODO Auto-generated constructor stub
		super();
		this.activity = activity;
		if(params != null && params.length != 0){
			this.tag1 = params[0].toString();
		}
	}

	@Override
	public void done(List<Food> listFood, AVException e) {
		// TODO Auto-generated method stub
		//		在这里进行查询完成后的相关UI操作。其中查询结果放在了listFood中，其中是Food对象。
		//		通过这里传进来的activity，可以使用findViewById方法获得控件，进行相关操作。

		if(null == e){
			//当e为null时表示查询成功。
			//	若是从FoodSearchResultActivity中调用的。
			foodItems = new ArrayList<Map<String,Object>>();
			if("FoodSearchResultActivity".equals(tag1)){
				foodListView = (ListView)activity.findViewById(R.id.lvSearchResult);
				for(int i=0;i<listFood.size();i++){
					Map<String, Object> tempMap = new HashMap<String, Object>();
					Food food = listFood.get(i);
					tempMap.put("food", food);
					foodItems.add(tempMap);
				}
				foodSearchAdapter = new FoodSearchAdapter(activity.getApplicationContext(), foodItems, (MyOnclickListener) activity); //创建适配器   
				foodListView.setAdapter(foodSearchAdapter);		
			}
			//	若是从FoodActivity中调用
			else if("FoodInfoActivity".equals(tag1)){
				if(listFood == null || listFood.size() == 0){
					Toast.makeText(activity, "没有找到您搜索的食物", Toast.LENGTH_SHORT).show();
				}else{
					foodListView = (ListView)activity.findViewById(R.id.lvFoodInfo);
					for(int i=0;i<listFood.size();i++){
						Map<String, Object> tempMap = new HashMap<String, Object>();
						Food food = listFood.get(i);
						tempMap.put("food", food);
						foodItems.add(tempMap);
					}
					foodInfoAdapter = new FoodInfoAdapter(activity.getApplicationContext(), foodItems); //创建适配器   
					foodListView.setAdapter(foodInfoAdapter);
					foodListView.setOnItemClickListener(new OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> arg0, View view,
								int arg2, long arg3) {
							Food food = (Food) view.getTag(R.id.btnAddCompare);
							Intent checkFoodIntent = new Intent(activity,FoodDetailsActivity.class);
							Bundle bundle = new Bundle();
							bundle.putParcelable("food", food);
							checkFoodIntent.putExtra("food", bundle);
							activity.startActivity(checkFoodIntent);
						}
					});
				}
			}
		}
		else{
			//否则，查询失败
			//这里我没有仔细地分析错误代码号。若是调试过程中遇到了记得告诉我，我研究一下。
			//你的前台代码
			Log.e("check failed", "food didn't found!");
			Toast.makeText(activity, "没有找到您搜索的食物", Toast.LENGTH_SHORT).show();
		}
	}

}

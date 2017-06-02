package com.nku.healthhelper;

import com.nku.healthhelper.task.FoodTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodInfoActivity extends Activity{
	
	private ImageView imgFoodInfoReturn;
	private TextView txtFoodInfoTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_foodinfo);
		imgFoodInfoReturn = (ImageView)findViewById(R.id.imgFoodInfoReturn);
		
		imgFoodInfoReturn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				finish();
			}
		});
		
		Intent intent = getIntent();
		String type = intent.getStringExtra("type");
		
		txtFoodInfoTitle=(TextView) findViewById(R.id.txtFoodInfoTitle);
		
//		直接搜索进入
		if(type == null || "".equals(type)){
			String name = intent.getStringExtra("name");
			txtFoodInfoTitle.setText(name);
			new FoodTask(this, "FoodInfoActivity").getFoodByName(name);
		}
//		按类别后跳入
		else{
			txtFoodInfoTitle.setText(getTitle(type));	
			new FoodTask(this).getFoodByType(type);
		}
		
	}
	
	public String getTitle(String type){
		String result="";
		if("rice".equals(type)){
			result="主食类";
		}
		if("meat".equals(type)){
			result="肉蛋类";
		}
		if("fruit".equals(type)){
			result="水果类";
		}
		if("milk".equals(type)){
			result="奶制类";
		}
		if("mushroom".equals(type)){
			result="菌菇类";
		}
		if("vegetable".equals(type)){
			result="蔬菜类";
		}
		if("snake".equals(type)){
			result="零食类";
		}
		if("beverage".equals(type)){
			result="饮品类";
		}
		if("other".equals(type)){
			result="其他类";
		}
		return result;
	}
	 
}

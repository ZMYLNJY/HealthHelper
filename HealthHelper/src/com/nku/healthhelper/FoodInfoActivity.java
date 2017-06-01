package com.nku.healthhelper;

import com.nku.healthhelper.task.FoodTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class FoodInfoActivity extends Activity implements OnClickListener{
	private ImageView imgReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_foodinfo);
		imgReturn = (ImageView)findViewById(R.id.imgFoodInfoReturn);
		
		imgReturn.setOnClickListener(this);
		
		Intent intent = getIntent();
		String type = intent.getStringExtra("type");
		
//		直接搜索进入
		if(type == null || "".equals(type)){
			String name = intent.getStringExtra("name");
			new FoodTask(this, "FoodInfoActivity").getFoodByName(name);
		}
//		按类别后跳入
		else{
			new FoodTask(this).getFoodByType(type);
		}
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.imgFoodInfoReturn){
//			Intent intent = new Intent(FoodInfoActivity.this,FoodActivity.class);
//			startActivity(intent);
			finish();
		}
		
	}
	 
}

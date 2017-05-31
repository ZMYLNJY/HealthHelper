package com.nku.healthhelper;

import com.nku.healthhelper.task.FoodTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FoodInfoActivity extends Activity implements OnClickListener{
	private Button btnBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foodinfo);
		btnBack = (Button)findViewById(R.id.btnBacktoFood);
		
		btnBack.setOnClickListener(this);
		
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
		if(v.getId()==R.id.btnBacktoFood){
//			Intent intent = new Intent(FoodInfoActivity.this,FoodActivity.class);
//			startActivity(intent);
			finish();
		}
		
	}
	 
}

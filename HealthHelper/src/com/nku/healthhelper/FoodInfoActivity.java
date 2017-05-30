package com.nku.healthhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.nku.healthhelper.adapter.FoodInfoAdapter;
import com.nku.healthhelper.task.FoodTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
		
		new FoodTask(this).getFoodByType(type);
		
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.btnBacktoFood){
			Intent intent = new Intent(FoodInfoActivity.this,FoodActivity.class);
			startActivity(intent);
		}
		
	}
	 
}

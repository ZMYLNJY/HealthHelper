package com.nku.healthhelper;

import com.nku.healthhelper.task.FoodTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FoodSearchResultActivity extends Activity implements OnClickListener{
	private TextView txtSearchFood;
	private ImageView imgReturnSearchFood;
	private ListView lvSearchResult;
	private String foodnameString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foodsearchresult);
		
		txtSearchFood = (TextView)findViewById(R.id.txtSearchFood);
		imgReturnSearchFood = (ImageView)findViewById(R.id.imgReturnSearchFood);
		lvSearchResult = (ListView)findViewById(R.id.lvSearchResult);
		
		imgReturnSearchFood.setOnClickListener(this);
		
		
		Intent intent = getIntent();
		foodnameString = (String) intent.getSerializableExtra("searchfood");
		
		new FoodTask(this).getFoodByName(foodnameString);
		
		
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.imgReturnSearchFood:
			Intent backIntent = new Intent(FoodSearchResultActivity.this,FoodSearchActivity.class);
			startActivity(backIntent);
			finish();
			break;

		default:
			break;
		}
	}
	
}

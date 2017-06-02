package com.nku.healthhelper;

import com.nku.healthhelper.adapter.FoodSearchAdapter.MyOnclickListener;
import com.nku.healthhelper.entity.Food;
import com.nku.healthhelper.task.FoodTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FoodSearchResultActivity extends Activity implements OnClickListener, MyOnclickListener{
	private TextView txtSearchFood;
	private ImageView imgReturnSearchFood;
	private ListView lvSearchResult;
	private String foodnameString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_foodsearchresult);
		
		txtSearchFood = (TextView)findViewById(R.id.txtSearchFood);
		imgReturnSearchFood = (ImageView)findViewById(R.id.imgReturnSearchFood);
		lvSearchResult = (ListView)findViewById(R.id.lvSearchResult);
		
		imgReturnSearchFood.setOnClickListener(this);
		
		Intent intent = getIntent();
		foodnameString = (String) intent.getSerializableExtra("searchfood");
		
		new FoodTask(this, "FoodSearchResultActivity").getFoodByName(foodnameString);
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.imgReturnSearchFood:
//			Intent backIntent = new Intent(FoodSearchResultActivity.this,FoodSearchActivity.class);
//			startActivity(backIntent);
			finish();
			break;

		default:
			break;
		}
	}
	@Override
	public void OnButtonClick(Food food) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		Bundle bundle = new Bundle();
		bundle.putParcelable("food", food);
		intent.putExtra("food", bundle);
		setResult(201, intent);
		finish();
	}
	
}

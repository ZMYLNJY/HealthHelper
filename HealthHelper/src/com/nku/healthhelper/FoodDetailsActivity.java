package com.nku.healthhelper;

import com.nku.healthhelper.entity.Food;
import com.nku.healthhelper.util.ImageUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDetailsActivity extends Activity implements OnClickListener {
	private Button btnAddRecord,btnAddCompare;
	private ImageView imgFooddetail,imgBackFoodList;
	private TextView txtFat,txtProtein,txtSugar,txtCalcuim,txtTips;
	private TextView txtFoodname,txtFoodhit;
	private TextView txtTitleFood;
	private String foodTypeString;
	private Food food;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fooddetails);
		btnAddRecord = (Button) findViewById(R.id.btnAddRecord);
		btnAddCompare = (Button)findViewById(R.id.btnAddCompare);
		imgFooddetail = (ImageView)findViewById(R.id.imgFooddetail);
		imgBackFoodList = (ImageView)findViewById(R.id.imgReturnFoodlist);
		txtFoodname = (TextView)findViewById(R.id.txtFooddetailname);
		txtFoodhit = (TextView)findViewById(R.id.txtFooddetailhit);
		txtFat = (TextView)findViewById(R.id.txtFooddetailfat);
		txtCalcuim = (TextView)findViewById(R.id.txtFooddetailcalcium);
		txtProtein = (TextView)findViewById(R.id.txtFooddetailprotein);
		txtSugar = (TextView)findViewById(R.id.txtFooddetailsugar);
		txtTips = (TextView)findViewById(R.id.txtFoodedetailtips);
		txtTitleFood = (TextView)findViewById(R.id.txtFoodTitle);
		
		
		btnAddCompare.setOnClickListener(this);
		btnAddRecord.setOnClickListener(this);
		imgBackFoodList.setOnClickListener(this);
		Intent  foodIntent = getIntent();
		food = foodIntent.getBundleExtra("food").getParcelable("food");
		if(food != null){
			Log.e("food2", food.toString());
			ImageUtil.SetImage(food.getPhotoFile(), imgFooddetail);
			txtFoodname.setText(food.getFoodName());
			txtTitleFood.setText(food.getFoodName());
			txtFoodhit.setText(food.getCalorie()+"");
			txtFat.setText(food.getNutrition().get("Fat")+"");
			txtCalcuim.setText(food.getNutrition().get("Ca")+"");
			txtProtein.setText(food.getNutrition().get("Protein")+"");
			txtSugar.setText(food.getNutrition().get("Carbonhydro")+"");
			txtTips.setText(food.getNutrition().get("Description")+"");
			
			foodTypeString = food.getType();
			
		}
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btnAddCompare:
			Intent compareIntent = new Intent(FoodDetailsActivity.this,FoodCompareActivity.class);
			Bundle bundle = new Bundle();
			bundle.putParcelable("food", food);
			compareIntent.putExtra("food", bundle);
			startActivity(compareIntent);
			break;
		case R.id.btnAddRecord:
			
			break;
		case R.id.imgReturnFoodlist:
//			Intent backIntent = new Intent(FoodDetailsActivity.this,FoodInfoActivity.class);
//			backIntent.putExtra("type", foodTypeString);
//			startActivity(backIntent);
			finish();
			break;
		default:
			break;
		}
		
	}
}

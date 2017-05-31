package com.nku.healthhelper;

import com.avos.avoscloud.AVFile;
import com.nku.healthhelper.entity.Food;
import com.nku.healthhelper.task.SetImageTask;
import com.nku.healthhelper.util.ImageUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodCompareActivity extends Activity implements OnClickListener{
	private ImageView imgbackDetail,imgFood1,imgFood2;
	private TextView txtCalorie1,txtCalorie2;
	private TextView txtFat1,txtFat2;
	private TextView txtProtein1,txtProtein2;
	private TextView txtSugar1,txtSugar2;
	private TextView txtCa1,txtCa2;
	private TextView txtZn1,txtZn2;
	private Food food;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foodcompare);
		
		imgbackDetail = (ImageView)findViewById(R.id.imgReturnFoodinfo);
		imgFood1 = (ImageView)findViewById(R.id.imgFood1);
		imgFood2 = (ImageView)findViewById(R.id.imgFood2);
		txtCalorie1 = (TextView)findViewById(R.id.txtFood1calorie);
		txtCalorie2 = (TextView)findViewById(R.id.txtFood2calorie);
		txtFat1 = (TextView)findViewById(R.id.txtFood1fat);
		txtFat2 = (TextView)findViewById(R.id.txtFood2fat);
		txtProtein1 = (TextView)findViewById(R.id.txtFood1protein);
		txtProtein2 = (TextView)findViewById(R.id.txtFood2protein);
		txtSugar1 = (TextView)findViewById(R.id.txtFood1sugar);
		txtSugar2 = (TextView)findViewById(R.id.txtFood2sugar);
		txtCa1 = (TextView)findViewById(R.id.txtFood1calcium);
		txtCa2 = (TextView)findViewById(R.id.txtFood2calcium);
		txtZn1 = (TextView)findViewById(R.id.txtFood1zn);
		txtZn2 = (TextView)findViewById(R.id.txtFood2zn);
		
		imgbackDetail.setOnClickListener(this);
		imgFood1.setOnClickListener(this);
		imgFood2.setOnClickListener(this);
		
		Intent intent = getIntent();
		food = intent.getBundleExtra("food").getParcelable("food");
//		ImageUtil.SetImage(imgFood1, food.getPhotoFile());
		AVFile file = food.getPhotoFile();
//		file.getDataInBackground(new SetImageTask(imgFood1, imgFood2));
		txtCalorie1.setText(food.getCalorie()+"");
		txtFat1.setText(food.getNutrition().get("Fat")+"");
		txtProtein1.setText(food.getNutrition().get("Protein")+"");
		txtSugar1.setText(food.getNutrition().get("Carbonhydro")+"");
		txtCa1.setText(food.getNutrition().get("Zn")+"");
		txtZn1.setText(food.getNutrition().get("K")+"");
		
		ImageUtil.SetImage(file, imgFood1, imgFood2);
		
		txtCalorie2.setText(food.getCalorie()+"");
		txtFat2.setText(food.getNutrition().get("Fat")+"");
		txtProtein2.setText(food.getNutrition().get("Protein")+"");
		txtSugar2.setText(food.getNutrition().get("Carbonhydro")+"");
		txtCa2.setText(food.getNutrition().get("Zn")+"");
		txtZn2.setText(food.getNutrition().get("K")+"");
		
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.imgReturnFoodinfo:
//			Intent returnInfoIntent = new Intent(FoodCompareActivity.this,FoodDetailsActivity.class);
//			Bundle bundle = new Bundle();
//			bundle.putParcelable("food", food);
//			returnInfoIntent.putExtra("food", bundle);
//			startActivity(returnInfoIntent);
			finish();
			break;
		case R.id.imgFood1:
			break;
		case R.id.imgFood2:
			//搜索界面
			Intent addCompareIntent = new Intent(FoodCompareActivity.this,FoodSearchActivity.class);
			startActivityForResult(addCompareIntent, 1);
//			startActivity(addCompareIntent);
//			finish();
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 1 && resultCode == 101){
			Food food = data.getBundleExtra("food").getParcelable("food");
			ImageUtil.SetImage(food.getPhotoFile(), imgFood2);
			
			txtCalorie2.setText(food.getCalorie()+"");
			txtFat2.setText(food.getNutrition().get("Fat")+"");
			txtProtein2.setText(food.getNutrition().get("Protein")+"");
			txtSugar2.setText(food.getNutrition().get("Carbonhydro")+"");
			txtCa2.setText(food.getNutrition().get("Zn")+"");
			txtZn2.setText(food.getNutrition().get("K")+"");
		}
	}
}

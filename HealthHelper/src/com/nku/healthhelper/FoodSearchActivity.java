package com.nku.healthhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodSearchActivity extends Activity implements OnClickListener{
	private ImageView imgReturnFoodSearch,imgFoodSearch;
	private EditText edtSearchFoodname;
	private TextView txtTag1,txtTag2,txtTag3;
	private TextView txtTag4,txtTag5,txtTag6;
	private String foodnameString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foodsearch);
		
		imgFoodSearch = (ImageView)findViewById(R.id.imgFoodSearch);
		imgReturnFoodSearch = (ImageView)findViewById(R.id.imgReturnFoodSearch);
		edtSearchFoodname = (EditText)findViewById(R.id.edtSearchFoodname);
		txtTag1 = (TextView)findViewById(R.id.txtTag1);
		txtTag2 = (TextView)findViewById(R.id.txtTag2);
		txtTag3 = (TextView)findViewById(R.id.txtTag3);
		txtTag4 = (TextView)findViewById(R.id.txtTag4);
		txtTag5 = (TextView)findViewById(R.id.txtTag5);
		txtTag6 = (TextView)findViewById(R.id.txtTag6);
		
		imgFoodSearch.setOnClickListener(this);
		imgReturnFoodSearch.setOnClickListener(this);
		txtTag1.setOnClickListener(this);
		txtTag2.setOnClickListener(this);
		txtTag3.setOnClickListener(this);
		txtTag4.setOnClickListener(this);
		txtTag5.setOnClickListener(this);
		txtTag6.setOnClickListener(this);
		
		
		
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		Intent searchIntent = new Intent(FoodSearchActivity.this,FoodSearchResultActivity.class);		
		switch (view.getId()) {	
		case R.id.imgFoodSearch:
			if(edtSearchFoodname.getText().toString()!=null){
				foodnameString = edtSearchFoodname.getText().toString();
				searchIntent.putExtra("searchfood", foodnameString);
				startActivity(searchIntent);
			}else {
				Toast.makeText(getApplicationContext(), "请输入食物名称", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.imgReturnFoodSearch:
			break;
		case R.id.txtTag1:
			foodnameString = txtTag1.getText().toString();
			searchIntent.putExtra("searchfood", foodnameString);
			startActivity(searchIntent);
			break;
		case R.id.txtTag2:
			foodnameString = txtTag2.getText().toString();
			searchIntent.putExtra("searchfood", foodnameString);
			startActivity(searchIntent);
			break;
		case R.id.txtTag3:
			foodnameString = txtTag3.getText().toString();
			searchIntent.putExtra("searchfood", foodnameString);
			startActivity(searchIntent);
			break;
		case R.id.txtTag4:
			foodnameString = txtTag4.getText().toString();
			searchIntent.putExtra("searchfood", foodnameString);
			startActivity(searchIntent);
			break;
		case R.id.txtTag5:
			foodnameString = txtTag5.getText().toString();
			searchIntent.putExtra("searchfood", foodnameString);
			startActivity(searchIntent);
			break;
		case R.id.txtTag6:
			foodnameString = txtTag6.getText().toString();
			searchIntent.putExtra("searchfood", foodnameString);
			startActivity(searchIntent);
			break;
		default:
			break;
		}
	}
	
}

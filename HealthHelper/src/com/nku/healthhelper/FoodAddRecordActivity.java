package com.nku.healthhelper;


import java.util.Calendar;

import com.avos.avoscloud.AVUser;
import com.nku.healthhelper.entity.Food;
import com.nku.healthhelper.task.DietRecordTask;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class FoodAddRecordActivity extends Activity implements OnClickListener {

	private TextView txtDateDisp;
	private TextView txtFoodCaro;
	private TextView txtFoodDes;
	private RadioGroup rdgChooseKind;
	private EditText edtAddWeight;
	private ImageView imgReturnFoodInfoA;
	private ImageView imgAddFinished;

	private Food food;
	private String dateString = "";
	private Double weight;
	private String kind = "早餐";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_food_add_record);

//		users = new Users();
		
		Intent intent = getIntent();
		food = intent.getBundleExtra("food").getParcelable("food");
//		food = new Food();
		
		txtDateDisp = (TextView)findViewById(R.id.txtDateDisp);
		txtFoodCaro = (TextView)findViewById(R.id.txtFoodCaro);
		txtFoodDes = (TextView)findViewById(R.id.txtFoodDes);
		rdgChooseKind = (RadioGroup)findViewById(R.id.rdgChooseKind);
		edtAddWeight = (EditText)findViewById(R.id.edtAddWeight);
		imgReturnFoodInfoA = (ImageView)findViewById(R.id.imgReturnFoodInfoA);
		imgAddFinished = (ImageView)findViewById(R.id.imgAddFinished);

		txtFoodDes.setText(food.getDescription()+"");
		dateString = txtDateDisp.getText().toString();
		
		imgReturnFoodInfoA.setOnClickListener(this);
		imgAddFinished.setOnClickListener(this);
		txtDateDisp.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance();  
				// 直接创建一个DatePickerDialog对话框实例，并将它显示出来  
				DatePickerDialog dialog = new DatePickerDialog(FoodAddRecordActivity.this,  
						new DatePickerDialog.OnDateSetListener() {  

							@Override  
							public void onDateSet(DatePicker view, int year,  
									int monthOfYear, int dayOfMonth) {  
								dateString = year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日";
								txtDateDisp.setText(dateString);
							}  
						}  
					// 设置初始日期  
					, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c  
					.get(Calendar.DAY_OF_MONTH))	;  

				dialog.getDatePicker().setSpinnersShown(false);
				dialog.getDatePicker().setCalendarViewShown(true);
				dialog.show();
				
				return false;
			}
		});

		edtAddWeight.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(s != null && !"".equals(s.toString())){
					weight = Double.parseDouble(s.toString());
					txtFoodCaro.setText((weight * food.getCalorie() / 100) + "");
				}else{
					weight = 0.0;
					txtFoodCaro.setText((weight * food.getCalorie() / 100) + "");
				}
			}
		});
	
		rdgChooseKind.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				for(int i = 0; i < group.getChildCount(); ++i){
					RadioButton radioButton = (RadioButton)group.getChildAt(i);
					if(radioButton.getId() == checkedId){
						kind = radioButton.getText().toString();
						radioButton.setTextColor(getResources().getColor(R.color.checked));
					}else{
						radioButton.setTextColor(getResources().getColor(R.color.unchecked));
					}
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imgReturnFoodInfoA:
			finish();
			break;
		case R.id.imgAddFinished:
			AVUser user = AVUser.getCurrentUser();
			new DietRecordTask(FoodAddRecordActivity.this).createRecord(dateString, kind, weight, food, user);
			break;
		default:
			break;
		}
	}


}

package com.nku.healthhelper;

import java.util.Calendar;

import com.avos.avoscloud.AVUser;
import com.nku.healthhelper.task.DietRecordTask;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;

public class MyRecordActivity extends Activity {

	private TextView txtDate;
	private String dateString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_my_record);
		
		txtDate = (TextView)findViewById(R.id.txtRecordDate);
		
		dateString = txtDate.getText().toString();
		
		AVUser user = AVUser.getCurrentUser();
		
		
		txtDate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance();  
				// 直接创建一个DatePickerDialog对话框实例，并将它显示出来  
				DatePickerDialog dialog = new DatePickerDialog(MyRecordActivity.this,  
						new DatePickerDialog.OnDateSetListener() {  
							@Override  
							public void onDateSet(DatePicker view, int year,  
									int monthOfYear, int dayOfMonth) {  
								dateString = year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日";
								txtDate.setText(dateString);
//								获取记录
								AVUser user = AVUser.getCurrentUser();
								new DietRecordTask(MyRecordActivity.this).getRecordList(user, dateString);
							}  
						}  
					// 设置初始日期  
					, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c  
					.get(Calendar.DAY_OF_MONTH))	;  

				dialog.getDatePicker().setSpinnersShown(false);
				dialog.getDatePicker().setCalendarViewShown(true);
				dialog.show();
			}
		});
		
		new DietRecordTask(this).getRecordList(user, dateString);
	}
}

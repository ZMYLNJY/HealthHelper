package com.nku.healthhelper;

import com.nku.healthhelper.R;
import com.nku.healthhelper.task.FoodTask;
import com.nku.healthhelper.task.UserTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	public String aaaa;
	
	private EditText edtUsername;
	private EditText edtPassword;
	private EditText edtResult;
	private Button btnSubmit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edtUsername = (EditText)findViewById(R.id.edt_Main_Username);
		edtPassword = (EditText)findViewById(R.id.edt_Main_Password);
		edtResult = (EditText)findViewById(R.id.edt_Main_Result);
		btnSubmit = (Button)findViewById(R.id.btn_Main_Submit);
		
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				注册例子
/*				String username = edtUsername.getText().toString();
				String password = edtPassword.getText().toString();
				new UserTask(MainActivity.this).register(username, password);*/
				
//				查询食物Food小例子
				/*String foodName = edtUsername.getText().toString();
				new FoodTask(MainActivity.this).getFoodByName(foodName);*/
				
//				查询食物Food,根据类别
				/*String type = edtUsername.getText().toString();
				new FoodTask(MainActivity.this).getFoodByType(type);*/
			}
		});
		
	}
}
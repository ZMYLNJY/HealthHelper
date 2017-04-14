package com.nku.healthhelper;

import com.nku.healthhelper.R;
import com.nku.healthhelper.task.UserTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText edtUsername;
	private EditText edtPassword;
	private Button btnSubmit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		edtUsername = (EditText)findViewById(R.id.edt_Main_Username);
		edtPassword = (EditText)findViewById(R.id.edt_Main_Password);
		btnSubmit = (Button)findViewById(R.id.btn_Main_Submit);
		
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String username = edtUsername.getText().toString();
				String password = edtPassword.getText().toString();
				new UserTask(MainActivity.this).register(username, password);
			}
		});
		
	}
}
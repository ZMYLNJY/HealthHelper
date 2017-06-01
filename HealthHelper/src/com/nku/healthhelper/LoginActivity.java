package com.nku.healthhelper;

import com.nku.healthhelper.task.UserTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{

	private EditText edtUsername;
	private EditText edtPassword;

	private Button btnLogin;
	private Button btnRegiser;
	
	private ImageView imgReturn;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);

		
		edtUsername = (EditText)findViewById(R.id.edtUsername);
		edtPassword = (EditText)findViewById(R.id.edtPassword);
		btnLogin = (Button)findViewById(R.id.btnLogin);
		btnRegiser = (Button)findViewById(R.id.btnRegister);
		imgReturn = (ImageView)findViewById(R.id.imgLoginReturn);
		
		btnLogin.setOnClickListener(this);
		btnRegiser.setOnClickListener(this);
		imgReturn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.imgLoginReturn){
			finish();
		}
		else if(edtUsername.getText() == null || "".equals(edtUsername.getText().toString())){
			Toast.makeText(getApplicationContext(), "用户名不能为空！", Toast.LENGTH_SHORT).show();
		}
		else if(edtPassword.getText() == null || "".equals(edtUsername.getText().toString())){
			Toast.makeText(getApplicationContext(), "密码不能为空！", Toast.LENGTH_SHORT).show();
		}else{
			String username = edtUsername.getText().toString();
			String password = edtPassword.getText().toString();
			switch (v.getId()) {
			case R.id.btnLogin:
				new UserTask(LoginActivity.this).login(username, password);
				break;
			case R.id.btnRegister:
				new UserTask(LoginActivity.this).register(username, password);
				break;
			default:
				break;
			}
		}
	}
}

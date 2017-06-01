package com.nku.healthhelper.callback;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SignUpCallback;

import android.app.Activity;
import android.widget.Toast;

public class MySignUpCallback extends SignUpCallback {

	private Activity activity;
	
	public MySignUpCallback(Activity activity) {
		// TODO Auto-generated constructor stub
		super();
		this.activity = activity;
	}

	@Override
	public void done(AVException e) {
		// TODO Auto-generated method stub
		if(e == null){
			Toast.makeText(activity.getApplicationContext(), "注册成功！请在该界面进行登录！", Toast.LENGTH_LONG).show();
		}
		else if(e.getCode() == AVException.USERNAME_TAKEN){
			Toast.makeText(activity.getApplicationContext(), "用户名已被使用！", Toast.LENGTH_LONG).show();
		}else {
			Toast.makeText(activity.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

}

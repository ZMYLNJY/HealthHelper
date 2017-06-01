package com.nku.healthhelper.callback;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

import android.app.Activity;
import android.widget.Toast;

public class MyLoginCallBack extends LogInCallback<AVUser> {

	private Activity activity;

	public MyLoginCallBack(Activity activity) {
		// TODO Auto-generated constructor stub
		super();
		this.activity = activity;
	}

	@Override
	public void done(AVUser user, AVException e) {
		// TODO Auto-generated method stub
		if(e == null){
			activity.finish();
		}else if(e.getCode() == AVException.USERNAME_PASSWORD_MISMATCH){
			Toast.makeText(activity.getApplicationContext(), "用户名或密码错误！", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(activity.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}

}

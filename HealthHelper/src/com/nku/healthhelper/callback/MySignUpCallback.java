package com.nku.healthhelper.callback;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SignUpCallback;

import android.content.Context;
import android.widget.Toast;

public class MySignUpCallback extends SignUpCallback {

	private Context context;
	
	public MySignUpCallback(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	public void done(AVException arg0) {
		// TODO Auto-generated method stub
		if(arg0 == null){
			Toast.makeText(context, "注册成功！", Toast.LENGTH_LONG).show();
		}
		else if(arg0.getCode() == AVException.USERNAME_TAKEN){
			Toast.makeText(context, "用户名已被使用！", Toast.LENGTH_LONG).show();
		}else {
			Toast.makeText(context, arg0.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

}

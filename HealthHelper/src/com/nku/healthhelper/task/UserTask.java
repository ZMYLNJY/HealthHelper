package com.nku.healthhelper.task;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SignUpCallback;
import com.nku.healthhelper.entity.Users;

import android.content.Context;
import android.widget.Toast;

public class UserTask {

	private Context context;
	
	public UserTask(Context context){
		this.context = context;
	}
	
//	register with username and password
	public void register(String username, String password){
		Users users = new Users();
		users.setUsername(username);
		users.setPassword(password);
		users.signUpInBackground(new SignUpCallback() {
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
		});
	}

}

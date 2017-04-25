package com.nku.healthhelper.task;

import com.nku.healthhelper.callback.MySignUpCallback;
import com.nku.healthhelper.entity.Users;

import android.content.Context;

public class UserTask {

	private Context context;
	
	public UserTask(Context context){
		this.context = context;
	}
	
/**
 * 根据用户名和密码进行注册，不过目测不需要该方法了
 * 会调用MySignUpCallback方法进行结果的处理	
 * @param username 用户名，不能重复
 * @param password 密码，无限制
 */
//	register with username and password
	public void register(String username, String password){
		Users users = new Users();
		users.setUsername(username);
		users.setPassword(password);
		users.signUpInBackground(new MySignUpCallback(context));
	}

}

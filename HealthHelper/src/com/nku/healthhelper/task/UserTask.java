package com.nku.healthhelper.task;

import com.avos.avoscloud.AVUser;
import com.nku.healthhelper.callback.MyLoginCallBack;
import com.nku.healthhelper.callback.MySignUpCallback;
import com.nku.healthhelper.callback.MyUpdateInfoCallBack;

import android.app.Activity;

public class UserTask {

	private Activity activity;
	
	public UserTask(Activity activity){
		this.activity = activity;
	}
	
	/**
	 * 通过用户名和密码注册新用户。完成后调用MySignUpCallback。
	 * @param username 用户名
	 * @param password 密码
	 */
//	register with username and password
	public void register(String username, String password){
		AVUser user = new AVUser();
		user.setUsername(username);
		user.setPassword(password);
		user.signUpInBackground(new MySignUpCallback(activity));
	}

	/**
	 * 通过用户名和密码登录。完成后调用MyLoginCallBack。
	 * @param username 用户名
	 * @param password 密码
	 */
	public void login(String username, String password){
		AVUser.logInInBackground(username, password, new MyLoginCallBack(activity));
	}
	
	/**
	 * 修改个人信息。完成后调用MyUpdateInfoCallBack.
	 * @param user 用户实体
	 */
	public void updateInfo(AVUser user){
		user.saveInBackground(new MyUpdateInfoCallBack(activity));
	}
	
}

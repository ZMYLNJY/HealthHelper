package com.nku.healthhelper.app;

import com.nku.healthhelper.entity.Users;

import android.app.Application;

public class MyApp extends Application {

	private Users users;
	
	public MyApp() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void setUser(Users users){
		this.users = users;
	}
	
	public Users getUser(){
		return this.users;
	}

}

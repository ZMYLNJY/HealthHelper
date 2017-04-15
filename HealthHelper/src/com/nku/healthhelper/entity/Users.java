package com.nku.healthhelper.entity;

import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVUser;

import android.os.Parcel;

public class Users extends AVUser {

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(Parcel in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	
	
//	set and get gender
	public String getGender() {
		return getString("gender");
	}
	public void setGender(String gender){
		put("gender", gender);
	}
	
//	set and get age
	public String getAge() {
		return getString("age");
	}
	public void setAge(String age){
		put("age", age);
	}
	
//	set and get height
	public String getHeight() {
		return getString("height");
	}
	public void setHeight(String height){
		put("height", height);
	}
	
//	set and get weight
	public String getWeight() {
		return getString("weight");
	}
	public void setWeight(String weight){
		put("weight", weight);
	}

//	set and get image
	public AVFile getImage() {
		return super.getAVFile("image");
	}
	public void setImage(AVFile image){
		put("image", image);
	}
}

package com.nku.healthhelper.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;

@AVClassName("UploadFood")
public class UploadFood extends AVObject {
	
	public static String SHEN_HE_ZHONG = "审核中";
	public static String YI_TONG_GUO = "已通过";
	public static String WEI_TONG_GUO = "未通过";
	public static int UPLOADED = 1;
	public static int CAO_GAO_XIANG = 2;
	
/*//	upload user
	Users user;
//	some images
	AVFile imgZheng;
	AVFile imgFan;
	AVFile imgYing;
*/
	public UploadFood() {
		// TODO Auto-generated constructor stub
		super();
	}

//	about user
	public void setUser(Users users){
		put("uploader", users);
	}
	public Users getUser(){
		return getAVUser("uploader");
	}
	
//	about scanCode
	public void setScanCode(String scanCode){
		put("scanCode", scanCode);
	}
	public String getScanCode(){
		return getString("scanCode");
	}
	
//	about brand
	public void setBrand(String brand){
		put("brand", brand);
	}
	public String getBrand(){
		return getString("brand");
	}
	
//	about name
	public void setName(String name) {
		put("name", name);
	}
	public String getName(){
		return getString("name");
	}
	
//	about nickName
	public void setNickName(String nickName){
		put("nickName", nickName);
	}
	public String getNickName(){
		return getString("nickName");
	}
	
//	about photo
	public void setPhotoZheng(AVFile photo){
		put("photoZheng", photo);
	}
	public AVFile getPhotoZheng(){
		return getAVFile("photoZheng");
	}
	public void setPhotoFan(AVFile photo){
		put("photoFan"	, photo);
	}
	public AVFile getPhotoFan(){
		return getAVFile("photoFan");
	}
	public void setPhotoYing(AVFile photo){
		put("photoYing", photo);
	}
	public AVFile getPhotoYing(){
		return getAVFile("photoYing");
	}
	
//	about state
	public void setState(String state){
		put("state", state);
	}
	public String getState(){
		return getString("state");
	}
	
//	about type
	public void setType(int type){
		put("type", type);
	}
	public int getType(){
		return getInt("type");
	}
	
//	about time
//	通过已经提供的createAt
}
/*Uploadfood：上传食物
Username
Scancode	二维码
Brand		品牌
Name		名称
Nickname	别名
Photo		照片(有多张)
State		状态（审核中或已通过之类的）
Type		类型（上传的或是草稿箱）
Time		上传时间*/
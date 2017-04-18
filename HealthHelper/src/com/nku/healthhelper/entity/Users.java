package com.nku.healthhelper.entity;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVUser;

import android.os.Parcel;

public class Users extends AVUser {

//	public static int  HAS_THUMBED = 1;
//	public static int SUCESS= 2;
	
/*//	点过赞的Photo(Thumb photo)
	List<Photo> listThumbPhotos = new ArrayList<Photo>();
//	关注的city
	List<String> listCity = new ArrayList<String>();
//	收藏的Photo(Favorite photo)
	List<Photo> listFavoPhotos = new ArrayList<Photo>();*/
	
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
	
//	about city
	public void setCity(List<String> listCity){
		if(null == listCity)
			return;
//		this.listCity = listCity;
		addAll("city", listCity);
	}
	@SuppressWarnings("unchecked")
	public List<String> getCity(){
//		return this.listCity;
		return getList("city");
	}
	public int getCityCount(){
		return getCity().size();
	}
	public void addCity(String city){
		addUnique("city", city);
	}
	public void removeCity(String city){
//		this.listCity.remove(string);
		List<String> list = new ArrayList<String>();
		list.add(city);
		removeAll("city", list);
	}
	
//	about thumb
	public void setThumbPhoto(List<Photo> listThumbPhoto){
		if(null == listThumbPhoto)
			return;
		addAll("thumbPhoto", listThumbPhoto);
	}
	@SuppressWarnings("unchecked")
	public List<Photo> getThumbPhoto(){
		return getList("thumbPhoto");
	}
	public int getThumbPhotoCount(){
		return getThumbPhoto().size();
	}
	public void addThumbPhoto(Photo photo){
		addUnique("thumbPhoto", photo);
	}
	public void removeThumbPhoto(Photo photo){
		List<Photo> list = new ArrayList<Photo>();
		list.add(photo);
		removeAll("thumbPhoto", list);;
	}
	
//	about favorite
	public void setFavoPhoto(List<Photo> listFavPhoto){
		if(listFavPhoto == null) return;
		addAll("favoPhoto", listFavPhoto);
	}
	@SuppressWarnings("unchecked")
	public List<Photo> getFavoPhoto(){
		return getList("favoPhoto");
	}
	public int getFavoPhotoCount(){
		return getFavoPhoto().size();
	}
	public void addFavoPhoto(Photo photo){
		addUnique("favoPhoto", photo);
	}
	public void removeFavoPhoto(Photo photo){
		List<Photo> list = new ArrayList<Photo>();
		list.add(photo);
		removeAll("favoPhoto", list);
	}
}














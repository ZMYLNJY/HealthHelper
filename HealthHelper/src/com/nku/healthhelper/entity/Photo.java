package com.nku.healthhelper.entity;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;

@AVClassName("Photo")
public class Photo extends AVObject {
	
/*	//点赞的人
	List<Users> thumbUsers = new ArrayList<Users>();
//	收藏的人
	List<Users> favoUsers = new ArrayList<Users>();*/

	public Photo() {
		// TODO Auto-generated constructor stub
		super();
	}

	//获得分享图片的用户(get the publisher of photo)
	public  Users getPublisher(){
		return (Users)super.getAVUser("publisher");
	}
	public void setPublisher(Users users){
		super.put("publisher", users);
	}
	
	//set and get photoname
	public String getPhotoname(){
		return getString("photoname");
	}
	public void setPhotoname(String photoname){
		put("photoname", photoname);
	}
	
	//set and get description
	public String getDescription(){
		return getString("description");
	}
	public void setDescription(String description){
		put("description", description);
	}
	
	//set and get photo
	public AVFile getPhotoFile(){
		return super.getAVFile("imageFile");
	}
	public void setPhotoFile(AVFile imageFile){
		super.put("imageFile", imageFile);
	}
	/*
	
//	我们使用 AVRelation 来链接 Photo 和 Users，给 Photo 类增加如下属性和方法
	public AVRelation getThumber(){
		AVRelation relation = getRelation("thumbs");
		return relation;
	}
	public void removeThumber(Users user){
		AVRelation users = getThumber();
		users.remove(user);
		this.saveInBackground();
	}
	public void addThumber(Users user){
		AVRelation users = getThumber();
		users.add(user);
		this.saveInBackground();
	}
	*/
	
//	关于点赞人(about thumbers)
	public void setThumbUsers(List<Users> users){
		if(null == users) return;
		addAll("thumbUser", users);
	}
	@SuppressWarnings("unchecked")
	public List<Users> getThumbUsers(){
		return getList("thumbUser");
	}
	public void addThumber(Users users){
		addUnique("thumbUser", users);
	}
	public void removeThumber(Users users){
		List<Users> list = new ArrayList<Users>();
		list.add(users);
		removeAll("thumbUser", list);
	}
	public int getThumbCount(){
		return getThumbUsers().size();
	}
	
//	关于收藏的人(about favorite)
	public void setFavoUsers(List<Users> users){
		if(null == users) return;
		addAll("favoUser", users);
	}
	@SuppressWarnings("unchecked")
	public List<Users> getFavoUsers(){
		return getList("favoUser");
	}
	public int getFavoUserCount(){
		return getFavoUsers().size();
	}
	public void addFavoUser(Users users){
		addUnique("favoUser", users);
	}
	public void removeFavoUser(Users users){
		List<Users> list = new ArrayList<Users>();
		list.add(users);
		removeAll("favoUser", list);
	}
}

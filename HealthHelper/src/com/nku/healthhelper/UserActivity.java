package com.nku.healthhelper;


import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVUser;
import com.nku.healthhelper.entity.CircleImageView;
import com.nku.healthhelper.util.ImageUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserActivity extends Activity implements OnClickListener{

	private CircleImageView imgMyPhoto; //头像
	private TextView txtMyRealName;
	private Button btnGoLog;
	
	private TextView txtMyId,txtMyGender,txtMyHigh,txtMyWeight;
	
	private LinearLayout lloMyRecord,lloMySetting;
	
	private AVUser user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);

		imgMyPhoto = (CircleImageView)findViewById(R.id.imgMyPhoto);
		txtMyRealName = (TextView)findViewById(R.id.txtMyRealName);
		btnGoLog = (Button)findViewById(R.id.btnGoLog);
		txtMyId = (TextView)findViewById(R.id.txtMyId);
		txtMyGender = (TextView)findViewById(R.id.txtMyGender);
		txtMyHigh = (TextView)findViewById(R.id.txtMyHigh);
		txtMyWeight = (TextView)findViewById(R.id.txtMyWeight);
		lloMyRecord = (LinearLayout)findViewById(R.id.lloMyRecord);
		lloMySetting = (LinearLayout)findViewById(R.id.lloMySetting);
		
		user = AVUser.getCurrentUser();
//		已经登录
		if(user != null){
			Log.e("user", user.toString());
			AVFile file = user.getAVFile("image");
			ImageUtil.SetImage(file, imgMyPhoto);
			
			txtMyRealName.setText(user.getUsername());
			txtMyId.setText(user.getUsername());
			txtMyGender.setText(user.getString("gender"));
			txtMyHigh.setText(user.getString("height") + "cm");
			txtMyWeight.setText(user.getString("weight") + "kg");
			
			btnGoLog.setText("点击登出");
			btnGoLog.setOnClickListener(this);
				
			
			lloMyRecord.setEnabled(true);
			lloMySetting.setEnabled(true);
			lloMyRecord.setOnClickListener(this);
			lloMySetting.setOnClickListener(this);
		}
//		未登录
		else{
			btnGoLog.setText("点击登录");
			btnGoLog.setOnClickListener(this);
			lloMyRecord.setEnabled(false);
			lloMySetting.setEnabled(false);
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnGoLog:
			if(AVUser.getCurrentUser() == null){
				btnGoLog.setText("点击登出");
				Intent intent = new Intent(UserActivity.this, LoginActivity.class);
				startActivity(intent);
			}else{
				btnGoLog.setText("点击登录");
				lloMyRecord.setEnabled(false);
				lloMySetting.setEnabled(false);
				AVUser.logOut();
				onCreate(null);
			}
			break;
		case R.id.lloMyRecord:
			Intent intent = new Intent(UserActivity.this, MyRecordActivity.class);
			startActivity(intent);
			break;
		case R.id.lloMySetting:
			Intent intent2 = new Intent(UserActivity.this, UpdateUserInfoActivity.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		onCreate(null);
	}


}

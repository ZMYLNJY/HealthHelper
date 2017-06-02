package com.nku.healthhelper;

import com.avos.avoscloud.AVUser;
import com.nku.healthhelper.task.UserTask;

import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateUserInfoActivity extends Activity {

	private ImageView imgUpdateInfoReturn;
	private TextView txtUUISave;
	private EditText edtUUIUsername;
	private EditText edtUUIGender;
	private EditText edtUUIHigh;
	private EditText edtUUIWeight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE	);
		setContentView(R.layout.activity_update_user_info);
		
		imgUpdateInfoReturn = (ImageView)findViewById(R.id.imgUpdateInfoReturn);
		txtUUISave = (TextView)findViewById(R.id.txtUUISave);
		edtUUIUsername = (EditText)findViewById(R.id.edtUUIUsername);
		edtUUIGender = (EditText)findViewById(R.id.edtUUIGender);
		edtUUIHigh = (EditText)findViewById(R.id.edtUUIHigh);
		edtUUIWeight = (EditText)findViewById(R.id.edtUUIWeight);
		
		AVUser user = AVUser.getCurrentUser();
		if(user.getUsername() != null && !"".equals(user.getUsername())){
			edtUUIUsername.setText(user.getUsername());
		}
		if(user.getString("gender") != null && !"".equals(user.getString("gender"))){
			edtUUIGender.setText(user.getString("gender"));
		}
		if(user.getString("height") != null && !"".equals(user.getString("height"))){
			edtUUIHigh.setText(user.getString("height"));
		}
		if(user.getString("weight") != null && !"".equals(user.getString("weight"))){
			edtUUIWeight.setText(user.getString("weight"));
		}
		
		imgUpdateInfoReturn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		txtUUISave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(edtUUIUsername.getText() == null || "".equals(edtUUIUsername.getText().toString())){
					Toast.makeText(getApplicationContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
				}else if(edtUUIGender.getText() == null || "".equals(edtUUIGender.getText().toString())){
					Toast.makeText(getApplicationContext(), "性别不能为空", Toast.LENGTH_SHORT).show();
				}else if(edtUUIHigh.getText() == null || "".equals(edtUUIHigh.getText().toString())){
					Toast.makeText(getApplicationContext(), "身高不能为空", Toast.LENGTH_SHORT).show();
				}else if(edtUUIWeight.getText() == null || "".equals(edtUUIWeight.getText().toString())){
					Toast.makeText(getApplicationContext(), "体重不能为空", Toast.LENGTH_SHORT).show();
				}else{
					AVUser user = AVUser.getCurrentUser();
					String username = edtUUIUsername.getText().toString();
					String gender = edtUUIGender.getText().toString();
					String height = edtUUIHigh.getText().toString();
					String weight = edtUUIWeight.getText().toString();
					user.setUsername(username);
					user.put("gender", gender);
					user.put("height", height);
					user.put("weight", weight);
					new UserTask(UpdateUserInfoActivity.this).updateInfo(user);
				}
			}
		});
		
	}
}

package com.nku.healthhelper;

import com.avos.avoscloud.AVUser;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class UpdateUserInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE	);
		setContentView(R.layout.activity_update_user_info);
		
	}
}

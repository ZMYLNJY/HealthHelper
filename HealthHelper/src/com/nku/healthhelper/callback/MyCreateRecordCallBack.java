package com.nku.healthhelper.callback;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SaveCallback;

import android.app.Activity;
import android.widget.Toast;

/**
 * 添加一条饮食记录后的回调方法
 * @author eumes
 *
 */

public class MyCreateRecordCallBack extends SaveCallback {

	private Activity activity;

	public MyCreateRecordCallBack(Activity activity) {
		// TODO Auto-generated constructor stub
		super();
		this.activity = activity;
	}

	@Override
	public void done(AVException e) {
		// TODO Auto-generated method stub
		if (null == e) {
			Toast.makeText(activity.getApplicationContext(), "添加饮食记录成功！", Toast.LENGTH_SHORT).show();
			activity.finish();
		} else {
			//出现异常错误。
			//你的代码
			Toast.makeText(activity.getApplicationContext(), "添加失败，请重新添加！", Toast.LENGTH_SHORT).show();
		}
	}

}

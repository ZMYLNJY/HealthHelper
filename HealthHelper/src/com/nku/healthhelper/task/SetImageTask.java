package com.nku.healthhelper.task;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.GetDataCallback;
import com.nku.healthhelper.util.ImageUtil;

import android.widget.ImageView;

public class SetImageTask extends GetDataCallback {

	private ImageView[] imgView;
	
	public SetImageTask(ImageView... imgView) {
		// TODO Auto-generated constructor stub
		this.imgView = imgView;
	}

	@Override
	public void done(byte[] bytes, AVException arg1) {
		// TODO Auto-generated method stub
		for (ImageView imageView : imgView) {
			imageView.setImageBitmap(ImageUtil.Byte2Bitmap(bytes));
		}
	}

}

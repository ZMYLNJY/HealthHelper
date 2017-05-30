package com.nku.healthhelper.util;


import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.GetDataCallback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class ImageUtil {

	public static ImageView imageView;
	
	public ImageUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Note：将图片从byte[]形式转换成Bitmap形式。
	 * @param bytes 图片的byte[]形式
	 * @return Bitmap格式
	 */
	public static Bitmap Byte2Bitmap(byte[] bytes){
		return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
	}
	
	public static void SetImage(ImageView iView, AVFile image){
		imageView = iView;
		
		image.getDataInBackground(new GetDataCallback() {
			@Override
			public void done(byte[] bytes, AVException e) {
			//下载完成后获得了图片的byte[]格式
				// TODO Auto-generated method stub
				//在setImageBitmap方法中调用ImageUtil.Byte2Bitmap()方法将byte[]格式转换成Bitmap格式。
				setImageBack(bytes);
			}
		});
	}
	
	private static void setImageBack(byte[] bytes){
		imageView.setImageBitmap(ImageUtil.Byte2Bitmap(bytes));
	}

}
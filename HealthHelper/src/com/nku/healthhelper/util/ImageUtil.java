package com.nku.healthhelper.util;

import com.avos.avoscloud.AVFile;
import com.nku.healthhelper.task.SetImageTask;

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
	
	public static void SetImage(ImageView imgView, AVFile file){
		file.getDataInBackground(new SetImageTask(imgView));
	}
	
}
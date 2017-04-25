package com.nku.healthhelper.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageUtil {

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
	
}

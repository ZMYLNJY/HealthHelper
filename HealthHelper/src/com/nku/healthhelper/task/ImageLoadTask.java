package com.nku.healthhelper.task;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

@SuppressLint("NewApi") public class ImageLoadTask extends AsyncTask<String, Void, Bitmap> {

	    //从后台加载图片的异步任务
		private View view;
		
		public ImageLoadTask(View view){
			this.view = view;
		}
		
		@Override
		protected Bitmap doInBackground(String... arg0) {
			
			Bitmap bitmap;
			try {
				URL url = new URL(arg0[0]);
				Log.e("picture", url.toString());
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
				conn.setDoInput(true);  
				conn.connect();  
			    InputStream is = conn.getInputStream();  
				bitmap = BitmapFactory.decodeStream(is);  
			    is.close();  
			    
				return bitmap;
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@SuppressWarnings("deprecation")
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if(view instanceof ImageView){
				((ImageView) view).setImageBitmap(result);
			}else{
				view.setBackground(new BitmapDrawable(result));
			}
			
		}
	
}

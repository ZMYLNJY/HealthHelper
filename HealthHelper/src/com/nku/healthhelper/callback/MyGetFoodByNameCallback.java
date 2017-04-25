package com.nku.healthhelper.callback;

import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.FindCallback;
import com.nku.healthhelper.entity.Food;

import android.app.Activity;

/**
 * 通过食物名称进行模糊查询得到食物对象列表的callback
 * @author Administrator
 *
 */
public class MyGetFoodByNameCallback extends FindCallback<Food> {

	private Activity activity;
	
	public MyGetFoodByNameCallback(Activity activity) {
		// TODO Auto-generated constructor stub
		super();
		this.activity = activity;
	}
	
	@Override
	public void done(List<Food> listFood, AVException e) {
		// TODO Auto-generated method stub
//		在这里进行查询完成后的相关UI操作。其中查询结果放在了listFood中，其中是Food对象。
//		通过这里传进来的activity，可以使用findViewById方法获得控件，进行相关操作。
		if(null == e){
			//当e为null时表示查询成功。
				//你的前台代码
			
//			下面一段是获得并设置图片的例子，在adapter中也可以这么写，就这么写吧。
			/*Food food = listFood.get(0);
			AVFile file = food.getPhotoFile();
			file.getDataInBackground(new GetDataCallback() {
				
				@Override
				public void done(byte[] bytes, AVException e) {
					// TODO Auto-generated method stub
					ImageView imageView = (ImageView)activity.findViewById(R.id.img_Main_Icon	);
					imageView.setImageBitmap(ImageUtil.Byte2Bitmap(bytes));
				}
			});*/
			
		}
		else{
			//否则，查询失败
				//你的前台代码
		}
	}

}

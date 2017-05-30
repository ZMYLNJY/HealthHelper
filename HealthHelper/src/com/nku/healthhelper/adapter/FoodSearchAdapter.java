package com.nku.healthhelper.adapter;

import java.util.List;
import java.util.Map;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.GetDataCallback;
import com.nku.healthhelper.R;
import com.nku.healthhelper.adapter.FoodInfoAdapter.FoodItemView;
import com.nku.healthhelper.entity.Food;
import com.nku.healthhelper.util.ImageUtil;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodSearchAdapter extends BaseAdapter {
	
	private Context context;
	private List<Map<String, Object>> foodItems;
	private LayoutInflater foodItemInflater;
	private FoodItemView foodItemView;
	public final class FoodItemView{
		public ImageView imgFoodItem;
		public TextView txtFoodHit;
		public TextView txtFoodName;
		public Button btnAddCompare;
		
	}
	public FoodSearchAdapter(Context context,List<Map<String, Object>>foodItems){
		this.context = context;
		foodItemInflater = LayoutInflater.from(context);
		this.foodItems = foodItems;
	}
	
	public void setImage(ImageView imageView, byte[] bytes){
		imageView.setImageBitmap(ImageUtil.Byte2Bitmap(bytes));
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return foodItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return foodItems.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.e("method", "getView");
		foodItemView = null; 
		if(convertView == null){
			foodItemView = new FoodItemView();
			convertView = foodItemInflater.inflate(R.layout.item_foodsearchinfo, null);
			foodItemView.imgFoodItem = (ImageView) convertView.findViewById(R.id.imgFoodSearch);
			foodItemView.txtFoodHit = (TextView) convertView.findViewById(R.id.txtSearchFoodHit);
			foodItemView.txtFoodName = (TextView) convertView.findViewById(R.id.txtSearchFoodName);
			foodItemView.btnAddCompare = (Button)convertView.findViewById(R.id.btnSearchAddCompare);
			convertView.setTag(foodItemView);
		}else {
			foodItemView = (FoodItemView) convertView.getTag();
		} 
		Food food = (Food) foodItems.get(position).get("food");
		AVFile file = (AVFile) food.getPhotoFile();
		//后台进行下载图片文件
		file.getDataInBackground(new GetDataCallback() {
			
			@Override
			public void done(byte[] bytes, AVException e) {
			//下载完成后获得了图片的byte[]格式
				// TODO Auto-generated method stub
				//在setImageBitmap方法中调用ImageUtil.Byte2Bitmap()方法将byte[]格式转换成Bitmap格式。
				setImage(foodItemView.imgFoodItem, bytes);
			}
		});
		
		foodItemView.txtFoodName.setText(food.getFoodName());
		foodItemView.txtFoodHit.setText(food.getCalorie() + "");
		//foodItemView.btnAddCompare.setText("加入对比");
		//我又忘了那个callback函数怎么写= =
		//foodItemView.txtAddCompare.setOnClickListener(l);
		convertView.setTag(R.id.btnAddCompare, food);
		
        return convertView;
	}

}

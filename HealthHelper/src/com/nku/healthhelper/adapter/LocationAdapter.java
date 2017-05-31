package com.nku.healthhelper.adapter;

import java.util.List;

import com.nku.healthhelper.R;
import com.nku.healthhelper.entity.WeatherInfo;
import com.nku.healthhelper.task.ImageLoadTask;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationAdapter extends BaseAdapter {
	
	private class ViewHolder{
		ImageView imgLocationShowWeather;
		ImageView imgLocationShowDelete;
		TextView txtLocationShowCity;
		TextView txtLocationShowTemper;
	}
	
	private ViewHolder holder;
	private List<WeatherInfo> weatherInfos;
	private Context mContext;
	
	public LocationAdapter(Context mContext,List<WeatherInfo> weatherInfos){
		this.mContext=mContext;
		this.weatherInfos=weatherInfos;
	}
	
	@Override
	public int getCount() {
		if(weatherInfos !=null)
             return weatherInfos.size();
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if(weatherInfos != null)
            return weatherInfos.get(position);
        return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {		
		
        if(convertView == null) {
        	holder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_location_show,null);
			holder.txtLocationShowCity=(TextView)convertView.findViewById(R.id.txtLocationShowCity);
			holder.txtLocationShowTemper=(TextView)convertView.findViewById(R.id.txtLocationShowTemper);
			holder.imgLocationShowDelete=(ImageView) convertView.findViewById(R.id.imgLocationShowDelete);
			holder.imgLocationShowWeather=(ImageView) convertView.findViewById(R.id.imgLocationShowWeather);
			convertView.setTag(holder);
        }else{
        	holder = (ViewHolder) convertView.getTag();
        }
        //判断weatherInfos是不是空
        if(weatherInfos==null){
        	return null;
        }
        else{
        	final WeatherInfo weatherInfo = weatherInfos.get(position);
        	//加载图片
        	ImageLoadTask iLoadTask = new ImageLoadTask(holder.imgLocationShowWeather);
   		 	iLoadTask.execute(weatherInfo.getPicture());
        	
            holder.txtLocationShowCity.setText(weatherInfo.getCity());
            holder.txtLocationShowTemper.setText(weatherInfo.getTemper()+"°C");
            holder.imgLocationShowDelete.setOnClickListener(new ImageView.OnClickListener() {
                @Override
                public void onClick(View v) {
                	
                	//删除城市后重新保存
                    String cityName=weatherInfo.getCity();
                    SharedPreferences settings = mContext.getSharedPreferences("Citys", Activity.MODE_PRIVATE);  
                	String tempt= settings.getString("citys", "");
                	Log.e("citys1", tempt);
                	String result="";
                	if(!"".equals(tempt)){
                		//用|分割城市名字
                		String []words=tempt.split("\\|");
                		for(int i=0;i<words.length;i++){
                			if(cityName.equals(words[i])){
                				continue;
                			}else{
                				result+=words[i]+"|";
                			}
                		}
                	}
                	if(!result.equals("")){
                		result=result.substring(0,result.length()-1);
                	}
                	Log.e("citys2", result+"xxx");
           
                	SharedPreferences settingsWrite = mContext.getSharedPreferences("Citys", Activity.MODE_PRIVATE);  
                	SharedPreferences.Editor editor = settingsWrite.edit();  
                	editor.putString("citys",result);  
                	editor.commit(); 
                	
                	weatherInfos.remove(weatherInfo);                	
                    notifyDataSetChanged();
                   
                }
            });
            
    		return convertView;
        }

	}

}

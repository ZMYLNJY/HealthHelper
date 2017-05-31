package com.nku.healthhelper.task;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.nku.healthhelper.entity.WeatherInfo;
import com.nku.healthhelper.util.HttpUtils;
import com.nku.healthhelper.util.JsonUtils;

import android.content.Context;
import android.os.AsyncTask;

public class GetWeatherByNameTask extends AsyncTask<String, Void, WeatherInfo> {

	Context context;
	
	public GetWeatherByNameTask(Context context){
		this.context=context;
	}
	@Override
	protected WeatherInfo doInBackground(String... arg0) {
		
		String cityName= arg0[0];
		String host = "https://ali-weather.showapi.com";
	    String path = "/area-to-weather";
	    String method = "GET";
	    String appcode = "651deaf3cac141329279662cf9e78579";
	    Map<String, String> headers = new HashMap<String, String>();

	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    
	    //支持中文查询
	    querys.put("area", cityName);
	    querys.put("need3HourForcast", "0");
	    querys.put("needAlarm", "1");
	    querys.put("needHourData", "0");
	    querys.put("needIndex", "1");
	    querys.put("needMoreDay", "1");
		
	    
	    HttpResponse httpResponse;
		try {
			
			httpResponse = HttpUtils.doGet(host, path, method, headers, querys);
			HttpEntity httpEntity=httpResponse.getEntity();
			String response=EntityUtils.toString(httpEntity,"utf-8");
			WeatherInfo weatherInfo=JsonUtils.getWeatherInfo(response);
			return weatherInfo;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		return null;
	}

}

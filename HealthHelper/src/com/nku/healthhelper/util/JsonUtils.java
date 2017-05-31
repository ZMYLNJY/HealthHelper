package com.nku.healthhelper.util;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.nku.healthhelper.entity.DayWeatherInfo;
import com.nku.healthhelper.entity.WeatherInfo;

import android.util.Log;  
  
/** 
 * json 
 */  
public class JsonUtils {  
  
    public static WeatherInfo getWeatherInfo(String jsonData){  
        try {  
//        	Log.e("response",jsonData); 
        	//得到总的对象
            JSONObject jsonObject1 = new JSONObject(jsonData);  
            //得到有关天气的部分
            JSONObject jsonObject2 = jsonObject1.getJSONObject("showapi_res_body"); 
            
            WeatherInfo weatherInfo = new WeatherInfo(); 
            //设置现在now的一些参数 得到有关now的
            JSONObject jsonObject3 = jsonObject2.getJSONObject("now"); 
            
            //设置城市名 空气质量
            JSONObject jsonObject4 = jsonObject3.getJSONObject("aqiDetail"); 
            
            weatherInfo.setCity(jsonObject4.getString("area"));  
            weatherInfo.setAqiQualityString(jsonObject4.getString("quality"));
            
            //设置图片路径
            weatherInfo.setPicture(jsonObject3.getString("weather_pic")); 
           
            
            //设置温度 风向 风力 天气 空气指数 湿度
            weatherInfo.setTemper(jsonObject3.getString("temperature")); 
            weatherInfo.setWind_direction(jsonObject3.getString("wind_direction"));
            weatherInfo.setWin_powerString(jsonObject3.getString("wind_power"));
            weatherInfo.setWeather(jsonObject3.getString("weather"));
            weatherInfo.setAqi(jsonObject3.getString("aqi"));
            weatherInfo.setSd(jsonObject3.getString("sd"));
            
            //得到未来六天的天气预报
            JSONArray jsonDayWeathers = new JSONArray();
            for(int i=1;i<=6;i++){
            	JSONObject jsonTempt = jsonObject2.getJSONObject("f"+i);
            	jsonDayWeathers.put(jsonTempt);
            }
            
            List<DayWeatherInfo> dayWeatherInfos = new ArrayList<DayWeatherInfo>();  
            
            
            for(int i=0;i<jsonDayWeathers.length();i++){  
                JSONObject obj = jsonDayWeathers.getJSONObject(i);  
                DayWeatherInfo dayWeatherInfo = new DayWeatherInfo();  
                
                dayWeatherInfo.setDay(obj.getString("day"));
                String []words=obj.getString("sun_begin_end").split("\\|");
                dayWeatherInfo.setSun_begin(words[0]);
                dayWeatherInfo.setSun_end(words[1]);
                dayWeatherInfo.setDay_weather(obj.getString("day_weather")+" "+obj.getString("day_air_temperature")+"°C");
                dayWeatherInfo.setNight_weather(obj.getString("night_weather")+" "+obj.getString("night_air_temperature")+"°C");
                dayWeatherInfo.setDay_wind_power(obj.getString("day_wind_power"));
                dayWeatherInfo.setNight_wind_power(obj.getString("night_wind_power"));
                
                JSONObject jsonTempt1 = obj.getJSONObject("index"); 
                JSONObject jsonTempt2 = jsonTempt1.getJSONObject("clothes");
                dayWeatherInfo.setClothesTitle(jsonTempt2.getString("title"));
                dayWeatherInfo.setClothesDesc(jsonTempt2.getString("desc"));
                JSONObject jsonTempt3 = jsonTempt1.getJSONObject("cold");
                dayWeatherInfo.setColdTitle(jsonTempt3.getString("title"));
                JSONObject jsonTempt4 = jsonTempt1.getJSONObject("uv");
                dayWeatherInfo.setUvTitle(jsonTempt4.getString("title"));
                
                dayWeatherInfo.setWeekday(obj.getString("weekday"));
                dayWeatherInfos.add(dayWeatherInfo);  
            }  
            weatherInfo.setForecast(dayWeatherInfos);  
            
            return weatherInfo;  
        }catch (Exception e){  
            e.printStackTrace();  
            Log.e(e.toString(),"获取Json数据失败");  
            return null;  
        }  
    }  
}  
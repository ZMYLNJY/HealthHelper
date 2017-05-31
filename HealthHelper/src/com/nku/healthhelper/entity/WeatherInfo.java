package com.nku.healthhelper.entity;

import java.util.List;

public class WeatherInfo {
/*
 * 7天的未来的天气  参考DayWeatherInfo 
 * 加上现在的天气 now
    "now": {//现在实时的天气情况
      "aqiDetail": {//aqi明细数据
        "co": 0.38,//一氧化碳1小时平均
        "so2": 8,//二氧化硫1小时平均
        "area": "丽江",//地区
        "o3": 42,//臭氧1小时平均
        "no2": 9,//二氧化氮1小时平均
        "area_code": "lijiang",
        "quality": "优",//空气质量指数类别，有“优、良、轻度污染、中度污染、重度污染、严重污染”6类
        "aqi": 19,//空气质量指数，越小越好
        "pm10": 18,//颗粒物（粒径小于等于10μm）1小时平均
        "pm2_5": 12,//颗粒物（粒径小于等于2.5μm）1小时平均
        "o3_8h": 37,//臭氧8小时平均
        "primary_pollutant": ""//首要污染物
      },
      "weather_code": "03",
      "wind_direction": "西北风",//风向
      "temperature_time": "16:01",//获得气温的时间
      "wind_power": "1级",//风力
      "aqi": 19,//空气质量指数，越小越好
      "sd": "70%",//空气湿度
      "weather_pic": "http://appimg.showapi.com/images/weather/icon/day/03.png",//天气小图标
      "weather": "阵雨",//天气
      "temperature": "21"//气温
    },
 */
    private String city;//城市名
    private String temper;//温度
    private String wind_direction;//风向
    private String win_powerString;//风力
    private String weather;//天气  比如阵雨等
    private String aqi;//空气指数
    private String aqiQualityString;//优 良等
    private String sd;//空气湿度
    private List<DayWeatherInfo> forecast;//未来七天的数据
    private String picture;//存放对应图片的路径
    
    
    public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
    public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTemper() {
		return temper;
	}
	public void setTemper(String temper) {
		this.temper = temper;
	}
	public String getWind_direction() {
		return wind_direction;
	}
	public void setWind_direction(String wind_direction) {
		this.wind_direction = wind_direction;
	}
	public String getWin_powerString() {
		return win_powerString;
	}
	public void setWin_powerString(String win_powerString) {
		this.win_powerString = win_powerString;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getAqiQualityString() {
		return aqiQualityString;
	}
	public void setAqiQualityString(String aqiQualityString) {
		this.aqiQualityString = aqiQualityString;
	}
	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	public List<DayWeatherInfo> getForecast() {
		return forecast;
	}
	public void setForecast(List<DayWeatherInfo> forecast) {
		this.forecast = forecast;
	}
	
}

package com.nku.healthhelper.entity;

import java.io.Serializable;

/**
 * about 7 days future
 */

/*example 
 "f7": {//今天+6天后的天气预报
      "day_weather": "小雨",//白天天气
      "night_weather": "中雨",//晚上天气
      "night_weather_code": "08",//晚上的天气编码
      "index": {//指数对象
        "cold": {//感冒
          "title": "少发",
          "desc": "无明显降温，感冒机率较低。"
        },
        "clothes": {//穿衣指数
          "title": "较舒适",
          "desc": "建议穿薄外套或牛仔裤等服装。"
        },
        "uv": {//紫外线
          "title": "最弱",
          "desc": "辐射弱，涂擦SPF8-12防晒护肤品。"
        },
        "wash_car": {//洗车
          "title": "较不宜",
          "desc": "有降水，推荐您在室内进行休闲运动。"
        },
        "travel": {//旅游
          "title": "良",
          "desc": "气象条件有利于空气污染物扩散。"
        }
      },
      "night_wind_power": "微风10m/h",//晚上风力编号
      "day_wind_power": "微风10m/h",//白天风力编号
      "day_weather_code": "07",//白天的天气编码
      "sun_begin_end": "06:28|20:17",//日出日落时间(中间用|分割)
      "day_weather_pic": "http://app1.showapi.com/weather/icon/day/07.png",//白天天气图标
      "weekday": 2,//星期几
      "night_air_temperature": "15",//晚上天气温度(摄氏度)
      "day_air_temperature": "23",//白天天气温度(摄氏度)
      "day_wind_direction": "无持续风向",//白天风向编号
      "day": "20160705",//当前天
      "night_weather_pic": "http://app1.showapi.com/weather/icon/night/08.png",//晚上天气图标
      "night_wind_direction": "无持续风向"//晚上风向编号
    },
    "time": "20160629113000",//预报发布时间
    "ret_code": 0,
    "cityInfo": {//查询的地区基本资料
      "c6": "yunnan",//城市所在省英文名
      "c5": "丽江",//城市所在市中文名
      "c4": "lijiang",//城市所在市英文名
      "c3": "丽江",//城市中文名
      "c9": "中国",//城市所在国家中文名
      "c8": "china",//城市所在国家英文名
      "c7": "云南",//城市所在省中文名
      "c17": "+8",
      "c16": "AZ9888",//雷达站号
      "c1": "101291401",//区域id
      "c2": "lijiang",//城市英文名
      "c11": "0888",//城市区号
      "longitude": 100.222,//经度
      "c10": "2",//城市级别
      "latitude": 26.903,//纬度
      "c12": "674100",//邮编
      "c15": "2394"//海拔
    }
 */
public class DayWeatherInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String day;//
	
	private String weekday;//星期几
	private String sun_begin;//日出 日落
	private String sun_end;
	private String day_weather;//白天天气
	private String night_weather;//晚上天气
	//和上面两个合并
//	private String night_air_temperature;//晚上温度
//	private String day_air_temperature;//白天温度
	private String day_wind_power;
	private String night_wind_power;
	
	//要不要加上 再看
//	private String day_wind_direction;
//	private String night_wind_direction;
	
	private String coldTitle;
	private String clothesTitle;
	private String clothesDesc;
	private String uvTitle;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public String getSun_begin() {
		return sun_begin;
	}
	public void setSun_begin(String sun_begin) {
		this.sun_begin = sun_begin;
	}
	public String getSun_end() {
		return sun_end;
	}
	public void setSun_end(String sun_end) {
		this.sun_end = sun_end;
	}
	public String getDay_weather() {
		return day_weather;
	}
	public void setDay_weather(String day_weather) {
		this.day_weather = day_weather;
	}
	public String getNight_weather() {
		return night_weather;
	}
	public void setNight_weather(String night_weather) {
		this.night_weather = night_weather;
	}
	public String getDay_wind_power() {
		return day_wind_power;
	}
	public void setDay_wind_power(String day_wind_power) {
		this.day_wind_power = day_wind_power;
	}
	public String getNight_wind_power() {
		return night_wind_power;
	}
	public void setNight_wind_power(String night_wind_power) {
		this.night_wind_power = night_wind_power;
	}
	public String getColdTitle() {
		return coldTitle;
	}
	public void setColdTitle(String coldTitle) {
		this.coldTitle = coldTitle;
	}
	public String getClothesTitle() {
		return clothesTitle;
	}
	public void setClothesTitle(String clothesTitle) {
		this.clothesTitle = clothesTitle;
	}
	
	public String getClothesDesc() {
		return clothesDesc;
	}
	public void setClothesDesc(String clothesDesc) {
		this.clothesDesc = clothesDesc;
	}
	
	public String getUvTitle() {
		return uvTitle;
	}
	public void setUvTitle(String uvTitle) {
		this.uvTitle = uvTitle;
	}
	
	@Override
	public String toString() {
		return "DayWeatherInfo [day=" + day + ", weekday=" + weekday
				+ ", sun_begin=" + sun_begin + ", sun_end=" + sun_end
				+ ", day_weather=" + day_weather + ", night_weather="
				+ night_weather + ", day_wind_power=" + day_wind_power
				+ ", night_wind_power=" + night_wind_power + ", coldTitle="
				+ coldTitle + ", clothesTitle=" + clothesTitle
				+ ", clothesDesc=" + clothesDesc + ", uvTitle=" + uvTitle + "]";
	}
	

}

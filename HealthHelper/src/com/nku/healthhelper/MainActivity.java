package com.nku.healthhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.nku.healthhelper.adapter.LocationAdapter;
import com.nku.healthhelper.entity.DayWeatherInfo;
import com.nku.healthhelper.entity.WeatherInfo;
import com.nku.healthhelper.task.GetWeatherByNameTask;
import com.nku.healthhelper.util.HttpUtils;
import com.nku.healthhelper.util.JsonUtils;
import com.slidingmenu.lib.SlidingMenu;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

@SuppressLint({ "NewApi", "HandlerLeak" })
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity{

	private TabHost mTabHost;
    private RadioGroup radioGroup;
    private RadioButton rbWeather,rbFood,rbUser;
   
    SlidingMenu menu;
    private ImageView imgWeatherAddLocation;
    public String cityName;
	public static final int SHOW_RESPONSE=0;
	private TextView txtWeatherCityName;
	private TextView txtWeatherCityTemp,txtWeatherWeather,txtWeatherMoisture,txtWeatherWindPower,txtWeatherAqi;
	private TextView txtWeatherDay1Date,txtWeatherDay1Day,txtWeatherDay1Night
	                 ,txtWeatherDay2Date,txtWeatherDay2Day,txtWeatherDay2Night;
	//leftmenu:show all locations 
	private ListView lvLocationShow;
	private LocationAdapter locationAdapter;
	private List<WeatherInfo> weatherInfos=new ArrayList<WeatherInfo>();
	//leftmenu:点击事件
	private ImageView imgLeftmenuAdd;
	//判断是不是第一次存储
	boolean isFirstIn = false; 
	private static final String SHAREDPREFERENCES_NAME = "first_pref";
	
	//展示未来几天的天气具体情况
	private LinearLayout lloWeatherShowFuture;
	private ArrayList<DayWeatherInfo> futureDays=new ArrayList<DayWeatherInfo>();
	
	//展示穿衣
	private ImageView imgWeatherHelper;
	private String []characters={"零","一","二","三","四","五","六","日"};
	
	 private Handler handler=new Handler(){
	    	public void handleMessage(Message msg){
	    		super.handleMessage(msg);
	    		switch (msg.what) {
				case SHOW_RESPONSE:
					String response=(String) msg.obj;
					if(response==null||"".equals(response)){
						Log.i("error", "没有返回数据");
						break;
					}
					WeatherInfo weatherInfo=JsonUtils.getWeatherInfo(response);
					futureDays=(ArrayList<DayWeatherInfo>) weatherInfo.getForecast();
					txtWeatherCityTemp.setText(weatherInfo.getTemper()+"°");
					txtWeatherWeather.setText(weatherInfo.getWeather());
					txtWeatherMoisture.setText(weatherInfo.getSd());
					txtWeatherWindPower.setText(weatherInfo.getWin_powerString()+" "+weatherInfo.getWind_direction());
					txtWeatherAqi.setText(weatherInfo.getAqiQualityString()+" "+weatherInfo.getAqi());
					txtWeatherCityName.setText(weatherInfo.getCity());
					
					DayWeatherInfo day1=new DayWeatherInfo();
					day1=futureDays.get(0);
					String tempt1="星期"+characters[Integer.parseInt(day1.getWeekday())];
					String tempt2=day1.getDay().substring(4,day1.getDay().length());
					txtWeatherDay1Date.setText(tempt1+" "+tempt2);
					txtWeatherDay1Day.setText(day1.getDay_weather());
					txtWeatherDay1Night.setText(day1.getNight_weather());
					
					DayWeatherInfo day2=new DayWeatherInfo();
					day2=futureDays.get(1);
					String tempt3="星期"+characters[Integer.parseInt(day2.getWeekday())];
					String tempt4=day2.getDay().substring(4,day2.getDay().length());
					txtWeatherDay2Date.setText(tempt3+" "+tempt4);
					txtWeatherDay2Day.setText(day2.getDay_weather());
					txtWeatherDay2Night.setText(day2.getNight_weather());
					
					break;

				default:
					break;
				}
	    	}
	    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.activity_main);
        
        txtWeatherCityName=(TextView) findViewById(R.id.txtWeatherCityName1);
        txtWeatherCityTemp=(TextView) findViewById(R.id.txtWeatherCityTemp);
        txtWeatherWeather=(TextView) findViewById(R.id.txtWeatherWeather);
        txtWeatherMoisture=(TextView) findViewById(R.id.txtWeatherMoisture);
        txtWeatherWindPower=(TextView) findViewById(R.id.txtWeatherWindPower);
        txtWeatherAqi=(TextView) findViewById(R.id.txtWeatherAqi);
        
        //未来两天的
        txtWeatherDay1Date=(TextView) findViewById(R.id.txtWeatherDay1Date);
        txtWeatherDay1Day=(TextView) findViewById(R.id.txtWeatherDay1Day);
        txtWeatherDay1Night=(TextView) findViewById(R.id.txtWeatherDay1Night);
        txtWeatherDay2Date=(TextView) findViewById(R.id.txtWeatherDay2Date);
        txtWeatherDay2Day=(TextView) findViewById(R.id.txtWeatherDay2Day);
        txtWeatherDay2Night=(TextView) findViewById(R.id.txtWeatherDay2Night);
        
        
        imgWeatherAddLocation=(ImageView) findViewById(R.id.imgWeatherAddLocation);
        imgWeatherAddLocation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 menu.toggle();//滑动的方法               
                 
            }
        });
        
              
        Intent intent=getIntent();
        String response=intent.getStringExtra("response");
        
        if(response==null||response.equals("")){
        	SharedPreferences settingsRead = getSharedPreferences("Citys", Activity.MODE_PRIVATE);  
        	String tempt= settingsRead.getString("citys", "");
        	if(tempt==null||"".equals(tempt)){
        		cityName="北京";
        	}
        	else{
        		String []words=tempt.split("\\|");
        		cityName=words[0];
        	}
        	
        	getWeatherJsonData();
        }
        else{
        	WeatherInfo weatherInfo=JsonUtils.getWeatherInfo(response);
        	//先得到原来的存储的内容 再加上新加入的城市 一起写入
        	cityName=weatherInfo.getCity();
        	
        	SharedPreferences settingsRead = getSharedPreferences("Citys", Activity.MODE_PRIVATE);  
        	String tempt= settingsRead.getString("citys", "");
        	if(tempt==null||"".equals(tempt)){
        		tempt=cityName;
        	}
        	else{
        		tempt+="|"+cityName;
        	}
        	
        
        	SharedPreferences settingsWrite = getSharedPreferences("Citys", Activity.MODE_PRIVATE);  
        	SharedPreferences.Editor editor = settingsWrite.edit();  
        	editor.putString("citys",tempt);  
        	editor.commit();  	
        	
        	Message msg=new Message();
			msg.what=SHOW_RESPONSE;
		    msg.obj=response.toString();
		    handler.sendMessage(msg);
        }
        
        menu=new SlidingMenu(this);
        //sliding menu设置
		menu.setMode(SlidingMenu.LEFT);
		// 设置触摸屏幕的模式
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		// 设置滑动菜单视图的宽度
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// 设置渐入渐出效果的值
		menu.setFadeDegree(0.35f);
		//把滑动菜单添加进所有的Activity中，可选值SLIDING_CONTENT ， SLIDING_WINDOW
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		//为侧滑菜单设置布局
		menu.setMenu(R.layout.leftmenu_weather);
        
		
		 //显示所有的选中的城市列表 进行处理  注意：这个只能在Menu的后面
   		lvLocationShow=(ListView) findViewById(R.id.lvLocationShow);	
   		//得到初始数据
   		weatherInfos=getWeatherInfos(); 
   	    //不知道weatherInfo是不是null
   		locationAdapter = new LocationAdapter(MainActivity.this,weatherInfos);
   		lvLocationShow.setAdapter(locationAdapter);
   		lvLocationShow.setOnItemClickListener(new ListView.OnItemClickListener() {
               
   			@Override
   			public void onItemClick(AdapterView<?> parent, View view, int position,
   					long id) {
   				finish();			
   			}
           });
   		imgLeftmenuAdd=(ImageView) findViewById(R.id.imgLeftmenuAdd);
   		imgLeftmenuAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 //点击加城市的时候跳转
            	menu.toggle();
            	Intent intent=new Intent(MainActivity.this,LocationAddActivity.class);
            	startActivity(intent);             
            }
        });
   		
   		//跳转到未来天气的界面
   		lloWeatherShowFuture=(LinearLayout) findViewById(R.id.lloWeatherShowFuture);
        lloWeatherShowFuture.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent  intent=new Intent(MainActivity.this,ShowFutureActivity.class);
				
				intent.putExtra("dayWeathers", futureDays);
				
				startActivity(intent);
			}
		});
        
//        imgWeatherHelper=(ImageView) findViewById(R.id.imgWeatherHelper);
//        imgWeatherHelper.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View view) {
//				Intent  intent=new Intent(MainActivity.this,ClothesActivity.class);
//				
//				intent.putExtra("dayWeathers", futureDays);
//				
//				startActivity(intent);
//				
//			}
//		});
		
        mTabHost = getTabHost();
        final TabWidget tabWidget = mTabHost.getTabWidget();
        tabWidget.setStripEnabled(false);// 圆角边线不启用
        //添加n个tab选项卡，定义他们的tab名，指示名，目标屏对应的类
        mTabHost.addTab(mTabHost.newTabSpec("TAG1").setIndicator("0").setContent(R.id.rloWeatherLayout));
        mTabHost.addTab(mTabHost.newTabSpec("TAG2").setIndicator("1").setContent(new Intent(this, FoodActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("TAG3").setIndicator("2").setContent(new Intent(this, UserActivity.class)));
        // 视觉上,用单选按钮替代TabWidget
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rbWeather = (RadioButton) findViewById(R.id.rbWeather);
        rbFood = (RadioButton) findViewById(R.id.rbFood);
        rbUser = (RadioButton) findViewById(R.id.rbUser);
        final Resources res = getResources();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {

                Drawable myImage1 = res.getDrawable(R.drawable.weather1);
                rbWeather.setCompoundDrawablesWithIntrinsicBounds(null, myImage1, null, null);
                Drawable myImage2 = res.getDrawable(R.drawable.food1);
                rbFood.setCompoundDrawablesWithIntrinsicBounds(null, myImage2, null, null);
                Drawable myImage3 = res.getDrawable(R.drawable.user1);
                rbUser.setCompoundDrawablesWithIntrinsicBounds(null, myImage3, null, null);
                if (id == rbWeather.getId()) {
                    mTabHost.setCurrentTab(0);
                    Drawable myImage = res.getDrawable(R.drawable.weather2);
                    rbWeather.setCompoundDrawablesWithIntrinsicBounds(null, myImage, null, null);
                    rbWeather.setTextColor(0xff00BCD4);
                    rbFood.setTextColor(0xff8a8a8a);
                    rbUser.setTextColor(0xff8a8a8a);
                } else if (id == rbFood.getId()) {
                    mTabHost.setCurrentTab(1);
                    Drawable myImage = res.getDrawable(R.drawable.food2);
                    rbFood.setCompoundDrawablesWithIntrinsicBounds(null, myImage, null, null);
                    rbWeather.setTextColor(0xff8a8a8a);
                    rbFood.setTextColor(0xff00BCD4);
                    rbUser.setTextColor(0xff8a8a8a);
                } else if (id == rbUser.getId()) {
                    mTabHost.setCurrentTab(2);
                    Drawable myImage = res.getDrawable(R.drawable.user2);
                    rbUser.setCompoundDrawablesWithIntrinsicBounds(null, myImage, null, null);
                    rbWeather.setTextColor(0xff8a8a8a);
                    rbFood.setTextColor(0xff8a8a8a);
                    rbUser.setTextColor(0xff00BCD4);
                }
            }
        });

        // 设置当前显示第一个标签
        mTabHost.setCurrentTab(0);
        // 遍历tabWidget每个标签，设置背景图片 无
        for (int i = 0; i < tabWidget.getChildCount(); i++) {
            View view = tabWidget.getChildAt(i);
            view.getLayoutParams().height = 45;
            view.setBackgroundDrawable(null);
        }
       
        
    }
	
    //最初显示weather的时候 需要调用API
    public void getWeatherJsonData(){   
    	new Thread(new Runnable() {			
			@Override
			public void run() {

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
//					Log.e("name", cityName);
					
					Message msg=new Message();
					msg.what=SHOW_RESPONSE;
				    msg.obj=response.toString();
				    handler.sendMessage(msg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			    
			}
		}).start();
    }
    
    //获取保存的城市名称
    private String[] getCitys(){
    	// 读取SharedPreferences中需要的数据  
        // 使用SharedPreferences来记录程序的使用次数  
        SharedPreferences preferences = getSharedPreferences(  
                SHAREDPREFERENCES_NAME, MODE_PRIVATE);  
  
        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值  
        isFirstIn = preferences.getBoolean("isFirstIn", true);  
        
//        Log.e("isfirstin", isFirstIn + "");
  
        //读取
        if (!isFirstIn) {
        	SharedPreferences settings = getSharedPreferences("Citys", Activity.MODE_PRIVATE);  
        	String tempt= settings.getString("citys", "");
//        	Log.e("citys", tempt);
        	if(!"".equals(tempt)){
        		//用|分割城市名字
        		String []words=tempt.split("\\|");
        		return words;
        	}
        	else{
				
				
        		return null;
        	}     	
        	
        } else {  
        	Editor editor = preferences.edit();
			// 存入数据
			editor.putBoolean("isFirstIn", false);
			// 提交修改
			editor.commit();
        	return null;
        }  
        
    }

	//得到所有的数据
	private List<WeatherInfo> getWeatherInfos(){
        String[] citys = getCitys();//测试的数据
        if(citys==null){
        	return null;
        }
        else{
        	List<WeatherInfo> weatherInfos = new ArrayList<WeatherInfo>();
            for (int i=0;i<citys.length;i++) {
                
				try {
					WeatherInfo weatherInfo = new GetWeatherByNameTask(MainActivity.this).execute(citys[i]).get();
					weatherInfos.add(weatherInfo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
            return weatherInfos;
        }
        
    }
}

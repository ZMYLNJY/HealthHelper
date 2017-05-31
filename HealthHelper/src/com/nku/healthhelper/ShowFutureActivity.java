package com.nku.healthhelper;

import java.util.ArrayList;

import com.nku.healthhelper.entity.DayWeatherInfo;
import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

@SuppressLint("InflateParams")
@SuppressWarnings("deprecation")
public class ShowFutureActivity extends TabActivity {

	private TabHost mTabHost;
	private ArrayList<DayWeatherInfo> futureDays=new ArrayList<DayWeatherInfo>(); 
	private TextView txtShowFutureSunrise,txtShowFutureSunset;
	private TextView txtShowFutureDayTem,txtShowFutureNightTem;
	private TextView txtShowFutureDayWind,txtShowFutureNightWind;
	private TextView txtShowFutureCold,txtShowFutureClothes,txtShowFutureUV;
	private String []characters={"零","一","二","三","四","五","六","日"};
	private ImageView imgShowFutureReturn;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_show_future);
		
		txtShowFutureSunrise=(TextView) findViewById(R.id.txtShowFutureSunrise);
		txtShowFutureSunset=(TextView) findViewById(R.id.txtShowFutureSunset);
		txtShowFutureDayTem=(TextView) findViewById(R.id.txtShowFutureDayTem);
		txtShowFutureNightTem=(TextView) findViewById(R.id.txtShowFutureNightTem);
		txtShowFutureDayWind=(TextView) findViewById(R.id.txtShowFutureDayWind);
		txtShowFutureNightWind=(TextView) findViewById(R.id.txtShowFutureNightWind);
		txtShowFutureCold=(TextView) findViewById(R.id.txtShowFutureCold);
		txtShowFutureClothes=(TextView) findViewById(R.id.txtShowFutureClothes);
		txtShowFutureUV=(TextView) findViewById(R.id.txtShowFutureUV);
		
		imgShowFutureReturn=(ImageView) findViewById(R.id.imgShowFutureReturn);
		imgShowFutureReturn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				finish();
			}
		});
		
		Intent intent=getIntent();
		futureDays=(ArrayList<DayWeatherInfo>)intent.getSerializableExtra("dayWeathers");
		
		//取得TabHost对象      
        mTabHost = getTabHost();     
              
        for(int i=0;i<6;i++){
        	View view1 = this.getLayoutInflater().inflate(R.layout.show_future_tabhost, null);

        	DayWeatherInfo dayWeatherInfo=futureDays.get(i);
        	 
    		TextView tv1 = (TextView) view1.findViewById(R.id.txtShowFutureTab1);
    		String tempt1="星期"+characters[Integer.parseInt(dayWeatherInfo.getWeekday())];
    		tv1.setText(tempt1);
    		
    		TextView tv2 = (TextView) view1.findViewById(R.id.txtShowFutureTab2);
    		String tempt2=dayWeatherInfo.getDay().substring(4,dayWeatherInfo.getDay().length());
    		tv2.setText(tempt2);

    		mTabHost.addTab(mTabHost.newTabSpec("tab_test"+i)     
    	                .setIndicator(view1)     
    	                .setContent(R.id.lloFutureShow));   
    		
        }
                      
        //设置当前显示哪一个标签       
        mTabHost.setCurrentTab(1);  
        mTabHost.setCurrentTab(0);  
        
        //把当前的布局显示成第一个标签的属性 
        setCurrentTag(0);
        updateTab(mTabHost);
        
        //标签切换事件处理，setOnTabChangedListener      
        mTabHost.setOnTabChangedListener(new OnTabChangeListener()     
        {     
            // TODO Auto-generated method stub      
            @Override    
            public void onTabChanged(String tabId)     
            {     
                if (tabId.equalsIgnoreCase("tab_test0")) { 
                	setCurrentTag(0);  
                	updateTab(mTabHost);
                } else if (tabId.equalsIgnoreCase("tab_test1")) { 
                	setCurrentTag(1);  
                	updateTab(mTabHost);
                } else if (tabId.equalsIgnoreCase("tab_test2")) {   
                	setCurrentTag(2);  
                	updateTab(mTabHost);
                } else if (tabId.equalsIgnoreCase("tab_test3")) {
                	setCurrentTag(3); 
                	updateTab(mTabHost);
                } else if (tabId.equalsIgnoreCase("tab_test4")) {
                	setCurrentTag(4);
                	updateTab(mTabHost);
                } else if (tabId.equalsIgnoreCase("tab_test5")) {
                	setCurrentTag(5);
                	updateTab(mTabHost);
                } else if (tabId.equalsIgnoreCase("tab_test76")) {    
                	setCurrentTag(6);
                	updateTab(mTabHost);
                } 

            }                
        });     
        
		
	}
	
	public void setCurrentTag(int tag){
		mTabHost.setCurrentTab(tag); 
		DayWeatherInfo dayWeatherInfo=futureDays.get(tag);
		txtShowFutureSunrise.setText(dayWeatherInfo.getSun_begin());
		txtShowFutureSunset.setText(dayWeatherInfo.getSun_end());
		txtShowFutureDayTem.setText(dayWeatherInfo.getDay_weather());
		txtShowFutureNightTem.setText(dayWeatherInfo.getNight_weather());
		txtShowFutureDayWind.setText(dayWeatherInfo.getDay_wind_power());
		txtShowFutureNightWind.setText(dayWeatherInfo.getNight_wind_power());
		txtShowFutureCold.setText(dayWeatherInfo.getColdTitle());
		txtShowFutureClothes.setText(dayWeatherInfo.getClothesTitle());
		if("".equals(dayWeatherInfo.getUvTitle())){
			txtShowFutureUV.setText("暂无");
		}
		else{
			txtShowFutureUV.setText(dayWeatherInfo.getUvTitle());
		}
		
	}
	
	public void updateTab(final TabHost tabHost) { 
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) { 
            View view = tabHost.getTabWidget().getChildAt(i); 
            TextView tv1 = (TextView) view.findViewById(R.id.txtShowFutureTab1);  
            TextView tv2 = (TextView) view.findViewById(R.id.txtShowFutureTab2); 
            
            if (tabHost.getCurrentTab() == i) {
            	//选中  
            	tv1.setTextColor(Color.RED); 
            	tv2.setTextColor(Color.RED); 
            	
            } else {
            	//不选中  
            	tv1.setTextColor(Color.BLACK);
            	tv2.setTextColor(Color.BLACK); 
            } 
        } 
    } 
}

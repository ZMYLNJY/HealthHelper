package com.nku.healthhelper;

import java.util.ArrayList;

import com.nku.healthhelper.adapter.ClothesImageAdapter;
import com.nku.healthhelper.entity.DayWeatherInfo;
import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

@SuppressLint("InflateParams")
@SuppressWarnings("deprecation")
public class ClothesActivity extends TabActivity implements OnItemSelectedListener,ViewFactory{

	private int[] res = {R.drawable.clothes1,R.drawable.clothes2,R.drawable.clothes1};  
	private int[] res1 = {R.drawable.all_go,R.drawable.all_return,R.drawable.all_go};  
    private Gallery clothesGallery;  
    private ClothesImageAdapter adapter;  
    private ImageSwitcher imgClothesSwitcher; 
    private TabHost mTabHost;
    private ArrayList<DayWeatherInfo> futureDays=new ArrayList<DayWeatherInfo>(); 
    private String []characters={"零","一","二","三","四","五","六","日"};
    private ImageView imgClothesReturn;
    private TextView txtClothesTip;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_clothes);

		clothesGallery = (Gallery)findViewById(R.id.clothesGallery);  
		imgClothesSwitcher = (ImageSwitcher)findViewById(R.id.imgClothesSwitcher);   
		
        Intent intent=getIntent();
		futureDays=(ArrayList<DayWeatherInfo>)intent.getSerializableExtra("dayWeathers");
        
        txtClothesTip=(TextView) findViewById(R.id.txtClothesTip);
        imgClothesReturn=(ImageView) findViewById(R.id.imgClothesReturn);
        imgClothesReturn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				finish();
			}
		});
        
        //取得TabHost对象      
        mTabHost = getTabHost();     
        for(int i=0;i<3;i++){
        	View view1 = this.getLayoutInflater().inflate(R.layout.show_clothes_tabhost, null);

        	DayWeatherInfo dayWeatherInfo=futureDays.get(i);
        	 
    		TextView tv1 = (TextView) view1.findViewById(R.id.txtClothesTab1);
    		String tempt1="星期"+characters[Integer.parseInt(dayWeatherInfo.getWeekday())];
    		tv1.setText(tempt1);
    		
    		TextView tv2 = (TextView) view1.findViewById(R.id.txtClothesTab2);
    		String tempt2=dayWeatherInfo.getDay().substring(4,dayWeatherInfo.getDay().length());
    		tv2.setText(tempt2);

    		mTabHost.addTab(mTabHost.newTabSpec("tab_test"+i)     
    	                .setIndicator(view1)     
    	                .setContent(R.id.rloShowClothes));   
    		
        }
        
        //设置当前显示哪一个标签       
        mTabHost.setCurrentTab(1);  
        mTabHost.setCurrentTab(0);  
        
        adapter = new ClothesImageAdapter(res, this);  
		clothesGallery.setAdapter(adapter);  
        clothesGallery.setOnItemSelectedListener(this);  
        imgClothesSwitcher.setFactory(this);  
        imgClothesSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));  
        imgClothesSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        
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
                } 

            }                
        });     
        
	}
	
	//设置不同的图片
	public void setCurrentTag(int tag){
		mTabHost.setCurrentTab(tag); 
		//设置txt和对应的res
		DayWeatherInfo dayWeatherInfo=futureDays.get(tag);
		if("".equals(dayWeatherInfo.getClothesDesc())){
			txtClothesTip.setText("暂无信息");
			//默认穿衣  相当于推荐  改变res的内容
			
			
		}else{
			txtClothesTip.setText(dayWeatherInfo.getClothesDesc());
			switch (tag) {
			case 0:
				res=res;
				break;
				
			case 1:
			    res=res1;
			    
				break;
				
			case 2:
				res=res1;
				
				break;

			default:
				break;
			}
			
			adapter.notifyDataSetChanged();
		    clothesGallery.invalidate();
		    imgClothesSwitcher.invalidate();
		}
		
       
    
	}
	
	public void updateTab(final TabHost tabHost) { 
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) { 
            View view = tabHost.getTabWidget().getChildAt(i); 
            TextView tv1 = (TextView) view.findViewById(R.id.txtClothesTab1);  
            TextView tv2 = (TextView) view.findViewById(R.id.txtClothesTab2); 
            
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
	

	@Override
	public View makeView() {
		ImageView image = new ImageView(this);  
        image.setScaleType(ScaleType.FIT_CENTER);  
        return image; 
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,  
            long id) {
		 // 使用ImageSwitcher  
		imgClothesSwitcher.setBackgroundResource(res[position]);  
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}

}

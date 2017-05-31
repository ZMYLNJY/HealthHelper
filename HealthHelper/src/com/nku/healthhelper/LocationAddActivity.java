package com.nku.healthhelper;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

import com.nku.healthhelper.util.HttpUtils;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("HandlerLeak")
public class LocationAddActivity extends Activity {

	private ImageView imgLocationAddReturn,imgLocationAddGo;
	private EditText edtLocationAddSearch;
	private Intent intent;
	private String cityName="";
	public static final int SHOW_RESPONSE=0;
	private Button btnHotCity1,btnHotCity2,btnHotCity3,btnHotCity4,btnHotCity5,btnHotCity6,
	btnHotCity7,btnHotCity8,btnHotCity9,btnHotCity10,btnHotCity11,btnHotCity12,btnHotCity13,
	btnHotCity14,btnHotCity15,btnHotCity16,btnHotCity17,btnHotCity18;
	
	private Handler handler=new Handler(){
    	public void handleMessage(Message msg){
    		super.handleMessage(msg);
    		switch (msg.what) {
			case SHOW_RESPONSE:
				Toast.makeText(getApplicationContext(), "对不起，您查询的城市不存在！", Toast.LENGTH_SHORT).show();
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
		setContentView(R.layout.activity_location_add);
		
		
		edtLocationAddSearch=(EditText) findViewById(R.id.edtLocationAddSearch);
		
		imgLocationAddReturn=(ImageView) findViewById(R.id.imgLocationAddReturn);
		imgLocationAddReturn.setOnClickListener(new OnClickListenerImpl());
		
		imgLocationAddGo=(ImageView) findViewById(R.id.imgLocationAddGo);
		imgLocationAddGo.setOnClickListener(new OnClickListenerImpl());
		
		btnHotCity1=(Button) findViewById(R.id.btnHotCity1);
		btnHotCity2=(Button) findViewById(R.id.btnHotCity2);
		btnHotCity3=(Button) findViewById(R.id.btnHotCity3);
		btnHotCity4=(Button) findViewById(R.id.btnHotCity4);
		btnHotCity5=(Button) findViewById(R.id.btnHotCity5);
		btnHotCity6=(Button) findViewById(R.id.btnHotCity6);
		btnHotCity7=(Button) findViewById(R.id.btnHotCity7);
		btnHotCity8=(Button) findViewById(R.id.btnHotCity8);
		btnHotCity9=(Button) findViewById(R.id.btnHotCity9);
		btnHotCity10=(Button) findViewById(R.id.btnHotCity10);
		btnHotCity11=(Button) findViewById(R.id.btnHotCity11);
		btnHotCity12=(Button) findViewById(R.id.btnHotCity12);
		btnHotCity13=(Button) findViewById(R.id.btnHotCity13);
		btnHotCity14=(Button) findViewById(R.id.btnHotCity14);
		btnHotCity15=(Button) findViewById(R.id.btnHotCity15);
		btnHotCity16=(Button) findViewById(R.id.btnHotCity16);
		btnHotCity17=(Button) findViewById(R.id.btnHotCity17);
		btnHotCity18=(Button) findViewById(R.id.btnHotCity18);
		
	    btnHotCity1.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity2.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity3.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity4.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity5.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity6.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity7.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity8.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity9.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity10.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity11.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity12.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity13.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity14.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity15.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity16.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity17.setOnClickListener(new OnClickListenerImpl());
	    btnHotCity18.setOnClickListener(new OnClickListenerImpl());
	}
	
	private class OnClickListenerImpl implements View.OnClickListener{

		@Override
		public void onClick(View view) {
			switch (view.getId()) {
			case R.id.imgLocationAddReturn:
				finish();
				break;
			case R.id.imgLocationAddGo:
				cityName=edtLocationAddSearch.getText().toString();
				//进行查找
				getWeatherJsonData();
				break;
			case R.id.btnHotCity1:
				cityName=btnHotCity1.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity2:
				cityName=btnHotCity2.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity3:
				cityName=btnHotCity3.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity4:
				cityName=btnHotCity4.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity5:
				cityName=btnHotCity5.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity6:
				cityName=btnHotCity6.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity7:
				cityName=btnHotCity7.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity8:
				cityName=btnHotCity8.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity9:
				cityName=btnHotCity9.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity10:
				cityName=btnHotCity10.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity11:
				cityName=btnHotCity11.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity12:
				cityName=btnHotCity12.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity13:
				cityName=btnHotCity13.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity14:
				cityName=btnHotCity14.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity15:
				cityName=btnHotCity15.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity16:
				cityName=btnHotCity16.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity17:
				cityName=btnHotCity17.getText().toString().trim();
				getWeatherJsonData();
				break;
			case R.id.btnHotCity18:
				cityName=btnHotCity18.getText().toString().trim();
				getWeatherJsonData();
				break;

			default:
				break;
			}
			
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
					Log.e("code",httpResponse.getStatusLine().getStatusCode()+"");
					if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
						HttpEntity httpEntity=httpResponse.getEntity();
						String response=EntityUtils.toString(httpEntity,"utf-8");
						//跳转到主界面
						intent=new Intent(LocationAddActivity.this,MainActivity.class);
						intent.putExtra("response", response);
						startActivity(intent);
					}
					//if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_CREATED)
					else {
						Message msg=new Message();
						msg.what=SHOW_RESPONSE;
					    handler.sendMessage(msg);
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			    
			}
		}).start();
    }

	
}

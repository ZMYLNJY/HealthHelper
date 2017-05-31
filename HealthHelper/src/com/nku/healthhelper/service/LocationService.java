package com.nku.healthhelper.service;

import com.nku.healthhelper.entity.Common;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

//1.启动应用的时候同时启动一个定位服务
//2.定位服务获取到定位信息后通过广播告知UI层（activity）
//3.UI层处理显示
//在下面的的例子中，在获取了当前的位置信息后，便停掉了的定位服务，并没有进行实时定位，当然也可以进行实时定位。

public class LocationService extends Service implements LocationListener {

	private static final String TAG = "LocationSvc";  
    private LocationManager locationManager;  
    
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override  
    public void onCreate() {  
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);  
    }  
  
    @Override  
    public void onStart(Intent intent, int startId) {  
        if (locationManager.getProvider(LocationManager.NETWORK_PROVIDER) != null) locationManager  
                .requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,  
                        this);  
        else if (locationManager.getProvider(LocationManager.GPS_PROVIDER) != null) locationManager  
                .requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,  
                        this);  
        else Toast.makeText(this, "无法定位", Toast.LENGTH_SHORT).show();  
    }  

    @Override  
    public boolean stopService(Intent name) {  
        return super.stopService(name);  
    }  
    
    @Override
	public void onLocationChanged(Location location) {
		Log.d(TAG, "Get the current position \n" + location);  
		  
        //通知Activity  
        Intent intent = new Intent();  
        intent.setAction(Common.LOCATION_ACTION);  
        intent.putExtra(Common.LOCATION, location.toString());  
        sendBroadcast(intent);  
  
        // 如果只是需要定位一次，这里就移除监听，停掉服务。如果要进行实时定位，可以在退出应用或者其他时刻停掉定位服务。  
        locationManager.removeUpdates(this);  
        stopSelf();  
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}
}

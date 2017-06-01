package com.nku.healthhelper.callback;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.FindCallback;
import com.nku.healthhelper.R;
import com.nku.healthhelper.entity.DietRecord;
import com.nku.healthhelper.entity.RecordView;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 根据登录用户获得该用户所有上传饮食记录后的回调方法。
 * @author eumes
 *
 */

public class MyGetRecordListCallBack extends FindCallback<DietRecord> {

	private Activity activity;
	
	public MyGetRecordListCallBack(Activity activity) {
		// TODO Auto-generated constructor stub
		super();
		this.activity = activity;
	}
	
	@Override
	public void done(List<DietRecord> list, AVException e) {
		// TODO Auto-generated method stub
		if(e == null){
			if(list != null && list.size() != 0){
				RelativeLayout rLayout = (RelativeLayout)activity.findViewById(R.id.rloRecord);
				
				List<DietRecord> zaoList = new ArrayList<DietRecord>();
				List<DietRecord> wuList = new ArrayList<DietRecord>();
				List<DietRecord> wanList = new ArrayList<DietRecord>();
				List<DietRecord> yeList = new ArrayList<DietRecord>();
				
				for (DietRecord dietRecord : list) {
					String kind = dietRecord.getKind();
					if("早餐".equals(kind)){
						zaoList.add(dietRecord);
					}else if("午餐".equals(kind)){
						wuList.add(dietRecord);
					}else if("晚餐".equals(kind)){
						wanList.add(dietRecord);
					}else{
						yeList.add(dietRecord);
					}
				}
				
				if(zaoList.size() > 0){
					TextView txtZao = new TextView(activity.getApplicationContext());
					txtZao.setText("      早餐");
					txtZao.setTextColor(Color.BLACK);
					txtZao.setGravity(Gravity.CENTER_VERTICAL);
					rLayout.addView(txtZao);
					
					for (DietRecord dietRecord : zaoList) {
						RecordView recordView = new RecordView(activity.getApplicationContext(), dietRecord);
						recordView.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								
							}
						});
						rLayout.addView(recordView);
					}
					
				}
				
			}else{
				Toast.makeText(activity.getApplicationContext(), "您还未上传任何记录！", Toast.LENGTH_SHORT).show();
			}
		}else{
			Toast.makeText(activity.getApplicationContext(), "查询失败，请重新查询！", Toast.LENGTH_SHORT).show();
		}
		
		
	}


}

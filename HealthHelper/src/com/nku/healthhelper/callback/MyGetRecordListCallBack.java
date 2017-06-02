package com.nku.healthhelper.callback;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.FindCallback;
import com.nku.healthhelper.R;
import com.nku.healthhelper.RecordDetailActivity;
import com.nku.healthhelper.entity.DietRecord;
import com.nku.healthhelper.entity.RecordView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
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
				LinearLayout rLayout = (LinearLayout)activity.findViewById(R.id.rloRecord);
				rLayout.removeAllViews();
				LinearLayout.LayoutParams params = null;
				
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
					params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 60, 0);
					TextView txtZao = new TextView(activity.getApplicationContext());
					txtZao.setText("      早餐");
					txtZao.setTextColor(Color.BLACK);					
					txtZao.setGravity(Gravity.CENTER_VERTICAL);
					txtZao.setTextSize(20);
					txtZao.setLayoutParams(params);
					rLayout.addView(txtZao);
					
					for (DietRecord dietRecord : zaoList) {
						params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 120, 0);
						RecordView recordView = new RecordView(activity.getApplicationContext(), dietRecord);
						recordView.setTag(dietRecord);
						recordView.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								DietRecord record = (DietRecord) v.getTag();
								Intent intent = new Intent(activity, RecordDetailActivity.class);
								Bundle bundle = new Bundle();
								bundle.putParcelable("record", record);
								intent.putExtra("record", bundle);
								activity.startActivity(intent);
							}
						});
						recordView.setShowDividers(LinearLayout.SHOW_DIVIDER_END);
						recordView.setLayoutParams(params);
						rLayout.addView(recordView);
						
						params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 10, 0);
						TextView textView = new TextView(activity.getApplicationContext());
						textView.setLayoutParams(params);
						rLayout.addView(textView);
								
					}
				}
				
				if(wuList.size() > 0){
					params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 60, 0);
					TextView txtZao = new TextView(activity.getApplicationContext());
					txtZao.setText("      午餐");
					txtZao.setTextColor(Color.BLACK);
					txtZao.setGravity(Gravity.CENTER_VERTICAL);
					txtZao.setTextSize(20);
					txtZao.setLayoutParams(params);
					rLayout.addView(txtZao);
					
					for (DietRecord dietRecord : wuList) {
						params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 120, 0);
						RecordView recordView = new RecordView(activity.getApplicationContext(), dietRecord);
						recordView.setTag(dietRecord);
						recordView.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								DietRecord record = (DietRecord) v.getTag();
								Intent intent = new Intent(activity, RecordDetailActivity.class);
								Bundle bundle = new Bundle();
								bundle.putParcelable("record", record);
								intent.putExtra("record", bundle);
								activity.startActivity(intent);
							}
						});
						recordView.setShowDividers(LinearLayout.SHOW_DIVIDER_END);
						recordView.setLayoutParams(params);
						rLayout.addView(recordView);
						
						params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 10, 0);
						TextView textView = new TextView(activity.getApplicationContext());
						textView.setLayoutParams(params);
						rLayout.addView(textView);
					}
				}
				
				if(wanList.size() > 0){
					params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 60, 0);
					TextView txtZao = new TextView(activity.getApplicationContext());
					txtZao.setText("      晚餐");
					txtZao.setTextColor(Color.BLACK);
					txtZao.setGravity(Gravity.CENTER_VERTICAL);
					txtZao.setTextSize(20);
					txtZao.setLayoutParams(params);
					rLayout.addView(txtZao);
					
					for (DietRecord dietRecord : wanList) {
						params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 120, 0);
						RecordView recordView = new RecordView(activity.getApplicationContext(), dietRecord);
						recordView.setTag(dietRecord);
						recordView.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								DietRecord record = (DietRecord) v.getTag();
								Intent intent = new Intent(activity, RecordDetailActivity.class);
								Bundle bundle = new Bundle();
								bundle.putParcelable("record", record);
								intent.putExtra("record", bundle);
								activity.startActivity(intent);
							}
						});
						recordView.setShowDividers(LinearLayout.SHOW_DIVIDER_END);
						recordView.setLayoutParams(params);
						rLayout.addView(recordView);
						
						params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 10, 0);
						TextView textView = new TextView(activity.getApplicationContext());
						textView.setLayoutParams(params);
						rLayout.addView(textView);
					}
				}
				
				if(yeList.size() > 0){
					params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 60, 0);
					TextView txtZao = new TextView(activity.getApplicationContext());
					txtZao.setText("      夜宵");
					txtZao.setTextColor(Color.BLACK);
					txtZao.setGravity(Gravity.CENTER_VERTICAL);
					txtZao.setTextSize(20);
					txtZao.setLayoutParams(params);
					rLayout.addView(txtZao);
					
					for (DietRecord dietRecord : yeList) {
						params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 120, 0);
						RecordView recordView = new RecordView(activity.getApplicationContext(), dietRecord);
						recordView.setTag(dietRecord);
						recordView.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								DietRecord record = (DietRecord) v.getTag();
								Intent intent = new Intent(activity, RecordDetailActivity.class);
								Bundle bundle = new Bundle();
								bundle.putParcelable("record", record);
								intent.putExtra("record", bundle);
								activity.startActivity(intent);
							}
						});
						recordView.setShowDividers(LinearLayout.SHOW_DIVIDER_END);
						recordView.setLayoutParams(params);
						rLayout.addView(recordView);
						
						params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 10, 0);
						TextView textView = new TextView(activity.getApplicationContext());
						textView.setLayoutParams(params);
						rLayout.addView(textView);
					}
				}
				
			}else{
				LinearLayout rLayout = (LinearLayout)activity.findViewById(R.id.rloRecord);
				rLayout.removeAllViews();
				Toast.makeText(activity.getApplicationContext(), "此日您还未上传任何记录！", Toast.LENGTH_SHORT).show();
			}
		}else{
			LinearLayout rLayout = (LinearLayout)activity.findViewById(R.id.rloRecord);
			rLayout.removeAllViews();
			Toast.makeText(activity.getApplicationContext(), "查询失败，请重新查询！" + e.getCode() + e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		
		
	}


}

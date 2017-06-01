package com.nku.healthhelper.entity;

import com.nku.healthhelper.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecordView extends LinearLayout {

	private TextView txtName;
	private TextView txtWeight;
	private TextView txtCaro;
	
	
	public RecordView(Context context, DietRecord record) {
		super(context);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(R.layout.record_view, this);
		
		txtName = (TextView)findViewById(R.id.txtRecordName);
		txtWeight = (TextView)findViewById(R.id.txtRecordWeight);
		txtCaro = (TextView)findViewById(R.id.txtRecordCaro);
		
		txtName.setText(record.getFood().getFoodName());
		txtWeight.setText(record.getWeight() + "g");
		txtCaro.setText(record.getCalories() + "千卡");
		
	}

	public RecordView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
	}

	public RecordView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

}

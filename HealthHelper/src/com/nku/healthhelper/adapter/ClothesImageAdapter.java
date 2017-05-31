package com.nku.healthhelper.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

@SuppressWarnings("deprecation")
public class ClothesImageAdapter extends BaseAdapter {

	private int[] res;  
    private Context context;  
    public ClothesImageAdapter(int []res,Context context){  
        this.res = res;  
        this.context = context;  
    }  
    @Override  
    public int getCount() {  
        // TODO Auto-generated method stub  
        return res.length;  
    }  
    @Override  
    public Object getItem(int position) {  
        // TODO Auto-generated method stub  
        return res[position];  
    }  
    @Override  
    public long getItemId(int position) {  
        // TODO Auto-generated method stub  
        return position;  
    }  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
        ImageView image = new ImageView(context);  
        image.setBackgroundResource(res[position%res.length]);  
        image.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));  
        image.setScaleType(ScaleType.FIT_XY);  
        return image;  
    }  

}

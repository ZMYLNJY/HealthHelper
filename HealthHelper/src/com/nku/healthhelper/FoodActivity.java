package com.nku.healthhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

public class FoodActivity extends Activity implements OnClickListener{
	private EditText edtFood;
	private ImageView imgSearchFood,imgRice,imgMeat,imgFruit,imgMilk;
	private ImageView imgMushroom,imgVegetable,imgSnake,imgBeverage,imgOther;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food);
		
		edtFood = (EditText)findViewById(R.id.edtFoodname);
		imgSearchFood = (ImageView)findViewById(R.id.imgSearchFood);
		imgRice = (ImageView)findViewById(R.id.imgRice);
		imgMeat = (ImageView)findViewById(R.id.imgMeat);
		imgFruit = (ImageView)findViewById(R.id.imgFruit);
		imgMilk = (ImageView)findViewById(R.id.imgMilk);
		imgMushroom = (ImageView)findViewById(R.id.imgMushroom);
		imgVegetable = (ImageView)findViewById(R.id.imgVegetable);
		imgSnake = (ImageView)findViewById(R.id.imgSnake);
		imgBeverage = (ImageView)findViewById(R.id.imgBeverage);
		imgOther = (ImageView)findViewById(R.id.imgOther);
		
		imgSearchFood.setOnClickListener(this);
		imgRice.setOnClickListener(this);
		imgMeat.setOnClickListener(this);
		imgFruit.setOnClickListener(this);
		imgMilk.setOnClickListener(this);
		imgMushroom.setOnClickListener(this);
		imgVegetable.setOnClickListener(this);
		imgSnake.setOnClickListener(this);
		imgBeverage.setOnClickListener(this);
		imgOther.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imgSearchFood:
			//搜索食物
			break;
		case R.id.imgRice:
			//进入主食
			Intent riceIntent = new Intent(FoodActivity.this,FoodInfoActivity.class);
			riceIntent.putExtra("type", "rice");
			startActivity(riceIntent);
			break;
		case R.id.imgMeat:
			//进入肉蛋类
			Intent meatIntent = new Intent(FoodActivity.this,FoodInfoActivity.class);
			meatIntent.putExtra("type", "meat");
			startActivity(meatIntent);
			break;
		case R.id.imgFruit:
			//进入水果
			Intent fruitIntent = new Intent(FoodActivity.this,FoodInfoActivity.class);
			fruitIntent.putExtra("type", "fruit");
			startActivity(fruitIntent);
			break;
		case R.id.imgMilk:
			//进入奶制品
			Intent milkIntent = new Intent(FoodActivity.this,FoodInfoActivity.class);
			milkIntent.putExtra("type", "milk");
			startActivity(milkIntent);
			break;
		case R.id.imgMushroom:
			//进入菌类
			Intent mushroomIntent = new Intent(FoodActivity.this,FoodInfoActivity.class);
			mushroomIntent.putExtra("type", "mushroom");
			startActivity(mushroomIntent);
			break;
		case R.id.imgVegetable:
			//进入蔬菜
			Intent vegetableIntent = new Intent(FoodActivity.this,FoodInfoActivity.class);
			vegetableIntent.putExtra("type", "vegetable");
			startActivity(vegetableIntent);
			break;
		case R.id.imgSnake:
			//进入小吃
			Intent snakeIntent = new Intent(FoodActivity.this,FoodInfoActivity.class);
			snakeIntent.putExtra("type", "snake");
			startActivity(snakeIntent);
			break;
		case R.id.imgBeverage:
			//进入饮料
			Intent beverageIntent = new Intent(FoodActivity.this,FoodInfoActivity.class);
			beverageIntent.putExtra("type", "beverage");
			startActivity(beverageIntent);
			break;
		case R.id.imgOther:
			//进入其他
			Intent otherIntent = new Intent(FoodActivity.this,FoodInfoActivity.class);
			otherIntent.putExtra("type", "other");
			startActivity(otherIntent);
			break;
		default:
			break;
		}
	}
}

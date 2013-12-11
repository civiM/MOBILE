package com.example.probudgetmaster_m2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class imageAdapter extends BaseAdapter{
	private Context context;
	
	/*public String applianceName[] = 
		{
			"TV", "Phone Charger", "Console Games", "Fan",
			"Fridge", "Hair Dryer", "Iron", "Laptop", "Lightbulb",
			"Microwave", "Washing Machine"
		};*/
	
	public Integer appliances[] = 
		{
			R.drawable.tv,
			R.drawable.charger,
			R.drawable.console,
			R.drawable.fan,
			R.drawable.fridge,
			R.drawable.hairdryer,
			R.drawable.iron,
			R.drawable.laptop,
			R.drawable.lightbulb,
			R.drawable.microwave,
			R.drawable.washingmachine
		};
	
	public imageAdapter(Context c){
		context = c;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return appliances.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return appliances[position];
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(appliances[position]);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(90,90));
		
		return imageView;
	}
	
}

package com.example.probudgetmaster_m2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class wbcAdaptor extends BaseAdapter {
	private Context context;
	
	public Integer water[]=
		{
			R.drawable.shower,
			R.drawable.washingmachine,
			R.drawable.plate
		};
	
	public wbcAdaptor(Context c){
		context = c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return water.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return water[position];
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(water[position]);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(90, 90));
		return imageView;
	}	
}

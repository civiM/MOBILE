package com.example.probudgetmaster_m2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ebfmenuAdapter extends BaseAdapter {
	private Context context;
	
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
			R.drawable.washingmachine,
			R.drawable.aircon,
			R.drawable.blender,
			R.drawable.desktop,
			R.drawable.printer
		};
	
	public ebfmenuAdapter(Context c){
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
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(appliances[position]);
        return imageView;
    }
}


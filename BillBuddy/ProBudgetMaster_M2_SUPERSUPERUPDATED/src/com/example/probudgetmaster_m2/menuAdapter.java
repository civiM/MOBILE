package com.example.probudgetmaster_m2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class menuAdapter extends ArrayAdapter<Icon>{
	Context context;
	int layoutResourceId;
	Icon menu[] = null;
	
	public menuAdapter(Context context, int layoutResourceId, Icon[] menu){
		super(context, layoutResourceId, menu);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.menu = menu;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View row = convertView;
		menuHolder holder = null;
		
		if(row == null){
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			
			holder = new menuHolder();
			holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
			holder.title = (TextView)row.findViewById(R.id.title);
			
			row.setTag(holder);
		}
		
		else
		{
			holder = (menuHolder)row.getTag();
		}
		
		Icon icon = menu[position];
		holder.title.setText(icon.title);
		holder.imgIcon.setImageResource(icon.imgIcon);
		
		return row;
	}
	
	static class menuHolder
	{
		ImageView imgIcon;
		TextView title;
	}
}

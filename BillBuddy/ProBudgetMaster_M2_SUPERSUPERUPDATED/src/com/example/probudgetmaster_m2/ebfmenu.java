package com.example.probudgetmaster_m2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;

public class ebfmenu extends Activity {
    
    
	private Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ebfmenu);
		GridView gridview = (GridView)findViewById(R.id.appliances);
		Button viewSummary = (Button)findViewById(R.id.electricViewSummary);
		
		gridview.setAdapter(new ebfmenuAdapter(this));
		i = getIntent();
		gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	String month = i.getStringExtra("month");
	        	//Bundle extras = getIntent().getExtras();
					Intent nextScreen = new Intent(getApplicationContext(), ebfcalculator.class);
					//viewSummary.setText(month);
					nextScreen.putExtra("month", month);
					nextScreen.putExtra("appliances", position);
					startActivity(nextScreen);						
				
	        }
	    });
		
		viewSummary.setOnClickListener(
			new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					String month = i.getStringExtra("month");
					// TODO Auto-generated method stub
					Intent summaryScreen = new Intent(getApplicationContext(), ViewElectricSummary.class);
					summaryScreen.putExtra("month", month);
					startActivity(summaryScreen);	
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

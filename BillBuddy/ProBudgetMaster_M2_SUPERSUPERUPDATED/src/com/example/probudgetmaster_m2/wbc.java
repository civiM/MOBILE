package com.example.probudgetmaster_m2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class wbc extends Activity {
	private Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.waterbillcalculator);

		GridView grid = (GridView) findViewById(R.id.water);
		Button viewSummary = (Button) findViewById(R.id.waterViewSummary);
		grid.setAdapter(new wbcAdaptor(this));
		i = getIntent();
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				String month = i.getStringExtra("month");
				Intent nextScreen = new Intent(getApplicationContext(), wbc2.class);
				nextScreen.putExtra("month", month);
				switch(position){	
				case 0:
					nextScreen.putExtra("type", "shower");
					break;
				case 1:
					nextScreen.putExtra("type", "washingmachine");
					break;
				case 2:
					nextScreen.putExtra("type", "plate");
					break;
				}
				
				startActivity(nextScreen);
				
			}
		});
		viewSummary.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent summaryScreen = new Intent(getApplicationContext(), viewWaterSummary.class);
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

package com.example.probudgetmaster_m2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class viewWaterSummary extends Activity{
	TextView type;
	TextView use;
	TextView size;
	private DatabaseHelper Databas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.watersummary);
		
		Databas = new DatabaseHelper(getBaseContext(), null, null, 0);

		type = (TextView)findViewById(R.id.textView4);
		type.setText(Databas.getAllwType());
		
		use = (TextView)findViewById(R.id.textView5);
		use.setText(Databas.getAllwUse());
		
		size = (TextView)findViewById(R.id.textView6);
		size.setText(Databas.getAllwSize());		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

package com.example.probudgetmaster_m2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class ViewElectricSummary extends Activity{
	TextView mon;
	TextView wat;
	TextView use;
	TextView day;
	TextView month;
	private Intent i;
	private DatabaseHelper Databas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electricitysummary);
		
		Databas = new DatabaseHelper(getBaseContext(), null, null, 0);

		i = getIntent();
		String month = i.getStringExtra("month");
		
		mon = (TextView)findViewById(R.id.textView5);
		mon.setText(Databas.getAllID());
		
		wat = (TextView)findViewById(R.id.textView4);
		wat.setText(Databas.getAllWatt());
		
		use = (TextView)findViewById(R.id.textView6);
		use.setText(Databas.getAllUse());		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

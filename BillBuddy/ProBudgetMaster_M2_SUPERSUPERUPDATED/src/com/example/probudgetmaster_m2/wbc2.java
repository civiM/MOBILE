package com.example.probudgetmaster_m2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class wbc2 extends Activity {

	String[] meterSize = new String[] { "1/2 or 13mm", "3/4 or 20mm",
			"1 or 25mm", "1 1/4 or 40mm", "2 or 50 mm", "3 or 75 mm",
			"4' or 50mm", "6 or 150 mm", "8 or 200 mm" };

	private ListView listMeterSize;
	private ArrayAdapter<String> ad;

	private EditText use;
	private EditText size;
	private EditText totalWB;
	private Button compute;
	private Button save;
	private Button edit;
	private Button back;
	final DatabaseHelper dbHelper = new DatabaseHelper(this, null, null, 0);;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.waterbillcalculator2);

		Bundle i = getIntent().getExtras();
		final String type = i.getString("type");

		listMeterSize = (ListView) findViewById(R.id.meterSize);
		ad = new ArrayAdapter<String>(this, R.layout.meter_size, meterSize);
		use = (EditText) findViewById(R.id.waterUsage);
		size = (EditText) findViewById(R.id.getMeterSize);
		totalWB = (EditText) findViewById(R.id.totalWaterBill);
		compute = (Button) findViewById(R.id.button1);
		save = (Button) findViewById(R.id.button2);
		edit = (Button) findViewById(R.id.button3);
		back = (Button) findViewById(R.id.button4);

		listMeterSize.setAdapter(ad);

		inDB(type);

		compute.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				compute();
			}
		});
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dbHelper.AddWaterUsage(type, use.getText().toString(), size
						.getText().toString());
			}
		});
		edit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dbHelper.EditWaterUsage(type, use.getText().toString(), size
						.getText().toString());
			}
		});
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent nextScreen = new Intent(getApplicationContext(),
						wbc.class);
				startActivity(nextScreen);
			}
		});
	}

	private void inDB(String type) {
		if (dbHelper.inDBW(type)) {
			use.setText(dbHelper.getWaterUsage(type));
			size.setText(dbHelper.getWaterSize(type));
			compute();
		}
	}

	private void compute() {
		double multi = 0;
		if (size.getText().toString().equals("1/2 or 13mm")){
			multi = 1.5;
		}
		else if (size.getText().toString().equals("3/4 or 20mm")){
			multi = 2;
		}
		double total = Integer.parseInt(use.getText().toString()) * multi;
		
		totalWB.setText(Double.toString(total));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

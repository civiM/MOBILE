package com.example.probudgetmaster_m2;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

public class ebfcalculator extends Activity {
	private EditText watt;
	private TextView appname;
	private EditText use;
	private TextView costd;
	private TextView costm;
	private Button compute;
	private Button save;
	private Button edit;
	private Button back;
	final DatabaseHelper dbHelper = new DatabaseHelper(this, null, null, 0);;
	private Intent o;
	private Bundle i;
	private String month;
	//final String month = i.getString("month");
	private int no;
	public String appl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ebfcalculator);

		String cjan;
		String cfeb;
		String cmar;
		String capr;
		String cmay;
		String cjun;
		String cjul;
		String caug;
		String csep;
		String coct;
		String cnov;
		String cdec;		
		
		


		appname = (TextView) findViewById(R.id.appliancename);
		watt = (EditText) findViewById(R.id.powerValue);
		use = (EditText) findViewById(R.id.noOfHrs);
		costd = (TextView) findViewById(R.id.costPerDay);
		costm = (TextView) findViewById(R.id.costPerMonth);
		compute = (Button) findViewById(R.id.button1);
		save = (Button) findViewById(R.id.button2);
		edit = (Button) findViewById(R.id.button3);
		back = (Button) findViewById(R.id.button4);
		
		o = getIntent();
		i = getIntent().getExtras();
		month = o.getStringExtra("month");
		no = i.getInt("appliances");
		
		
		if (no == 0) {
			appname.setText("TV");
			appl="TV";
		} else if (no == 1) {
			appname.setText("CHARGER");
			appl="CHARGER";
		} else if (no == 2) {
			appname.setText("CONSOLE");
			appl="CONSOLE";
		} else if (no == 3) {
			appname.setText("FAN");
			appl="FAN";
		} else if (no == 4) {
			appname.setText("FRIDGE");
			appl="FRIDGE";
		} else if (no == 5) {
			appname.setText("HAIRDRYER");
			appl="HAIRDRYER";
		} else if (no == 6) {
			appname.setText("IRON");
			appl="IRON";
		} else if (no == 7) {
			appname.setText("LAPTOP");
			appl="LAPTOP";
		} else if (no == 8) {
			appname.setText("LIGHTBULB");
			appl="LIGHTBULB";
		} else if (no == 9) {
			appname.setText("MICROWAVE");
			appl="MICROWAVE";
		} else if (no == 10) {
			appname.setText("WASHING MACHINE");
			appl="WASHING MACHINE";
		} else if (no == 11) {
			appname.setText("AIRCON");
			appl="AIRCON";
		} else if (no == 12) {
			appname.setText("BLENDER");
			appl="BLENDER";
		} else if (no == 13) {
			appname.setText("DESKTOP");
			appl="DESKTOP";
		} else if (no == 14) {
			appname.setText("PRINTER");
			appl="PRINTER";
		}
		
		inDB(month, no);

		compute.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				compute();
			}
		});

		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dbHelper.AddApplianceUsage(month, appl, watt.getText().toString(), use.getText().toString());
			}
		});
		
		edit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dbHelper.EditApplianceUsage(month, Integer.toString(no), watt.getText().toString(), use.getText().toString());
			}
		});

		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent nextScreen = new Intent(getApplicationContext(), ebfmenu.class);
				nextScreen.putExtra("month", month);
				startActivity(nextScreen);

			}
		});

	}

	private void compute() {
		

		
		
		String name = appname.getText().toString();
		int wat = Integer.parseInt(watt.getText().toString());
		int us = Integer.parseInt(use.getText().toString());

		double cpk = 0.33;
		int day = 31;

		double costda = wat * us * cpk;
		double costmo = wat * us * cpk * day;

		String ccostda = String.valueOf(costda);
		String ccostmo = String.valueOf(costmo);

		costd.setText("P" + ccostda);
		costm.setText("P" + ccostmo);
	}

	private void inDB(String month, int id) {
		if (dbHelper.inDB(month, id)) {
			watt.setText(dbHelper.getWatt(month, id));
			use.setText(dbHelper.getUse(month, id));
			compute();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

package com.example.probudgetmaster_m2;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

public class ebfMonth extends Activity {

	private RadioButton jan;
			RadioButton feb;
			RadioButton mar;
			RadioButton apr;
			RadioButton may;
			RadioButton jun;
			RadioButton jul;
			RadioButton aug;
			RadioButton sep;
			RadioButton oct;
			RadioButton nov;
			RadioButton dec;
			Button done;
			RadioGroup radioGroup;
			
			String cjan = "January";
			String cfeb = "February";
			String cmar = "March";
			String capr = "April";
			String cmay = "May";
			String cjun = "June";
			String cjul = "July";
			String caug = "August";
			String csep = "September";
			String coct = "October";
			String cnov = "November";
			String cdec = "December";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ebfmonth);
		
		
		done = (Button)findViewById (R.id.button1);
		jan = (RadioButton)findViewById (R.id.radioButton1);
		feb = (RadioButton)findViewById (R.id.radioButton2);
		mar = (RadioButton)findViewById (R.id.radioButton3);
		apr = (RadioButton)findViewById (R.id.radioButton4);
		may = (RadioButton)findViewById (R.id.radioButton5);
		jun = (RadioButton)findViewById (R.id.radioButton6);
		jul = (RadioButton)findViewById (R.id.radioButton7);
		aug = (RadioButton)findViewById (R.id.radioButton8);
		sep = (RadioButton)findViewById (R.id.radioButton9);
		oct = (RadioButton)findViewById (R.id.radioButton10);
		nov = (RadioButton)findViewById (R.id.radioButton11);
		dec = (RadioButton)findViewById (R.id.radioButton12);
		radioGroup = (RadioGroup) findViewById(R.id.RadioGroup01);

		done.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (jan.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", cjan);
					startActivity(myIntent);						
				}
				else
				if (feb.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", cfeb);
					startActivity(myIntent);						
				}
				else
				if (mar.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", cmar);
					startActivity(myIntent);						
				}
				else
				if (apr.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", capr);
					startActivity(myIntent);						
				}
				else
				if (may.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", cmay);
					startActivity(myIntent);						
				}
				else
				if (jun.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", cjun);
					startActivity(myIntent);						
				}
				else
				if (jul.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", cjul);
					startActivity(myIntent);						
				}
				else
				if (aug.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", caug);
					startActivity(myIntent);						
				}
				else
				if (sep.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", csep);
					startActivity(myIntent);						
				}
				else
				if (oct.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", coct);
					startActivity(myIntent);						
				}
				else
				if (nov.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", cnov);
					startActivity(myIntent);						
				}
				else
				if (dec.isChecked()){
					Bundle extras = getIntent().getExtras();
					Intent myIntent = new Intent(getApplicationContext(), ebfmenu.class);
					myIntent.putExtra("month", cdec);
					startActivity(myIntent);						
				}
						
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

package com.example.probudgetmaster_m2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

public class MainActivity extends Activity {

	private ListView menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Icon menu_data[] = new Icon[] {
				new Icon(R.drawable.electricity, "Electricity Bill Calculator"),
				new Icon(R.drawable.water, "Water Bill Calculator") };

		menu = (ListView) findViewById(R.id.menu);

		menuAdapter adapter = new menuAdapter(this, R.layout.menu, menu_data);

		menu.setAdapter(adapter);

		/*
		 * menu.setOnItemClickListener(new OnItemClickListener() {
		 * 
		 * @Override public void onItemClick(AdapterView<?> parent, View view,
		 * int position, long id) { // TODO Auto-generated method stub Intent
		 * myIntent = (getApplicationContent(), electricitybill.xml);
		 * 
		 * }
		 * 
		 * });
		 */

		menu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				if (position == 0) {
					Intent nextScreen = new Intent(getApplicationContext(),
							electricmain.class);
					startActivity(nextScreen);
				} else if (position == 1) {
					Intent nextScreens = new Intent(getApplicationContext(),
							wbcMonth.class);
					startActivity(nextScreens);
				} else if (position == 2) {
					Intent nextScreens = new Intent(getApplicationContext(),
							budgeterOverview.class);
					startActivity(nextScreens);
				} else if (position == 3) {
					Intent nextScreens = new Intent(getApplicationContext(),
							AddFragment.class);
					startActivity(nextScreens);
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

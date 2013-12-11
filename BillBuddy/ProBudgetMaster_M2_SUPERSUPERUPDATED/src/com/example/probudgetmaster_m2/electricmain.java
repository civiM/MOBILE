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

public class electricmain extends Activity {

	private Button com;
			Button view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electricmenu);
		
		
		com = (Button)findViewById (R.id.button2);
		view = (Button)findViewById (R.id.button1);
		
		com.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent myIntent = new Intent(getApplicationContext(), ebfMonth.class);
				startActivity(myIntent);	
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

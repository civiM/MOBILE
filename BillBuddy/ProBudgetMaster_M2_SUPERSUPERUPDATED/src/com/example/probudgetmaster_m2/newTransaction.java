package com.example.probudgetmaster_m2;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class newTransaction extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newtransaction);
		
		Button btnNextScreen = (Button) findViewById(R.id.button1);

		//Listening to button event
		btnNextScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				//Starting a new Intent
				Intent nextScreen = new Intent(getApplicationContext(), expenses.class);
				startActivity(nextScreen);

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

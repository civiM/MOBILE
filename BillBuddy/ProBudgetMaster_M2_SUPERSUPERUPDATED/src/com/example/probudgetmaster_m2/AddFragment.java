package com.example.probudgetmaster_m2;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar;
import android.content.Intent;

public class AddFragment extends Activity {

	private Fragment mFragment;
	private EditText idnumber;
	private EditText name;
	// private TextView counter;
	private Button addstudent;
	private Button lookstudent;
	private Button update;
	private Button delete;
	private DatabaseHelper dbHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.proto1);
		// Initialize the UI component
		idnumber = (EditText) findViewById(R.id.editText1);
		name = (EditText) findViewById(R.id.editText2);
		addstudent = (Button) findViewById(R.id.button1);
		lookstudent = (Button) findViewById(R.id.button2);
		update = (Button) findViewById(R.id.button3);
		delete = (Button) findViewById(R.id.button4);
		// Once "Add Student" is clicked this method is triggered
		addstudent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Initialize a Student Object
				Student newStudent = new Student();
				newStudent.setIdnumber(idnumber.getText().toString());
				newStudent.setName(name.getText().toString());
				// Store it to Database
				dbHelper.AddStudent(newStudent);
				// Update the counter
				// counter.setText("Counter : " +
				// String.valueOf(dbHelper.getStudentCount()));
			}
		});

		lookstudent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent nextScreen = new Intent(getApplicationContext(),
						ViewFragment.class);
				startActivity(nextScreen);
			}
		});

		update.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent nextScreen = new Intent(getApplicationContext(),
						EditFragment.class);
				startActivity(nextScreen);
			}
		});

		delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent nextScreen = new Intent(getApplicationContext(),
						DeleteFragment.class);
				startActivity(nextScreen);
			}
		});

		try {
			// Checks if Database is not yet created
			dbHelper = new DatabaseHelper(getBaseContext(), null, null, 0);
			// Loads the counter
			// counter.setText("Counter : " +
			// String.valueOf(dbHelper.getStudentCount()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(mFragment);
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}
}
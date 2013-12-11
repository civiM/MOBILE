package com.example.probudgetmaster_m2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar;
import android.content.Intent;

public class DeleteFragment extends Activity {
	

private EditText idnumber;
private Button updatestudent;
private Button deletestudent;
private DatabaseHelper dbHelper;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.proto4);
//Initialize the UI component
idnumber= (EditText) findViewById(R.id.editText1);
updatestudent = (Button) findViewById(R.id.button1);
deletestudent = (Button) findViewById(R.id.button2);

//Once "Add Student" is clicked this method is triggered
updatestudent.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View arg0) {
//Initialize a Student Object
String id = idnumber.getText().toString();
//Store it to Database
dbHelper.DeleteStudent(id);
//Update the counter
		}
		});


deletestudent.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View arg0) {
	Intent nextScreen = new Intent(getApplicationContext(), AddFragment.class);
	startActivity(nextScreen);
		}
		});



		try
		{
		//Checks if Database is not yet created
		dbHelper=new DatabaseHelper(getBaseContext(), null, null, 0);
		//Loads the counter
		}
		catch(Exception ex)
		{ ex.printStackTrace();
		}
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		}
		}
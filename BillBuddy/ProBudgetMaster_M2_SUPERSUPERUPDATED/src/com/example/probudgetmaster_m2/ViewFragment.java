package com.example.probudgetmaster_m2;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar;
import android.app.Activity;
import android.widget.Button;
import android.content.Intent;

public class ViewFragment extends Activity {
private Fragment mFragment;
private TextView viewtext;
private DatabaseHelper dbHelper;
private Button botton;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.proto2);
// Initialize Database
dbHelper = new DatabaseHelper(getBaseContext(), null, null, 0);
// Initialize UI
viewtext = (TextView) findViewById(R.id.textView1);
botton = (Button) findViewById(R.id.button1);
// Get text from the database
viewtext.setText(dbHelper.getAllStudentNames());


botton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View arg0) {
	Intent nextScreen = new Intent(getApplicationContext(), AddFragment.class);
	startActivity(nextScreen);
		}
		});


}

public void onTabUnselected(Tab tab, FragmentTransaction ft) {
ft.remove(mFragment);
}
public void onTabReselected(Tab tab, FragmentTransaction ft) {
}
}

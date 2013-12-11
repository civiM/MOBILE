package com.example.probudgetmaster_m2;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "probudgetmaster";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_CREATE_APP = "CREATE TABLE apps(month, id, watt, use)";
	private static final String TABLE_CREATE_WB = "CREATE TABLE wb(type, use, size)";
	private static final String TABLE_CREATE_BUDGET = "CREATE TABLE budget(month, year, income)";
	private static final String TABLE_CREATE_EXPENSE = "CREATE TABLE expense(month, year, day, details, amount, category)";

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Creates the Student table
		db.execSQL(TABLE_CREATE_APP);
		db.execSQL(TABLE_CREATE_WB);
		db.execSQL(TABLE_CREATE_BUDGET);
		db.execSQL(TABLE_CREATE_EXPENSE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public void AddApplianceUsage(String month, String id, String watt,
			String use) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("month", month);
		cv.put("id", id);
		cv.put("watt", watt);
		cv.put("use", use);
		db.insert("apps", null, cv);
		db.close();
	}

	public void EditApplianceUsage(String month, String id, String watt,
			String use) {
		SQLiteDatabase db = this.getWritableDatabase();

		String strSql = "UPDATE apps SET watt = '" + watt + "', use = '" + use
				+ "' WHERE month ='" + month + "' AND id = '" + id + "'";
		db.execSQL(strSql);

		db.close();
	}

	public boolean inDB(String month, int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		boolean bool = false;
		Cursor cur = db.rawQuery("SELECT * FROM apps WHERE month=? AND id=?",
				new String[] { month, Integer.toString(id) });
		if (cur.getCount() > 0)
			bool = true;

		cur.close();
		db.close();

		return bool;
	}

	public String getAllWatt()
	{
	//Open DB Connection
	SQLiteDatabase db=this.getWritableDatabase();
	//Execute the query
	Cursor cur= db.rawQuery("SELECT * FROM apps",null);
	String data = "";
	//Retrieve all student names
	if (cur.moveToFirst()){
	do{
	data += cur.getString(cur.getColumnIndex("watt")) +
	"\n\n";
	}while(cur.moveToNext());
	}
	//Close conections
	cur.close();
	db.close();
	return data;
	}
	
	public String getAllUse()
	{
	//Open DB Connection
	SQLiteDatabase db=this.getWritableDatabase();
	//Execute the query
	Cursor cur= db.rawQuery("SELECT * FROM apps",null);
	String data = "";
	//Retrieve all student names
	if (cur.moveToFirst()){
	do{
	data += cur.getString(cur.getColumnIndex("use")) +
	"\n\n";
	}while(cur.moveToNext());
	}
	//Close conections
	cur.close();
	db.close();
	return data;
	}	
	
	public String getAllID()
	{
	//Open DB Connection
	SQLiteDatabase db=this.getWritableDatabase();
	//Execute the query
	Cursor cur= db.rawQuery("SELECT * FROM apps",null);
	String data = "";
	//Retrieve all student names
	if (cur.moveToFirst()){
	do{
	data += cur.getString(cur.getColumnIndex("id")) +
	"\n\n";
	}while(cur.moveToNext());
	}
	//Close conections
	cur.close();
	db.close();
	return data;
	}		
	
	public String getWatt(String month, int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("SELECT * FROM apps WHERE month=? AND id=?",
				new String[] { month, Integer.toString(id) });
		String watt = "";

		if (cur.moveToFirst()) {
			do {
				watt = cur.getString(cur.getColumnIndex("watt"));
			} while (cur.moveToNext());
		}

		cur.close();
		db.close();

		return watt;
	}

	public String getUse(String month, int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("SELECT * FROM apps WHERE month=? AND id=?",
				new String[] { month, Integer.toString(id) });
		String use = "";

		if (cur.moveToFirst()) {
			do {
				use = cur.getString(cur.getColumnIndex("use"));
			} while (cur.moveToNext());
		}

		cur.close();
		db.close();

		return use;
	}

	public void AddWaterUsage(String type, String use, String size) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("type", type);
		cv.put("use", use);
		cv.put("size", size);
		db.insert("wb", null, cv);
		db.close();
	}
	
	public String getAllwType()
	{
	//Open DB Connection
	SQLiteDatabase db=this.getWritableDatabase();
	//Execute the query
	Cursor cur= db.rawQuery("SELECT * FROM wb",null);
	String data = "";
	//Retrieve all student names
	if (cur.moveToFirst()){
	do{
	data += cur.getString(cur.getColumnIndex("type")) +
	"\n\n";
	}while(cur.moveToNext());
	}
	//Close conections
	cur.close();
	db.close();
	return data;
	}	
	
	public String getAllwUse()
	{
	//Open DB Connection
	SQLiteDatabase db=this.getWritableDatabase();
	//Execute the query
	Cursor cur= db.rawQuery("SELECT * FROM wb",null);
	String data = "";
	//Retrieve all student names
	if (cur.moveToFirst()){
	do{
	data += cur.getString(cur.getColumnIndex("use")) +
	"\n\n";
	}while(cur.moveToNext());
	}
	//Close conections
	cur.close();
	db.close();
	return data;
	}	
	
	public String getAllwSize()
	{
	//Open DB Connection
	SQLiteDatabase db=this.getWritableDatabase();
	//Execute the query
	Cursor cur= db.rawQuery("SELECT * FROM wb",null);
	String data = "";
	//Retrieve all student names
	if (cur.moveToFirst()){
	do{
	data += cur.getString(cur.getColumnIndex("size")) +
	"\n\n";
	}while(cur.moveToNext());
	}
	//Close conections
	cur.close();
	db.close();
	return data;
	}	
	
	
	

	public void EditWaterUsage(String type, String use, String size) {
		SQLiteDatabase db = this.getWritableDatabase();

		String strSql = "UPDATE wb SET use = '" + use + "', size = '" + size
				+ "' WHERE type ='" + type + "'";
		db.execSQL(strSql);

		db.close();
	}
	
	public boolean inDBW(String type) {
		SQLiteDatabase db = this.getWritableDatabase();
		boolean bool = false;
		Cursor cur = db.rawQuery("SELECT * FROM wb WHERE type = ?",
				new String[] { type });
		if (cur.getCount() > 0)
			bool = true;

		cur.close();
		db.close();

		return bool;
	}
	
	public String getWaterUsage(String type){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("SELECT * FROM wb WHERE type=?", new String[] {type});
		String use = "";

		if (cur.moveToFirst()) {
			do {
				use = cur.getString(cur.getColumnIndex("use"));
			} while (cur.moveToNext());
		}

		cur.close();
		db.close();

		return use;
	}
	
	public String getWaterSize(String type){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("SELECT * FROM wb WHERE type=?", new String[] {type});
		String size = "";

		if (cur.moveToFirst()) {
			do {
				size = cur.getString(cur.getColumnIndex("size"));
			} while (cur.moveToNext());
		}

		cur.close();
		db.close();

		return size;
	}
	
	public void AddExpense(String month, String year, String day, String details, String amount, String category){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("month", month);
		cv.put("year", year);
		cv.put("day", day);
		cv.put("details", details);
		cv.put("amount", amount);
		cv.put("category", category);
		db.insert("expense", null, cv);
		db.close();
	}
	
	public void AddBudget(String month, String year, String income) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("month", month);
		cv.put("year", year);
		cv.put("income", income);
		db.insert("budget", null, cv);
		db.close();
	}
	
	public String getBudget(String month, String year){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("SELECT * FROM budget WHERE month=? and year=?", new String[] {month, year});
		String income = "";

		if (cur.moveToFirst()) {
			do {
				income = cur.getString(cur.getColumnIndex("income"));
			} while (cur.moveToNext());
		}

		cur.close();
		db.close();

		return income;
	}
	
	public String[] getExpenseList(String month, String year){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("SELECT * FROM expense WHERE month=? and year=?", new String[] {month, year});
		ArrayList arrExpenses = new ArrayList();

		if (cur.moveToFirst()) {
			do {
				arrExpenses.add(cur.getString(cur.getColumnIndex("details")));
			} while (cur.moveToNext());
		}

		cur.close();
		db.close();
		
		String[] sarExpenses = new String[arrExpenses.size()];
		sarExpenses = (String[]) arrExpenses.toArray(sarExpenses);

		return sarExpenses;
	}

	// *********************************************************************************************

	// Method that adds a row in the Student Table
	public void AddStudent(Student newStudent) {
		// Open DB Connection
		SQLiteDatabase db = this.getWritableDatabase();
		// storage for your data
		ContentValues cv = new ContentValues();
		cv.put("idnumber", newStudent.getIdnumber());
		cv.put("name", newStudent.getName());
		// insert values
		db.insert("student", null, cv);
		// Close DB
		db.close();
	}

	// Method that count rows stored in the Student table
	public void EditStudent(Student newStudent, String id) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put("idnumber", newStudent.getIdnumber());
		cv.put("name", newStudent.getName());

		db.update(DATABASE_NAME, cv, "idnumber=?", new String[] { id });
		db.close();

	}

	public void DeleteStudent(String id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(DATABASE_NAME, "idnumber=?", new String[] { id });
		db.close();

	}

	public int getStudentCount() {
		// Open DB Connection
		SQLiteDatabase db = this.getWritableDatabase();
		// Execute the query
		Cursor cur = db.rawQuery("SELECT * from student", null);
		// Gets the row count
		int x = cur.getCount();
		// Close connections
		cur.close();
		db.close();
		return x;
	}

	// Method that retrieves all student names from the database
	public String getAllStudentNames() {
		// Open DB Connection
		SQLiteDatabase db = this.getWritableDatabase();
		// Execute the query
		Cursor cur = db.rawQuery("SELECT * FROM student", null);
		String data = "";
		// Retrieve all student names
		if (cur.moveToFirst()) {
			do {
				data += cur.getString(cur.getColumnIndex("name")) + "\n\n";
			} while (cur.moveToNext());
		}
		// Close conections
		cur.close();
		db.close();
		return data;
	}
}
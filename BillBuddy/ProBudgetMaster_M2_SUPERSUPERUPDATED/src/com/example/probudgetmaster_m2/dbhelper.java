package com.example.probudgetmaster_m2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class dbhelper extends SQLiteOpenHelper{
private static final String DATABASE_NAME = "electric";
private static final int DATABASE_VERSION = 1;
private static final String TABLE_CREATE =
"CREATE TABLE electric(month text, watt integer, use integer, costd integer, costm integer, appname text)";
public dbhelper(Context context, String name, CursorFactory
factory, int version) {
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}
@Override
public void onCreate(SQLiteDatabase db) {
// Creates the Student table
db.execSQL(TABLE_CREATE);
}
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
{
}
// Method that adds a row in the Student Table
public void AddStudent(Student newStudent)
{
//Open DB Connection
SQLiteDatabase db = this.getWritableDatabase();
//storage for your data
ContentValues cv = new ContentValues();
cv.put("idnumber", newStudent.getIdnumber());
cv.put("name", newStudent.getName());
//insert values
db.insert("student",null, cv);
//Close DB
db.close();
}
//Method that count rows stored in the Student table
public void EditStudent(Student newStudent, String id){
	SQLiteDatabase db = this.getWritableDatabase();
	
	ContentValues cv = new ContentValues();
	cv.put("idnumber", newStudent.getIdnumber());
	cv.put("name", newStudent.getName());
	
     db.update(DATABASE_NAME, cv, "idnumber=?", new String[] {id});
	db.close();
	
}


public void DeleteStudent(String id){
	SQLiteDatabase db = this.getWritableDatabase();
     db.delete(DATABASE_NAME, "idnumber=?", new String[] {id});
	db.close();
	
}


public int getStudentCount()
{
//Open DB Connection
SQLiteDatabase db = this.getWritableDatabase();
//Execute the query
Cursor cur = db.rawQuery("SELECT * from student", null);
//Gets the row count
int x = cur.getCount();
//Close connections
cur.close();
db.close();
return x;
}
//Method that retrieves all student names from the database
public String getAllStudentNames()
{
//Open DB Connection
SQLiteDatabase db=this.getWritableDatabase();
//Execute the query
Cursor cur= db.rawQuery("SELECT * FROM student",null);
String data = "";
//Retrieve all student names
if (cur.moveToFirst()){
do{
data += cur.getString(cur.getColumnIndex("name")) +
"\n\n";
}while(cur.moveToNext());
}
//Close conections
cur.close();
db.close();
return data;
}
}
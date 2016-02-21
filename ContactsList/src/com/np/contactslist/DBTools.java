package com.np.contactslist;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBTools extends SQLiteOpenHelper{
	public static final String DATABASE_NAME= "addressbook.db"; 
	public static final String TABLE_NAME= "contacts";
	public DBTools(Context context) {
		super(context, DATABASE_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String query = "CREATE TABLE "+TABLE_NAME+" ( contactId INTEGER PRIMARY KEY, firstname TEXT, " +
				"lastname TEXT, mobile TEXT, work TEXT, email TEXT, address TEXT)";
		
		// Executes the query provided as long as the query isn't a select
		// or if the query doesn't return any data
		
        db.execSQL(query);

		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public void insertContent(HashMap<String, String> queryData){
		SQLiteDatabase db= this.getWritableDatabase();
		ContentValues values= new ContentValues();
		values.put("firstname", queryData.get("firstname"));
		values.put("lastname", queryData.get("lastname"));
		values.put("mobile", queryData.get("mobile"));
		values.put("work", queryData.get("work"));
		values.put("email", queryData.get("email"));
		values.put("address", queryData.get("address"));
		
		db.insert(TABLE_NAME, null, values);
		db.close();
	}
	
	public int updateContent(HashMap<String, String> queryData){
		SQLiteDatabase db= this.getWritableDatabase();
		ContentValues values= new ContentValues();
		values.put("firstname", queryData.get("firstname"));
		values.put("lastname", queryData.get("lastname"));
		values.put("mobile", queryData.get("mobile"));
		values.put("work", queryData.get("work"));
		values.put("email", queryData.get("email"));
		values.put("address", queryData.get("address"));
		return db.update(TABLE_NAME, values, "contactId=?", new String[]{queryData.get("contactId")});
	}
	
	public void deleteContact(String id){
		SQLiteDatabase db= this.getWritableDatabase();
		String query= "DELETE FROM "+TABLE_NAME+" WHERE contactId='"+id+"'";
		db.execSQL(query);
	}
	
	public ArrayList<HashMap<String, String>> getAllContacts(){
		
		ArrayList<HashMap<String,String>> contactList = new ArrayList<HashMap<String,String>>();
		String query= "SELECT * FROM "+TABLE_NAME + " ORDER BY firstname"; 
		SQLiteDatabase db= this.getWritableDatabase();
		Cursor cursor= db.rawQuery(query, null);
		
		if(cursor.moveToFirst()){
			do{
				HashMap<String, String> contactmap= new HashMap<String, String>();
				contactmap.put("contactId", cursor.getString(0));
				contactmap.put("firstname", cursor.getString(1));
				contactmap.put("lastname", cursor.getString(2));
				contactmap.put("mobile", cursor.getString(3));
				contactmap.put("work", cursor.getString(4));
				contactmap.put("email", cursor.getString(5));
				contactmap.put("address", cursor.getString(6));
				contactList.add(contactmap);
			}while(cursor.moveToNext());
		}
		return contactList ;	
	}
	
	public HashMap<String, String> getContactInfo(String id) {
		HashMap<String, String> contactMap = new HashMap<String, String>();
		
		// Open a database for reading only
		
		SQLiteDatabase database = this.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM contacts WHERE contactId='"+id+"'";
		
		// rawQuery executes the query and returns the result as a Cursor
		
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
	        do {
					
	        	contactMap.put("firstname", cursor.getString(1));
	        	contactMap.put("lastname", cursor.getString(2));
	        	contactMap.put("mobile", cursor.getString(3));
	        	contactMap.put("work", cursor.getString(4));
	        	contactMap.put("email", cursor.getString(5));
	        	contactMap.put("address", cursor.getString(6));
				   
	        } while (cursor.moveToNext());
	    }				    
	return contactMap;
	}	
}

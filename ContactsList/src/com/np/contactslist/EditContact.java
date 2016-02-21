package com.np.contactslist;

import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditContact extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_contact);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_contact, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}
		EditText firstName;
		EditText lastName;
		EditText mobile;
		EditText work;
		EditText email;
		EditText address;
		
		String contactId; 
		Button EditContact;
		Button DeleteContact ;
		
		DBTools db;


		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_edit_contact,
					container, false);
			db= new DBTools(getActivity());

			firstName=  (EditText) rootView.findViewById(R.id.firstname);
			lastName=  (EditText) rootView.findViewById(R.id.lastname);
			mobile=  (EditText) rootView.findViewById(R.id.mobile);
			work=  (EditText) rootView.findViewById(R.id.work);
			email= (EditText) rootView.findViewById(R.id.email);
			address=  (EditText) rootView.findViewById(R.id.address);
			contactId= getActivity().getIntent().getStringExtra("contactId");
		    HashMap<String,String> contactInfo = db.getContactInfo(contactId);
		    
		    firstName.setText(contactInfo.get("firstname"));
		    lastName.setText(contactInfo.get("lastname"));
		    mobile.setText(contactInfo.get("mobile"));
		    work.setText(contactInfo.get("work"));
		    email.setText(contactInfo.get("email"));
		    address.setText(contactInfo.get("address"));
		    EditContact = (Button) rootView.findViewById(R.id.editContact);
		    DeleteContact= (Button) rootView.findViewById(R.id.deleteContact);
		    EditContact.setOnClickListener(saveEditedContact);
		    DeleteContact.setOnClickListener(deleteContact);
			return rootView;
		}
		
		public OnClickListener saveEditedContact = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HashMap<String, String> queryData= new HashMap<String, String>();
				queryData.put("contactId", contactId);
				queryData.put("firstname", firstName.getText().toString());
				queryData.put("lastname", lastName.getText().toString());
				queryData.put("mobile", mobile.getText().toString());
				queryData.put("work", work.getText().toString());
				queryData.put("email", email.getText().toString());
				queryData.put("address", address.getText().toString());
				db.updateContent(queryData);
				callmainActivity(v);
			}
		};

		
	    public OnClickListener deleteContact = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db.deleteContact(contactId);	
		    	callmainActivity(v);			
			}
		};
	 
	    
		private void callmainActivity(View view) {
			// TODO Auto-generated method stub
			Intent intent= new Intent(getActivity().getApplicationContext(), MainActivity.class);
			startActivity(intent);
			
		}

	}

}

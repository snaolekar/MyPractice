package com.np.contactslist;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	public static class PlaceholderFragment extends ListFragment {

		public PlaceholderFragment() {
		}
		Intent intent ;
		TextView contactIdTV ;
		Button addNewContactBtn ;
		DBTools db ;	
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,false);
			addNewContactBtn= (Button) rootView.findViewById(R.id.addContact);
			addNewContactBtn.setOnClickListener(AddNewContactListnet);
			return rootView;
		}
		
		@Override
		public void onViewCreated(View view, Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onViewCreated(view, savedInstanceState);
			db= new DBTools(getActivity());
			ArrayList<HashMap<String, String>> contactList = db.getAllContacts();
			
			if(contactList.size() >0)
			{
				ListView listView = (ListView) getListView();
				listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						contactIdTV=  (TextView) view.findViewById(R.id.contactId);
						String contactId=  contactIdTV.getText().toString();
						intent = new Intent(getActivity().getApplicationContext(), EditContact.class);
						intent.putExtra("contactId", contactId);
						startActivity(intent);
					}
					
				});
			}
			ListAdapter adapter = new SimpleAdapter(getActivity().getApplicationContext(), contactList, R.layout.contect_entry,
					new String[]{"contactId", "firstname"}, new int[]{R.id.contactId, R.id.contactName});
			setListAdapter(adapter);

		}

		public OnClickListener AddNewContactListnet = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity().getApplicationContext(),AddContact.class);
				startActivity(intent);
			}
		};			
	}

}

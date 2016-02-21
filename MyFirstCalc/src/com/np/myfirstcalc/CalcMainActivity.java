package com.np.myfirstcalc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class CalcMainActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calc_main);

		if (savedInstanceState == null) {
			//application  started for first time no restore
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calc_main, menu);
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
		
		private double billAmount;
		private double tipAmount ;

		public PlaceholderFragment() {
			billAmount =0.0 ;
			tipAmount =.15;
		}		 
		EditText billAmountET  ;
		EditText tipAmountET  ;
		EditText finalBillAmountET  ;
		SeekBar tipSeekBar ; 
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_calc_main,
					container, false);
			
			//initialize edit Text and add Listener
			billAmountET = (EditText)  rootView.findViewById(R.id.calcBillEditText);
			tipAmountET =(EditText) rootView.findViewById(R.id.calcTipEditText);
			finalBillAmountET= (EditText) rootView.findViewById(R.id.billFinalEditText);
			tipSeekBar = (SeekBar) rootView.findViewById(R.id.calcTipSeekBar);
			
			//Add Listener to Bill Amount Edit Text
			
			billAmountET.addTextChangedListener(billAmountChagedListener);
			
			//Add Listener to seek Bar
			tipSeekBar.setOnSeekBarChangeListener(tipSeekBarChangeListenet);

			return rootView;
		}
		private TextWatcher billAmountChagedListener = new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				try{
				billAmount = Double.parseDouble(s.toString());
				}
				catch(NumberFormatException e)
				{
					billAmount =0.0 ;
				}
				updateAllValues();
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
			
			
		};
		
		private void updateAllValues()
		{
			double tipAmount = Double.parseDouble(tipAmountET.getText().toString());
			double finalBillAmount = billAmount + tipAmount*billAmount ;
			finalBillAmountET.setText(String.format("%.2f", finalBillAmount));
		}
		
		private OnSeekBarChangeListener tipSeekBarChangeListenet =new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				tipAmount = (seekBar.getProgress())*.01 ;
				tipAmountET.setText(String.format("%.2f", tipAmount));
				updateAllValues();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
	}

}

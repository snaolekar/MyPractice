package com.navpravartancorp.stockapp;

import java.util.Arrays;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class StockAppMainActivity extends ActionBarActivity {
	public static final String STOCK_SYMBOL= "com.navpravartancorp.stockapp.STOCK" ;
	private static SharedPreferences StockSymbolEntered ;
	private static TableLayout stockListScrollViewTable ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stock_app_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stock_app_main, menu);
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
		private  Button enterStockSymbol ;
		private  Button deleteAllSymbol ;
		private  EditText StockSymbolEditText ;


		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_stock_app_main,
					container, false);
			StockSymbolEntered = getActivity().getSharedPreferences("stocklist", MODE_PRIVATE);
					
			stockListScrollViewTable = (TableLayout) rootView.findViewById(R.id.StockListTable);
			enterStockSymbol = (Button)rootView.findViewById(R.id.enterStockSymbol);
			deleteAllSymbol = (Button)rootView.findViewById(R.id.deleteAllSymbol);
			StockSymbolEditText = (EditText) rootView.findViewById(R.id.StockSymbolEditText);
			enterStockSymbol.setOnClickListener(enterStockButtonListener);
			deleteAllSymbol.setOnClickListener(deleteStockButtonListener);
			updateSavedStockList(null);
			return rootView;
		}
		
		private void updateSavedStockList(String newStockSymbol){
			String [] stocks = StockSymbolEntered.getAll().keySet().toArray(new String[0]);
			Arrays.sort(stocks,String.CASE_INSENSITIVE_ORDER);
			
			if(newStockSymbol!=null){
				insertStocksIntoScrollView(newStockSymbol, Arrays.binarySearch(stocks, newStockSymbol));
			}
			else{
				for(int i=0; i<stocks.length ;i++)
				insertStocksIntoScrollView(stocks[i],i);
			}
		}
		
		private void saveStockSymbol(String newStockSymbol){
			String isStockNew = StockSymbolEntered.getString(newStockSymbol, null);
			SharedPreferences.Editor preferencesEditor = StockSymbolEntered.edit();
			preferencesEditor.putString(newStockSymbol, newStockSymbol);
			preferencesEditor.apply();
			if(isStockNew == null){
				updateSavedStockList(newStockSymbol);
			}
		
		}
	   	
		private void insertStocksIntoScrollView(String newStockSymbol, int index){
			LayoutInflater inflator = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View newStockRow =  inflator.inflate(R.layout.stock_symbols_row, null);
			TextView newStockTextView = (TextView) newStockRow.findViewById(R.id.stockSymbolTextView);
			newStockTextView.setText(newStockSymbol);
			Button stockQuotes =(Button) newStockRow.findViewById(R.id.stockQuotes);
			stockQuotes.setOnClickListener(getStockActivityListener);
			Button gotoWeb = (Button) newStockRow.findViewById(R.id.gotoWeb);
			gotoWeb.setOnClickListener(gotoWebActivityListenet);
			stockListScrollViewTable.addView(newStockRow,index);
		}
		
		public OnClickListener enterStockButtonListener = new OnClickListener (){

			@Override
			public void onClick(View v) {
				if(StockSymbolEditText.getText().length()>0){
					saveStockSymbol(StockSymbolEditText.getText().toString());
					StockSymbolEditText.setText("");
					InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(StockSymbolEditText.getWindowToken(), 0);
				}
				else{
					AlertDialog.Builder builder = new AlertDialog.Builder(getActivity().getApplicationContext());
					builder.setTitle(R.string.invalid_stock_symbol);
					builder.setPositiveButton(R.string.ok, null);
					builder.setMessage(R.string.missing_stock_symbol);
					AlertDialog theDialogeBox = builder.create();
					theDialogeBox.show();	
				}
			}
			
		};
		
		private void deleteAllStocks(){
			stockListScrollViewTable.removeAllViews();
		}
		
		public OnClickListener deleteStockButtonListener= new OnClickListener(){

			@Override
			public void onClick(View v) {
			deleteAllStocks();
			SharedPreferences.Editor preferenceEditor = StockSymbolEntered.edit();
			preferenceEditor.clear();
			preferenceEditor.apply();
			}
			
		};
		
		public OnClickListener getStockActivityListener= new OnClickListener(){

			@Override
			public void onClick(View v) {
				TableRow tableRow = (TableRow)v.getParent();
				TextView stockSymbolTextView = (TextView) tableRow.findViewById(R.id.stockSymbolTextView);
				String stockSymbol= stockSymbolTextView.getText().toString();
				Intent intent = new Intent (getActivity() , StockInfoActivity.class);
				intent.putExtra(STOCK_SYMBOL, stockSymbol);
				startActivity(intent);
			}
			
		};
		
		public OnClickListener gotoWebActivityListenet= new OnClickListener(){

			@Override
			public void onClick(View v) {
				TableRow tableRow = (TableRow)v.getParent();
				TextView stockSymbolTextView = (TextView) tableRow.findViewById(R.id.stockSymbolTextView);
				String stockSymbol= stockSymbolTextView.getText().toString();
			    String stockURL = getString(R.string.yahoo_stock_url)+stockSymbol ;
				Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(stockURL) );
				startActivity(intent);
			}
			
		};

	     
	}

}

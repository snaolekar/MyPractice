package com.navpravartancorp.stockapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StockInfoActivity extends ActionBarActivity {

//	private static final String TAG ="STOCKQUOTE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stock_info);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stock_into, menu);
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

		TextView companyNameTextView ;
		TextView dayLowTextView ;
		TextView dayHighTextView ;
		TextView monthLowTextView ;
		TextView monthHighTextView ;
		TextView changeTextView ;
		TextView daysRangeTextView ;
		TextView lastTradepriceTextView ;
		
		static final String KEY_ITEM ="quote";
		static final String KEY_NAME= "name";
		static final String KEY_DAY_LOW="DayLow";
		static final String KEY_DAY_HIGH="DayHigh";
		static final String KEY_MONTH_LOW="MonthLow";
		static final String KEY_MONTH_HIGH="MonthHigh";
		static final String KEY_LAST_TRADE_PRICE="LastTradePrice";
		static final String KEY_CHANGE="Change";
		static final String KEY_RANGE ="DaysRange";
		
		String companyName="" ;
		String dayLow="" ;
		String dayHigh="" ;
		String monthLow="" ;
		String monthHigh="" ;
		String change="" ;
		String daysRange="" ;
		String lastTradeprice="" ;
		String[][] xmlPullParserArray={{"AverageDailyVolume", "0"}, {"Change", "0"}, {"DaysLow", "0"},
				           {"DaysHigh", "0"}, {"YearLow", "0"}, {"YearHigh", "0"},
				           {"MarketCapitalization", "0"}, {"LastTradePriceOnly", "0"}, {"DaysRange", "0"},
				           {"Name", "0"}, {"Symbol", "0"}, {"Volume", "0"},
					       {"StockExchange", "0"}};
		String yahooURLFirst ="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quote%20where%20symbol%20in%20(%22YHOO%22%2C%22AAPL%22%2C%22GOOG%22%2C%22";
		String yahooURLSecound= "%22)&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		int parserArrayIncriment= 0;
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_stock_info,
					container, false);
			Intent intent = getActivity().getIntent();
			String stockSymbol = intent.getStringExtra(StockAppMainActivity.STOCK_SYMBOL);
			companyNameTextView= (TextView) rootView.findViewById(R.id.companyNameTextView);
			dayLowTextView = (TextView) rootView.findViewById(R.id.daysLowTextView);
			dayHighTextView = (TextView) rootView.findViewById(R.id.daysHighTextView);
			monthLowTextView = (TextView) rootView.findViewById(R.id.monthLowTextView);
			monthHighTextView = (TextView) rootView.findViewById(R.id.monthHighTextView);
			changeTextView = (TextView) rootView.findViewById(R.id.changeTextView);
			daysRangeTextView = (TextView) rootView.findViewById(R.id.daysRangeTextView);
			lastTradepriceTextView = (TextView) rootView.findViewById(R.id.lastTradePriceTextVeiw);
			
			Log.d("Before URL creation ", stockSymbol);
			
			final String yqlURL= yahooURLFirst+ stockSymbol +yahooURLSecound ;
			
		   new MyAsyncTask().execute(yqlURL);
		   
			return rootView;
		}
		
		private class MyAsyncTask extends AsyncTask<String, String, String>{

			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				try {
					XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
					XmlPullParser parser = factory.newPullParser();
					parser.setInput(new InputStreamReader(getUrlData(params[0])));
					//checking if beginning of document is proper or not
					beginDocument(parser,"quote");
					
					int eventType= parser.getEventType();
					do{
						//checks for nextElement validity
						nextElement(parser);
						parser.next();
						eventType= parser.getEventType();
						if(eventType== XmlPullParser.TEXT){
							String valuefromXML= parser.getText();
							xmlPullParserArray[parserArrayIncriment++][1] = valuefromXML; 						
						}
						
					}while(eventType!= XmlPullParser.END_DOCUMENT);
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			}
			
			protected final void nextElement(XmlPullParser parser)  throws XmlPullParserException, IOException{
				int type;
				while ((type=parser.next()) != XmlPullParser.START_TAG	&& type != XmlPullParser.END_DOCUMENT) ;
			}
			protected final void beginDocument(XmlPullParser parser, String firstElementName) throws XmlPullParserException, IOException{
				int type;

				while ((type=parser.next()) != XmlPullParser.START_TAG	&& type != XmlPullParser.END_DOCUMENT) ;
				
				if (type != XmlPullParser.START_TAG) {
					throw new XmlPullParserException("No start tag found");
				}
				if (!parser.getName().equals(firstElementName)) {
					throw new XmlPullParserException("Unexpected start tag: found " + parser.getName() +
							", expected " + firstElementName);
				}
			}
			protected InputStream getUrlData(String url) throws ClientProtocolException, IOException
			{
				DefaultHttpClient client= new DefaultHttpClient();
				HttpGet method= new HttpGet(url);
				HttpResponse res= client.execute(method);
				return res.getEntity().getContent();
			}
			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				 companyNameTextView.setText("CompanyName "+xmlPullParserArray[9][1]); ;
				 dayLowTextView.setText("Days Low "+xmlPullParserArray[2][1]);
				 dayHighTextView.setText("Days High "+xmlPullParserArray[3][1]); ;
				 monthLowTextView.setText("Months Low "+xmlPullParserArray[4][1]) ;
				 monthHighTextView.setText("Months High "+xmlPullParserArray[5][1]); ;
				 changeTextView.setText("Change "+xmlPullParserArray[1][1]) ;
				 daysRangeTextView.setText("Days Range "+xmlPullParserArray[8][1]); ;
				 lastTradepriceTextView.setText("Last treded Price "+xmlPullParserArray[7][1]); ;
				
				
			}

			}
		}
	}

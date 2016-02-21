package com.example.stockappjason;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity{
	
	static String symbol= "MSFT";
	static String yahooQuote ="https://query.yahooapis.com/v1/public/yql?q=select%20*%20"
			+ "from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22"+symbol+"%22)&format=json&env=store"
			+ "%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
	String stcokSymbol= "";
	String change= "";
	String daysHigh= "";
	String daysLow= "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new MyAsyncTask().execute();
	}
	
	private class MyAsyncTask extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			DefaultHttpClient httpClient= new DefaultHttpClient(new BasicHttpParams());
			HttpPost httpPost= new HttpPost(yahooQuote);
			httpPost.setHeader("Content-type", "application/json");
			String results= null;
			InputStream inputStream= null;
			try{
				
				HttpResponse httpRes= httpClient.execute(httpPost);
				HttpEntity entity= httpRes.getEntity();
				inputStream = entity.getContent();
				BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream,"UTF-8"), 8);
				StringBuilder stb= new StringBuilder();
				String line= null;
				while((line= reader.readLine())!=null){
					stb.append(line +"\n");
				}
				results= stb.toString();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					if(inputStream !=null)
						inputStream.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
			JSONObject jsonObj;
			try{
				jsonObj = new JSONObject(results);
				JSONObject quoteObj= ((jsonObj.getJSONObject("query")).getJSONObject("results")).getJSONObject("quote");
				stcokSymbol= quoteObj.getString("symbol");
				change= quoteObj.getString("Change");
				daysLow=  quoteObj.getString("DaysLow");
				daysHigh= quoteObj.getString("DaysHigh");
				
				Log.v("Symbol", stcokSymbol);
				Log.v("change", change);
				Log.v("low", daysLow);
				Log.v("high", daysHigh);
				
				//Extra stuff self code
				JSONArray jsonArr=  quoteObj.names();
				List<String> names = new ArrayList<String>();
				for(int i=0; i<jsonArr.length(); i++){
					names.add(jsonArr.getString(i));
				}
				
				for(String item: names){
					Log.v("Array Items", item);
				}
				
			}
			catch(JSONException e){
				e.printStackTrace();
			}
			
			return results;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			TextView line1 = (TextView) findViewById(R.id.line1);
			TextView line2 = (TextView) findViewById(R.id.line2);
			TextView line3 = (TextView) findViewById(R.id.line3);
			TextView line4 = (TextView) findViewById(R.id.line4);
			line1.setText("STOCK "+stcokSymbol);
			line2.setText("Days Low "+daysLow);
			line3.setText("Days High "+daysHigh);
			line4.setText("Change "+change);
		}
		
	}
	
}
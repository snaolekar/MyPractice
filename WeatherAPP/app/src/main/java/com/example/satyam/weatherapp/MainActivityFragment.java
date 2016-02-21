package com.example.satyam.weatherapp;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public MainActivityFragment() {
    }

    ArrayAdapter<String> mForeCastAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh_btn) {
            FetchWeatherTask weatherTask = new FetchWeatherTask();
            weatherTask.execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        String sampleData[] = {};
        List<String> weekForecast = new ArrayList<String>(Arrays.asList(sampleData));
        mForeCastAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                weekForecast);
        ListView listItem = (ListView) rootView.findViewById(R.id.list_view_forecast);
        listItem.setAdapter(mForeCastAdapter);
        FetchWeatherTask weatherTask = new FetchWeatherTask();
        weatherTask.execute();
        return rootView;
    }

    public String getWeatherData(String city, String country) {
        HttpURLConnection urlConnection = null;
        BufferedReader buffReader = null;
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=" + city + "," + country + "&units=metric&cnt=7&APPID=8e59baa6fc247eebaa0ef4533a6ccce0");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inpStream = urlConnection.getInputStream();
            StringBuffer buff = new StringBuffer();
            if (inpStream == null)
                return null;
            buffReader = new BufferedReader(new InputStreamReader(inpStream));
            String line;
            while ((line = buffReader.readLine()) != null) {
                buff.append(line + "\n");
            }
            if (buff.length() == 0)
                return null;
            return buff.toString();
        } catch (IOException e) {
            Log.e("IOException", "Could not open the connection", e);
            return null;
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (final IOException e) {
                    Log.e("IOException", "Could not close the reader", e);
                }
            }
        }
    }

    public class FetchWeatherTask extends AsyncTask<Void, Void, String[]> {
        String LOG_TAG = FetchWeatherTask.class.getSimpleName();

        @Override
        protected void onPostExecute(String[] result) {
            super.onPostExecute(result);
            mForeCastAdapter.clear();
            mForeCastAdapter.addAll(Arrays.asList(result));
        }

        @Override
        protected String[] doInBackground(Void... param) {
            String jsonData = getWeatherData("sarni", "in");
            try {
                double max_temp = WeatherDataParser.getMaxTemperatureForDay(jsonData, 3);
                Log.e(LOG_TAG, "success" + max_temp + " ");
                String results [];
                results = WeatherDataParser.getTemperatureForWeek(jsonData);
                return results;
//                for (String str : showList)
//                    Log.e(LOG_TAG, "success :" + str + "\n");
            } catch (Exception e) {
                Log.e(LOG_TAG, "ERROR" + e.toString());
            }
            return null ;
        }
    }
}

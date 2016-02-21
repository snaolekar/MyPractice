package com.example.satyam.weatherapp;

/**
 * Created by satyam on 14-02-2016.
 */
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    static final String deg = "\u2103";
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        JSONObject data = new JSONObject(weatherJsonStr);
        JSONArray listArr= data.getJSONArray("list");
        Log.e("TEST", listArr.toString());

        JSONObject indexObj = listArr.getJSONObject(dayIndex);
        JSONObject mainObj =  indexObj.getJSONObject("temp");
        double temp_max = mainObj.optDouble("max");
        if(!Double.isNaN(temp_max))
            return temp_max;
        return -1;
    }

    public static String[] getTemperatureForWeek(String weatherJsonStr)
            throws JSONException {
        JSONObject data = new JSONObject(weatherJsonStr);
        JSONArray listArr= data.getJSONArray("list");
        //Log.e("TEST", listArr.toString());
        String [] output = new String[7];
        int index=0;
        for (; index<7 ; index++){
            JSONObject obj = listArr.getJSONObject(index);
            String dt = obj.optString("dt");
            long dv= Long.valueOf(dt)*1000;
            String formatedDate = new SimpleDateFormat("EEE, MMM d, ''yy").format(new Date(dv));
            JSONObject mainObj = obj.getJSONObject("temp");
            double temp_max = mainObj.optDouble("max");
            if(Double.isNaN(temp_max))
                temp_max=-1;
            double temp_min = mainObj.optDouble("min");
            if(Double.isNaN(temp_min))
                temp_min=-1;
            output[index] = formatedDate+" "+temp_min+"/"+temp_max+" "+deg;
        }
        return output ;
    }

}

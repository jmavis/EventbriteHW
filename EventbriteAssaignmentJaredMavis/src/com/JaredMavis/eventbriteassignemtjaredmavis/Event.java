package com.JaredMavis.eventbriteassignemtjaredmavis;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * @author Jared Mavis
 *
 */
public class Event {
	private final String TAG = "Event";
	private long _id;
	private String _title;
	
	public Event(JSONObject jsonRepresentation) throws JSONException{
		Log.d(TAG + " Constructor", jsonRepresentation.toString());
		_id = (Long) jsonRepresentation.get("id");
		_title = (String) jsonRepresentation.get("title");
	}
	
	public String toString(){
	    StringBuilder convertedString = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    convertedString.append("ID: " + _id + NEW_LINE);
	    convertedString.append("Title: " + _title + NEW_LINE);
	    return (convertedString.toString());
	}
}

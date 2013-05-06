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
	private String _dateOfEvent;
	private String _eventDescription;
	
	public Event(JSONObject jsonRepresentation) throws JSONException{
		_id = (Long) jsonRepresentation.get("id");
		_title = (String) jsonRepresentation.get("title");
		_dateOfEvent = (String) jsonRepresentation.get("start_date");
		_eventDescription = (String) jsonRepresentation.get("description");
	}
	
	public String GetTitle(){
		return (_title);
	}
	
	public String GetDateOfEvent(){
		return (_dateOfEvent);
	}
	
	public String GetDesciprtion(){
		return (_eventDescription);
	}
	
	public String toString(){
	    StringBuilder convertedString = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    convertedString.append("ID: " + _id + NEW_LINE);
	    convertedString.append("Title: " + _title + NEW_LINE);
	    convertedString.append("Date: " + _dateOfEvent + NEW_LINE);
	    return (convertedString.toString());
	}
}

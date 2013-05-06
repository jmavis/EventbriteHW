package com.JaredMavis.eventbriteassigmentjaredmavis.ServerCommunication;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import com.JaredMavis.eventbriteassignmentjaredmavis.exceptions.ServerResponseException;

import android.util.Log;

public class EventCommunication extends ServerConnection {
	private final String TAG = "EventCommunication";
	private final String url = "http://www.eventbrite.com/json/event_search?app_key=NQE2XUB44E5EHKMYOR&keywords=super%20fun";
	
	/**
	 * GETS the listings server for the first x amount of listings
	 * 
	 * @return json array given by the url
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws JSONException
	 * @throws ServerResponseException 
	 */
	public JSONObject getEvents() throws ClientProtocolException,
			IOException, JSONException, ServerResponseException {
		String response = getDataFromURL(url);
		JSONObject jsonObj = new JSONObject(response);

		return jsonObj;
		/*
		if (isValidResponse(jsonObj)){
			return jsonObj;
		} else {
			throw new ServerResponseException(jsonObj); // if it went through but wasn't valid for some reason tell higher ups why
		}*/
	}
	
	/**
	 * Checks if the url response was valid by looking if it contains an error 
	 * 
	 * @return true if the response did not signify an error
	 */
	private boolean isValidResponse(JSONObject response){
		return (!response.has("error"));
	}
}

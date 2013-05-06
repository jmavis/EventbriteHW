package com.JaredMavis.eventbriteassigmentjaredmavis.ServerCommunication;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

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
	 */
	public JSONObject getEvents() throws ClientProtocolException,
			IOException, JSONException {
		String response = getDataFromURL(url);
		Log.d(TAG, "Got response " + response);
		JSONObject jsonObj = new JSONObject(response);

		return jsonObj;
	}
}

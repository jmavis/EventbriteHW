package com.JaredMavis.eventbriteassigmentjaredmavis.ServerCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public class ServerConnection {
	private final String TAG = "ServerConnection";
	
	/**
	 * Retrieves a string from the given url 
	 * @param url
	 * 	url to request data
	 * @return http response string
	 * @throws ClientProtocolException
	 * 	No Network Connection Established
	 * @throws IOException
	 *  No Server Connection
	 */
	protected String getDataFromURL(String url) throws ClientProtocolException,
			IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		HttpResponse response = client.execute(get);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				response.getEntity().getContent(), "UTF-8"));
		String responseLabel = reader.readLine();
		return responseLabel;
	}
}

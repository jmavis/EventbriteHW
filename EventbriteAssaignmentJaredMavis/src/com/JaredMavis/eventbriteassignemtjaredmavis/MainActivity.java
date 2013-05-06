package com.JaredMavis.eventbriteassignemtjaredmavis;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.JaredMavis.eventbriteassaignemtjaredmavis.R;
import com.JaredMavis.eventbriteassigmentjaredmavis.ServerCommunication.EventCommunication;
import com.JaredMavis.eventbriteassignmentjaredmavis.exceptions.ServerResponseException;

/**
 * @author Jared Mavis
 *
 */
public class MainActivity extends Activity {
	private final String TAG = "MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EventCommunication connection = new EventCommunication();
		try {
			JSONObject temp = connection.getEvents();
			JSONArray listEvents = temp.getJSONArray("events");
			Event first = new Event((JSONObject) ((JSONObject) listEvents.get(1)).get("event"));
			Log.d(TAG, "I read in the event: \n" + first);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ServerResponseException e) {
			Log.e(TAG, e.getError());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
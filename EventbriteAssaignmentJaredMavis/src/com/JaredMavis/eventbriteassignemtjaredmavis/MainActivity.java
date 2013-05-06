package com.JaredMavis.eventbriteassignemtjaredmavis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.JaredMavis.eventbriteassaignemtjaredmavis.R;
import com.JaredMavis.eventbriteassigmentjaredmavis.ServerCommunication.EventCommunication;
import com.JaredMavis.eventbriteassignmentjaredmavis.exceptions.ServerResponseException;
import com.JaredMavis.eventbriteassignmentjaredmavis.view.EventListAdapter;

/**
 * @author Jared Mavis
 * 
 */
public class MainActivity extends Activity {
	private final String TAG = "MainActivity";
	private ListView listView;
	private LinearLayout header;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		BindViews();

		LoadEvents eventLoader = new LoadEvents(this);
		eventLoader.execute("blah");
	}

	/**
	 * Loads the events from a given url then updates the list view. Takes the
	 * url to load as a string in param 0
	 * 
	 * @author Jared Mavis
	 * 
	 */
	private class LoadEvents extends AsyncTask<String, Void, List<Event>> {
		private Activity _context;
		
		public LoadEvents(Activity context) {
			super();
			_context = context;
		}
		
		protected List<Event> doInBackground(String... arg0) {
			EventCommunication connection = new EventCommunication();
			try {
				JSONObject temp = connection.getEvents();
				JSONArray listEvents = temp.getJSONArray("events");
				List<Event> events = new ArrayList<Event>();
				Log.d(TAG, "Read in " + listEvents.length());
				for (int i = 1; i < listEvents.length(); i++) {
					events.add(new Event((JSONObject) ((JSONObject) listEvents
							.get(i)).get("event")));
				}				
				Log.d(TAG, "Done");
				return events;
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (ServerResponseException e) {
				Log.e(TAG, e.getError());
			}
			return null;
		}

		protected void onPreExecute() {
			header.setVisibility(View.VISIBLE);
		}

		protected void onPostExecute(List<Event> result) {
			Log.d(TAG, "onPostExecute");
			if (result != null){
				EventListAdapter eventListAdapter = new EventListAdapter(_context,
						R.layout.event_row, result);
	
				listView.setAdapter(eventListAdapter);
				header.setVisibility(View.GONE);
			} else {
				ShowConnectionErrorToast();
			}
		}

	}

	private void ShowConnectionErrorToast() {
		Toast.makeText(getApplicationContext(),
				R.string.connection_issues_dialog, Toast.LENGTH_SHORT).show();
	}

	private void BindViews() {
		listView = (ListView) findViewById(R.id.listView);
		header = (LinearLayout) findViewById(R.id.headerProgress);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
package com.JaredMavis.eventbriteassignmentjaredmavis.view;

import org.json.JSONArray;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class EventListAdapter implements OnClickListener {
	private final String TAG = "EventListAdapter";
	
	private Activity _context;
	private JSONArray _eventList;
	
	public EventListAdapter(Activity context, JSONArray events){
		_context = context;
		_eventList = events;
	}
	
	private void fillView(View v){
		
	}
	
	@Override
	public void onClick(View arg0) {
	}
}
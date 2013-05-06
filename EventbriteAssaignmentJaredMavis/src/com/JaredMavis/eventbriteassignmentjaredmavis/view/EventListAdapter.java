package com.JaredMavis.eventbriteassignmentjaredmavis.view;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.JaredMavis.eventbriteassaignemtjaredmavis.R;
import com.JaredMavis.eventbriteassignemtjaredmavis.Event;

public class EventListAdapter extends ArrayAdapter<Event> implements OnClickListener{
	private final String TAG = "EventListAdapter";
	
	Context _context;
    int _layoutResourceId;   
    List<Event> _data = null;
	
	public EventListAdapter(Activity context, int layoutResourceId, List<Event> events){
		super(context, layoutResourceId, events);
		_context = context;
		_layoutResourceId = layoutResourceId;
		_data = events;
	}
	
	public void PopulateRow(View row){
		
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		EventViewHolder eventHolder = null;
		
		if (rowAllreadyLoaded(row)){
			eventHolder = (EventViewHolder) row.getTag();
		} else {
			LayoutInflater inflater = ((Activity) _context).getLayoutInflater();
			row = inflater.inflate(_layoutResourceId, null);
			row.setOnClickListener(this);
			
			eventHolder = new EventViewHolder();
			
			eventHolder.title = (TextView)row.findViewById(R.id.eventTitle);
			eventHolder.date = (TextView)row.findViewById(R.id.dateOfEvent);
			row.setTag(eventHolder);
		}
		
		Event event = _data.get(position);
		eventHolder.title.setText(event.GetTitle());	
		eventHolder.date.setText(event.GetDateOfEvent());
		
		return (row);
	}
	
	@Override
	public void onClick(View arg0) {
		Log.d(TAG, "Click");
	}
	
	private static class EventViewHolder{
		public TextView title;
		public TextView date;
	}
	
	private boolean rowAllreadyLoaded(View row){
		return (row != null);
	}
}
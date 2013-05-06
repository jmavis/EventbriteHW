/**
 * 
 */
package com.JaredMavis.eventbriteassaignemtjaredmavis.test;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.JaredMavis.eventbriteassignemtjaredmavis.Event;

/**
 * @author Jared Mavis
 *
 */
public class EventTest {
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=JSONException.class)
	public void NullJSONTest() {
		JSONObject emptyJson = null;
		try {
			Event eventTest = new Event(emptyJson);
		} catch (JSONException e) {}
	}

	@Test(expected=JSONException.class)
	public void EmptyJSONTest() {
		JSONObject emptyJson = new JSONObject();
		try {
			Event eventTest = new Event(emptyJson);
		} catch (JSONException e) {}
	}
}

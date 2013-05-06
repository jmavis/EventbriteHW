/**
 * 
 */
package com.JaredMavis.eventbriteassignmentjaredmavis.exceptions;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Jared Mavis
 * 
 */
public class ServerResponseException extends Exception {
	String errorType;
	String errorMessage;

	public ServerResponseException() {
		super();
		errorType = "unknown";
	}

	public ServerResponseException(JSONObject err) throws JSONException {
		JSONObject errorData = ((JSONObject) err.get("error"));
		errorType = errorData.getString("error_type");
		errorMessage = errorData.getString("error_message");
	}

	public String getError() {
		return (errorType + ": " + errorMessage);
	}
}

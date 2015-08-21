package com.pingdum.requestResources;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestService
{
    private final String urlToCheck;

    public HttpRequestService(String urlToCheck) {

        this.urlToCheck = urlToCheck;
    }

	public int makeRequest() throws IOException{

		URL url = new URL(urlToCheck);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		int statusCode = http.getResponseCode();

        return statusCode;
	}

}

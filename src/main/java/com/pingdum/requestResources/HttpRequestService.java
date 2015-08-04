package com.pingdum.requestResources;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestService
{
    private final String defaultUrl;

    public HttpRequestService(String defaultUrl) {

        this.defaultUrl = defaultUrl;
    }

	public int makeRequest() throws IOException{

		URL url = new URL(defaultUrl);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		int statusCode = http.getResponseCode();

        return statusCode;
	}

}

package com.iof.jlmc.booksearch;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BookClient {

    private static final String API_BASE_URL = "http://openlibrary.org/";
    private AsyncHttpClient client;

    public BookClient() {
        this.client = new AsyncHttpClient();
    }

    private String getApiBaseUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    // Methid for accessing the search API
    public void getBooks(final String query, JsonHttpResponseHandler handler) {
        try {
            String url = getApiBaseUrl("search.json?q=");
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        }  catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

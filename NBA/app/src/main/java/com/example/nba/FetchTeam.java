package com.example.nba;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchTeam extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mTeamName;

    protected String getRoster(String query) throws IOException {
        String apiURL = "https://www.balldontlie.io/api/v1/players";
        apiURL += query;

        URL requestURL = new URL(apiURL);
        HttpURLConnection urlConnection = (HttpURLConnection) requestURL.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }

        String jsonString = builder.toString();
        Log.d("FetchTeamTagJsonString", jsonString);
        return jsonString;
    }

    @Override
    protected String doInBackground(String... strings) {

        String jsonString = null;
        try {
            jsonString = getRoster(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    protected void  onPostExecute(String s){
        super.onPostExecute(s);
        String team = null;
        JSONObject jsonObject = null;
        JSONArray itemsArray = null;
        int i = 0;
        try{
            jsonObject = new JSONObject(s);
            itemsArray = jsonObject.getJSONArray("items");
            while (i<itemsArray.length() && (team == null){
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                title = volumeInfo.getString("title");
                author = volumeInfo.getString("authors");
                mAuthorText.get().setText(author);
                mTitleText.get().setText(title);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
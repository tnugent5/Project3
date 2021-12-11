package com.example.nba;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchTeam extends AsyncTask<String, Void, String> {
    private Intent intent;
    private Context context;

    FetchTeam(Intent intent, Context context) {
        this.intent = intent;
        this.context = context;
    }
//in onpostexecute is where youre gonna go to new activity

    protected String getRoster(String query) throws IOException {
        String apiURL = "https://www.balldontlie.io/api/v1/teams/";
        apiURL +=query;

        URL requestURL = new URL(apiURL);
        HttpURLConnection urlConnection = (HttpURLConnection) requestURL.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder builder = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        String jsonString = builder.toString();
        Log.d("jsonString", jsonString);
        return jsonString;
    }

    protected String doInBackground(String ... strings) {
        Log.d("FetTeamTag", "Inside FetchTeam thread");
        String jsonString = null;
        try {
            jsonString = getRoster(strings[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String abbreviation = null;
        String city = null;
        String conference = null;
        String division = null;
        String fullname = null;
        String name = null;
        JSONObject jsonObject = null;
        JSONArray itemsArray = null;
        int i = 0;
        try{
            jsonObject = new JSONObject(s);
            itemsArray = jsonObject.getJSONArray("items");
            while(i< itemsArray.length() && (abbreviation == null && city == null && conference == null && division == null && fullname == null && name == null)) {
                JSONObject team = itemsArray.getJSONObject(i);
                JSONObject teaminfo = team.getJSONObject("teaminfo");

                abbreviation = teaminfo.getString("abbreviation");
                city = teaminfo.getString("city");
                conference = teaminfo.getString("conference");
                division = teaminfo.getString("division");
                fullname = teaminfo.getString("fullname");
                name = teaminfo.getString("name");

                //maybe put logds

                if(abbreviation != null && city != null && conference != null && division != null && fullname != null && name != null) {

                }
                else{

                }
                i++;

            }

        Bundle teamInfo = intent.getExtras();
        teamInfo.putString("ABB", abbreviation);
        teamInfo.putString("CITY", city);
        teamInfo.putString("CONF", conference);
        teamInfo.putString("DIV", division);
        teamInfo.putString("FNAME", fullname);
        teamInfo.putString("NAME", name);
        intent.putExtras(teamInfo);
        context.startActivity(intent);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
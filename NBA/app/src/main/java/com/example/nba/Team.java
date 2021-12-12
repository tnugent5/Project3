package com.example.nba;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;

public class Team extends AppCompatActivity {
        private TextView mAbb;
        private TextView mCity;
        private TextView mConf;
        private TextView mDiv;
        private TextView mFullName;
        private TextView mTeamName;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.team_roster);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            Intent intent = getIntent();
            Bundle teamInfo = intent.getExtras();
            String abb_string = teamInfo.getString("ABB");
            String city_string = teamInfo.getString("CITY");
            String conf_string = teamInfo.getString("CONF");
            String div_string = teamInfo.getString("DIV");
            String full_string = teamInfo.getString("FNAME");
            String name_string = teamInfo.getString("NAME");
            Log.d("ABB", abb_string);
            Log.d("CITY", city_string);
            Log.d("CONF", conf_string);
            Log.d("DIV", div_string);
            Log.d("FNAME", full_string);
            Log.d("NAME", name_string);
            mAbb = (TextView) findViewById(R.id.abbView);
            mAbb.setText(name_string);
            mCity = (TextView) findViewById(R.id.cityView);
            mCity.setText(name_string);
            mConf = (TextView) findViewById(R.id.confView);
            mConf.setText(name_string);
            mDiv = (TextView) findViewById(R.id.divView);
            mDiv.setText(name_string);
            mFullName = (TextView) findViewById(R.id.fullView);
            mFullName.setText(name_string);
            mTeamName = (TextView) findViewById(R.id.teamView);
            mTeamName.setText(name_string);


        }

    }


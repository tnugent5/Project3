package com.example.nba;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

    public class Team extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.team_roster);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //mTeamName = (EditText) findViewById(R.id.teamName);

        }

    }


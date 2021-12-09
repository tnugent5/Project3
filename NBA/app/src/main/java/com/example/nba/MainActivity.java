package com.example.nba;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private final LinkedList<String> mTeamsList = new LinkedList<>();
    private TeamAdaptor mAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeamsList.add("Atlanta Hawks");
        mTeamsList.add("Boston Celtics");
        mTeamsList.add("Brooklyn Nets");
        mTeamsList.add("Charlotte Hornets");
        mTeamsList.add("Chicago Bulls");
        mTeamsList.add("Cleveland Cavaliers");
        mTeamsList.add("Dallas Mavericks");
        mTeamsList.add("Denver Nuggets");
        mTeamsList.add("Detroit Pistons");
        mTeamsList.add("Golden State Warriors");
        mTeamsList.add("Houston Rockets");
        mTeamsList.add("Indiana Pacers");
        mTeamsList.add("Los Angeles Clippers");
        mTeamsList.add("Los Angeles Lakers");
        mTeamsList.add("Memphis Grizzlies");
        mTeamsList.add("Miami Heat");
        mTeamsList.add("Milwaukee Bucks");
        mTeamsList.add("Minnesota Timberwolves");
        mTeamsList.add("New Orleans Pelicans");
        mTeamsList.add("New York Knicks");
        mTeamsList.add("Oklahoma City Thunder");
        mTeamsList.add("Orlando Magic");
        mTeamsList.add("Philadelphia 76ers");
        mTeamsList.add("Phoenix Suns");
        mTeamsList.add("Portland Trail Blazers");
        mTeamsList.add("Sacramento Kings");
        mTeamsList.add("San Antonio Spurs");
        mTeamsList.add("Toronto Raptors");
        mTeamsList.add("Utah Jazz");
        mTeamsList.add("Washington Wizards");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdaptor = new TeamAdaptor(this, mTeamsList);
        mRecyclerView.setAdapter(mAdaptor);

    }
}
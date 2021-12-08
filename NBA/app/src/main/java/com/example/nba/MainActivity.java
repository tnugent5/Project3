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

        mTeamsList.add("Philadelphia 76ers");
        mTeamsList.add("Los Angeles Lakers");
        mTeamsList.add("Chicago Bulls");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdaptor = new TeamAdaptor(this, mTeamsList);
        mRecyclerView.setAdapter(mAdaptor);


    }
}
package com.example.nba;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class TeamAdaptor extends RecyclerView.Adapter<TeamAdaptor.TeamsViewHolder>{

    private LayoutInflater mInflater;
    private LinkedList<String> mTeamsList;
    private Context context;

    public TeamAdaptor(Context context, LinkedList<String> teamslist) {
        mInflater = LayoutInflater.from(context);
        mTeamsList = teamslist;
        this.context = context;

    }

    @NonNull
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.team_item, parent, false);
        return new TeamsViewHolder(mItemView, this);
    }

    public void onBindViewHolder (@NonNull TeamsViewHolder holder,int position){
        String mCurrent = mTeamsList.get(position);
        holder.mTeamItemView.setText(mCurrent);
    }

    public int getItemCount() {
        return mTeamsList.size();
    }

    class TeamsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTeamItemView;
        private TeamAdaptor adaptor;

        public TeamsViewHolder(View itemView, TeamAdaptor adaptor) {
            super(itemView);
            mTeamItemView = itemView.findViewById(R.id.team);
            this.adaptor = adaptor;
            itemView.setOnClickListener(this);
        }
        public void onClick(View v) {
            Intent intent = new Intent(context, Team.class);
            context.startActivity(intent);
            Log.d("Inside Click", "Inside click");
            FetchTeam ft = new FetchTeam(intent, context);
            ft.execute("14");
        }
    }
}

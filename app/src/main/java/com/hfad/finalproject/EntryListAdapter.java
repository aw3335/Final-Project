package com.hfad.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EntryListAdapter extends RecyclerView.Adapter<EntryListAdapter.ScoreViewHolder> {

    private ArrayList<Entry> scoresList;
    private Context context;

    public EntryListAdapter(Context c)
    {
        context = c;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(context).inflate(R.layout.score_item, parent, false);
        return new ScoreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {
        Entry entry = scoresList.get(position);
        holder.setData(entry, position);
    }

    @Override
    public int getItemCount() {
        return scoresList.size();
    }

    public void setEntries(ArrayList<Entry> entries) {
        scoresList = entries;
        notifyDataSetChanged();
        notifyItemRangeChanged(0, scoresList.size());

    }

    class ScoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private int currentPos = -1;
        private Entry currentEnt = null;

        public ScoreViewHolder(View view)
        {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);
        }

        public void setData(Entry e, int pos)
        {
            currentPos = pos;
            currentEnt = e;

            TextView txtName = itemView.findViewById(R.id.txt_name);
            TextView txtGame = itemView.findViewById(R.id.txt_game);
            TextView txtPoints = itemView.findViewById(R.id.txt_points);

            txtName.setText(e.getName());
            txtGame.setText(e.getGame());
            txtPoints.setText(e.getScore() + " Points");

        }

        public void onClick(View view)
        {
            //show dialog
        }


    }


}

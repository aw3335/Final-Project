package com.hfad.finalproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * This class is a list adapter to add entries to the recycler view
 */
public class EntryListAdapter extends RecyclerView.Adapter<EntryListAdapter.ScoreViewHolder> {

    private ArrayList<Entry> scoresList; //arraylist of entries
    private Context context; //current context
    private FragmentManager manager; //fragment manager

    /**
     * Constructor
     * @param c - context
     * @param fm - fragment manager
     */
    public EntryListAdapter(Context c, FragmentManager fm)
    {
        context = c;
        manager = fm;
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

    /**
     * This class is a view holder for an individual row
     */
    class ScoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private int currentPos = -1; //current position in list
        private Entry currentEnt = null; //current entry at position

        /**
         * Constructor
         * @param view - current view
         */
        public ScoreViewHolder(View view)
        {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);
        }

        /**
         * Adds data of entry to row in recycler view
         * @param e - entry to add
         * @param pos - position in list
         */
        public void setData(Entry e, int pos)
        {
            currentPos = pos; //position in list
            currentEnt = e; //entry to add

            //Get java handlers for XML objects
            TextView txtName = itemView.findViewById(R.id.txt_name);
            TextView txtGame = itemView.findViewById(R.id.txt_game);
            TextView txtPoints = itemView.findViewById(R.id.txt_points);

            //Fill in XML objects with text
            txtName.setText(e.getName());
            txtGame.setText(e.getGame());
            txtPoints.setText(e.getScore() + " Points");

        }

        //On click, show row dialog
        public void onClick(View view)
        {
            DialogEntry dialog = new DialogEntry(currentEnt, EntryListAdapter.this, scoresList);
            dialog.show(manager, "");
        }


    }


}

package com.hfad.finalproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

/**
 * This class is for a dialog when the user
 * selects a row in the recycler view
 */
public class DialogEntry extends DialogFragment {

    private Entry currentEntry; //Whichever entry was selected
    private EntryListAdapter adapter; //List adapter
    private ArrayList<Entry> entryList; //Entire list

    /**
     * Constructor
     * @param current - current entry
     * @param a - list adapter
     * @param e - arraylist of entries
     */
    public DialogEntry(Entry current, EntryListAdapter a, ArrayList<Entry> e)
    {
        currentEntry = current;
        adapter = a;
        entryList = e;
        this.setCancelable(false);
    }

    /**
     * Override for onCreateDialog
     * @param savedInstanceState
     * @return
     */
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_entry, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Get handles for objects
        TextView lblName = dialogView.findViewById(R.id.lbl_name);
        TextView lblGame = dialogView.findViewById(R.id.lbl_game);
        TextView lblScore = dialogView.findViewById(R.id.lbl_score);
        Button btnDelete = dialogView.findViewById(R.id.btn_delete);
        Button btnClose = dialogView.findViewById(R.id.btn_close);

        //Fill out text views with info
        lblName.setText(currentEntry.getName());
        lblGame.setText(currentEntry.getGame());
        lblScore.setText(currentEntry.getScore() + " Points");

        DBHelper dbHelper = new DBHelper(getContext());

        //When delete button is clicked...
        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dbHelper.deleteEntry(currentEntry.getId()); //...delete entry from database
                entryList.remove(currentEntry); //...and delete entry from list

                //notify of change
                adapter.notifyDataSetChanged();
                adapter.notifyItemRangeChanged(0, entryList.size());
                dismiss();
            }
        });

        //When close button is clicked, close dialog
        btnClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dismiss();
            }
        });

        builder.setView(dialogView);

        return builder.create();

    }


}

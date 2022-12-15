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

public class DialogEntry extends DialogFragment {

    private Entry currentEntry;
    private EntryListAdapter adapter;
    private ArrayList<Entry> entryList;

    public DialogEntry(Entry current, EntryListAdapter a, ArrayList<Entry> e)
    {
        currentEntry = current;
        adapter = a;
        entryList = e;
        this.setCancelable(false);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_entry, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        TextView lblName = dialogView.findViewById(R.id.lbl_name);
        TextView lblGame = dialogView.findViewById(R.id.lbl_game);
        TextView lblScore = dialogView.findViewById(R.id.lbl_score);
        Button btnDelete = dialogView.findViewById(R.id.btn_delete);
        Button btnClose = dialogView.findViewById(R.id.btn_close);

        lblName.setText(currentEntry.getName());
        lblGame.setText(currentEntry.getGame());
        lblScore.setText(currentEntry.getScore() + " Points");

        DBHelper dbHelper = new DBHelper(getContext());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dbHelper.deleteEntry(currentEntry.getId());
                entryList.remove(currentEntry);
                adapter.notifyDataSetChanged();
                adapter.notifyItemRangeChanged(0, entryList.size());
                dismiss();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dismiss();
            }
        });





        builder.setView(dialogView);

        return builder.create();

    }


}

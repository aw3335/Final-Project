package com.hfad.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HighScore#} factory method to
 * create an instance of this fragment.
 */
public class HighScore extends Fragment {

    private EntryListAdapter entryListAdapter;
    private DBHelper dbHelper;
    private View thisView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisView = inflater.inflate(R.layout.fragment_high_score, container, false);

        dbHelper = new DBHelper(getContext());
        entryListAdapter = setUpRecyclerView();

        ImageView imgTicTacToe = thisView.findViewById(R.id.imgTicTacToe);
        ImageView imgHangMan = thisView.findViewById(R.id.imgHangman);
        ImageView imgHome = thisView.findViewById(R.id.imgHome);

        imgTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogTicTacToe dialog = new DialogTicTacToe(R.id.action_highScore_to_ticTacToe);
                dialog.show(getActivity().getSupportFragmentManager(), "");
            }
        });

        imgHangMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_highScore_to_hangMan);
            }
        });

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_highScore_to_mainMenu2);
            }
        });


        return thisView;
    }

    private EntryListAdapter setUpRecyclerView()
    {
        RecyclerView rv = thisView.findViewById(R.id.recyclerView);

        EntryListAdapter entListAdapter = new EntryListAdapter(getContext(), getActivity().getSupportFragmentManager());
        ArrayList<Entry> entries = dbHelper.fetchAllEntries();
        entListAdapter.setEntries(entries);

        rv.setAdapter(entListAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);

        return entListAdapter;
    }






}
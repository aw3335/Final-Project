package com.hfad.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HighScore#} factory method to
 * create an instance of this fragment.
 */
public class HighScore extends Fragment {

    private DBHelper dbHelper; //database helper
    private View thisView; //current view

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisView = inflater.inflate(R.layout.fragment_high_score, container, false);

        dbHelper = new DBHelper(getContext()); //create dbhelper
        EntryListAdapter entryListAdapter = setUpRecyclerView(); //set up recyclerview

        //Get java handles for xml objects
        ImageView imgTicTacToe = thisView.findViewById(R.id.imgTicTacToe);
        ImageView imgHangMan = thisView.findViewById(R.id.imgHangman);
        ImageView imgHome = thisView.findViewById(R.id.imgHome);

        //Go back to tictactoe
        imgTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogTicTacToe dialog = new DialogTicTacToe(R.id.action_highScore_to_ticTacToe);
                dialog.show(getActivity().getSupportFragmentManager(), "");
            }
        });

        //Go back to hangman
        imgHangMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_highScore_to_hangMan);
            }
        });

        //Go back to home screen
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_highScore_to_mainMenu2);
            }
        });

        return thisView;
    }

    /**
     * Set up recycler view for screen
     * @return - list adapter
     */
    private EntryListAdapter setUpRecyclerView()
    {
        //Get ID for recycler view
        RecyclerView rv = thisView.findViewById(R.id.recyclerView);

        //Create adapter, get all entries, and add them to adapter
        EntryListAdapter entListAdapter = new EntryListAdapter(getContext(), getActivity().getSupportFragmentManager());
        ArrayList<Entry> entries = dbHelper.fetchAllEntries();
        entListAdapter.setEntries(entries);

        rv.setAdapter(entListAdapter); //set adapter

        //Create and set layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);

        return entListAdapter;
    }







}
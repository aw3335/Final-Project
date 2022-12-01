package com.hfad.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HangMan#} factory method to
 * create an instance of this fragment.
 */
public class HangMan extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hang_man, container, false);

        ImageView imgTicTacToe = view.findViewById(R.id.imgTicTacToe);
        ImageView imgHome = view.findViewById(R.id.imgHome);
        ImageView imgScore = view.findViewById(R.id.imgScore);

        imgTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("\n\n We are at TicTacToe!!!");
//                DialogTicTacToe dialog = new DialogTicTacToe();
//                dialog.onCreateDialog(savedInstanceState);
                Navigation.findNavController(v).navigate(R.id.action_hangMan_to_ticTacToe);
            }
        });

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_hangMan_to_mainMenu);
            }
        });

        imgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_hangMan_to_highScore);
            }
        });

        return view;
    }
}
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
 * Use the {@link Score#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Score extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        ImageView imgTicTacToe = view.findViewById(R.id.imgTicTacToe);
        ImageView imgHangMan = view.findViewById(R.id.imgHangman);
        ImageView imgHome = view.findViewById(R.id.imgHome);

        imgTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("\n\n We are at TicTacToe!!!");
                DialogTicTacToe dialog = new DialogTicTacToe();
                dialog.onCreateDialog(savedInstanceState);
                Navigation.findNavController(v).navigate(R.id.action_highScore_to_ticTacToe);
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
        return view;
    }
}
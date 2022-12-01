package com.hfad.finalproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainMenu#} factory method to
 * create an instance of this fragment.
 */
public class MainMenu extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        ImageView imgTicTacToe = view.findViewById(R.id.imgTicTacToe);
        ImageView imgHangMan = view.findViewById(R.id.imgHangman);
        ImageView imgHome = view.findViewById(R.id.imgHome);
        ImageView imgScore = view.findViewById(R.id.imgScore);

        imgTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("\n\n We are at TicTacToe!!!");
//                DialogTicTacToe dialog = new DialogTicTacToe();
//                dialog.onCreateDialog(savedInstanceState);
                Navigation.findNavController(v).navigate(R.id.action_mainMenu_to_ticTacToe);
            }
        });

        imgHangMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainMenu_to_hangMan);
            }
        });

        imgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainMenu_to_highScore);
            }
        });
        return view;
    }
}
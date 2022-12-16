package com.hfad.finalproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Fragment MainMenu is where the application starts and allows the user to proceed to
 * either one of the games or the current High score
 */
public class MainMenu extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        //Connects the variables to the layout file
        ImageView imgTicTacToe = view.findViewById(R.id.imgTicTacToe);
        ImageView imgHangMan = view.findViewById(R.id.imgHangman);
        ImageView imgScore = view.findViewById(R.id.imgScore);
        ImageView imgRockPaperScissor = view.findViewById(R.id.RockPaperScissor);

        //If the image for the TicTacToe is clicked on then create a new dialog and show it to the user
        imgTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogTicTacToe dialog = new DialogTicTacToe(R.id.action_mainMenu_to_ticTacToe);
                dialog.show(getActivity().getSupportFragmentManager(), "");

            }
        });

        //If the image for the Hangman is clicked on then proceed to the hangman game where
        //you will be prompted for a name
        imgHangMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Navigation.findNavController(v).navigate(R.id.action_mainMenu_to_hangMan);
        }});

        //If the score image is clicked on the proceed to the recycler view of the current high scores
        imgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainMenu_to_highScore);
            }
        });

        imgRockPaperScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogRPS dialog = new DialogRPS(R.id.action_hangMan_to_RPS);
                dialog.show(getActivity().getSupportFragmentManager(), "");
            }
        });


        return view;
    }
}
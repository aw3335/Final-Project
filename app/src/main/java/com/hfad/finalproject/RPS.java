package com.hfad.finalproject;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class RPS extends Fragment{

    //The Player who is playing
    public static String player;
    //The words that one will be chosen randomly to play with
    public static final String[] WORDS = {
            "ROCK", "PAPER", "SCISSORS"
    };

    //Creates a random variable that will help draw a random word from the words arraylist
    private Random random = new Random();
    //This will hold the word once checked if the user has another character left
    private String enemyAction;

    //How many lives the user has
    private int lives = 3;
    //What hangman image is being diplayed depending on the lives left
    private int Image = 0;
    //Enemy lives
    private int enemylives = 3;
    private int index = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_r_p_s, container, false);

        //Generates a new dialog and display it to the user to get player name
        DialogRPS dialog = new DialogRPS();
        dialog.show(getActivity().getSupportFragmentManager(), "");

        //Connect the menu buttons so they can work between the fragments
        ImageView imgTicTacToe = view.findViewById(R.id.imgTicTacToe);
        ImageView imgHangMan = view.findViewById(R.id.imgHangman);
        ImageView imgHome = view.findViewById(R.id.imgHome);
        ImageView imgScore = view.findViewById(R.id.imgScore);
        TextView tvLives = view.findViewById(R.id.tvLives);

        //When the menu buttons are clicked go to that fragment
        imgTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogTicTacToe dialog = new DialogTicTacToe(R.id.action_RPS_to_ticTacToe);
                dialog.show(getActivity().getSupportFragmentManager(), "");
            }
        });
        imgHangMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_RPS_to_hangMan);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_RPS_to_mainMenu);
            }
        });
        imgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_RPS_to_highScore);
            }
        });

        //********************************************************************************
        //Start of code
        //********************************************************************************

        //This will hold the chosen random action from the words arraylist to be used in
        //the current session of the game


        //Gathers the random words and puts it into the variable word
        index = random.nextInt(WORDS.length);
        enemyAction = WORDS[index];

        //Sets the on screen text to the length of the word in '_'
        TextView tvWord = view.findViewById(R.id.wordToFindTv);
        tvWord.setText("");

        //Connects all the buttons and the hangman image so it can be called on
        ImageView rpsPic = view.findViewById(R.id.imgDraw);
        Button btnA = view.findViewById(R.id.btnA);
        Button btnB = view.findViewById(R.id.btnB);
        Button btnC = view.findViewById(R.id.btnC);

        //For each button call the buttonClicked method and send the required arguments
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnA, enemyAction, tvWord, tvLives, rpsPic);

            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnB, enemyAction, tvWord, tvLives, rpsPic);
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnC, enemyAction, tvWord, tvLives, rpsPic);
            }
        });


        return view;
    }

    /**
     * Every time a button is clicked run through this code to see if the player has either
     * got a correct guess or if the player has won or lost
     * @param view The view of the screen
     * @param btn The button that has been pressed
     * @param enemyAction The action that has been randomly chosen
     * @param tvWord The string that is currently being displayed to user at that time
     * @param tvLives The amount of lives left for the user to continue playing
     */
    public void buttonClicked(View view, Button btn, String word, TextView tvWord, TextView tvLives, ImageView hangPic) throws InterruptedException {
        String name = player;
        checker((String) btn.getText());
        tvWord.setText(result(true));
        Thread.sleep(3000);
        //If the enemy lives are 0 the user won and the game is over
        //If the user lives are 0 the user lost and the game is over
        if(lives == 0 || enemylives == 0) {
            RPSDirections.ActionRPSToResults action =
                    RPSDirections.actionRPSToResults(name, lives, "RPS");
            Navigation.findNavController(view).navigate(action);

        }

        tvWord.setText(result(false));
        newRound();
    }

    // THE GAME
    public String result(Boolean x) {
        if (x){
            return enemyAction;
        }
        return "";

    }
    public void newRound(){
        index = random.nextInt(WORDS.length);
        enemyAction = WORDS[index];
    }
    public void checker(String abc){
        if (index == WORDS.length){
            if (Objects.equals(abc, WORDS[0]))
                enemylives-=1;
            if (Objects.equals(abc, WORDS[WORDS.length - 1]))
                lives-=1;
        } else if (Objects.equals(abc, WORDS[0])) {
            if (Objects.equals(enemyAction, WORDS[1]))
                lives -= 1;
        } else {
            if(Objects.equals(WORDS[index + 1], abc))
                enemylives-=1;
        }

    }




}

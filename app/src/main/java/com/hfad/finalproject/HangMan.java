package com.hfad.finalproject;

import android.content.Context;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 *Class Hangman Allows the user to Play the classic game HangMan
 */
public class HangMan extends Fragment {

    //The Player who is playing
    public static String player;
    //The words that one will be chosen randomly to play with
    public static final String[] WORDS = {
            "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE",
            "CASE", "CATCH", "CHAR", "CLASS", "CONST",
            "CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE",
            "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY",
            "FLOAT", "FOR", "GOTO", "IF", "IMPLEMENTS",
            "IMPORT", "INSTANCEOF", "INT", "INTERFACE",
            "LONG", "NATIVE", "NEW", "NULL", "PACKAGE",
            "PRIVATE", "PROTECTED", "PUBLIC", "RETURN",
            "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH",
            "SYNCHRONIZED", "THIS", "THROW", "THROWS",
            "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE"
    };

    //Creates a random variable that will help draw a random word from the words arraylist
    private Random random = new Random();
    //This will hold the word once checked if the user has another character left
    private String updatedWord;

    //How many lives the user has to guess the word
    private int lives = 6;
    //What hangman image is being diplayed depending on the lives left
    private int Image = 0;

    //HangDraws arraylist that holds all the hangman images that are used in the game
    ArrayList<Integer> hangDraws = new ArrayList<Integer>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hang_man, container, false);

        //Generates a new dialog and display it to the user to get player name
        DialogHangman dialog = new DialogHangman();
        dialog.show(getActivity().getSupportFragmentManager(), "");

        //Connect the menu buttons so they can work between the fragments
        ImageView imgTicTacToe = view.findViewById(R.id.imgTicTacToe);
        ImageView imgHome = view.findViewById(R.id.imgHome);
        ImageView imgScore = view.findViewById(R.id.imgScore);
        TextView tvLives = view.findViewById(R.id.tvLives);

        //Adds all the hangman images to the hangdraw arraylist
        hangDraws.add(R.drawable.hang1);
        hangDraws.add(R.drawable.hang2);
        hangDraws.add(R.drawable.hang3);
        hangDraws.add(R.drawable.hang4);
        hangDraws.add(R.drawable.hang5);
        hangDraws.add(R.drawable.hang6);

        //When the menu buttons are clicked go to that fragment
        imgTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogTicTacToe dialog = new DialogTicTacToe(R.id.action_hangMan_to_ticTacToe);
                dialog.show(getActivity().getSupportFragmentManager(), "");
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


        //********************************************************************************
        //Start of hangman code
        //********************************************************************************

        //This will hold the chosen random word from the words arraylist to be used in
        //the current session of the game
        String word;

        //Gathers the random words and puts it into the variable word
        int index = random.nextInt(WORDS.length);
        word = WORDS[index];

        //Sets the on screen text to the length of the word in '_'
        TextView tvWord = view.findViewById(R.id.wordToFindTv);
        tvWord.setText("");
        for(int i = 0; i < word.length(); i++)
        {
            tvWord.setText(tvWord.getText() + "_ ");
        }

        //Connects all the buttons and the hangman image so it can be called on
        ImageView hangPic = view.findViewById(R.id.imgDraw);
        Button btnA = view.findViewById(R.id.btnA);
        Button btnB = view.findViewById(R.id.btnB);
        Button btnC = view.findViewById(R.id.btnC);
        Button btnD = view.findViewById(R.id.btnD);
        Button btnE = view.findViewById(R.id.btnE);
        Button btnF = view.findViewById(R.id.btnF);
        Button btnG = view.findViewById(R.id.btnG);
        Button btnH = view.findViewById(R.id.btnH);
        Button btnI = view.findViewById(R.id.btnI);
        Button btnJ = view.findViewById(R.id.btnJ);
        Button btnK = view.findViewById(R.id.btnK);
        Button btnL = view.findViewById(R.id.btnL);
        Button btnM = view.findViewById(R.id.btnM);
        Button btnN = view.findViewById(R.id.btnN);
        Button btnO = view.findViewById(R.id.btnO);
        Button btnP = view.findViewById(R.id.btnP);
        Button btnQ = view.findViewById(R.id.btnQ);
        Button btnR = view.findViewById(R.id.btnR);
        Button btnS = view.findViewById(R.id.btnS);
        Button btnT = view.findViewById(R.id.btnT);
        Button btnU = view.findViewById(R.id.btnU);
        Button btnV = view.findViewById(R.id.btnV);
        Button btnW = view.findViewById(R.id.btnW);
        Button btnX = view.findViewById(R.id.btnX);
        Button btnY = view.findViewById(R.id.btnY);
        Button btnZ = view.findViewById(R.id.btnZ);

        //For each button call the buttonClicked method and send the required arguments
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnA, word, tvWord, tvLives, hangPic);

            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnB, word, tvWord, tvLives, hangPic);
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnC, word, tvWord, tvLives, hangPic);
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnD, word, tvWord, tvLives, hangPic);
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnE, word, tvWord, tvLives, hangPic);
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnF, word, tvWord, tvLives, hangPic);
            }
        });
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnG, word, tvWord, tvLives, hangPic);
            }
        });
        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnH, word, tvWord, tvLives, hangPic);
            }
        });
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnI, word, tvWord, tvLives, hangPic);
            }
        });
        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnJ, word, tvWord, tvLives, hangPic);
            }
        });
        btnK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnK, word, tvWord, tvLives, hangPic);
            }
        });
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnL, word, tvWord, tvLives, hangPic);
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnM, word, tvWord, tvLives, hangPic);
            }
        });
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnN, word, tvWord, tvLives, hangPic);
            }
        });
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnO, word, tvWord, tvLives, hangPic);
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnP, word, tvWord, tvLives, hangPic);
            }
        });
        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnQ, word, tvWord, tvLives, hangPic);
            }
        });
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnR, word, tvWord, tvLives, hangPic);
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnS, word, tvWord, tvLives, hangPic);
            }
        });
        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnT, word, tvWord, tvLives, hangPic);
            }
        });
        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnU, word, tvWord, tvLives, hangPic);
            }
        });
        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnV, word, tvWord, tvLives, hangPic);
            }
        });
        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnW, word, tvWord, tvLives, hangPic);
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnX, word, tvWord, tvLives, hangPic);
            }
        });
        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnY, word, tvWord, tvLives, hangPic);
            }
        });
        btnZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(view,btnZ, word, tvWord, tvLives, hangPic);
            }
        });

        return view;
    }

    /**
     * Every time a button is clicked run through this code to see if the player has either
     * got a correct guess or if the player has won or lost
     * @param view The view of the screen
     * @param btn The button that has been pressed
     * @param word The word that has been randomly chosen
     * @param tvWord The string that is currently being displayed to user at that time
     * @param tvLives The amount of lives left for the user to continue playing
     * @param hangPic The hangman picture that is currently displayed to the user
     */
    public void buttonClicked(View view, Button btn, String word, TextView tvWord, TextView tvLives, ImageView hangPic)
    {

        //Checks to see if the letter is in the word and updates accordingly
        updatedWord = checkLetter(word, btn, tvWord, tvLives, hangPic);
        //Sets a new string to string returned from the checkLetter
        String newWord = setText(updatedWord);
        //Sets the displayed text to either the same thing or the update word with a new letter
        tvWord.setText(newWord);
        //Sets that button to be not clickable
        btn.setClickable(false);
        //Sets the background color of that button to black to show user that they cant click it again
        btn.setBackgroundColor(Color.BLACK);
        //Genereates a string with the players name
        String name = player;
        //If the displayed word does not contain any '_' then the word has
        // been guessed and the user won
        if(!tvWord.getText().toString().contains("_"))
        {
            HangManDirections.ActionHangManToResults action =
                    HangManDirections.actionHangManToResults(name, lives, "Hangman");
            Navigation.findNavController(view).navigate(action);
        }
        //If the user lives are 0 the the user lost and the game is over
        if(lives == 0)
        {
            HangManDirections.ActionHangManToResults action =
                    HangManDirections.actionHangManToResults(name, lives, "Hangman");
            Navigation.findNavController(view).navigate(action);

        }
    }

    /**
     * CheckLetter that takes in the button being pressed and determines if it is in the chosen word
     * @param word The chosen random word
     * @param btn The button that was pressed
     * @param tvWord The displayed text on screen
     * @param tvLives The current user lives left
     * @param hangPic The hangman picture currently on screen
     * @return A string with the new update word
     */
    public String checkLetter(String word, Button btn, TextView tvWord, TextView tvLives, ImageView hangPic)
    {
        //The new word after being updated
        String updateWord = "";
        //The word that was displayed on screen
        String tvGuess = tvWord.getText().toString();
        //Holds the on screen word after being changed
        String secWord = "";
        //Loops through the on screen word and gets rid of any spaces so it become the
        //same length as the chosen word
        for(int k = 0 ; k <tvGuess.length(); k++)
        {
            if(tvGuess.charAt(k) != ' ')
            {
                secWord += tvGuess.charAt(k);
            }
        }
        //Sets the onScreen variable to the newSecondWod
        tvGuess = secWord;
        //Prints out for error checking
        System.out.println("GUESS: " + tvGuess);

        //For the chosen word, loop through the chosen button and if that character is in the word then
        //Add is to the newWord variable. Secondly, if the character being looked at is not a '_' then
        // keep the character there because it is a letter already guessed. If none of those then just
        // add '_' signifying that it has not been guessed yet.
        for(int i = 0; i < word.length(); i++)
        {
            if(btn.getText().charAt(0) == word.charAt(i)) {
                updateWord = updateWord + word.charAt(i);
            }
            else if(tvGuess.charAt(i) != word.charAt(i))
            {
                updateWord = updateWord + "_";
            }
            else
            {
                System.out.println("Test");
                updateWord = updateWord + tvGuess.charAt(i);
            }
        }
        //Print out for error checking
        System.out.println(updateWord);

        //If there has been not update to the word then the user guessed wrong and their lives
        // are deducted by one and the next hangman image is displayed
        if(tvGuess.equals(updateWord))
        {
            lives--;
            tvLives.setText("Lives: " + lives);
            hangPic.setImageResource(hangDraws.get(Image));
            Image++;
        }

        //Return the new updated word
        return updateWord;

    }

    /**
     * setText takes in the newWords and formats it so its ready to be displayed to the user
     * @param newWord The new word sent back by the checkLetter function
     * @return The new word correctly formatted for on screen display
     */
    public String setText(String newWord)
    {
        //Create a second string to hold the updated word
        String word = "";
        //For each character in the word add a space between each one
        for(int i = 0; i < newWord.length(); i++)
        {
            word += newWord.charAt(i) + " ";
        }
        //Test for error checking
        System.out.println("WORD: " + word);

        //Returns the correctly formatted word
        return word;
    }

}

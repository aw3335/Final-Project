package com.hfad.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HangMan#} factory method to
 * create an instance of this fragment.
 */
public class HangMan extends Fragment {
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

        //Start of hangman code





        return view;
    }
}





//
//    public static final Random RANDOM = new Random();
//
//    // Max errors before user lose
//    public static final int MAX_ERRORS = 6;
//    // Word to find
//    private String wordToFind;
//    // Word found stored in a char array to show progression of user
//    private char[] wordFound;
//    private int nbErrors;
//    // letters already entered by user
//    private ArrayList<String> letters = new ArrayList<>();
//    private ImageView img;
//    private TextView wordTv;
//    private TextView wordToFindTv;
//
//    private String nextWordToFind() {
//        return WORDS[RANDOM.nextInt(WORDS.length)];
//    }
//
//    private void updateImg(int play) {
//        int resImg = getResources().getIdentifier("hangman_" + play, "drawable", getActivity().getPackageName());
//        img.setImageResource(resImg);
//    }
//
//    private String wordFoundContent() {
//        StringBuilder builder = new StringBuilder();
//
//        for (int i = 0; i < wordFound.length; i++) {
//            builder.append(wordFound[i]);
//
//            if (i < wordFound.length - 1) {
//                builder.append(" ");
//            }
//        }
//
//        return builder.toString();
//    }
//
//    public void newGame() {
//        nbErrors = -1;
//        letters.clear();
//        wordToFind = nextWordToFind();
//
//        // word found initialization
//        wordFound = new char[wordToFind.length()];
//
//        for (int i = 0; i < wordFound.length; i++) {
//            wordFound[i] = '_';
//        }
//
//        updateImg(nbErrors);
//        wordTv.setText(wordFoundContent());
//        wordToFindTv.setText("");
//    }
//
//    private void enter(String c) {
//        // we update only if c has not already been entered
//        if (!letters.contains(c)) {
//            // we check if word to find contains c
//            if (wordToFind.contains(c)) {
//                // if so, we replace _ by the character c
//                int index = wordToFind.indexOf(c);
//
//                while (index >= 0) {
//                    wordFound[index] = c.charAt(0);
//                    index = wordToFind.indexOf(c, index + 1);
//                }
//            } else {
//                // c not in the word => error
//                nbErrors++;
//                Toast.makeText(this.getContext(), R.string.try_an_other, Toast.LENGTH_SHORT).show();
//            }
//
//            // c is now a letter entered
//            letters.add(c);
//        } else {
//            Toast.makeText(this.getContext(), R.string.letter_already_entered, Toast.LENGTH_SHORT).show();
//        }
//    }
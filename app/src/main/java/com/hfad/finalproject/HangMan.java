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

    private Random random = new Random();
    private String updatedWord;

    private int lives = 6;
    private int Image = 0;

    ArrayList<Integer> hangDraws = new ArrayList<Integer>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hang_man, container, false);

        ImageView imgTicTacToe = view.findViewById(R.id.imgTicTacToe);
        ImageView imgHome = view.findViewById(R.id.imgHome);
        ImageView imgScore = view.findViewById(R.id.imgScore);
        TextView tvLives = view.findViewById(R.id.tvLives);

        hangDraws.add(R.drawable.hang1);
        hangDraws.add(R.drawable.hang2);
        hangDraws.add(R.drawable.hang3);
        hangDraws.add(R.drawable.hang4);
        hangDraws.add(R.drawable.hang5);
        hangDraws.add(R.drawable.hang6);

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
        String word;

        int index = random.nextInt(WORDS.length);
        word = WORDS[index];

        TextView tvWord = view.findViewById(R.id.wordToFindTv);
        tvWord.setText("");
        for(int i = 0; i < word.length(); i++)
        {
            tvWord.setText(tvWord.getText() + "_ ");
        }

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

    public void buttonClicked(View view, Button btn, String word, TextView tvWord, TextView tvLives, ImageView hangPic)
    {

        updatedWord = checkLetter(word, btn, tvWord, tvLives, hangPic);
        String newWord = setText(updatedWord);
        tvWord.setText(newWord);
        btn.setClickable(false);
        btn.setBackgroundColor(Color.BLACK);
        if(!tvWord.getText().toString().contains("_"))
        {
            Context context = view.getContext();
            CharSequence text = "You Win!!!!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            HangManDirections.ActionHangManToResults action =
                    HangManDirections.actionHangManToResults("Test", lives, "Hangman");
            Navigation.findNavController(view).navigate(action);
        }
        if(lives == 0)
        {
            Context context = view.getContext();
            CharSequence text = "You Loose!!!!!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            HangManDirections.ActionHangManToResults action =
                    HangManDirections.actionHangManToResults("Test", lives, "Hangman");
            Navigation.findNavController(view).navigate(action);

        }
    }

    public String checkLetter(String word, Button btn, TextView tvWord, TextView tvLives, ImageView hangPic)
    {
        String updateWord = "";
        String tvGuess = tvWord.getText().toString();
        String secWord = "";
        for(int k = 0 ; k <tvGuess.length(); k++)
        {
            if(tvGuess.charAt(k) != ' ')
            {
                secWord += tvGuess.charAt(k);
            }
        }
        tvGuess = secWord;
        System.out.println("GUESS: " + tvGuess);
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
        System.out.println(updateWord);

        if(tvGuess.equals(updateWord))
        {
            lives--;
            tvLives.setText("Lives: " + lives);
            hangPic.setImageResource(hangDraws.get(Image));
            Image++;
        }

        return updateWord;

    }

    public String setText(String newWord)
    {
        String word = "";
        for(int i = 0; i < newWord.length(); i++)
        {

            word += newWord.charAt(i) + " ";

        }
        System.out.println("WORD: " + word);

        return word;
    }

}

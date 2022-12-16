package com.hfad.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Results} factory method to
 * create an instance of this fragment.
 */
public class Results extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_results, container, false);

        //Get java handles for XML objects
        TextView txtWinner = view.findViewById(R.id.txt_winner);
        TextView txtScore = view.findViewById(R.id.txt_score);
        Button btnSave = view.findViewById(R.id.btn_save);
        Button btnHome = view.findViewById(R.id.btn_home);
        Button btnReplay = view.findViewById(R.id.btn_replay);

        //Get args from previous screen (tictactoe or hangman)
        String winner = ResultsArgs.fromBundle(requireArguments()).getName();
        String game = ResultsArgs.fromBundle(requireArguments()).getGame();
        int score = ResultsArgs.fromBundle(requireArguments()).getScore();

        //Fill in text fields
        txtWinner.setText("Winner: " + winner);
        txtScore.setText("Score: " + score);

        if(game.equals("Hangman"))
        {
            if(score == 0)
            {
                txtWinner.setText("Loser");
            }
            else {
                txtWinner.setText("Winner");
            }
            txtScore.setText("Lives: " + score);
        }
        DBHelper dbHelper = new DBHelper(getContext());

        //If save button clicked...
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //...save score to database
                DBContract dbContract = new DBContract();
                dbHelper.saveEntry(winner, game, score);

                //System.out.println(dbHelper.fetchAllEntries());

                //Blur out save button (can only save an entry once!)
                btnSave.setText("Saved!");
                btnSave.setEnabled(false);
            }
        });

        //Go back home
        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_results_to_mainMenu);
            }
        });

        //Go back to previous game played
        btnReplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (game.equals("TicTacToe") || game.equals("R. TicTacToe"))
                {
                    Navigation.findNavController(view).navigate(R.id.action_results_to_ticTacToe);
                }
                else if (game.equals("Hangman"))
                {
                    Navigation.findNavController(view).navigate(R.id.action_results_to_hangMan);
                }
            }
        });


        return view;
    }
}
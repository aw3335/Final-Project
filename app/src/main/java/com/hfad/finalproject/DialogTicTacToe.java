package com.hfad.finalproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.Navigation;

/**
 * This class is for gathering info to play
 * tic tac toe (names, reverse, etc)
 */
public class DialogTicTacToe extends DialogFragment {

    int action; //Action to nagivate to tictactoe

    /**
     * Constructor
     * @param a - action to navigate to
     */
    public DialogTicTacToe(int a)
    {
        action = a;

    }

    /**
     * Override for onCreateDialog
     * @param savedInstanceState
     * @return
     */
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_tic_tac_toe, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Get handle for XML objects
        EditText edtPlayerOne = dialogView.findViewById(R.id.edt_player_one);
        EditText edtPlayerTwo = dialogView.findViewById(R.id.edt_player_two);
        CheckBox chkReversed = dialogView.findViewById(R.id.chk_reversed);
        Button btnStart = dialogView.findViewById(R.id.btn_start);

        //When start button is clicked
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //Get player names
                String player1 = edtPlayerOne.getText().toString();
                String player2 = edtPlayerTwo.getText().toString();

                //if any textfield not filled in, request information
                if (player1.equals("") || player2.equals(""))
                {
                    Toast.makeText(getActivity(), "Please enter both names", Toast.LENGTH_LONG).show();
                }
                else
                {
                    //Pass along information to tictactoe
                    TicTacToe.Manager.setReversed(chkReversed.isChecked());
                    TicTacToe.Manager.setPlayer(1, player1);
                    TicTacToe.Manager.setPlayer(2, player2);

                    //goofy navigation code
                    //Get handle to tictactoe button that activated this dialogue,
                    //use it and the action parameter to move to the tictactoe fragment
                    Navigation.findNavController(getActivity().findViewById(R.id.imgTicTacToe)).navigate(action);
                    dismiss();
                }
            }
        });

        builder.setView(dialogView);

        return builder.create();

    }


}

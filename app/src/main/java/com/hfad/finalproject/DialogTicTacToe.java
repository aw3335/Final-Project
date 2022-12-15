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

import androidx.fragment.app.DialogFragment;
import androidx.navigation.Navigation;

public class DialogTicTacToe extends DialogFragment {

    int action;

    public DialogTicTacToe(int a)
    {
        action = a;

    }

    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_tic_tac_toe, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        EditText edtPlayerOne = dialogView.findViewById(R.id.edt_player_one);
        EditText edtPlayerTwo = dialogView.findViewById(R.id.edt_player_two);
        CheckBox chkReversed = dialogView.findViewById(R.id.chk_reversed);
        Button btnStart = dialogView.findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String player1 = edtPlayerOne.getText().toString();
                String player2 = edtPlayerTwo.getText().toString();

                if (player1.equals("") || player2.equals(""))
                {
                    //toast to ask for player names
                }
                else
                {
                    TicTacToe.Manager.setReversed(chkReversed.isChecked());
                    TicTacToe.Manager.setPlayer(1, player1);
                    TicTacToe.Manager.setPlayer(2, player2);
                    //goofy ahh navigation code
                    Navigation.findNavController(getActivity().findViewById(R.id.imgTicTacToe)).navigate(action);
                    dismiss();
                }
            }
        });

        builder.setView(dialogView);

        return builder.create();



    }


}

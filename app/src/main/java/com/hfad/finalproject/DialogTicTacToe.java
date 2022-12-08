package com.hfad.finalproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class DialogTicTacToe extends DialogFragment {

    public DialogTicTacToe()
    {
        this.setCancelable(false);
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
                if (edtPlayerOne.getText().toString().equals("") || edtPlayerTwo.getText().toString().equals(""))
                {
                    //toast to ask for player names
                }
                else
                {
                    TicTacToe.Manager.setPlayer(1, edtPlayerOne.getText().toString());
                    TicTacToe.Manager.setPlayer(2, edtPlayerTwo.getText().toString());
                    TicTacToe.Manager.setReversed(chkReversed.isChecked());
                    //Keep track of names
                }
            }
        });



        builder.setView(dialogView);

        return builder.create();



    }


}

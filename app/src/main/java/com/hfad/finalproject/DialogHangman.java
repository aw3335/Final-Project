package com.hfad.finalproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * DialogHangMan display a dialog to the user to gets a name of whos playing the game
 *
 */
public class DialogHangman extends DialogFragment {

    /**
     * Constructor that doesn't allow the user to cancel out of the dialog
     */
    public DialogHangman()
    {
        setCancelable(false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        //Inflates the layout to look like the dialog
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_hangman, null);

        //Creates an alertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Connects to the text and button so we can call them
        EditText edtPlayerOne = view.findViewById(R.id.edt_player_one);
        Button btnStart = view.findViewById(R.id.btn_start);

        //When the start button is clicked we first check if the user has entered a name.
        //If not then they cant proceed and a message is displayed else the dialog closes and the
        //player name is taken
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtPlayerOne.getText().toString().equals(""))
                {
                    Context context = v.getContext();
                    CharSequence text = "Enter a Name!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    HangMan.player = edtPlayerOne.getText().toString();
                    dismiss();
                }
            }
        });

        //Builds the view with the dialog
        builder.setView(view);

        //Returns the created build
        return builder.create();
    }
}
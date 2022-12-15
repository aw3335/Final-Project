package com.hfad.finalproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogHangman#} factory method to
 * create an instance of this fragment.
 *
 */
public class DialogHangman extends DialogFragment {

    public DialogHangman()
    {
        setCancelable(false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_hangman, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        EditText edtPlayerOne = view.findViewById(R.id.edt_player_one);
        Button btnStart = view.findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HangMan.player = edtPlayerOne.getText().toString();
                dismiss();
            }
        });

        builder.setView(view);

        return builder.create();
    }
}
package com.hfad.finalproject;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogHangman#} factory method to
 * create an instance of this fragment.
 *
 */
public class DialogHangman extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog_hangman, container, false);

        EditText edtPlayerOne = view.findViewById(R.id.edt_player_one);
        Button btnStart = view.findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogHangmanDirections.ActionDialogHangmanToHangMan action =
                        DialogHangmanDirections.actionDialogHangmanToHangMan(edtPlayerOne.getText().toString());
                Navigation.findNavController(view).navigate(action);
            }
        });
        return view;
    }
}
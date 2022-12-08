package com.hfad.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TicTacToe} factory method to
 * create an instance of this fragment.
 */
public class TicTacToe extends Fragment {

    static class Manager
    {
        private static String player1;
        private static String player2;
        private static boolean reversed;

        static void setPlayer(int n, String p)
        {
            if (n == 1)
                player1 = p;
            else if (n == 2)
                player2 = p;
        }

        static String getPlayer(int n)
        {
            String name = "";
            if (n == 1)
                name = player1;
            else if (n == 2)
                name = player2;
            return name;
        }

        static void setReversed(boolean r)
        {
            reversed = r;
        }

        static boolean isReversed()
        {
            return reversed;
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);

        DialogTicTacToe dialog = new DialogTicTacToe();
        dialog.show(getActivity().getSupportFragmentManager(), "");

        ImageView imgTopLeft = view.findViewById(R.id.img_top_left);
        ImageView imgTopMid = view.findViewById(R.id.img_top_mid);
        ImageView imgTopRight = view.findViewById(R.id.img_top_right);
        ImageView imgMidLeft = view.findViewById(R.id.img_mid_left);
        ImageView imgCenter = view.findViewById(R.id.img_center);
        ImageView imgMidRight = view.findViewById(R.id.img_mid_right);
        ImageView imgBotLeft = view.findViewById(R.id.img_bot_left);
        ImageView imgBotMid = view.findViewById(R.id.img_bot_mid);
        ImageView imgBotRight = view.findViewById(R.id.img_bot_right);

        //***********************************************
        //Moving Between Fragment
        ImageView imgHangMan = view.findViewById(R.id.imgHangman);
        ImageView imgHome = view.findViewById(R.id.imgHome);
        ImageView imgScore = view.findViewById(R.id.imgScore);


        imgHangMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_ticTacToe_to_hangMan);
            }
        });

        imgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_ticTacToe_to_highScore);
            }
        });

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_ticTacToe_to_mainMenu);
            }
        });
        //***********************************************

        ArrayList<ImageView> boxes = new ArrayList<ImageView>();
        boxes.add(imgTopLeft);
        boxes.add(imgTopMid);
        boxes.add(imgTopRight);
        boxes.add(imgMidLeft);
        boxes.add(imgCenter);
        boxes.add(imgMidRight);
        boxes.add(imgBotLeft);
        boxes.add(imgBotMid);
        boxes.add(imgBotRight);

        ArrayList<String> map = new ArrayList<String>();
        for (ImageView i : boxes)
        {
            map.add(null);
        }

        int[] playerTurn = {1};

        for (ImageView box : boxes)
        {
            box.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ImageView current = (ImageView) view;
                    if (playerTurn[0] == 1 && map.get(boxes.indexOf(current)) == null)
                    {
                        current.setImageResource(R.drawable.ic_x);
                        playerTurn[0] = 2;
                        map.set(boxes.indexOf(current), "X");
                    }
                    else if (playerTurn[0] == 2 && map.get(boxes.indexOf(current)) == null)
                    {
                        current.setImageResource(R.drawable.ic_o);
                        playerTurn[0] = 1;
                        map.set(boxes.indexOf(current), "O");
                    }

                    if (winnerExists(map))
                    {
                        int winner;
                        if (Database.getReversed())
                        {
                            winner = playerTurn[0];
                        }
                        else
                        {
                            if (playerTurn[0] == 1) {winner = 2;} else {winner = 1;}
                        }

                        //display winner, save results, etc

                    }

                }
            });
        }

        return view;
    }

    private boolean winnerExists(ArrayList<String> map)
    {
        boolean found = false;

        ArrayList<int[]> options = new ArrayList<int[]>();
        options.add(new int[] {0, 1, 2}); //top row
        options.add(new int[] {0, 3, 6}); //down the left
        options.add(new int[] {0, 4, 8}); //top left to bottom right diagonal
        options.add(new int[] {3, 4, 5}); //center row
        options.add(new int[] {1, 4, 7}); //down the middle
        options.add(new int[] {6, 4, 2}); //bottom left to top right diagonal
        options.add(new int[] {6, 7, 8}); //bottom row
        options.add(new int[] {2, 5, 8}); //down the right

        for (int[] o : options)
        {
            if (map.get(o[0]).equals( map.get(o[1]) ) && map.get(o[1]).equals( map.get(o[2]) ))
            {
                found = true;
            }
        }

        return found;

    }


}
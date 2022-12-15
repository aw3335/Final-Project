package com.hfad.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        ImageView imgTopLeft = view.findViewById(R.id.img_top_left);
        ImageView imgTopMid = view.findViewById(R.id.img_top_mid);
        ImageView imgTopRight = view.findViewById(R.id.img_top_right);
        ImageView imgMidLeft = view.findViewById(R.id.img_mid_left);
        ImageView imgCenter = view.findViewById(R.id.img_center);
        ImageView imgMidRight = view.findViewById(R.id.img_mid_right);
        ImageView imgBotLeft = view.findViewById(R.id.img_bot_left);
        ImageView imgBotMid = view.findViewById(R.id.img_bot_mid);
        ImageView imgBotRight = view.findViewById(R.id.img_bot_right);

        TextView txtTurn = view.findViewById(R.id.txt_turn);

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
            map.add("");
        }

        int[] playerTurn = {1};

        txtTurn.setText("It is " + Manager.getPlayer(1) + "'s turn!");

        for (ImageView box : boxes)
        {
            box.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ImageView current = (ImageView) view;
                    if (playerTurn[0] == 1 && map.get(boxes.indexOf(current)).equals(""))
                    {
                        current.setImageResource(R.drawable.ic_x);
                        playerTurn[0] = 2;
                        map.set(boxes.indexOf(current), "X");
                        txtTurn.setText("It is " + Manager.getPlayer(2) + "'s turn!");
                    }
                    else if (playerTurn[0] == 2 && map.get(boxes.indexOf(current)).equals(""))
                    {
                        current.setImageResource(R.drawable.ic_o);
                        playerTurn[0] = 1;
                        map.set(boxes.indexOf(current), "O");
                        txtTurn.setText("It is " + Manager.getPlayer(1) + "'s turn!");
                    }

                    if (tieExists(map))
                    {
                        String game = "Tic Tac Toe";
                        if (Manager.isReversed()) {game = "Reversed " + game;}
                        TicTacToeDirections.ActionTicTacToeToResults action =
                                TicTacToeDirections.actionTicTacToeToResults("Tie", 0, game);
                        Navigation.findNavController(view).navigate(action);
                    }

                    else if (winnerExists(map))
                    {
                        String winner;
                        int turn = playerTurn[0];
                        if (Manager.isReversed())
                        {
                            winner = Manager.getPlayer(turn);
                        }
                        else
                        {
                            if (turn == 1)
                            {
                                winner = Manager.getPlayer(2);
                            }
                            else
                            {
                                winner = Manager.getPlayer(1);
                            }
                        }

                        System.out.println("!!!!!! \n WINNER \n !!!!!!");
                        String game = "Tic Tac Toe";
                        if (Manager.isReversed()) {game = "Reversed " + game;}
                        TicTacToeDirections.ActionTicTacToeToResults action =
                                TicTacToeDirections.actionTicTacToeToResults(winner, getScore(map), game);
                        Navigation.findNavController(view).navigate(action);
                    }

                }
            });
        }

        return view;
    }

    private boolean tieExists(ArrayList<String> map)
    {
        boolean found = true;

        for (String s : map)
        {
            if (s.equals(""))
            {
                found = false;
            }
        }
        System.out.println(found);
        return found;
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
            boolean allSame = map.get(o[0]).equals( map.get(o[1]) ) && map.get(o[1]).equals( map.get(o[2]) );
            boolean noneEmpty = (!map.get(o[0]).equals(""));
            if (allSame && noneEmpty)
            {
                found = true;
            }
        }

        return found;

    }

    private int getScore(ArrayList<String> map)
    {
        int score = 10;
        for (String s : map)
        {
            if (s.equals(""))
            {
                score += 10;
            }
        }
        return score;
    }


}
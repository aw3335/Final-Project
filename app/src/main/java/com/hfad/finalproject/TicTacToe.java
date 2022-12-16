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

    /**
     *
     //Class to keep track of players and if game is reversed
     //This is how the dialog communicates with the tictactoe fragment
     //Its also useful for not asking for a new name for the replay button
     //on the results screen
     */
    static class Manager
    {
        private static String player1; //name of player one
        private static String player2; //name of player two
        private static boolean reversed; //whether game is reversed

        /**
         * Set player
         * @param n - which player (1 or 2)
         * @param p - their name
         */
        static void setPlayer(int n, String p)
        {
            if (n == 1)
                player1 = p;
            else if (n == 2)
                player2 = p;
        }

        /**
         * Get player's name
         * @param n - which player (1 or 2)
         * @return Name of chosen player
         */
        static String getPlayer(int n)
        {
            String name = "";
            if (n == 1)
                name = player1;
            else if (n == 2)
                name = player2;
            return name;
        }

        /**
         * Set whether game reversed
         * @param r - true for reversed, else false
         */
        static void setReversed(boolean r)
        {
            reversed = r;
        }

        /**
         * See if game is reversed
         * @return true for reversed, else false
         */
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

        //Get java handlers for XML objects
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
        ImageView imgRockPaperScissor = view.findViewById(R.id.RockPaperScissor);

        //Go back to hangman
        imgHangMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_ticTacToe_to_hangMan);
            }
        });

        //Go back to scoreboard
        imgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_ticTacToe_to_highScore);
            }
        });

        //Go back to home screen
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_ticTacToe_to_mainMenu);
            }
        });

        imgRockPaperScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogRPS dialog = new DialogRPS(R.id.action_hangMan_to_RPS);
                dialog.show(getActivity().getSupportFragmentManager(), "");
            }
        });
        //***********************************************

        //Create arraylist of imageviews
        //add all image views to it
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

        //Create and fill arraylist of strings
        //This maps out which boxes have X, O, or nothing
        ArrayList<String> map = new ArrayList<String>();
        for (ImageView i : boxes)
        {
            map.add("");
        }

        //Use array of one integer instead of naked primitive type integer
        //so that it can be accessed from inner class (aka onClickListener)
        //and avoid following error:
        //"Variable 'playerTurn' is accessed from within inner class,
        //needs to be final or effectively final"
        int[] playerTurn = {1};

        //Display whose turn it is
        txtTurn.setText("It is " + Manager.getPlayer(1) + "'s turn!");

        //Add SAME onclicklistener for EACH imageview in list
        for (ImageView box : boxes)
        {
            box.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //Get current image view
                    ImageView current = (ImageView) view;

                    //If X's turn and selected view is empty
                    if (playerTurn[0] == 1 && map.get(boxes.indexOf(current)).equals(""))
                    {
                        //Fill with X and make it player 2's turn
                        current.setImageResource(R.drawable.ic_x);
                        playerTurn[0] = 2;
                        map.set(boxes.indexOf(current), "X");
                        txtTurn.setText("It is " + Manager.getPlayer(2) + "'s turn!");
                    }
                    //If O's turn and selected view is empty
                    else if (playerTurn[0] == 2 && map.get(boxes.indexOf(current)).equals(""))
                    {
                        //Fill with O and make it player 1's turn
                        current.setImageResource(R.drawable.ic_o);
                        playerTurn[0] = 1;
                        map.set(boxes.indexOf(current), "O");
                        txtTurn.setText("It is " + Manager.getPlayer(1) + "'s turn!");
                    }

                    //If there's a tie, go to results screen with "Tie"
                    if (tieExists(map))
                    {
                        String game = "Tic Tac Toe";
                        if (Manager.isReversed()) {game = "Reversed " + game;}
                        TicTacToeDirections.ActionTicTacToeToResults action =
                                TicTacToeDirections.actionTicTacToeToResults("Tie", 0, game);
                        Navigation.findNavController(view).navigate(action);
                    }

                    //if there's a winner, determine who won and go to results screen with winner
                    else if (winnerExists(map))
                    {
                        String winner; //who wins
                        int turn = playerTurn[0]; //current turn

                        //if its reversed, the winner is whoevers
                        //turn it just became
                        if (Manager.isReversed())
                        {
                            winner = Manager.getPlayer(turn);
                        }
                        //Else, the winner is whoevers turn
                        //just occured
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

                        //Go to results screen with name of winner and their score
                        System.out.println("!!!!!! \n WINNER \n !!!!!!");
                        String game = "TicTacToe";
                        if (Manager.isReversed()) {game = "Rev. " + game;}
                        TicTacToeDirections.ActionTicTacToeToResults action =
                                TicTacToeDirections.actionTicTacToeToResults(winner, getScore(map), game);
                        Navigation.findNavController(view).navigate(action);
                    }

                }
            });
        }

        return view;
    }

    /**
     * If all spaces are full and there's no winner, tie must exist
     * @param map - map of where X's and O's are
     * @return true if tie, else false
     */
    private boolean tieExists(ArrayList<String> map)
    {
        boolean boardFull = true; //assume no empty spaces
        boolean noWinner = !winnerExists(map); //see if there's a winner

        //for each space on board
        for (String s : map)
        {
            //if empty space on board, its not full aka not a tie
            if (s.equals(""))
            {
                boardFull = false;
            }
        }
        //If board is full AND there is no winner, must be a tie
        return (boardFull && noWinner);
    }

    /**
     * See if there's a winner on the board
     * @param map - map fo where X's and O's are
     * @return
     */
    private boolean winnerExists(ArrayList<String> map)
    {
        boolean found = false; //assume no winner found

        //All winning conditions
        ArrayList<int[]> options = new ArrayList<int[]>();
        options.add(new int[] {0, 1, 2}); //top row
        options.add(new int[] {0, 3, 6}); //down the left
        options.add(new int[] {0, 4, 8}); //top left to bottom right diagonal
        options.add(new int[] {3, 4, 5}); //center row
        options.add(new int[] {1, 4, 7}); //down the middle
        options.add(new int[] {6, 4, 2}); //bottom left to top right diagonal
        options.add(new int[] {6, 7, 8}); //bottom row
        options.add(new int[] {2, 5, 8}); //down the right

        //For each possible win condition
        for (int[] o : options)
        {
            //If all three spaces are the same AND none are empty...
            boolean allSame = map.get(o[0]).equals( map.get(o[1]) ) && map.get(o[1]).equals( map.get(o[2]) );
            boolean noneEmpty = (!map.get(o[0]).equals(""));
            if (allSame && noneEmpty)
            {
                found = true; //...then we found a winning board
            }
        }

        return found;

    }

    /**
     * Get score for game. Score = 10 + 10 per empty space
     * (you want to win in as few moves as possible)
     * @param map
     * @return
     */
    private int getScore(ArrayList<String> map)
    {
        int score = 10; //start with ten (starting with 0 felt mean)
        //For each empty space, add 10 more points
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
package com.hfad.finalproject;

import java.util.ArrayList;

public class Database {

    private class Entry
    {
        private String name;
        private String game;
        private int score;

        public Entry(String n, String g, int s)
        {
            name = n;
            game = g;
            score = s;
        }

        public int getScore() {
            return score;
        }

        public String getGame() {
            return game;
        }

        public String getName() {
            return name;
        }
    }

    private static ArrayList<Entry> scores;
    private static boolean reversed;

    public static void load()
    {
        scores = new ArrayList<Entry>();
        //LOAD DATA
    }

    public static void setReversed(boolean b)
    {
        reversed = b;
    }

    public static boolean getReversed()
    {
        return reversed;
    }

    public static ArrayList<Entry> getScores()
    {
        return scores;
    }



}

package com.hfad.finalproject;

/**
 * This class is an entry for a saved score
 */
public class Entry {
    private long id; //ID for row
    private String name; //Name of winner
    private String game; //Game that was played
    private int score; //Their final score

    /**
     * Constructor
     * @param _id - row id
     * @param n - name of player
     * @param g - game played
     * @param s - score
     */
    public Entry(long _id, String n, String g, int s)
    {
        id = _id;
        name = n;
        game = g;
        score = s;
    }

    /**
     * Get ID
     * @return long id
     */
    public long getId() {
        return id;
    }

    /**
     * Set id
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get score
     * @return int score
     */
    public int getScore() {
        return score;
    }

    /**
     * Get game
     * @return string game
     */
    public String getGame() {
        return game;
    }

    /**
     * Get name
     * @return string name
     */
    public String getName() {
        return name;
    }

    /**
     * to string
     * @return string of info about entry
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", game='" + game + '\'' +
                ", score=" + score +
                '}';
    }

}

package com.hfad.finalproject;

public class Entry {
    private long id;
    private String name;
    private String game;
    private int score;

    public Entry(long _id, String n, String g, int s)
    {
        id = _id;
        name = n;
        game = g;
        score = s;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
